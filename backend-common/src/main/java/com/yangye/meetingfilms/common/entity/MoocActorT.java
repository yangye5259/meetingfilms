package com.yangye.meetingfilms.common.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
/**
 * <p>
 * 演员表
 * </p>
 *
 * @author yangye
 * @since 2022-05-07
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MoocActorT extends Model<MoocActorT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer uuid;

    /**
     * 演员名称
     */
    private String actorName;

    /**
     * 演员图片位置
     */
    private String actorImg;

    @Override
    protected Serializable pkVal() {
        return null;
    }

}
