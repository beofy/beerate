package cn.beerate.service.eastmoney;

import cn.beerate.common.Message;
import cn.beerate.model.bean.eastmoney.report.GGSR;
import cn.beerate.service.base.BaseCrawlService;
import cn.beerate.service.eastmoney.report.StockResearchReportService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
        Message<List<GGSR>> listMessage = stockResearchReportService.stockResearchReport("50","1","000001");

        System.out.println(listMessage);
    }
}
