package cn.beerate.service;

import cn.beerate.service.eastmoney.ProfitForecastService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ProfitForecastServiceTest {
    @Autowired
    private ProfitForecastService profitForecastService;

    @Test
    public void testProfitForecast(){
        profitForecastService.profitForecast("sz000001");
    }
}
