package com.rtst.dhjc.repository;

import com.rtst.dhjc.entity.Alarm;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/6/28 9:04
 * @Version 1.0
 */
@Component
public interface AlarmMapper {
    List<Alarm> alarmList(Alarm alarm);
}
