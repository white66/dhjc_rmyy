package com.rtst.dhjc.service;

import com.rtst.dhjc.entity.AreaInfo;

import java.util.List;

/**
 * 功能模块(区域信息)
 *
 * @Author white Liu
 * @Date 2020/4/1 19:13
 * @Version 1.0
 */
public interface AreaService {

    int addArea(AreaInfo areaInfo);

    int deleteArea(AreaInfo areaInfo);

    int updateArea(AreaInfo areaInfo);

    List<AreaInfo> findAreaList(AreaInfo areaInfo);

    List<AreaInfo> findAreaListUp(AreaInfo areaInfo);
}
