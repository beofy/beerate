package cn.beerate.service.eastmoney.f10;

import cn.beerate.common.Message;
import cn.beerate.dao.eastmoney.f10.bonusfinancing.FhyxDao;
import cn.beerate.dao.eastmoney.f10.bonusfinancing.LnfhrzDao;
import cn.beerate.dao.eastmoney.f10.bonusfinancing.PgmxDao;
import cn.beerate.dao.eastmoney.f10.bonusfinancing.ZfmxDao;
import cn.beerate.model.bean.eastmoney.f10.BonusFinancing;
import cn.beerate.service.EastMoneyService;
import cn.beerate.service.IEastMoneyService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 分红融资
 */
@Component
@Transactional(readOnly = true)
public class BonusFinancingService extends EastMoneyService implements IEastMoneyService {

    private FhyxDao fhyxDao;
    private LnfhrzDao lnfhrzDao;
    private PgmxDao pgmxDao;
    private ZfmxDao zfmxDao;

    public BonusFinancingService(FhyxDao fhyxDao, LnfhrzDao lnfhrzDao, PgmxDao pgmxDao, ZfmxDao zfmxDao) {
        this.fhyxDao = fhyxDao;
        this.lnfhrzDao = lnfhrzDao;
        this.pgmxDao = pgmxDao;
        this.zfmxDao = zfmxDao;

        super.eastMoneyService=this;
    }

    /**
     *  抓取分红融资<br>
     *  包含（分红影响 | 历年分红融资 | 增发明细 | 配股明细）
     * @param stockCode 股票代码
     *
     */
    public Message<BonusFinancing> bonusFinancing(String stockCode){
        String url ="http://emweb.securities.eastmoney.com/BonusFinancing/BonusFinancingAjax";
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);

        return super.getBean(BonusFinancing.class,url,params) ;
    }

    /**
     * 抓取每日分红价格<br>
     * @param stockCode 股票代码
     * @param date 日期
     * @return Message<String>
     */
    public Message<String> bonusDetailChart(String stockCode,String date){
        String url="http://emweb.securities.eastmoney.com/BonusFinancing/BonusDetailChartAjax";
        Map<String,String> params = new HashMap<>();
        params.put("code",stockCode);
        params.put("date",date);

        return Message.success(super.getJsonString(url,params)) ;
    }

    public Message<BonusFinancing> findByStockCode(String code){
        BonusFinancing bonusFinancing = new BonusFinancing();
        bonusFinancing.setFhyx(fhyxDao.findByCode(code));
        bonusFinancing.setLnfhrz(lnfhrzDao.findByCode(code));
        bonusFinancing.setZfmx(zfmxDao.findByCode(code));
        bonusFinancing.setPgmx(pgmxDao.findByCode(code));

        return Message.success(bonusFinancing);
    }


    @Override
    @Transactional
    public void updateByStockCodes(String code) {
        Message<BonusFinancing> bonusFinancingMessage = bonusFinancing(code);
        if(!bonusFinancingMessage.fail()){
            //添加股票代码
            bonusFinancingMessage.getData().getFhyx().forEach(t_eastmoney_fhyx -> t_eastmoney_fhyx.setCode(code));
            bonusFinancingMessage.getData().getLnfhrz().forEach(t_eastmoney_lnfhrz -> t_eastmoney_lnfhrz.setCode(code));
            bonusFinancingMessage.getData().getZfmx().forEach(t_eastmoney_zfmx -> t_eastmoney_zfmx.setCode(code));
            bonusFinancingMessage.getData().getPgmx().forEach(t_eastmoney_pgmx -> t_eastmoney_pgmx.setCode(code));

            //删除数据
            fhyxDao.deleteByCode(code);
            lnfhrzDao.deleteByCode(code);
            zfmxDao.deleteByCode(code);
            pgmxDao.deleteByCode(code);

            //保存数据
            fhyxDao.saveAll(bonusFinancingMessage.getData().getFhyx());
            lnfhrzDao.saveAll(bonusFinancingMessage.getData().getLnfhrz());
            zfmxDao.saveAll(bonusFinancingMessage.getData().getZfmx());
            pgmxDao.saveAll(bonusFinancingMessage.getData().getPgmx());
        }
    }
}
