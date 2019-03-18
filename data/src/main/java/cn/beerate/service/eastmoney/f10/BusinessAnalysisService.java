package cn.beerate.service.eastmoney.f10;

import cn.beerate.common.Message;
import cn.beerate.dao.eastmoney.f10.businessanalysis.JypsDao;
import cn.beerate.dao.eastmoney.f10.businessanalysis.ZyfwDao;
import cn.beerate.dao.eastmoney.f10.businessanalysis.ZygcfxDao;
import cn.beerate.model.bean.eastmoney.f10.BusinessAnalysis;
import cn.beerate.model.entity.eastmoney.f10.businessanalysis.t_eastmoney_jyps;
import cn.beerate.model.entity.eastmoney.f10.businessanalysis.t_eastmoney_zyfw;
import cn.beerate.model.entity.eastmoney.f10.businessanalysis.t_eastmoney_zygcfx;
import cn.beerate.service.EastMoneyService;
import cn.beerate.service.IEastMoneyService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 经营分析
 */
@Component
@Transactional(readOnly = true)
public class BusinessAnalysisService extends EastMoneyService implements IEastMoneyService{

    private ZyfwDao zyfwDao;
    private JypsDao jypsDao;
    private ZygcfxDao zygcfxDao;

    public BusinessAnalysisService(ZyfwDao zyfwDao, JypsDao jypsDao, ZygcfxDao zygcfxDao) {
        this.zyfwDao = zyfwDao;
        this.jypsDao = jypsDao;
        this.zygcfxDao = zygcfxDao;

        super.eastMoneyService=this;
    }

    /**
     * 抓取经营分析
     * @param stockCode 股票代码
     * @return Message<String>
     */
    public Message<BusinessAnalysis> businessAnalysis(String stockCode){
        String url="http://emweb.securities.eastmoney.com/BusinessAnalysis/BusinessAnalysisAjax";
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);

        return super.getBean(BusinessAnalysis.class,url,params);
    }

    public Message<BusinessAnalysis> findBusinessAnalysisByStockCode(String stockCode){
        BusinessAnalysis businessAnalysis = new BusinessAnalysis();
        businessAnalysis.setZyfw(zyfwDao.findByCode(stockCode));
        businessAnalysis.setJyps(jypsDao.findByCode(stockCode));
        businessAnalysis.setZygcfx(zygcfxDao.findByCode(stockCode));

        return Message.success(businessAnalysis);
    }



    @Override
    @Transactional
    public void updateByStockCodes(String code) {
        Message<BusinessAnalysis> businessAnalysisMessage =  businessAnalysis(code);
        if(!businessAnalysisMessage.fail()){
            List<t_eastmoney_zyfw> zyfwList = businessAnalysisMessage.getData().getZyfw();//主营范围
            List<t_eastmoney_zygcfx> zygcfxList = businessAnalysisMessage.getData().getZygcfx();//主营构成分析
            List<t_eastmoney_jyps> jypsList = businessAnalysisMessage.getData().getJyps();//经营评述

            //删除数据
            zyfwDao.deleteByCode(code);

            //更新数据
            if(zyfwList.size()>0){
                t_eastmoney_zyfw zyfw = zyfwList.get(0);
                zyfw.setCode(code);
                zyfwDao.save(zyfw);
            }
            if(jypsList.size()>0){
                t_eastmoney_jyps jyps = jypsList.get(0);
                jyps.setCode(code);
                jypsDao.save(jyps);

            }

            zygcfxList.forEach(t_eastmoney_zygcfx -> t_eastmoney_zygcfx.setCode(code));
            zygcfxDao.saveAll(zygcfxList);
        }
    }
}
