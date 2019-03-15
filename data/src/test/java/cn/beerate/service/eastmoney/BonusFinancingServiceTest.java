package cn.beerate.service.eastmoney;

import cn.beerate.common.Message;
import cn.beerate.service.eastmoney.f10.BonusFinancingService;
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
        bonusFinancingService.bonusFinancing("SZ000002");
        bonusFinancingService.bonusDetailChart("SZ000002","2018-08-21");
    }

    @Test
    public void testUpdateAllStockCodesData(){

        bonusFinancingService.updateAllStockCodesData();
    }
}
