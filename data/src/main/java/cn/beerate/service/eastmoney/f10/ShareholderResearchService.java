package cn.beerate.service.eastmoney.f10;

import cn.beerate.common.Message;
import cn.beerate.dao.eastmoney.f10.shareholderresearch.*;
import cn.beerate.model.bean.eastmoney.f10.ShareholderResearch;
import cn.beerate.model.entity.eastmoney.f10.shareholderresearch.*;
import cn.beerate.service.EastMoneyService;
import cn.beerate.service.IEastMoneyService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 股东研究
 */
@Component
@Transactional(readOnly = true)
public class ShareholderResearchService extends EastMoneyService implements IEastMoneyService {

    private GdrsDao gdrsDao;
    private JjcgDao jjcgDao;
    private KggxDao kggxDao;
    private SdgdDao sdgdDao;
    private SdltgdChartDao sdltgdChartDao;
    private SdltgdDao sdltgdDao;
    private ZlccDao zlccDao;

    public ShareholderResearchService(GdrsDao gdrsDao, JjcgDao jjcgDao, KggxDao kggxDao, SdgdDao sdgdDao, SdltgdChartDao sdltgdChartDao, SdltgdDao sdltgdDao, ZlccDao zlccDao) {
        this.gdrsDao = gdrsDao;
        this.jjcgDao = jjcgDao;
        this.kggxDao = kggxDao;
        this.sdgdDao = sdgdDao;
        this.sdltgdChartDao = sdltgdChartDao;
        this.sdltgdDao = sdltgdDao;
        this.zlccDao = zlccDao;

        super.eastMoneyService=this;
    }

    /**
     * 根据股票代码抓取-股东研究
     *
     * @param stockCode 股票代码
     */
    public Message<ShareholderResearch> shareholderResearch(String stockCode) {
        String url = "http://emweb.securities.eastmoney.com/ShareholderResearch/ShareholderResearchAjax";
        Map<String, String> params = new HashMap<>();
        params.put("code", stockCode);

        return super.getBean(ShareholderResearch.class, url, params);
    }

    /**
     * 抓取机构持仓
     *
     * @param stockCode 股票代码
     * @param date      日期
     */
    public Message<List<t_eastmoney_zlcc>> mainPositionsHodler(String stockCode, String date) {
        String url = "http://emweb.securities.eastmoney.com/ShareholderResearch/MainPositionsHodlerAjax";
        Map<String, String> params = new HashMap<>();
        params.put("date", date);
        params.put("code", stockCode);

        return super.getListBean(t_eastmoney_zlcc.class, url, params);
    }


    @Override
    @Transactional
    public void updateByStockCodes(String code) {
        /*
         * 这里不更新 十大股东持股变动 和 限售解禁
         */
        Message<ShareholderResearch> shareholderResearchMessage = shareholderResearch(code);
        if(!shareholderResearchMessage.fail()){
            List<t_eastmoney_gdrs> gdrsList  =  shareholderResearchMessage.getData().getGdrs();//股东人数
            List<t_eastmoney_sdltgd> sdltgdList =  shareholderResearchMessage.getData().getSdltgd();//十大流通股东
            List<t_eastmoney_sdgd> sdgdList = shareholderResearchMessage.getData().getSdgd();//十大股东
            List<t_eastmoney_jjcg> jjcgList = shareholderResearchMessage.getData().getJjcg();//基金持股
            t_eastmoney_kggx kggx = shareholderResearchMessage.getData().getKggx();//数据控制人
            List<t_eastmoney_sdltgd_chart> sdltgdChartList = shareholderResearchMessage.getData().getSdltgd_chart();//流通股东占比详情
            List<t_eastmoney_zlcc> zlccList = new ArrayList<>();//机构持仓
            shareholderResearchMessage.getData().getZlcc_rz().forEach(s -> {
                Message<List<t_eastmoney_zlcc>> zlListMessage = mainPositionsHodler(code,s);
                if(!zlListMessage.fail()){
                    zlccList.addAll(zlListMessage.getData()) ;
                }
            });

            //添加股票代码
            gdrsList.forEach(t_eastmoney_gdrs -> t_eastmoney_gdrs.setCode(code));
            sdltgdList.forEach(t_eastmoney_sdltgd -> t_eastmoney_sdltgd.setCode(code));
            sdgdList.forEach(t_eastmoney_sdgd -> t_eastmoney_sdgd.setCode(code));
            jjcgList.forEach(t_eastmoney_jjcg -> t_eastmoney_jjcg.setCode(code));
            kggx.setCode(code);
            sdltgdChartList.forEach(t_eastmoney_sdltgd_chart -> t_eastmoney_sdltgd_chart.setCode(code));
            zlccList.forEach(t_eastmoney_zlcc -> t_eastmoney_zlcc.setCode(code));

            //删除数据
            gdrsDao.deleteByCode(code);
            jjcgDao.deleteByCode(code);
            kggxDao.deleteByCode(code);
            sdgdDao.deleteByCode(code);
            sdltgdChartDao.deleteByCode(code);
            sdltgdDao.deleteByCode(code);
            zlccDao.deleteByCode(code);

            //更新数据
            gdrsDao.saveAll(gdrsList);
            jjcgDao.saveAll(jjcgList);
            kggxDao.save(kggx);
            sdgdDao.saveAll(sdgdList);
            sdltgdChartDao.saveAll(sdltgdChartList);
            sdltgdDao.saveAll(sdltgdList);
            zlccDao.saveAll(zlccList);
        }


    }

}
