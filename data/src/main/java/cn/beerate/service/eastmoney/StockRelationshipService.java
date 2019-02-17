package cn.beerate.service.eastmoney;

import cn.beerate.common.Message;
import cn.beerate.service.base.BaseCrawlService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 关联个股
 */
@Component
@Transactional
public class StockRelationshipService extends BaseCrawlService {
    /** 同行业个股排名  */
    private final static String STOCK_RELATIONSHIP_AJAX="http://eastmoney.securities.eastmoney.com/StockRelationship/StockRelationshipAjax";

    /** 同概念个股排名-类型 */
    private final static String GET_CONCEPT_LIST="http://eastmoney.securities.eastmoney.com/StockRelationship2/GetConceptList";

    /** 同概念个股排名 */
    private final static String GET_SAME_CONCEPT_STOCK_RANK_LIST= "http://eastmoney.securities.eastmoney.com/StockRelationship2/GetSameConceptStockRankList";

    /** 3 、6 、12日内涨幅最大 */
    private final static String GET_SANE_CONCEPT_DAY_RANK_INFO="http://eastmoney.securities.eastmoney.com/StockRelationship2/GetSameConceptDayRankInfo";

    /** 同地域个股排名 */
    private final static String STOCK_RELATIONSHIP_AJAX3="http://eastmoney.securities.eastmoney.com/StockRelationship3/StockRelationshipAjax";

    /**
     * 同概念个股排名
     * @param code 股票代码
     * @param orderBy 排序类型
     * @param isAsc false：降序 | true:升序
     * @return Message<String>
     */
    public Message<String> stockRelationship( String code, String orderBy, String isAsc){
        Map<String,String> params = new HashMap<>();
        params.put("code",code);
        params.put("orderBy",orderBy);
        params.put("isAsc",isAsc);

        return super.crawl(StockRelationshipService.STOCK_RELATIONSHIP_AJAX,params);
    }

    /**
     * 同概念个股排名-类型
     * @param code 股票代码
     * @param isAsc false：降序 | true:升序
     * @param orderBy 排序类型
     */
    public Message<String> getConceptList(String code, String orderBy, String isAsc){
        Map<String,String> params = new HashMap<>();
        params.put("code",code);
        params.put("orderBy",orderBy);
        params.put("isAsc",isAsc);

        return super.crawl(StockRelationshipService.GET_CONCEPT_LIST,params);
    }


    /**
     * 同概念个股排名
     * @param code 股票代码
     * @param orderBy 排序类型
     * @param typeId 排名-类型
     * @param isAsc 是否排序
     * @return Message<String>
     */
    public Message<String> getSameConceptStockRankList(String code ,String orderBy ,String typeId, String isAsc){
        Map<String,String> params = new HashMap<>();
        params.put("code",code);
        params.put("orderBy",orderBy);
        params.put("typeId",typeId);
        params.put("isAsc",isAsc);

        return super.crawl(StockRelationshipService.GET_SAME_CONCEPT_STOCK_RANK_LIST,params);
    }

    /**
     * 3、6、12日内涨幅最大
     * @param code  股票代码
     * @param typeId 排名-类型
     * @return Message<String>
     */
    public Message<String> getSameConceptDayRankInfo(String code,String typeId){
        Map<String,String> params = new HashMap<>();
        params.put("code",code);
        params.put("typeId",typeId);

        return super.crawl(StockRelationshipService.GET_SANE_CONCEPT_DAY_RANK_INFO,params);
    }

    /**
     * 同地域个股排名
     * @param code 股票代码
     * @param orderBy 排序类型
     * @param isAsc false：降序 | true:升序
     * @return Message<String>
     */
    public Message<String> stockRelationship3( String code, String orderBy, String isAsc){
        Map<String,String> params = new HashMap<>();
        params.put("code",code);
        params.put("orderBy",orderBy);
        params.put("isAsc",isAsc);

        return super.crawl(StockRelationshipService.STOCK_RELATIONSHIP_AJAX3,params);
    }
}
