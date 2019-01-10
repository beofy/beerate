package cn.beerate.service;

import cn.beerate.common.Message;
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
       Message<String> message = financeAnalysisService.crawlMainTarget("0","SZ000002");
        //测试杜邦分析
        message = financeAnalysisService.crawlDubangAnalysis("SZ000002");
        //测试资产负债表
        message = financeAnalysisService.crawlZcfzb("0","1","","SZ000002");
        //测试利润表
        message = financeAnalysisService.crawlLrb("0","1","","SZ000002");
        //现金流量表
        message = financeAnalysisService.crawlXjllb("0","1","","SZ000002");

        //百分比报表-按类型
        message = financeAnalysisService.crawlPercentIndex("SZ000002");
        //百分比报表-按类型
        message = financeAnalysisService.crawlPercent("SZ000002","0");
    }

}
