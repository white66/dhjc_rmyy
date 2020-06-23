package com.rtst.dhjc.service.serviceImpl;

import com.rtst.dhjc.entity.Signal;
import com.rtst.dhjc.entity.SignalVo;
import com.rtst.dhjc.repository.ParameterMapper;
import com.rtst.dhjc.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/5/6 11:49
 * @Version 1.0
 */
@Service
public class ParameterServiceImpl implements ParameterService {
    @Autowired
    ParameterMapper parameterMapper;

    /**
     * 查询设备所有配置参数信息
     * @return
     */
    @Override
    public List<Signal> parameterList() {
        List<Signal> signals = parameterMapper.parameterList();
        return signals;
    }

    /**
     * 批量修改设备参数
     * @param signals
     * @return
     */
    @Override
    public int updateParameter(List<SignalVo> signals) {
        int refNum = parameterMapper.updateParameter(signals);
        return refNum;
    }

    /**
     * 通过模块flag标识获取已勾选的参数总数
     * @param  模块标识
     * @return
     */
    @Override
    public int findParameterByState(Signal signal) {
        int parameterInfos = parameterMapper.findParameterByState(signal);
        return parameterInfos;
    }

    /**
     * 通过参数单位sigUnit、模块标识获取参数总条数
     * @param signal
     * @return
     */
    @Override
    public int findParameterByUnit(Signal signal) {
        int parameter =parameterMapper.findParameterByUnit(signal);
        return parameter;
    }

    /**
     * 查询电能参数
     * @return
     */
    @Override
    public int findEnergyParam() {
        int paramter = parameterMapper.findEnergyParam();
        return paramter;
    }

    @Override
    public List<Signal> findEnergyParamName() {
        List<Signal> paramter = parameterMapper.findEnergyParamName();
        return paramter;
    }
}
