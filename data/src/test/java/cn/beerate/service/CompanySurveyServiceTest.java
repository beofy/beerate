package cn.beerate.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class CompanySurveyServiceTest {

    @Autowired
    private CompanySurveyService companySurveyService;

    @Test
    public void testCompanySurvey(){
        companySurveyService.companySurvey("sz000001");
    }

}
