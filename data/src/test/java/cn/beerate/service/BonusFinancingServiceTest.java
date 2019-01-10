package cn.beerate.service;

import cn.beerate.common.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class BonusFinancingServiceTest {

    @Autowired
    private BonusFinancingService bonusFinancingService;

    @Test
    public void testAll(){

       Message message = bonusFinancingService.crawlBonusFinancing("SZ000002");

       message= bonusFinancingService.crawlBonusDetailChart("SZ000002","2018-08-21");
    }
}
