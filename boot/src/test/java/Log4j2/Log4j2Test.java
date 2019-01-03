package Log4j2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class Log4j2Test {
    private Log log = LogFactory.getLog(Log4j2Test.class);

    @Test
    public void  logTest(){
        log.info("info.....");
    }

}
