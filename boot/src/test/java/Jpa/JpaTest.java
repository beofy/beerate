package Jpa;

import cn.beerate.dao.Impl.AdminDaoImpl;
import cn.beerate.model.entity.t_admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class JpaTest {

    @Autowired
    private AdminDaoImpl adminDao;



    @PersistenceContext
    private EntityManager em;

    @Test
    public void testJpaAdd(){
        if(em.getTransaction().isActive()){
            em.getTransaction().begin();
        }

        t_admin admin =  new t_admin();
        admin.setCreateTime(new Date());
        admin.setAccount("asd");
        admin.setPassword("123456");
        adminDao.save(admin);
        em.getTransaction().commit();
    }
}
