package cn.beerate.service.cninfo;

import cn.beerate.common.util.Crawler;
import org.jsoup.nodes.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class DisclosureServiceTest {

    @Autowired
    private DisclosureService disclosureService;


    @Test
    public void testGetAllDisclosure(){
        disclosureService.updateDisclosure();
    }

    @Test
    public void testGetCurrDisclosuresByApi(){
        disclosureService.getCurrDisclosuresByApi("000001",1,30,"","2000-01-01","2019-02-25",null);
    }

    @Test
    public void testUpdateDisclosureByApi(){
        disclosureService.updateDisclosureByApi();
    }


}
