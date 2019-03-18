package cn.beerate.service.eastmoney.f10;

import cn.beerate.common.Message;
import cn.beerate.dao.eastmoney.f10.capitaloperation.CapitalFromDao;
import cn.beerate.dao.eastmoney.f10.capitaloperation.ProjectProgressDao;
import cn.beerate.model.bean.eastmoney.f10.CapitalOperation;
import cn.beerate.model.entity.eastmoney.f10.capitaloperation.t_eastmoney_capital_from;
import cn.beerate.model.entity.eastmoney.f10.capitaloperation.t_eastmoney_project_progress;
import cn.beerate.service.EastMoneyService;
import cn.beerate.service.IEastMoneyService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资本运作
 */
@Component
@Transactional(readOnly = true)
public class CapitalOperationService extends EastMoneyService implements IEastMoneyService {


    private CapitalFromDao capitalFromDao;
    private ProjectProgressDao projectProgressDao;

    public CapitalOperationService(CapitalFromDao capitalFromDao, ProjectProgressDao projectProgressDao) {
        this.capitalFromDao = capitalFromDao;
        this.projectProgressDao = projectProgressDao;

        super.eastMoneyService=this;
    }

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
    public Message<CapitalOperation> capitalOperation(String code, String orderBy, String isAsc){
        String url="http://emweb.securities.eastmoney.com/CapitalOperation/CapitalOperationAjax";
        Map<String,String> params = new HashMap<>();
        params.put("code",code);
        params.put("orderBy",orderBy);
        params.put("isAsc",isAsc);

        return super.getBean(CapitalOperation.class,url,params);
    }

    public Message<CapitalOperation> findCapitalOperationByCode(String code){
        CapitalOperation capitalOperation = new CapitalOperation();
        capitalOperation.setCapitalFrom(capitalFromDao.findByCode(code));
        capitalOperation.setProjectProgress(projectProgressDao.findByCode(code));

        return Message.success(capitalOperation);
    }

    @Override
    public void updateByStockCodes(String code) {
        Message<CapitalOperation> capitalOperationMessage = capitalOperation(code,"1","false");
        if(!capitalOperationMessage.fail()){
            List<t_eastmoney_capital_from> capitalFromList = capitalOperationMessage.getData().getCapitalFrom();//募集资金来源
            List<t_eastmoney_project_progress> projectProgressList = capitalOperationMessage.getData().getProjectProgress();// 项目进度

            //添加股票代码
            capitalFromList.forEach(t_eastmoney_capital_from -> t_eastmoney_capital_from.setCode(code));
            projectProgressList.forEach(t_eastmoney_project_progress -> t_eastmoney_project_progress.setCode(code));

            //删除数据
            capitalFromDao.deleteByCode(code);
            projectProgressDao.deleteByCode(code);

            //保存数据
            capitalFromDao.saveAll(capitalFromList);
            projectProgressDao.saveAll(projectProgressList);
        }
    }

}
