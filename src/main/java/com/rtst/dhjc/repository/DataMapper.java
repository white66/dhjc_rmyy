package com.rtst.dhjc.repository;

import com.rtst.dhjc.entity.EnergyInfo;
import com.rtst.dhjc.entity.Signal;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/6/17 10:41
 * @Version 1.0
 */
@Component
public interface DataMapper {
    /**
     * 获取日最大电能值
     * @param signal
     * @return
     */
    List<Signal> energyMax(Signal signal);

    List<Signal> energyMin(Signal signal);

    void addEnergyDay(Map<String, Object> param);

    void addEnergyMonth(Map<String, Object> param);

    void addEnergyYear(Map<String, Object> param);

    List<EnergyInfo> energyDayList(EnergyInfo energyInfo);

    List<EnergyInfo> energyMonthList(EnergyInfo energyInfo);

    List<EnergyInfo> energyYearList(EnergyInfo energyInfo);
}
