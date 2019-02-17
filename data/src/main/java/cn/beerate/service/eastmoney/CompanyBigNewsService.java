package cn.beerate.service.eastmoney;

import cn.beerate.common.Message;
import cn.beerate.service.base.BaseCrawlService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Component
@Transactional
public class CompanyBigNewsService extends BaseCrawlService {

    private final String URL = "http://emweb.securities.eastmoney.com/companybignews/CompanyBigNewsAjax";

    private final String PLEDGEHOLDER_URL="http://emweb.securities.eastmoney.com/CompanyBigNews/GetPledgeHolder";

    /**
     *  抓取公司大事
     * @param stockCode 股票代码
     */
    public Message<String> companyBigNews(String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("requesttimes","1");
        params.put("code",stockCode);

        return Message.success(super.getText(this.URL,params));
    }

    /**
     * 分页获取股票质押
     * @param code 股票代码
     * @param pageIndex 页数
     * @return Message<String>
     */
    public Message<String> getPledgeHolder(String code,String pageIndex){
        Map<String,String> params = new HashMap<>();
        params.put("code",code);
        params.put("pageIndex",pageIndex);

        return Message.success(super.getText(this.PLEDGEHOLDER_URL,params));
    }
}
