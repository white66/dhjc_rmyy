package com.rtst.dhjc.controller;

import com.rtst.dhjc.bean.BaseResult;
import com.rtst.dhjc.entity.SiteInfo;
import com.rtst.dhjc.service.serviceImpl.SiteServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/5/19 14:04
 * @Version 1.0
 */
@RequestMapping("/api/site")
@RestController
@Api(tags = "站点管理")
public class SiteController {
    @Autowired
    SiteServiceImpl siteService;
    /**
     * 根据学校ID查询机房信息
     * @return
     */
    @PostMapping("/findSiteBySchoolId")
    @ApiOperation(value = "根据学校ID查询机房信息")
    public BaseResult findSiteBySchoolId(@RequestBody @ApiParam(name="学校ID",value="schoolId",required = true) SiteInfo siteInfo){
        List<SiteInfo> siteInfos = siteService.findSiteBySchoolId(siteInfo);
        return BaseResult.ok().put("data",siteInfos);
    }
    @PostMapping("/addSite")
    @ApiOperation(value="添加机房站点")
    public BaseResult addSite(@RequestBody @ApiParam(name="站点",value="schoolId,siteId,siteName",required = true) SiteInfo siteInfo){
        int refNum = siteService.addSite(siteInfo);
        if(refNum>0){
            return BaseResult.ok("添加成功");
        }else{
            return BaseResult.error(400,"添加失败");
        }
    }
    @DeleteMapping("/deleteSiteById")
    public BaseResult deleteSiteById(@RequestBody @ApiParam(name="主键ID",value="id",required = true) SiteInfo siteInfo){
        int refNum = siteService.deleteSite(siteInfo);
        if(refNum>0){
            return BaseResult.ok("删除成功");
        }else{
            return BaseResult.error(400,"删除失败");
        }
    }
}
