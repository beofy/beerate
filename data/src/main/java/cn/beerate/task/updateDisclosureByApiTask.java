package cn.beerate.task;

import cn.beerate.service.cninfo.DisclosureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("updateDisclosureByApiTask")
public class updateDisclosureByApiTask {
    @Autowired
    private DisclosureService disclosureService;

    @Scheduled(cron = "0 55 11 * * ? ")
    public void doUpdateDisclosureByApi(){
        disclosureService.updateDisclosureByApi();
    }

}
