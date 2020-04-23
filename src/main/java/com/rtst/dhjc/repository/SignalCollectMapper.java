package com.rtst.dhjc.repository;

import com.rtst.dhjc.entity.SignalCollectInfo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/4/13 10:15
 * @Version 1.0
 */
@Component
public interface SignalCollectMapper {
    List<SignalCollectInfo> findSignalCollectListByDeviceName(SignalCollectInfo signalCollectInfo);

    List<SignalCollectInfo> findSignalCollectList();

    int addSignalCollect(SignalCollectInfo signalCollectInfo);

    int deleteSignalById(SignalCollectInfo signalCollectInfo);

    int updateSignalCollect(SignalCollectInfo signalCollectInfo);

    int deleteSignalByDeviceId(SignalCollectInfo signalCollectInfo);
}
