package cn.beerate.service.eastmoney;

import cn.beerate.common.Message;
import cn.beerate.service.eastmoney.f10.NewFinanceAnalysisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class NewFinanceAnalysisServiceTest {

    @Autowired
    private NewFinanceAnalysisService financeAnalysisService;

    @Test
    public void testAll(){
        //测试主要指标
       financeAnalysisService.mainTarget("0","SZ000002");
        //测试杜邦分析
        financeAnalysisService.dubangAnalysis("SZ000002");
        //测试资产负债表
        financeAnalysisService.zcfzb("0","1","","SZ000002");
        //测试利润表
        financeAnalysisService.lrb("0","1","","SZ000002");
        //现金流量表
        financeAnalysisService.xjllb("0","1","","SZ000002");
        //百分比报表-按类型
        Message message = financeAnalysisService.percentIndex("SZ000002");
        //百分比报表-按类型
        financeAnalysisService.percent("SZ000002","0");
    }

    @Test
    public void updateMainTarget(){
        financeAnalysisService.updateAllStockCodesData(financeAnalysisService.getMainTargetService());
    }

    @Test
    public void updateDubangAnalysis(){
        financeAnalysisService.updateAllStockCodesData(financeAnalysisService.getDubangAnalysisService());
    }

    @Test
    public void updateZcfzb(){
        financeAnalysisService.updateAllStockCodesData(financeAnalysisService.getZcfzbService());
    }

    @Test
    public void updateLrb(){
        financeAnalysisService.updateAllStockCodesData(financeAnalysisService.getLrbService());
    }

    @Test
    public void updateXjllb(){
        financeAnalysisService.updateAllStockCodesData(financeAnalysisService.getXjllbService());
    }

    @Test
    public void updatePercent(){
        financeAnalysisService.updateAllStockCodesData(financeAnalysisService.getPercentService());
    }
}
