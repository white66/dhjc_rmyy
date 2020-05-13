package com.rtst.dhjc.controller;

import com.rtst.dhjc.bean.BaseResult;
import com.rtst.dhjc.entity.Signal;
import com.rtst.dhjc.entity.SignalVo;
import com.rtst.dhjc.service.serviceImpl.ParameterServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 功能模块(用户定制采集参数模块)
 *
 * @Author white Liu
 * @Date 2020/5/6 11:10
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/parameter")
@Api(tags = "配置参数相关接口")
public class ParameterController {
    @Autowired
    ParameterServiceImpl parameterService;

    /**
     * 查询设备所有所有参数
     * @return
     */
    @GetMapping("/parameterList")
    @ApiOperation(value = "查询所有配置参数信息列表")
    public BaseResult parameterList(){
        List<Signal> signals = parameterService.parameterList();
        List<Signal> configSignal = new ArrayList<>();
        List<Signal> ioSignal = new ArrayList<>();
        Map<String,List<Signal>> resultMap = new LinkedHashMap<>();
        for(int i=0;i<signals.size();i++){
            if("配电参数".equals(signals.get(i).getSIG_Type())){
                configSignal.add(signals.get(i));
            }else{
                ioSignal.add(signals.get(i));
            }
        }
        resultMap.put("configData",configSignal);
        resultMap.put("ioData",ioSignal);
        return BaseResult.okMap(resultMap);
    }

    /**
     * 批量修改配置参数
     * @return
     */
    @PostMapping("/updateParameter")
    @ApiOperation(value = "修改配置参数信息")
    public BaseResult updateParameter(@RequestBody List<SignalVo> signals){
        int refNum= parameterService.updateParameter(signals);
        if(refNum>0){
            return BaseResult.ok("修改成功");
        }else{
            return BaseResult.error(400,"修改失败");
        }
    }
}
