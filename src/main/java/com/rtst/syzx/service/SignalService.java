package com.rtst.syzx.service;

import com.rtst.syzx.entity.Signal;

import java.util.List;

/**
 * @Author white Liu
 * @Date 2019/12/10 9:52
 * @Version 1.0
 */
public interface SignalService {

    List<Signal> getSignalList();

    List<Signal> getSignalListHistory(Signal signal);

    List<Signal> getAlarmListHistory(Signal signal);
}
