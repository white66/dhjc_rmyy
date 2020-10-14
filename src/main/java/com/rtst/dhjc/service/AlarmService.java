package com.rtst.dhjc.service;

import com.rtst.dhjc.entity.Alarm;

import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/6/28 8:54
 * @Version 1.0
 */
public interface AlarmService {
    List<Alarm> alarmList(Alarm alarm);

    List<Alarm> selectAlarmList();
}
