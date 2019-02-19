package cn.beerate.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class Crawler {
    private Log log = LogFactory.getLog(Crawler.class);

    public static Crawler getInstance(){
        return new Crawler();
    }

    public Connection getConnect(String url){
        return   Jsoup.connect(url);
    }

    public Connection.Response getResponse(String url,Map<String,String> params){
        Connection.Response response = null;
        try {
            Connection connection = this.getConnect(url);
            connection .ignoreContentType(true);

            //无参数
            if(params!=null&&!params.isEmpty()){
                connection .data(params);
            }

            response= connection.execute();
        } catch (IOException e) {
            log.warn(e.getMessage(),e);
        }
        return response;
    }

    public String getString(String url, Map<String,String> params){
        return this.getResponse(url,params).body();
    }

    public Document getDocument(String url, Map<String,String> params){
        try {
            return this.getResponse(url,params).parse();
        } catch (IOException e) {
            log.warn(e.getMessage(),e);
            return null;
        }
    }

    public Document getDocument(String url){
        try {
            return this.getResponse(url,null).parse();
        } catch (IOException e) {
            log.warn(e.getMessage(),e);
            return null;
        }
    }

    /**
     * 获取html页面内容
     * @param url url
     * @return String
     */
    public String getHtml(String url){
        return this.getDocument(url,null).outerHtml();
    }

    /**
     * 获取html页面内容
     * @param url url
     * @param params 参数
     * @return String
     */
    public String getHtml(String url,Map<String,String> params){
        return this.getDocument(url,params).outerHtml();
    }

    /**
     * 获取所有的隐藏区域元素
     * @param url url
     * @param params 参数
     * @return Map<String,String>
     */
    public Map<String,String> getHidden(String url, Map<String,String> params){
        Document document=  this.getDocument(url,params);

        return  this.getHidden(document);
    }

    /**
     * 获取所有的隐藏区域元素
     * @param document 页面元素
     * @return Map<String,String>
     */
    public Map<String,String> getHidden(Document document){
        //所有隐藏域元素
        Elements input_hiddens = document.select("input[type=hidden]");
        Iterator<Element> iterator = input_hiddens.iterator();

        Map<String,String> map  = new HashMap<String,String>();
        while (iterator.hasNext()){
            Element element = iterator.next();
            String key = element.attr("id");
            String value=element.attr("value");
            //存入map
            map.put(key,value);
        }
        return map;
    }

    /**
     * 获取所有的隐藏区域元素
     * @param url url
     * @return Map<String,String>
     */
    public Map<String,String> getHidden(String url){
       return this.getHidden(url,null);
    }

    /**
     * 获取元素内所有的标签名
     * @param element 元素节点
     * @return Set<String>
     */
    public Set<String> getTagNames(Element element){
        Set<String> set = new HashSet<>();
        if(element.children().size()==0){
            return null;
        } else{
           Iterator<Element> elementIterator = element.children().iterator();
           while(elementIterator.hasNext()){
               Element element1 = elementIterator.next();
               Set<String> set1 = getTagNames(element1);
               if(set1!=null){
                   for (String str :set1) {
                       set.add(str);
                   }
               }
               //当前元素标签名
               String tagName = element1.tagName();
               set.add(tagName);
           }
           return set;
        }
    }

}
