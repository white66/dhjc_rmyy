package com.rtst.dhjc.repository;

import com.rtst.dhjc.entity.AreaInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/4/1 19:34
 * @Version 1.0
 */
@Component
public interface AreaMapper {
    int addArea(AreaInfo areaInfo);

    int deleteArea(AreaInfo areaInfo);

    int updateArea(AreaInfo areaInfo);

    List<AreaInfo> findAreaList(AreaInfo areaInfo);

    List<AreaInfo> findAreaListUp(AreaInfo areaInfo);
}
