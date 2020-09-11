package com.rtst.dhjc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rtst.dhjc.bean.BaseResult;
import com.rtst.dhjc.entity.DeviceInfo;
import com.rtst.dhjc.entity.OrganizationInfo;
import com.rtst.dhjc.entity.SiteInfo;
import com.rtst.dhjc.service.serviceImpl.DeviceServiceImpl;
import com.rtst.dhjc.service.serviceImpl.OrganizationServiceImpl;
import com.rtst.dhjc.service.serviceImpl.SiteServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 功能模块(组织信息相关)
 *
 * @Author white Liu
 * @Date 2020/4/13 9:35
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/organization")
@Api(tags = "组织信息")
public class OrganizationController {
    @Autowired
    OrganizationServiceImpl organizationService;
    @Autowired
    DeviceServiceImpl deviceService;
    @Autowired
    SiteServiceImpl siteService;
    /**
     * 查询组织信息列表分页
     * @return
     */
    @PostMapping("/organizationListPage")
    @ApiOperation(value="通过所属区域ID查询组织信息列表(分页)")
    public BaseResult organizationListPage(@RequestBody @ApiParam(name="组织对象",value="belongArea,pageNum,pageSize",required = true) OrganizationInfo organizationInfo){
        PageHelper.startPage(organizationInfo.getPageNum(), organizationInfo.getPageSize());
        List<OrganizationInfo> organizationInfoList = organizationService.findOrganizationList(organizationInfo);
        PageInfo pageInfo = new PageInfo(organizationInfoList);
        return BaseResult.ok().put("data",pageInfo);
    }
    /**
     * 查询组织信息列表
     * @return
     */
    @PostMapping("/organizationList")
    @ApiOperation(value="查询所有组织信息")
    public BaseResult organizationList(@RequestBody @ApiParam(name="组织对象") OrganizationInfo organizationInfo){
        List<OrganizationInfo> organizationInfoList = organizationService.findOrganizationList(organizationInfo);
        return BaseResult.ok().put("data", organizationInfoList);
    }
    /**
     * 添加组织信息
     * @return
     */
    @PostMapping("/addOrganization")
    @ApiOperation(value="添加组织")
    public BaseResult addOrganization(@RequestBody @ApiParam(name="组织对象",value="organizationName,belongArea,location,lngAndLat", required = true) OrganizationInfo organizationInfo){
        int refNum = organizationService.addOrganization(organizationInfo);
        if(refNum>0){
            return BaseResult.ok("添加学校"+ organizationInfo.getOrganizationName()+"成功");
        }else{
            return BaseResult.error(400,"添加学校失败！");
        }
    }

    /**
     * 通过ID删除组织
     * @return
     */
    @DeleteMapping("/deleteOrganization")
    @ApiOperation(value="以id删除组织信息")
    public BaseResult deleteOrganization(@RequestBody @ApiParam(name="组织ID",value="id",required = true) OrganizationInfo organizationInfo){
        int refNum = organizationService.deleteOrganization(organizationInfo);
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setOrganizationId(organizationInfo.getId());
        SiteInfo siteInfo = new SiteInfo();
        siteInfo.setOrganizationId(organizationInfo.getId());
        siteService.deleteSiteByOrganizationId(siteInfo);
        int refNum1 = deviceService.deleteDeviceByOrganizationId(deviceInfo);
        if(refNum>0 && refNum1>0){
            return BaseResult.ok("删除成功！");
        }else{
            return BaseResult.error(400,"删除失败！");
        }
    }

    /**
     * 修改组织信息
     * @return
     */
    @PostMapping("/updateOrganization")
    @ApiOperation(value="修改组织信息")
    public BaseResult updateOrganization(@RequestBody @ApiParam(name="组织对象",value="id,organizationName,belongArea,location,lngAndLat",required = true) OrganizationInfo organizationInfo){
        int refNum = organizationService.updateOrganization(organizationInfo);
        if(refNum>0){
            return BaseResult.ok("修改组织信息成功！");
        }else{
            return BaseResult.error(400,"修改组织失败！");
        }
    }
}
