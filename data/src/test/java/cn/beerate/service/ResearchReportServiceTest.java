package cn.beerate.service;

import cn.beerate.service.eastmoney.ResearchReportService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ResearchReportServiceTest {

    @Autowired
    private ResearchReportService researchReportService;

    @Test
    public void testResearchReport(){
        researchReportService.researchReport("sz000001");
    }
}
