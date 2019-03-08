package cn.beerate.model.bean.cninfo;

import cn.beerate.model.entity.cninfo.t_stock_announcement;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class AnnouncementsBean {
    private Object classifiedAnnouncements;
    private int totalSecurities;
    private int totalAnnouncement;
    private int totalRecordNum;
    private Object categoryList;
    private boolean hasMore;
    private int totalpages;
    private List<t_stock_announcement> announcements;
}
