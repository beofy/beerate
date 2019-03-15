package cn.beerate.task;

import cn.beerate.service.cninfo.DisclosureService;
import cn.beerate.service.eastmoney.f10.*;
import cn.beerate.service.eastmoney.report.StockResearchReportService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UpdateStockDataTask {
    private static final Log logger  = LogFactory.getLog(UpdateStockDataTask.class);

    private DisclosureService disclosureService;
    private CompanySurveyService companySurveyService;
    private CompanyBigNewsService companyBigNewsService;
    private CompanyManagementService companyManagementService;
    private CapitalStockStructureService capitalStockStructureService;
    private StockResearchReportService stockResearchReportService;
    private NewFinanceAnalysisService financeAnalysisService;
    private BonusFinancingService bonusFinancingService;

    public UpdateStockDataTask(DisclosureService disclosureService, CompanySurveyService companySurveyService, CompanyBigNewsService companyBigNewsService, CompanyManagementService companyManagementService, CapitalStockStructureService capitalStockStructureService, StockResearchReportService stockResearchReportService, NewFinanceAnalysisService financeAnalysisService, BonusFinancingService bonusFinancingService) {
        this.disclosureService = disclosureService;
        this.companySurveyService = companySurveyService;
        this.companyBigNewsService = companyBigNewsService;
        this.companyManagementService = companyManagementService;
        this.capitalStockStructureService = capitalStockStructureService;
        this.stockResearchReportService = stockResearchReportService;
        this.financeAnalysisService = financeAnalysisService;
        this.bonusFinancingService = bonusFinancingService;
    }

    /**
     * 每天0开始，每8小时执行一次,更新巨潮公告数据
     */
    @Scheduled(cron = "0 0 0/8 * * ?")
    public void updateDisclosure(){
        logger.info("------------------开始定时任务：更新巨潮公告数据------------------");
        disclosureService.updateDisclosureByApi();
        logger.info("------------------结束定时任务：更新巨潮公告数据------------------");
    }

    @Scheduled(cron = "0 0 9 * * ?")
    public void updateCompanySurveys(){
        logger.info("------------------开始定时任务：更新公司概况------------------");
        companySurveyService.updateAllStockCodesData();
        logger.info("------------------结束定时任务：更新公司概况------------------");
    }

    @Scheduled(cron = "0 0 10 * * ?")
    public void updateCompanyBigNews(){
        logger.info("------------------开始定时任务：更新公司大事数据------------------");
        companyBigNewsService.updateAllStockCodesData();
        logger.info("------------------结束定时任务：更新公司大事数据------------------");
    }

    @Scheduled(cron = "0 0 11 * * ?")
    public void updateCompanyManagement(){
        logger.info("------------------开始定时任务：更新公司高管数据------------------");
        companyManagementService.updateAllStockCodesData();
        logger.info("------------------结束定时任务：更新公司高管数据------------------");
    }

    @Scheduled(cron = "0 0 12 * * ?")
    public void updateCapitalStockStructure(){
        logger.info("------------------开始定时任务：更新股本结构数据------------------");
        capitalStockStructureService.updateAllStockCodesData();
        logger.info("------------------结束定时任务：更新股本结构数据------------------");
    }

    @Scheduled(cron = "0 0 13 * * ?")
    public void updateStockResearchReport(){
        logger.info("------------------开始定时任务：更新个股研报数据------------------");
        stockResearchReportService.updateAllStockCodesData();
        logger.info("------------------结束定时任务：更新个股研报数据------------------");
    }

    @Scheduled(cron = "0 0 14 * * ?")
    public void updateIndustryResearchReport(){
        logger.info("------------------开始定时任务：更新行业研报数据------------------");
        stockResearchReportService.updateIndustryResearchReport("50","1","","0","0");
        logger.info("------------------结束定时任务：更新行业研报数据------------------");
    }

    @Scheduled(cron = "0 0 15 * * ?")
    public void updateMainTarget(){
        logger.info("------------------开始定时任务：更新主要指标数据------------------");
        financeAnalysisService.updateAllStockCodesData(financeAnalysisService.getMainTargetService());
        logger.info("------------------开始定时任务：更新主要指标报数据------------------");
    }

    @Scheduled(cron = "0 0 16 * * ?")
    public void updateDubangAnalysis(){
        logger.info("------------------开始定时任务：更新杜邦分析数据------------------");
        financeAnalysisService.updateAllStockCodesData(financeAnalysisService.getDubangAnalysisService());
        logger.info("------------------开始定时任务：更新杜邦分析数据------------------");
    }

    @Scheduled(cron = "0 0 17 * * ?")
    public void updateZcfzb(){
        logger.info("------------------开始定时任务：更新资产负载表数据------------------");
        financeAnalysisService.updateAllStockCodesData(financeAnalysisService.getZcfzbService());
        logger.info("------------------开始定时任务：更新资产负载表数据------------------");
    }

    @Scheduled(cron = "0 0 18 * * ?")
    public void updateLrb(){
        logger.info("------------------开始定时任务：更新利润表数据------------------");
        financeAnalysisService.updateAllStockCodesData(financeAnalysisService.getLrbService());
        logger.info("------------------开始定时任务：更新利润表数据------------------");
    }

    @Scheduled(cron = "0 0 19 * * ?")
    public void updateXjllb(){
        logger.info("------------------开始定时任务：更新现金流量表数据------------------");
        financeAnalysisService.updateAllStockCodesData(financeAnalysisService.getXjllbService());
        logger.info("------------------开始定时任务：更新现金流量表数据------------------");
    }

    @Scheduled(cron = "0 0 20 * * ?")
    public void updatePercent(){
        logger.info("------------------开始定时任务：更新百分比报表数据------------------");
        financeAnalysisService.updateAllStockCodesData(financeAnalysisService.getPercentService());
        logger.info("------------------开始定时任务：更新百分比报表数据------------------");
    }


    @Scheduled(cron = "0 0 21 * * ?")
    public void updatebonusFinancing(){
        logger.info("------------------开始定时任务：更新分红融资数据------------------");
        bonusFinancingService.updateAllStockCodesData();
        logger.info("------------------开始定时任务：更新分红融资数据------------------");
    }
}
