package com.rtst.dhjc.service.serviceImpl;

import com.rtst.dhjc.entity.ParameterInfo;
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
     * 获取参数
     * @return
     */
    @Override
    public List<ParameterInfo> findParameterByState() {
        List<ParameterInfo> parameterInfos = parameterMapper.findParameterByState();
        return parameterInfos;
    }
}
