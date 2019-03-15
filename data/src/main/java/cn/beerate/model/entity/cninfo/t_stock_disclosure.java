package cn.beerate.model.entity.cninfo;

import cn.beerate.model.Model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
@Setter
@Getter
public class t_stock_disclosure extends Model {

    /** 公告时间 */
    private String announcementTime;

    /** 股票代码 */
    private String stockCode;

    /** 公告标题 */
    private String title;

    /** 公告id */
    private String announcementId;

    /** 详情地址 */
    @Column(columnDefinition = "TINYTEXT")
    private String detail_url;

    /** PDF文件地址 */
    @Column(columnDefinition = "TINYTEXT")
    private String pdf_url;

    /** 公告内容 */
    @Column(columnDefinition = "MEDIUMTEXT")
    private String announcementContent;

    @Column(columnDefinition = "TINYTEXT")
    /** 本地文件地址 */
    private String location_url;

}
