package com.yangye.meetingfilms.film.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yangye.meetingfilms.common.exception.CommonServiceException;
import com.yangye.meetingfilms.common.util.ToolUtils;
import com.yangye.meetingfilms.film.controller.request.FilmSaveRequest;
import com.yangye.meetingfilms.film.controller.vo.FilmActorVO;
import com.yangye.meetingfilms.film.controller.vo.FilmFilmVO;
import com.yangye.meetingfilms.film.controller.vo.FilmFilmsVO;
import com.yangye.meetingfilms.film.dao.entity.MoocCatDictT;
import com.yangye.meetingfilms.film.dao.entity.MoocFilmActorT;
import com.yangye.meetingfilms.film.dao.entity.MoocFilmInfoT;
import com.yangye.meetingfilms.film.dao.entity.MoocFilmT;
import com.yangye.meetingfilms.film.dao.mapper.*;
import com.yangye.meetingfilms.film.service.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author: yangye
 * @Date: 2022/5/9 11:19
 */
@Slf4j
@Service
public class FilmServiceImpl implements FilmService {

    @Resource
    private MoocActorTMapper moocActorTMapper;

    @Resource
    private MoocFilmActorTMapper moocFilmActorTMapper;

    @Resource
    private MoocFilmInfoTMapper moocFilmInfoTMapper;

    @Resource
    private MoocFilmTMapper moocFilmTMapper;

    @Resource
    private MoocCatDictTMapper moocCatDictTMapper;

    @Override
    public IPage<FilmActorVO> getActors(int nowPage, int pageSize) {
        Page<FilmActorVO> page = new Page<>(nowPage, pageSize);
        return moocActorTMapper.selectPageActors(page);
    }

    @Override
    public IPage<FilmFilmsVO> getFilms(Integer nowPage, Integer pageSize) {
        Page<FilmActorVO> page = new Page<>(nowPage, pageSize);
        return moocFilmTMapper.selectPageFilms(page);
    }

    @Override
    public FilmFilmVO getFilmById(String filmId) {
        MoocFilmT moocFilmT = moocFilmTMapper.getById(Integer.valueOf(filmId));
        if (Objects.isNull(moocFilmT)) {
            return null;
        }
        MoocFilmInfoT moocFilmInfoT = moocFilmInfoTMapper.selectByFilmIdMoocFilmInfoT(filmId);
        if (Objects.isNull(moocFilmInfoT)) {
            return null;
        }
        List<MoocFilmActorT> moocFilmActorTList = moocFilmActorTMapper.listRecordsByFilmId(filmId);
        String filmCats = moocFilmT.getFilmCats();
        String[] split = filmCats.split("#");
        List<String> idList = new ArrayList<>(Arrays.asList(split));
        List<Integer> collect = idList.stream().filter(StringUtils::isNotEmpty).map(Integer::parseInt).collect(Collectors.toList());
        List<MoocCatDictT> moocCatDictTList = moocCatDictTMapper.listRecordsByIds(collect);
        return buildFilmFilmVO(moocFilmT, moocFilmInfoT, moocFilmActorTList, moocCatDictTList);
    }

    private FilmFilmVO buildFilmFilmVO(MoocFilmT moocFilmT, MoocFilmInfoT moocFilmInfoT,
                                       List<MoocFilmActorT> moocFilmActorTList, List<MoocCatDictT> moocCatDictTList) {
        FilmFilmVO filmFilmVO = new FilmFilmVO();
        filmFilmVO.setFilmId(moocFilmT.getUuid() + "");
        filmFilmVO.setFilmName(moocFilmT.getFilmName());
        filmFilmVO.setFilmLength(moocFilmInfoT.getFilmLength() + "");
        if (!CollectionUtils.isEmpty(moocFilmActorTList)) {
            filmFilmVO.setActors(moocFilmActorTList.stream().map(MoocFilmActorT::getRoleName).collect(Collectors.joining(",")));
        }
        filmFilmVO.setImgAddress(moocFilmT.getImgAddress());
        filmFilmVO.setSubAddress(moocFilmInfoT.getFilmImgs());
        if (!CollectionUtils.isEmpty(moocCatDictTList)) {
            filmFilmVO.setFilmCats(moocCatDictTList.stream().map(MoocCatDictT::getShowName).collect(Collectors.joining(",")));
        }
        return filmFilmVO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveFilm(FilmSaveRequest filmSaveRequest) {
        try {
            // 保存电影主表
            MoocFilmT film = new MoocFilmT();
            film.setFilmName(filmSaveRequest.getFilmName());
            film.setFilmType(ToolUtils.str2Int(filmSaveRequest.getFilmTypeId()));
            film.setImgAddress(filmSaveRequest.getMainImgAddress());
            film.setFilmScore(filmSaveRequest.getFilmScore());
            film.setFilmPresalenum(ToolUtils.str2Int(filmSaveRequest.getPreSaleNum()));
            film.setFilmBoxOffice(ToolUtils.str2Int(filmSaveRequest.getBoxOffice()));
            film.setFilmSource(ToolUtils.str2Int(filmSaveRequest.getFilmSourceId()));
            film.setFilmCats(filmSaveRequest.getFilmCatIds());
            film.setFilmArea(ToolUtils.str2Int(filmSaveRequest.getAreaId()));
            film.setFilmDate(ToolUtils.str2Int(filmSaveRequest.getDateId()));
            film.setFilmTime(ToolUtils.str2LocalDateTime(filmSaveRequest.getFilmTime() + " 00:00:00"));
            film.setFilmStatus(ToolUtils.str2Int(filmSaveRequest.getFilmStatus()));
            moocFilmTMapper.insert(film);
            // 保存电影子表
            MoocFilmInfoT filmInfo = new MoocFilmInfoT();
            filmInfo.setFilmId(film.getUuid() + "");
            filmInfo.setFilmEnName(filmSaveRequest.getFilmEnName());
            filmInfo.setFilmScore(filmSaveRequest.getFilmScore());
            filmInfo.setFilmScoreNum(ToolUtils.str2Int(filmSaveRequest.getFilmScorers()));
            filmInfo.setFilmLength(ToolUtils.str2Int(filmSaveRequest.getFilmLength()));
            filmInfo.setBiography(filmSaveRequest.getBiography());
            filmInfo.setDirectorId(ToolUtils.str2Int(filmSaveRequest.getDirectorId()));
            filmInfo.setFilmImgs(filmSaveRequest.getFilmImgs());
            moocFilmInfoTMapper.insert(filmInfo);
            String[] actorId = filmSaveRequest.getActIds().split("#");
            String[] roleNames = filmSaveRequest.getRoleNames().split("#");
            if (actorId.length != roleNames.length) {
                throw new CommonServiceException("演员和角色名数量不匹配", 500);
            }
            for (int i = 0; i < actorId.length; i++) {
                // 保存演员映射表
                MoocFilmActorT filmActor = new MoocFilmActorT();
                filmActor.setFilmId(film.getUuid());
                filmActor.setActorId(ToolUtils.str2Int(actorId[i]));
                filmActor.setRoleName(roleNames[i]);
                moocFilmActorTMapper.insert(filmActor);
            }
        } catch (Exception e) {
            throw new CommonServiceException(e.getMessage(), 500);
        }
    }
}
