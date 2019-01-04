package cn.beerate.service;


import cn.beerate.model.entity.stock.CompanySurvey.t_stock_fxxg;
import cn.beerate.model.entity.stock.CompanySurvey.t_stock_info;
import cn.beerate.model.entity.stock.CompanySurvey.t_stock_jbzl;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;


@Component
@Transactional
public class CompanySurveyService {

    @PersistenceContext
    private EntityManager em;

    private Log log = LogFactory.getLog(CompanySurveyService.class);

    //股票打头
    private final String[] CODE_START={"sz000","sz002","sz300","sh600","sh601","sh603"};

    //抓取公司概况
    public void companySurvey(String url,String stockCode){

        Document document = null;
        try {
            document = Jsoup.connect(url).ignoreContentType(true).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonResult = document.body().text();
        JSONObject jsonObject = JSONObject.parseObject(jsonResult);
        if(!StringUtil.isBlank(jsonObject.getString("status"))){
            log.info(jsonObject.toJSONString()+"----"+stockCode);
            return;
        }

        //jsonTobean
        t_stock_info stockInfo = jsonObject.toJavaObject(t_stock_info.class);
        t_stock_fxxg stockFxxg = jsonObject.getJSONObject("fxxg").toJavaObject(t_stock_fxxg.class);
        t_stock_jbzl stockJbzl = jsonObject.getJSONObject("jbzl").toJavaObject(t_stock_jbzl.class);

        //开启事务
//        if(!em.getTransaction().isActive()){
//            em.getTransaction().begin();
//        }

        //设置主一
        stockInfo.stock_fxxg=stockFxxg;
        stockInfo.stock_jbzl=stockJbzl;
        //设置从一
        stockFxxg.stock_info= stockInfo;
        stockJbzl.stock_info= stockInfo;

        em.persist(stockInfo);
//        em.getTransaction().commit();

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
                log.info(num);
                String url ="http://emweb.securities.eastmoney.com/CompanySurvey/CompanySurveyAjax?code="+num;
                companySurvey(url,num);
            }
        }
    }





}
