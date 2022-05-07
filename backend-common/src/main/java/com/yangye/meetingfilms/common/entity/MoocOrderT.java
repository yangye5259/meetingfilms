package com.yangye.meetingfilms.common.entity;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
/**
 * <p>
 * 订单信息表
 * </p>
 *
 * @author yangye
 * @since 2022-05-07
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MoocOrderT extends Model<MoocOrderT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableField("UUID")
    private String uuid;

    /**
     * 影院编号
     */
    private Integer cinemaId;

    /**
     * 放映场次编号
     */
    private Integer fieldId;

    /**
     * 电影编号
     */
    private Integer filmId;

    /**
     * 已售座位编号
     */
    private String seatsIds;

    /**
     * 已售座位名称
     */
    private String seatsName;

    /**
     * 影片售价
     */
    private Double filmPrice;

    /**
     * 订单总金额
     */
    private Double orderPrice;

    /**
     * 下单时间
     */
    private LocalDateTime orderTime;

    /**
     * 下单人
     */
    private Integer orderUser;

    /**
     * 0-待支付,1-已支付,2-已关闭
     */
    private Integer orderStatus;



    @Override
    protected Serializable pkVal() {
        return null;
    }

}
