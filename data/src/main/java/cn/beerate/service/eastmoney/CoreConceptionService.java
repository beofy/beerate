package cn.beerate.service.eastmoney;

import cn.beerate.common.Message;
import cn.beerate.service.base.BaseCrawlService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Component
@Transactional
public class CoreConceptionService extends BaseCrawlService {

    private final String URL="http://emweb.securities.eastmoney.com/CoreConception/CoreConceptionAjax";

    /**
     * 抓取核心题材
     * @param stockCode 股票代码
     */
    public Message<String> coreConception(String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);

        return Message.success(super.getText(this.URL,params));
    }

}
