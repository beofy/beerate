package cn.beerate.task;

import cn.beerate.service.cninfo.DisclosureService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component()
public class updateDisclosureByApiTask {
    private static final Log logger  = LogFactory.getLog(updateDisclosureByApiTask.class);

    @Autowired
    private DisclosureService disclosureService;

    /**
     * 每天0开始，每8小时执行一次
     */
    @Scheduled(cron = "0 0 0/8 * * ?")
    public void doUpdateDisclosureByApi(){
        logger.info("------------------开始定时任务：更新巨潮公告数据------------------");
        disclosureService.updateDisclosureByApi();
        logger.info("------------------结束定时任务：更新巨潮公告数据------------------");
    }

}
