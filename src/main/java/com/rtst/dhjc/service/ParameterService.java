package com.rtst.dhjc.service;

import com.rtst.dhjc.entity.ParameterInfo;
import com.rtst.dhjc.entity.Signal;
import com.rtst.dhjc.entity.SignalVo;

import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/5/6 11:50
 * @Version 1.0
 */
public interface ParameterService {

    List<Signal> parameterList();

    int updateParameter(List<SignalVo> signals);

    List<ParameterInfo> findParameterByState();
}
