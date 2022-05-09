package com.yangye.meetingfilms.cinema.dao.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
/**
 * <p>
 * 影院信息表
 * </p>
 *
 * @author yangye
 * @since 2022-05-07
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MoocCinemaT extends Model<MoocCinemaT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer uuid;

    /**
     * 影院名称
     */
    private String cinemaName;

    /**
     * 影院电话
     */
    private String cinemaPhone;

    /**
     * 品牌编号
     */
    private Integer brandId;

    /**
     * 地域编号
     */
    private Integer areaId;

    /**
     * 包含的影厅类型,以#作为分割
     */
    private String hallIds;

    /**
     * 影院图片地址
     */
    private String imgAddress;

    /**
     * 影院地址
     */
    private String cinemaAddress;

    /**
     * 最低票价
     */
    private Integer minimumPrice;


    @Override
    protected Serializable pkVal() {
        return null;
    }
}
