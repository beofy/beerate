package cn.beerate.service.cninfo;

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
        disclosureService.getCurrDisclosures("000001");
    }


}
