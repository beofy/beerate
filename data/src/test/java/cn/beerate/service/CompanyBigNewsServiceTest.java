package cn.beerate.service;

import cn.beerate.service.emweb.CompanyBigNewsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class CompanyBigNewsServiceTest {
    @Autowired
    private CompanyBigNewsService bigNewsService;

    @Test
    public void testCompanyBigNews(){
        bigNewsService.companyBigNews("sz000001");
    }
}
