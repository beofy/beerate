package cn.beerate.service.tenjqka;

import cn.beerate.model.bean.tenjqka.DetailThshy;
import cn.beerate.model.bean.tenjqka.Thshy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ThshyServiceTest {

    @Autowired
    private ThshyService thshyService;

    @Test
    public void testIndexThshy(){
        List<Thshy> thshyList = thshyService.indexThshy("199112","desc","1");
        System.out.println(thshyList);
    }

    @Test
    public void testDetailThshy(){
        List<DetailThshy> detailThshyList = thshyService.detailThshy("10","desc","1","881132");
        System.out.println(detailThshyList);
    }

}
