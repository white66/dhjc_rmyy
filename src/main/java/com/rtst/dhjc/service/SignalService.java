package com.rtst.dhjc.service;

import com.rtst.dhjc.entity.Signal;

import java.util.List;

/**
 * @Author white Liu
 * @Date 2019/12/10 9:52
 * @Version 1.0
 */
public interface SignalService {

    List<Signal> getSignalList(Signal signal);

    List<Signal> getSignalListHistory(Signal signal);

    List<Signal> getAlarmListHistory(Signal signal);

    List<Signal> getSignalAlarmList(Signal signal);
}
