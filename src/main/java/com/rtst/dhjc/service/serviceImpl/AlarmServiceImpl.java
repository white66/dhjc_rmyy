package com.rtst.dhjc.service.serviceImpl;

import com.rtst.dhjc.entity.Alarm;
import com.rtst.dhjc.repository.AlarmMapper;
import com.rtst.dhjc.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能模块(告警功能)
 *
 * @Author white Liu
 * @Date 2020/6/28 8:54
 * @Version 1.0
 */
@Service
public class AlarmServiceImpl implements AlarmService {
    @Autowired
    AlarmMapper alarmMapper;
    @Override
    public List<Alarm> alarmList(Alarm alarm) {
        List<Alarm> alarms = alarmMapper.alarmList(alarm);
        return alarms;
    }
}
