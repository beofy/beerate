package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.service.base.BaseCrawlService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 关联个股
 */
@Component
public class StockRelationshipService extends BaseCrawlService {
    private Log log = LogFactory.getLog(StockRelationshipService.class);

    /** 同行业个股排名  */
    private final static String STOCK_RELATIONSHIP_AJAX="http://emweb.securities.eastmoney.com/StockRelationship/StockRelationshipAjax";

    /** 同概念个股排名-类型 */
    public final static String GET_CONCEPT_LIST="http://emweb.securities.eastmoney.com/StockRelationship2/GetConceptList";

    /** 同概念个股排名 */
    public final static String GET_SAME_CONCEPT_STOCK_RANK_LIST= "http://emweb.securities.eastmoney.com/StockRelationship2/GetSameConceptStockRankList";

    /** 3 、6 、12日内涨幅最大 */
    public final static String GET_SANE_CONCEPT_DAY_RANK_INFO="http://emweb.securities.eastmoney.com/StockRelationship2/GetSameConceptDayRankInfo";

    /** 同地域个股排名 */
    private final static String STOCK_RELATIONSHIP_AJAX3="http://emweb.securities.eastmoney.com/StockRelationship3/StockRelationshipAjax";

    /**
     * 同概念个股排名
     */
    public Message<String> crawlStockRelationship( String code, String orderBy, String isAsc){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",code);
        params.put("orderBy",orderBy);
        params.put("isAsc",isAsc);

        return super.crawl(this.STOCK_RELATIONSHIP_AJAX,params);
    }

    /**
     * 同概念个股排名-类型
     * @param code
     * @param isAsc
     * @param orderBy
     */
    public Message<String> getConceptList(String code, String orderBy, String isAsc){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",code);
        params.put("orderBy",orderBy);
        params.put("isAsc",isAsc);

        return super.crawl(this.GET_CONCEPT_LIST,params);
    }


    /**
     * 同概念个股排名
     * @param code 股票代码
     * @param orderBy
     * @param typeId 排名-类型
     * @param isAsc 是否排序
     * @return
     */
    public Message<String> getSameConceptStockRankList(String code ,String orderBy ,String typeId, String isAsc){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",code);
        params.put("orderBy",orderBy);
        params.put("typeId",typeId);
        params.put("isAsc",isAsc);

        return super.crawl(this.GET_SAME_CONCEPT_STOCK_RANK_LIST,params);
    }

    /**
     * 3、6、12日内涨幅最大
     * @param code  股票代码
     * @param typeId 排名-类型
     * @return
     */
    public Message<String> getSameConceptDayRankInfo(String code,String typeId){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",code);
        params.put("typeId",typeId);

        return super.crawl(this.GET_SANE_CONCEPT_DAY_RANK_INFO,params);
    }

    /**
     * 同地域个股排名
     */
    public Message<String> crawlStockRelationship3( String code, String orderBy, String isAsc){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",code);
        params.put("orderBy",orderBy);
        params.put("isAsc",isAsc);

        return super.crawl(this.STOCK_RELATIONSHIP_AJAX3,params);
    }
}
