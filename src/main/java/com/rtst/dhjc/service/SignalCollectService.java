package com.rtst.dhjc.service;

import com.rtst.dhjc.entity.SignalCollectInfo;

import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/4/13 10:13
 * @Version 1.0
 */
public interface SignalCollectService {

    List<SignalCollectInfo> findSignalCollectList();

    List<SignalCollectInfo> findSignalCollectListByDeviceName(SignalCollectInfo signalCollectInfo);

    int addSignalCollect(SignalCollectInfo signalCollectInfo);

    int deleteSignalById(SignalCollectInfo signalCollectInfo);

    int updateSignalCollect(SignalCollectInfo signalCollectInfo);

    int deleteSignalByDeviceId(SignalCollectInfo signalCollectInfo);
}
