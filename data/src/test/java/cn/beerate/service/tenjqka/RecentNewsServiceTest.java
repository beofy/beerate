package cn.beerate.service.tenjqka;

import cn.beerate.common.util.StockCodeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class RecentNewsServiceTest {

    @Autowired
    private RecentNewsService recentNewsService;

    @Test
    public void testProfile(){
         //recentNewsService.profile("300603");

        Set<String> stockCodes =  StockCodeUtil.getStockCode();
        for (String s:stockCodes) {
            try {
                recentNewsService.profile(StockCodeUtil.getNumberStockCode(s));
            }catch (Exception e){
                System.out.println(e.getMessage()+",股票代码："+s);
            }
        }

    }

    @Test
    public void testPointNew(){
        recentNewsService.pointNew("300603");
    }

}
