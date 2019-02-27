package cn.beerate.service.eastmoney;

import cn.beerate.service.eastmoney.f10.BusinessAnalysisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class BusinessAnalysisServiceTest {

    @Autowired
    private BusinessAnalysisService analysisService;

    @Test
    public void testBusinessAnalysis(){
        analysisService.businessAnalysis("sz000001");
    }
}
