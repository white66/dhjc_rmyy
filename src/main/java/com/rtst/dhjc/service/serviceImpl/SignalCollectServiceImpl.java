package com.rtst.dhjc.service.serviceImpl;

import com.rtst.dhjc.entity.SignalCollectInfo;
import com.rtst.dhjc.repository.SignalCollectMapper;
import com.rtst.dhjc.service.SignalCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/4/13 10:12
 * @Version 1.0
 */
@Service
public class SignalCollectServiceImpl implements SignalCollectService {
    @Autowired
    SignalCollectMapper signalCollectMapper;
    @Override
    public List<SignalCollectInfo> findSignalCollectListByDeviceName(SignalCollectInfo signalCollectInfo) {
        List<SignalCollectInfo> signalCollectInfos = signalCollectMapper.findSignalCollectListByDeviceName(signalCollectInfo);
        return signalCollectInfos;
    }

    @Override
    public List<SignalCollectInfo> findSignalCollectList() {
        List<SignalCollectInfo> signalCollectInfos = signalCollectMapper.findSignalCollectList();
        return signalCollectInfos;
    }

    @Override
    public int addSignalCollect(SignalCollectInfo signalCollectInfo) {
        int refNum = signalCollectMapper.addSignalCollect(signalCollectInfo);
        return refNum;
    }

    @Override
    public int deleteSignalById(SignalCollectInfo signalCollectInfo) {
        int refNum = signalCollectMapper.deleteSignalById(signalCollectInfo);
        return refNum;
    }

    @Override
    public int updateSignalCollect(SignalCollectInfo signalCollectInfo) {
        int refNum = signalCollectMapper.updateSignalCollect(signalCollectInfo);
        return refNum;
    }

    /**
     * 删除设备时同时要删除采集信息表中的com端口对应的设备ID数据
     * @param signalCollectInfo
     * @return
     */
    @Override
    public int deleteSignalByDeviceId(SignalCollectInfo signalCollectInfo) {
        int refNum = signalCollectMapper.deleteSignalByDeviceId(signalCollectInfo);
        return refNum;
    }
}
