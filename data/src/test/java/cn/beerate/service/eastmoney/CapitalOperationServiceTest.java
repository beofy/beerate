package cn.beerate.service.eastmoney;

import cn.beerate.service.eastmoney.f10.CapitalOperationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class CapitalOperationServiceTest {

    @Autowired
    private CapitalOperationService capitalOperationService;


    @Test
    public void updateCapitalOperation() {
        capitalOperationService.updateAllStockCodesData();
    }
}
