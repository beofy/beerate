package cn.beerate.model.entity.cninfo;

import cn.beerate.model.Model;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Transient;

@NoArgsConstructor
@Data
@Entity
public class t_stock_announcement extends Model {
    //private Object id;
    private String secCode;
    private String secName;
    private String orgId;
    private String announcementId;
    private String announcementTitle;
    private long announcementTime;
    private String adjunctUrl;
    private int adjunctSize;
    @Transient
    private Object adjunctType;
    @Transient
    private Object storageTime;
    @Transient
    private Object columnId;
    @Transient
    private Object pageColumn;
    @Transient
    private String announcementType;
    @Transient
    private Object associateAnnouncement;
    @Transient
    private Object important;
    @Transient
    private Object batchNum;
    @Transient
    private Object announcementContent;
    @Transient
    private Object orgName;
    @Transient
    private Object announcementTypeName;
}
