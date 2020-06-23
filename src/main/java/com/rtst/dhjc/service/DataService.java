package com.rtst.dhjc.service;

import com.rtst.dhjc.entity.EnergyInfo;

import java.util.List;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/6/17 10:35
 * @Version 1.0
 */
public interface DataService {

    void energyDay();

    void energyMonth();

    void energyYear();

    List<EnergyInfo> energyList(EnergyInfo energyInfo);
}
