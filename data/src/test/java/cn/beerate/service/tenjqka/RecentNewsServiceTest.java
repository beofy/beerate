package cn.beerate.service.tenjqka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class RecentNewsServiceTest {

    @Autowired
    private RecentNewsService recentNewsService;

    @Test
    public void testProfile(){
         recentNewsService.profile("300603");
    }

    @Test
    public void testPointNew(){
        recentNewsService.pointNew("300603");
    }

}
