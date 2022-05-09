package com.yangye.meetingfilms.film.dao.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
/**
 * <p>
 * 影片主表
 * </p>
 *
 * @author yangye
 * @since 2022-05-07
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MoocFilmInfoT extends Model<MoocFilmInfoT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer uuid;

    /**
     * 影片编号
     */
    private String filmId;

    /**
     * 影片英文名称
     */
    private String filmEnName;

    /**
     * 影片评分
     */
    private String filmScore;

    /**
     * 评分人数,以万为单位
     */
    private Integer filmScoreNum;

    /**
     * 播放时长，以分钟为单位，不足取整
     */
    private Integer filmLength;

    /**
     * 影片介绍
     */
    private String biography;

    /**
     * 导演编号
     */
    private Integer directorId;

    /**
     * 影片图片集地址,多个图片以逗号分隔
     */
    private String filmImgs;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
