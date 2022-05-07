package com.yangye.meetingfilms.common.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
/**
 * <p>
 * banner信息表
 * </p>
 *
 * @author yangye
 * @since 2022-05-07
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MoocBannerT extends Model<MoocBannerT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer uuid;

    /**
     * banner图存放路径
     */
    private String bannerAddress;

    /**
     * banner点击跳转url
     */
    private String bannerUrl;

    /**
     * 是否弃用 0-失效,1-失效
     */
    private Integer isValid;

    @Override
    protected Serializable pkVal() {
        return null;
    }
}
