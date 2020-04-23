package com.rtst.dhjc.controller;

import com.rtst.dhjc.bean.BaseResult;
import com.rtst.dhjc.entity.AreaInfo;
import com.rtst.dhjc.service.serviceImpl.AreaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能模块(区域信息)
 *
 * @Author white Liu
 * @Date 2020/4/1 19:11
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/area")
public class AreaController {
    @Autowired
    AreaServiceImpl areaService;

    /**
     * 添加区域信息
     * @param areaInfo
     * @return
     */
    @PostMapping("/addArea")
    public BaseResult addArea(@RequestBody AreaInfo areaInfo){
        int refNum = areaService.addArea(areaInfo);
        if(refNum>0){
            return BaseResult.ok().put("200",areaInfo);
        }else{
            return BaseResult.error(400,"添加区域信息失败！");
        }
    }

    /**
     * 通过id删除区域信息
     * @param areaInfo
     * @return
     */
    @DeleteMapping("/deleteArea")
    public BaseResult deleteArea(@RequestBody AreaInfo areaInfo){
        int refNum = areaService.deleteArea(areaInfo);
        if(refNum>0){
            return BaseResult.ok().put("200","删除区域成功！");
        }else{
            return BaseResult.error(400,"删除失败！");
        }
    }

    /**
     * 修改区域信息
     * @param areaInfo
     * @return
     */
    @PostMapping("/updateArea")
    public BaseResult updateArea(@RequestBody AreaInfo areaInfo){
        int refNum = areaService.updateArea(areaInfo);
        if(refNum>0){
            return BaseResult.ok().put("200","修改成功");
        }else{
            return BaseResult.error(400,"修改失败");
        }
    }

    /**
     * 根据上级区域Id查询下级区域信息
     * @return
     */
    @PostMapping("/findArea")
    public BaseResult areaList(@RequestBody AreaInfo areaInfo){
        List<AreaInfo> areaInfos = areaService.findAreaList(areaInfo);
        return BaseResult.ok().put("data",areaInfos);
    }

    /**
     * 通过学校所属区域Id查询出所在省市区的信息
     * @return
     */
    @PostMapping("/findAreaUp")
    public BaseResult areaListUp(@RequestBody AreaInfo areaInfo){
        List<AreaInfo> areaInfoList = areaService.findAreaListUp(areaInfo);
        return BaseResult.ok().put("data",areaInfoList);
    }
}
