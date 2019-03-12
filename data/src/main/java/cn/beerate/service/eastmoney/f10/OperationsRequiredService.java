package cn.beerate.service.eastmoney.f10;

import cn.beerate.common.Message;
import cn.beerate.service.BaseCrawlService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 *  操盘必读
 */
@Component
@Transactional(readOnly = true)
public class OperationsRequiredService extends BaseCrawlService {
    private final String URL="http://emweb.securities.eastmoney.com/OperationsRequired/OperationsRequiredAjax";

    /**
     *  操盘必读
     *  @param stockCode 股票代码
     */
    public Message<String> operationsRequired(String stockCode){
        Map<String,String> params = new HashMap<>();
        params.put("times","1");
        params.put("code",stockCode);

        return Message.success(super.getJsonString(this.URL,params));
    }
}
