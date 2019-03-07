package cn.beerate.task;

import cn.beerate.controller.CompanySurveyController;
import cn.beerate.service.cninfo.DisclosureService;
import cn.beerate.service.eastmoney.f10.CompanySurveyService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component()
public class updateDisclosureByApiTask {
    private static final Log logger  = LogFactory.getLog(updateDisclosureByApiTask.class);

    private DisclosureService disclosureService;
    private CompanySurveyService companySurveyService;

    public updateDisclosureByApiTask(DisclosureService disclosureService, CompanySurveyService companySurveyService) {
        this.disclosureService = disclosureService;
        this.companySurveyService = companySurveyService;
    }


    /**
     * 每天0开始，每8小时执行一次,更新巨潮公告数据
     */
    @Scheduled(cron = "0 0 0/8 * * ?")
    public void doUpdateDisclosureByApi(){
        logger.info("------------------开始定时任务：更新巨潮公告数据------------------");
        disclosureService.updateDisclosureByApi();
        logger.info("------------------结束定时任务：更新巨潮公告数据------------------");
    }

    /**
     * 每天0执行一次,更新公司概况
     */
    @Scheduled(cron = "0 30 10 * * ?")
    public void updateCompanySurveys(){
        logger.info("------------------开始定时任务：公司概况------------------");
        companySurveyService.updateCompanySurveys();
        logger.info("------------------结束定时任务：公司概况------------------");
    }

}
