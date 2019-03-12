package cn.beerate.service.eastmoney.f10;

import cn.beerate.common.Message;
import cn.beerate.dao.eastmoney.f10.companybignews.*;
import cn.beerate.model.bean.eastmoney.f10.CompanyBigNews;
import cn.beerate.model.entity.eastmoney.f10.companybignews.*;
import cn.beerate.service.EastMoneyService;
import cn.beerate.service.IEastMoneyService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Transactional(readOnly = true)
public class CompanyBigNewsService extends EastMoneyService  implements IEastMoneyService {
    private DwdbDao dwdbDao;
    private DzjyDao dzjyDao;
    private GgcgbdDao ggcgbdDao;
    private GqzyDao gqzyDao;
    private LhbdDao lhbdDao;
    private RzrqDao rzrqDao;
    private SdgdcgbdDao sdgdcgbdDao;
    private SszcDao sszcDao;
    private WgclDao wgclDao;
    private XsjjDao xsjjDao;

    public CompanyBigNewsService(DwdbDao dwdbDao, DzjyDao dzjyDao, GgcgbdDao ggcgbdDao, GqzyDao gqzyDao,LhbdDao lhbdDao, RzrqDao rzrqDao, SdgdcgbdDao sdgdcgbdDao, SszcDao sszcDao, WgclDao wgclDao, XsjjDao xsjjDao) {
        this.dwdbDao = dwdbDao;
        this.dzjyDao = dzjyDao;
        this.ggcgbdDao = ggcgbdDao;
        this.gqzyDao = gqzyDao;
        this.lhbdDao = lhbdDao;
        this.rzrqDao = rzrqDao;
        this.sdgdcgbdDao = sdgdcgbdDao;
        this.sszcDao = sszcDao;
        this.wgclDao = wgclDao;
        this.xsjjDao = xsjjDao;

        super.eastMoneyService=this;
    }

    /**
     *  抓取公司大事
     * @param stockCode 股票代码
     */
    public Message<CompanyBigNews> companyBigNews(String stockCode){
        String url = "http://emweb.securities.eastmoney.com/companybignews/CompanyBigNewsAjax";
        Map<String,String> params = new HashMap<>();
        params.put("requesttimes","1");
        params.put("code",stockCode);


        return super.getBean(CompanyBigNews.class,url,params);
    }

    /**
     * 分页获取股票质押
     * @param code 股票代码
     * @param pageIndex 页数
     * @return Message<String>
     */
    public Message<List<t_eastmoney_gqzy>> getPledgeHolder(String code, String pageIndex){
        String url="http://emweb.securities.eastmoney.com/CompanyBigNews/GetPledgeHolder";
        Map<String,String> params = new HashMap<>();
        params.put("code",code);
        params.put("pageIndex",pageIndex);

        return super.getListBean(t_eastmoney_gqzy.class,url,params);
    }

    /**
     * 根据股票代码获取公司大事,包含(大事提醒|重大事项|限售解禁|十大股东持股变动|高管持股变动|龙虎榜单|大宗交易|融资融券)
     * @param code 股票代码
     */
    public Message<CompanyBigNews> findCompanyBigNewsByStockCode(String code){
        /*
         * 注：该方法采用懒加载策略，默认控制层一关闭hibernate session会话，
         * 当控制返回Message 转化为json数据时会默认调用get方式触发延时加载，出现on seesion异常
         * 解决方法将当前Controller绑定session
         */
        CompanyBigNews companyBigNews = new CompanyBigNews();
        companyBigNews.setDstx(null);
        companyBigNews.setGqzy(gqzyDao.findByCode(code));
        companyBigNews.setDwdb(dwdbDao.findByCode(code));
        companyBigNews.setSszc(sszcDao.findByCode(code));
        companyBigNews.setWgcl(wgclDao.findByCode(code));
        companyBigNews.setXsjj(xsjjDao.findByCode(code));
        companyBigNews.setSdgdcgbd(sdgdcgbdDao.findByCode(code));
        companyBigNews.setGgcgbd(ggcgbdDao.findByCode(code)) ;
        companyBigNews.setDzjy(dzjyDao.findByCode(code)) ;
        companyBigNews.setRzrq(rzrqDao.findByCode(code));
        companyBigNews.setLhbd(lhbdDao.findByCode(code));

        return Message.success(companyBigNews);
    }

