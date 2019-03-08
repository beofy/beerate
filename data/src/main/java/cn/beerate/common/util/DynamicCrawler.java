package cn.beerate.common.util;

import cn.beerate.service.cninfo.DisclosureService;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.ScriptResult;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

public class DynamicCrawler {
    private Log logger = LogFactory.getLog(DisclosureService.class);

    private int RECONECTION_TIMES=0;

    private WebClient webClient=null;

    private HtmlPage homePage=null;

    public static DynamicCrawler getInstance(){
        return new DynamicCrawler();
    }

    private void defaultWebclient(){
        WebClient webClient = new WebClient(BrowserVersion.CHROME);
        //开启js驱动
        webClient.getOptions().setJavaScriptEnabled(true);
        //设置css不可用
        webClient.getOptions().setCssEnabled(false);
        //开启ajax异步
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());
        //设置超时时间
        webClient.getOptions().setTimeout(20000);
        //javascript异常不抛出
        webClient.getOptions().setThrowExceptionOnScriptError(true);
        //不跟踪抓取
        webClient.getOptions().setDoNotTrackEnabled(false);

        this.webClient = webClient;
    }


    public WebClient getWebClient(){
        if (webClient==null){
            defaultWebclient();
        }

        return this.webClient;
    }


    public HtmlPage getHomePage(String url){
        if (homePage==null){
            setHomeHtml(url);
        }

        return this.homePage;
    }

    /**
     * 设置主页
     * @param url 地址
     */
    private void setHomeHtml(String url){
        HtmlPage htmlPage=null;
        this.webClient = getWebClient();
        try {
            htmlPage = webClient.getPage(url);
        } catch (IOException e) {
            logger.debug(url+"，An exception occurred on the fetch page",e);
            logger.info("第"+RECONECTION_TIMES+1+"次页面打开异常，10秒后重新连接！");

            //线程休眠
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e1) {
                logger.error("线程休眠异常",e);
            }

            //异常重连
            if(RECONECTION_TIMES<10){
                setHomeHtml(url);
                RECONECTION_TIMES++;
            }else {
                webClient.close();
            }
        }

        //等待js执行
        webClient.waitForBackgroundJavaScript(5000L);

        this.homePage=htmlPage;
    }

    /**
     * 执行javascript代码
     * @param sourceCode javascript代码
     */
    public void executeJavaScript(String sourceCode){
        if(this.homePage==null){
            throw new NullPointerException(" the DynamicCrawler is homePage is null");
        }

        ScriptResult scriptResult = this.homePage.executeJavaScript(sourceCode);
        this.webClient.waitForBackgroundJavaScript(5000L);
        logger.debug(scriptResult);
    }

}
