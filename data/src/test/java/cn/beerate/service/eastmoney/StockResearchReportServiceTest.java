package cn.beerate.service.eastmoney;

import cn.beerate.common.Message;
import cn.beerate.model.bean.eastmoney.report.GGSR;
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
        Message<List<GGSR>> listMessage = stockResearchReportService.stockResearchReport("50","1","000001","0","0");

        System.out.println(listMessage);
    }

    @Test
    public void testIndustryResearchReport(){
       Message message =stockResearchReportService.industryResearchReport("50","1","","0","0");

       System.out.println(message);
    }
}
