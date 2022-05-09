package com.yangye.meetingfilms.film.dao.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
/**
 * <p>
 * 影片与演员映射表
 * </p>
 *
 * @author yangye
 * @since 2022-05-07
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MoocFilmActorT extends Model<MoocFilmActorT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer uuid;

    /**
     * 影片编号,对应mooc_film_t
     */
    private Integer filmId;

    /**
     * 演员编号,对应mooc_actor_t
     */
    private Integer actorId;

    /**
     * 角色名称
     */
    private String roleName;



    @Override
    protected Serializable pkVal() {
        return null;
    }

}
