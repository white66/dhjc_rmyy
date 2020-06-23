package com.rtst.dhjc.service.serviceImpl;

import com.rtst.dhjc.entity.EnergyInfo;
import com.rtst.dhjc.entity.Signal;
import com.rtst.dhjc.repository.DataMapper;
import com.rtst.dhjc.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 功能模块()
 *
 * @Author white Liu
 * @Date 2020/6/17 10:34
 * @Version 1.0
 */
@Service
public class DataServiceImpl implements DataService {
    @Autowired
    DataMapper dataMapper;
    @Autowired
    ParameterServiceImpl parameterService;
    /**
     * 统计日能耗值并插入c_energyDay表中
     */
    @Override
    public void energyDay() {
        Signal signal = new Signal();
        Date nowDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateTime = simpleDateFormat.format(nowDate);
        signal.setStartTime(dateTime+" 00:00:00");
        signal.setEndTime(dateTime+" 23:59:59");
        List<Signal> signalsMax = dataMapper.energyMax(signal);
        List<Signal> signalsMin = dataMapper.energyMin(signal);
        List<Signal> paramInfo = parameterService.findEnergyParamName();
        Map<String ,Object> param = new HashMap<>();
        if(signalsMax.size()==0 || signalsMin.size()==0){
            for(int num=0;num<paramInfo.size();num++){
                param.put("sigCode",paramInfo.get(num).getSIG_Code());
                param.put("energyValue",0);
                param.put("dateTime",dateTime);
                dataMapper.addEnergyDay(param);
            }
            return;
        }
        for(int i = 0;i<signalsMax.size();i++){
            for(int j=0;j<signalsMin.size();j++){
                if(signalsMax.get(i).getSIG_Code().equals(signalsMin.get(j).getSIG_Code())){
                    param.put("sigCode",signalsMax.get(i).getSIG_Code());
                    param.put("energyValue",Double.valueOf(signalsMax.get(i).getDSIG_Value())-Double.valueOf(signalsMin.get(j).getDSIG_Value()));
                    param.put("dateTime",dateTime);
                    dataMapper.addEnergyDay(param);
                }
            }
        }
    }

    /**
     * 统计月能耗值并插入c_energyMonth表中
     */
    @Override
    public void energyMonth() {
        Signal signal = new Signal();
        Date nowDate = new Date();
        SimpleDateFormat simpleDateFormatEnd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormatStart = new SimpleDateFormat("yyyy-MM");
        String dateTimeEnd = simpleDateFormatEnd.format(nowDate);
        String dateTimeStart = simpleDateFormatStart.format(nowDate);
        signal.setStartTime(dateTimeStart+"-01 00:00:00");
        signal.setEndTime(dateTimeEnd+" 23:59:59");
        List<Signal> signalsMax = dataMapper.energyMax(signal);
        List<Signal> signalsMin = dataMapper.energyMin(signal);
        List<Signal> paramInfo = parameterService.findEnergyParamName();
        Map<String ,Object> param = new HashMap<>();
        if(signalsMax.size()==0 || signalsMin.size()==0){
            for(int num=0;num<paramInfo.size();num++){
                param.put("sigCode",paramInfo.get(num).getSIG_Code());
                param.put("energyValue",0);
                param.put("dateTime",dateTimeStart);
                dataMapper.addEnergyMonth(param);
            }
            return;
        }
        for(int i = 0;i<signalsMax.size();i++){
            for(int j=0;j<signalsMin.size();j++){
                if(signalsMax.get(i).getSIG_Code().equals(signalsMin.get(j).getSIG_Code())){
                    param.put("sigCode",signalsMax.get(i).getSIG_Code());
                    param.put("energyValue",Double.valueOf(signalsMax.get(i).getDSIG_Value())-Double.valueOf(signalsMin.get(j).getDSIG_Value()));
                    param.put("dateTime",dateTimeStart);
                    dataMapper.addEnergyMonth(param);
                }
            }
        }
    }

    /**
     * 统计年能耗值并插入c_energyYear表中
     */
    @Override
    public void energyYear() {
        Signal signal = new Signal();
        Date nowDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        String dateTime = simpleDateFormat.format(nowDate);
        signal.setStartTime(dateTime+"-01-01 00:00:00");
        signal.setEndTime(dateTime+"-12-31 23:59:59");
        List<Signal> signalsMax = dataMapper.energyMax(signal);
        List<Signal> signalsMin = dataMapper.energyMin(signal);
        List<Signal> paramInfo = parameterService.findEnergyParamName();
        Map<String ,Object> param = new HashMap<>();
        if(signalsMax.size()==0 || signalsMin.size()==0){
            for(int num=0;num<paramInfo.size();num++){
                param.put("sigCode",paramInfo.get(num).getSIG_Code());
                param.put("energyValue",0);
                param.put("dateTime",dateTime);
                dataMapper.addEnergyYear(param);
            }
            return;
        }
        for(int i = 0;i<signalsMax.size();i++){
            for(int j=0;j<signalsMin.size();j++){
                if(signalsMax.get(i).getSIG_Code().equals(signalsMin.get(j).getSIG_Code())){
                    param.put("sigCode",signalsMax.get(i).getSIG_Code());
                    param.put("energyValue",Double.valueOf(signalsMax.get(i).getDSIG_Value())-Double.valueOf(signalsMin.get(j).getDSIG_Value()));
                    param.put("dateTime",dateTime);
                    dataMapper.addEnergyYear(param);
                }
            }
        }
    }

    /**
     * 查询时间段内能耗详情
     * @param energyInfo
     * @return
     */
    @Override
    public List<EnergyInfo> energyList(EnergyInfo energyInfo) {
        List<EnergyInfo> energyList=null;
        if(energyInfo.getType()==1){//按日来查询能耗值
            energyList = dataMapper.energyDayList(energyInfo);
        }else if(energyInfo.getType()==2){//按月来查询能耗值
            energyList = dataMapper.energyMonthList(energyInfo);
        }else if(energyInfo.getType()==3){//按年来查询能耗值
            energyList = dataMapper.energyYearList(energyInfo);
        }
        return energyList;
    }
}
