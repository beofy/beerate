package cn.beerate.service;

import cn.beerate.service.emweb.NewsBulletinService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class NewsBulletinServiceTest {

    @Autowired
    private NewsBulletinService bulletinService;

    @Test
    public void testNewsBulletin(){
        this.bulletinService.newsBulletin("sz000001");
    }
}
