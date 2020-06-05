package com.rtst.dhjc.repository;

import com.rtst.dhjc.entity.Signal;
import com.rtst.dhjc.entity.SignalVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/5/6 11:52
 * @Version 1.0
 */
@Component
public interface ParameterMapper {
    List<Signal> parameterList();

    int updateParameter(List<SignalVo> signals);

    int findParameterByState(Signal signal);

    int findParameterByUnit(Signal signal);
}