    @Override
    @Transactional
    public void updateByStockCodes(String code) {
        Message<CompanyBigNews> companyBigNewsMessage = companyBigNews(code);
        if (!companyBigNewsMessage.fail()){
            CompanyBigNews companyBigNews = companyBigNewsMessage.getData();

            List<t_eastmoney_gqzy> gqzyList= companyBigNews.getGqzy();
            List<t_eastmoney_dwdb> dwdbList= companyBigNews.getDwdb();
            List<t_eastmoney_sszc> sszcList=  companyBigNews.getSszc();
            List<t_eastmoney_wgcl> wgclList=  companyBigNews.getWgcl();
            List<t_eastmoney_xsjj> xsjjList=  companyBigNews.getXsjj();
            List<t_eastmoney_sdgdcgbd> sdgdcgbdList=  companyBigNews.getSdgdcgbd();
            List<t_eastmoney_ggcgbd> ggcgbdList=  companyBigNews.getGgcgbd();
            List<t_eastmoney_lhbd> lhbdList= companyBigNews.getLhbd();
            List<t_eastmoney_dzjy> dzjyList=  companyBigNews.getDzjy();
            List<t_eastmoney_rzrq> rzrqList=  companyBigNews.getRzrq();

            gqzyList.forEach(gqzy -> gqzy.setCode(code) );//股权质押
            dwdbList.forEach(dwdb -> dwdb.setCode(code));//对外担保
            sszcList.forEach(sszc ->sszc.setCode(code));//诉讼仲裁
            wgclList.forEach(wgcl->wgcl.setCode(code));//违规处理
            xsjjList.forEach(xsjj -> xsjj.setCode(code));//限售解禁
            sdgdcgbdList.forEach(sdgdcgbd -> sdgdcgbd.setCode(code));//十大股东持股变动
            ggcgbdList.forEach(ggcgbd -> ggcgbd.setCode(code));//高管持股变动
            lhbdList.forEach(lhbd-> {//龙虎榜单
                lhbd.setCode(code);
                //数据关系为一对多，这里处理一下级联关系，设置多方，
                lhbd.getGroup_mc().forEach(eastmoney_group_mc -> eastmoney_group_mc.setLhbd(lhbd));
                lhbd.getGroup_mr().forEach(eastmoney_group_mr ->eastmoney_group_mr.setLhbd(lhbd));
            });
            dzjyList.forEach(dzjy ->dzjy.setCode(code));//大宗交易
            rzrqList.forEach(rzrq ->rzrq.setCode(code));//融资融券

            //删除数据
            dwdbDao.deleteByCode(code);
            dzjyDao.deleteByCode(code);
            ggcgbdDao.deleteByCode(code);
            gqzyDao.deleteByCode(code);
            lhbdDao.deleteByCode(code);
            rzrqDao.deleteByCode(code);
            sdgdcgbdDao.deleteByCode(code);
            sszcDao.deleteByCode(code);
            wgclDao.deleteByCode(code);
            xsjjDao.deleteByCode(code);

            //保存数据
            dwdbDao.saveAll(dwdbList);
            dzjyDao.saveAll(dzjyList);
            ggcgbdDao.saveAll(ggcgbdList);
            gqzyDao.saveAll(gqzyList);
            lhbdDao.saveAll(lhbdList);
            rzrqDao.saveAll(rzrqList);
            sdgdcgbdDao.saveAll(sdgdcgbdList);
            sszcDao.saveAll(sszcList);
            wgclDao.saveAll(wgclList);
            xsjjDao.saveAll(xsjjList);
        }
    }

}
