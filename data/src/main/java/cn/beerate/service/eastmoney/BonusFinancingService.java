package cn.beerate.service.eastmoney;

import cn.beerate.common.Message;
import cn.beerate.service.base.BaseCrawlService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 分红融资
 */
@Component
public class BonusFinancingService extends BaseCrawlService {
    private final static String BONUS_FINANCING_AJAX="http://eastmoney.securities.eastmoney.com/BonusFinancing/BonusFinancingAjax";
    private final static String BONUS_DETAIL_CHART_AJAX="http://eastmoney.securities.eastmoney.com/BonusFinancing/BonusDetailChartAjax";

    /**
     *  抓取分红融资<br>
     *  包含（分红影响 | 历年分红融资 | 增发明细 | 配股明细）
     * @param stockCode 股票代码
     *
     */
    public Message<String> bonusFinancing(String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);

        return super.crawl(BonusFinancingService.BONUS_FINANCING_AJAX,params);
    }

    /**
     * 抓取每日分红价格<br>
     * @param stockCode 股票代码
     * @param date 日期
     * @return Message<String>
     */
    public Message<String> bonusDetailChart(String stockCode,String date){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);
        params.put("date",date);

        return super.crawl(BonusFinancingService.BONUS_DETAIL_CHART_AJAX,params);
    }
}
