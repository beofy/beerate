package cn.beerate.service.eastmoney;

import cn.beerate.common.Message;
import cn.beerate.service.base.BaseCrawlService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 *  操盘必读
 */
@Component
@Transactional
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

        return Message.success(super.getText(this.URL,params));
    }
}
