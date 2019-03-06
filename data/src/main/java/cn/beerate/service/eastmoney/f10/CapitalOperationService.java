package cn.beerate.service.eastmoney.f10;

import cn.beerate.common.Message;
import cn.beerate.service.BaseCrawlService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 资本运作
 */
@Component
@Transactional
public class CapitalOperationService extends BaseCrawlService {

    private final String CAPITAL_OPERATION_AJAX="http://emweb.securities.eastmoney.com/CapitalOperation/CapitalOperationAjax";

    /**
     * 资本运作
     * @param code 股票代码
     * @param orderBy
     *       <ul style="color:red">
     *           <li >
     *              <span>截止日期 -- 1</span>
     *           </li>
     *            <li>
     *              <span>计划投资(万元) -- 2</span>
     *           </li>
     *            <li>
     *               <span>已投入募集资金(万元) -- 3</span>
     *           </li>
     *           <li>
     *               <span>建设期(年) -- 4</span>
     *            </li>
     *            <li>
     *               <span>收益率(税后) -- 5</span>
     *            </li>
     *            <li>
     *               <span>投资回收期(年) -- 6</span>
     *           </li>
     *       </ul>
     * @param isAsc  false：降序 | true:升序
     * @return Message<String>
     */
    public Message<String> capitalOperation(String code, String orderBy, String isAsc){
        Map<String,String> params = new HashMap<String,String>();
        params.put("code",code);
        params.put("orderBy",orderBy);
        params.put("isAsc",isAsc);

        return Message.success(super.getJsonString(this.CAPITAL_OPERATION_AJAX,params));
    }

}
