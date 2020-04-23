package com.rtst.dhjc.service.serviceImpl;

import com.rtst.dhjc.bean.BaseResult;
import com.rtst.dhjc.entity.AreaInfo;
import com.rtst.dhjc.repository.AreaMapper;
import com.rtst.dhjc.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/4/1 19:13
 * @Version 1.0
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    AreaMapper areaMapper;
    @Override
    public int addArea(AreaInfo areaInfo) {
        int refNum = areaMapper.addArea(areaInfo);
        return refNum;
    }

    @Override
    public int deleteArea(AreaInfo areaInfo) {
        int refNum = areaMapper.deleteArea(areaInfo);
        return refNum;
    }

    @Override
    public int updateArea(AreaInfo areaInfo) {
        int refNum = areaMapper.updateArea(areaInfo);
        return refNum;
    }

    @Override
    public List<AreaInfo> findAreaList(AreaInfo areaInfo) {
        List<AreaInfo> areaInfos = areaMapper.findAreaList(areaInfo);
        return areaInfos;
    }

    @Override
    public List<AreaInfo> findAreaListUp(AreaInfo areaInfo) {
        if(null==areaInfo){
            return null;
        }
        List<AreaInfo> areaInfoList = areaMapper.findAreaListUp(areaInfo);


        return areaInfoList;
    }
}
