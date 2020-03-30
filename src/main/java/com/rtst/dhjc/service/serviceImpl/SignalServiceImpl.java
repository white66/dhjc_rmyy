package com.rtst.dhjc.service.serviceImpl;

import com.rtst.dhjc.entity.Signal;
import com.rtst.dhjc.repository.SignalMapper;
import com.rtst.dhjc.service.SignalService;
import com.rtst.dhjc.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author white Liu
 * @Date 2019/12/10 9:51
 * @Version 1.0
 */
@Service
public class SignalServiceImpl implements SignalService {
    @Autowired
    SignalMapper signalMapper;
    @Override
    public List<Signal> getSignalList() {
        List<Signal> signals = signalMapper.getSignalList();
        return signals;
    }

    @Override
    public List<Signal> getSignalListHistory(Signal signal) {
        List<Signal> signals = signalMapper.getSignalListHistory(signal);
        return signals;
    }

    @Override
    public List<Signal> getAlarmListHistory(Signal signal) {
        List<Signal> signalList = signalMapper.getAlarmListHistory(signal);
        for(Signal signals: signalList){
            signals.setDSIG_Value(StringUtil.tenTurnTwo(Integer.parseInt(signals.getDSIG_Value())));
        }
        return signalList;
    }
}
