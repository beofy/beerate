package cn.beerate.task;

import cn.beerate.service.base.BaseCrawlService;
import cn.beerate.service.cninfo.DisclosureService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("updateDisclosureByApiTask")
public class updateDisclosureByApiTask {
    private static final Log logger  = LogFactory.getLog(updateDisclosureByApiTask.class);

    @Autowired
    private DisclosureService disclosureService;

    /**
     * 每天0 6 12 18 点执行
     */
    @Scheduled(cron = "0 0 0,6,12,18 * * ? ")
    public void doUpdateDisclosureByApi(){
        logger.info("------------------开始定时任务：更新巨潮公告数据------------------");
        disclosureService.updateDisclosureByApi();
        logger.info("------------------结束定时任务：更新巨潮公告数据------------------");
    }

}
