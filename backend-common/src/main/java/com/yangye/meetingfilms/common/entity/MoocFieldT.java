package com.yangye.meetingfilms.common.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
/**
 * <p>
 * 放映场次表
 * </p>
 *
 * @author yangye
 * @since 2022-05-07
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MoocFieldT extends Model<MoocFieldT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer uuid;

    /**
     * 影院编号
     */
    private Integer cinemaId;

    /**
     * 电影编号
     */
    private Integer filmId;

    /**
     * 开始时间
     */
    private String beginTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 放映厅类型编号
     */
    private Integer hallId;

    /**
     * 放映厅名称
     */
    private String hallName;

    /**
     * 票价
     */
    private Integer price;



    @Override
    protected Serializable pkVal() {
        return null;
    }
}
