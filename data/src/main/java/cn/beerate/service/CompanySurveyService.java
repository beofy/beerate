package cn.beerate.service;


import cn.beerate.dao.Impl.StockInfoDaoImpl;
import cn.beerate.model.entity.stock.companysurvey.t_stock_fxxg;
import cn.beerate.model.entity.stock.companysurvey.t_stock_info;
import cn.beerate.model.entity.stock.companysurvey.t_stock_jbzl;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;


/**
 * 公司概况
 */
@Component
@Transactional
public class CompanySurveyService {

    @Autowired
    private StockInfoDaoImpl stockInfoDao;

    private Log log = LogFactory.getLog(CompanySurveyService.class);

    //股票打头
    private final String[] CODE_START={"sz000","sz002","sz300","sh600","sh601","sh603"};

    //抓取公司概况
    public void companySurvey(String url){

        Document document = null;
        try {
            document = Jsoup.connect(url).ignoreContentType(true).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = document.body().text();
        JSONObject jsonObject = JSONObject.parseObject(result);
        if(!StringUtil.isBlank(jsonObject.getString("status"))){
            log.info(jsonObject.toJSONString());
            return;
        }

        //jsonTobean
        t_stock_info stockInfo = jsonObject.toJavaObject(t_stock_info.class);
        t_stock_fxxg stockFxxg = jsonObject.getJSONObject("fxxg").toJavaObject(t_stock_fxxg.class);
        t_stock_jbzl stockJbzl = jsonObject.getJSONObject("jbzl").toJavaObject(t_stock_jbzl.class);

        //设置主一
        stockInfo.setStock_fxxg(stockFxxg);
        stockInfo.setStock_jbzl(stockJbzl);
        //设置从一
        stockFxxg.setStock_info(stockInfo);
        stockJbzl.setStock_info(stockInfo);

        //级联保存
        stockInfoDao.save(stockInfo);

    }

    //抓取所有
    public void snatchAllcompanySurvey(){
        for(String start: CODE_START){
            //0-999
            for (int i = 0; i <1000 ; i++) {
                String num="";
                if(i<10){
                    num=start+"00"+i;
                }
                if(i>=10&&i<100){
                    num=start+"0"+i;
                }
                if(i>=100&&i<1000){
                    num=start+i;
                }

                String url ="http://emweb.securities.eastmoney.com/companysurvey/CompanySurveyAjax?code="+num;
                log.info(url);
                companySurvey(url);
            }
        }
    }





}
