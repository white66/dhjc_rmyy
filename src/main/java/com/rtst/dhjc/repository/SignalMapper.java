package com.rtst.dhjc.repository;

import com.rtst.dhjc.entity.Signal;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author white Liu
 * @Date 2019/12/10 9:54
 * @Version 1.0
 */
@Component
public interface SignalMapper {

    List<Signal> getSignalList();

    List<Signal> getSignalListHistory(Signal signal);

    List<Signal> getAlarmListHistory(Signal signal);
}
