package com.yangye.meetingfilms.film.controller.request;

import com.yangye.meetingfilms.common.exception.CommonServiceException;
import com.yangye.meetingfilms.common.vo.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: yangye
 * @Date: 2022/5/9 15:25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class FilmSaveRequest extends BaseRequest {
    private String filmStatus;
    private String filmName;
    private String filmEnName;
    private String mainImgAddress;
    private String filmScore;
    private String filmScorers;
    private String preSaleNum;
    private String boxOffice;
    private String filmTypeId;
    private String filmSourceId;
    private String filmCatIds;
    private String areaId;
    private String dateId;
    private String filmTime;
    private String directorId;
    private String actIds;      // actIds与RoleNames是不是能在数量上对应上
    private String roleNames;
    private String filmLength;
    private String biography;
    private String filmImgs;

    @Override
    public void checkParam() throws CommonServiceException {

    }
}
