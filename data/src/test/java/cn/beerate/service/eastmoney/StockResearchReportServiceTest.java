package cn.beerate.service.eastmoney;

import cn.beerate.common.Message;
import cn.beerate.model.entity.eastmoney.report.t_eastmoney_ggsr;
import cn.beerate.model.entity.eastmoney.report.t_eastmoney_hysr;
import cn.beerate.service.eastmoney.report.StockResearchReportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class StockResearchReportServiceTest {


    @Autowired
    private StockResearchReportService stockResearchReportService;

    @Test
    public void testStockResearchReport(){
        Message<List<t_eastmoney_ggsr>> listMessage = stockResearchReportService.stockResearchReport("50","1","000001","0","0");
    }

    @Test
    public void testIndustryResearchReport(){
       Message<List<t_eastmoney_hysr>> hysrMessage =stockResearchReportService.industryResearchReport("50","1","","0","0");
    }

    @Test
    public void updateStockResearchReport(){
        stockResearchReportService.updateAllStockCodesData();
    }

    @Test
    public void testUpdateIndustryResearchReport(){
        stockResearchReportService.updateIndustryResearchReport("50","1","","0","0");
    }
}
