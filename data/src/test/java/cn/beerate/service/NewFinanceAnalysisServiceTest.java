package cn.beerate.service;

import cn.beerate.common.Message;
import cn.beerate.service.emweb.NewFinanceAnalysisService;
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
       Message<String> message = financeAnalysisService.mainTarget("0","SZ000002");
        //测试杜邦分析
        message = financeAnalysisService.dubangAnalysis("SZ000002");
        //测试资产负债表
        message = financeAnalysisService.zcfzb("0","1","","SZ000002");
        //测试利润表
        message = financeAnalysisService.lrb("0","1","","SZ000002");
        //现金流量表
        message = financeAnalysisService.xjllb("0","1","","SZ000002");

        //百分比报表-按类型
        message = financeAnalysisService.percentIndex("SZ000002");
        //百分比报表-按类型
        message = financeAnalysisService.percent("SZ000002","0");
    }

}
