package cn.beerate.service.eastmoney.f10;

import cn.beerate.common.Message;
import cn.beerate.dao.eastmoney.f10.capitalstockstructure.CapitalStockStructureDetailDao;
import cn.beerate.dao.eastmoney.f10.capitalstockstructure.ShareChangeDao;
import cn.beerate.dao.eastmoney.f10.capitalstockstructure.UnlistedShareDao;
import cn.beerate.dao.eastmoney.f10.companybignews.XsjjDao;
import cn.beerate.model.bean.eastmoney.f10.CapitalStockStructure;
import cn.beerate.model.bean.eastmoney.f10.ShareChangeList;
import cn.beerate.model.bean.eastmoney.f10.UnlistedShareChangeList;
import cn.beerate.model.entity.eastmoney.f10.capitalstockstructure.t_eastmoney_capital_stock_structure_detail;
import cn.beerate.model.entity.eastmoney.f10.capitalstockstructure.t_eastmoney_share_change;
import cn.beerate.model.entity.eastmoney.f10.capitalstockstructure.t_eastmoney_unlisted_share;
import cn.beerate.service.EastMoneyService;
import cn.beerate.service.IEastMoneyService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 股本结构
 */
@Component
@Transactional(readOnly = true)
public class CapitalStockStructureService extends EastMoneyService implements IEastMoneyService {

    private CapitalStockStructureDetailDao capitalStockStructureDetailDao;
    private ShareChangeDao shareChangeDao;
    private UnlistedShareDao unlistedShareDao;
    private XsjjDao xsjjDao;

    public CapitalStockStructureService(CapitalStockStructureDetailDao capitalStockStructureDetailDao, ShareChangeDao shareChangeDao, UnlistedShareDao unlistedShareDao, XsjjDao xsjjDao) {
        this.capitalStockStructureDetailDao = capitalStockStructureDetailDao;
        this.shareChangeDao = shareChangeDao;
        this.unlistedShareDao = unlistedShareDao;
        this.xsjjDao = xsjjDao;

        super.eastMoneyService=this;
    }

    /**
     * 股本结构
     * @param code 股票代码
     * @return Message<String>
     */
    public Message<CapitalStockStructure> capitalStockStructure(String code){
        String url="http://emweb.securities.eastmoney.com/CapitalStockStructure/CapitalStockStructureAjax";
        Map<String,String> params = new HashMap<>();
        params.put("code",code);

        return super.getBean(CapitalStockStructure.class,url,params);
    }

    @Transactional
    @Override
    public void updateByStockCodes(String code) {
        Message<CapitalStockStructure> capitalStockStructureMessage =  capitalStockStructure(code);
        if(!capitalStockStructureMessage.fail()){
            CapitalStockStructure capitalStockStructure = capitalStockStructureMessage.getData();
            //这里不处理限售解禁，已在公司大事中保存
            //股本结构
            t_eastmoney_capital_stock_structure_detail stockStructureDetail = capitalStockStructure.getCapitalStockStructureDetail();
            //历年股本变动
            List<ShareChangeList> shareChangeList = capitalStockStructure.getShareChangeList();
            // 股本构成
            List<UnlistedShareChangeList> unlistedShareChangeList = capitalStockStructure.getUnlistedShareChangeList();

            //保存历年股本变动实体数据
            List<t_eastmoney_share_change> eastmoneyShareChangeList = new ArrayList<>();
            for (int i = 0; i < shareChangeList.get(0).getChangeList().size(); i++) {//股票代码和日期
                eastmoneyShareChangeList.add(new t_eastmoney_share_change(code,shareChangeList.get(0).getChangeList().get(i),null,null,null,null,null,null,null));
            }
            for (int i = 0; i < shareChangeList.get(1).getChangeList().size(); i++) {//总股本
                eastmoneyShareChangeList.get(i).setZgb(shareChangeList.get(1).getChangeList().get(i));
            }
            for (int i = 0; i < shareChangeList.get(2).getChangeList().size(); i++) {//流通受限股份
                eastmoneyShareChangeList.get(i).setLtsxgf(shareChangeList.get(2).getChangeList().get(i));
            }
            for (int i = 0; i < shareChangeList.get(3).getChangeList().size(); i++) {//国有法人持股(受限)
                eastmoneyShareChangeList.get(i).setGyfrcg(shareChangeList.get(3).getChangeList().get(i));
            }
            for (int i = 0; i < shareChangeList.get(4).getChangeList().size(); i++) {//其他内资持股(受限)
                eastmoneyShareChangeList.get(i).setQtnzcg(shareChangeList.get(4).getChangeList().get(i));
            }
            for (int i = 0; i < shareChangeList.get(5).getChangeList().size(); i++) {//已流通股份
                eastmoneyShareChangeList.get(i).setYltgf(shareChangeList.get(5).getChangeList().get(i));
            }
            for (int i = 0; i < shareChangeList.get(6).getChangeList().size(); i++) {//已上市流通A股
                eastmoneyShareChangeList.get(i).setYssltAg(shareChangeList.get(6).getChangeList().get(i));
            }
            for (int i = 0; i < shareChangeList.get(7).getChangeList().size(); i++) {//变动原因
                eastmoneyShareChangeList.get(i).setBdyy(shareChangeList.get(7).getChangeList().get(i));
            }

            //保存股本构成实体数据
            List<t_eastmoney_unlisted_share> unlistedShareList = new ArrayList<>();
            for (int i = 0; i < unlistedShareChangeList.get(0).getChangeList().size(); i++) {//股票代码和日期
                unlistedShareList.add(new t_eastmoney_unlisted_share(code,unlistedShareChangeList.get(0).getChangeList().get(i),null,null,null));
            }
            for (int i = 0; i < unlistedShareChangeList.get(1).getChangeList().size(); i++) {//股份总数
                unlistedShareList.get(i).setGfzs(unlistedShareChangeList.get(1).getChangeList().get(i));
            }
            for (int i = 0; i < unlistedShareChangeList.get(2).getChangeList().size(); i++) {//已上市流通A股
                unlistedShareList.get(i).setYssltAg(unlistedShareChangeList.get(2).getChangeList().get(i));
            }
            for (int i = 0; i < unlistedShareChangeList.get(3).getChangeList().size(); i++) {//受限流通股份
                unlistedShareList.get(i).setSxltgf(unlistedShareChangeList.get(3).getChangeList().get(i));
            }

            //删除数据
            capitalStockStructureDetailDao.deleteByCode(code);
            shareChangeDao.deleteByCode(code);
            unlistedShareDao.deleteByCode(code);

            //保存数据
            capitalStockStructureDetailDao.save(stockStructureDetail);
            shareChangeDao.saveAll(eastmoneyShareChangeList);
            unlistedShareDao.saveAll(unlistedShareList);
        }
    }

    /**
     * 股本结构
     */
    public Message<CapitalStockStructure> findCapitalStockStructureByStockCode(String code){
        CapitalStockStructure capitalStockStructure = new CapitalStockStructure();

        capitalStockStructure.setRptRestrictedBanList(xsjjDao.findByCode(code));//限售解禁
        capitalStockStructure.setCapitalStockStructureDetail(capitalStockStructureDetailDao.findByCodeOrderByCreateTimeAsc(code));//股本结构
        capitalStockStructure.setShareChange(shareChangeDao.findByCode(code));//历年股本变动
        capitalStockStructure.setUnlistedShare(unlistedShareDao.findByCode(code));//股本构成

        return Message.success(capitalStockStructure);
    }

}
