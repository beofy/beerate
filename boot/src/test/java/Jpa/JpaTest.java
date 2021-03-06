package Jpa;

import cn.beerate.dao.AdminDao;
import cn.beerate.model.entity.t_admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class JpaTest {
    @Autowired
    private AdminDao adminDao;

    @Test
    public void testJpaAdd(){
        t_admin admin =  new t_admin();
        admin.setCreateTime(new Date());
        admin.setAccount("asd");
        admin.setPassword("123456");
        adminDao.save(admin);
    }
}
