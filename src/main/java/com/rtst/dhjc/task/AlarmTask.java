package com.rtst.dhjc.task;

import com.rtst.dhjc.entity.Alarm;
import com.rtst.dhjc.entity.JobNumber;
import com.rtst.dhjc.service.serviceImpl.AlarmServiceImpl;
import com.rtst.dhjc.service.serviceImpl.JobNumberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author White Liu
 * @Description 详情
 * @Date 2020/10/13 14:51
 * @Version 1.0
 */
@Component
@Configuration
@Slf4j
public class AlarmTask {
    @Autowired
    JobNumberServiceImpl jobNumberService;
    @Autowired
    AlarmServiceImpl alarmService;
    private final static String WEB_SERVICE_URL = "http://192.133.1.40:8090/wechatmsg.asmx?WSDL";

    @Scheduled(cron="0,20,40 * * * * ?")
    public void sentAlarmMsgToWeChat(){
        List<Alarm> alarmList =   alarmService.selectAlarmList();
        if(alarmList.size()>0){
            List<JobNumber> jobNumbers = jobNumberService.jobNumberList();
            // 创建动态客户端
            JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
            Client client = dcf.createClient(WEB_SERVICE_URL);
            // 需要密码的情况需要加上用户名和密码
            // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
            Object[] objects = new Object[0];
            for(int i = 0;i<alarmList.size();i++){
                for(int j = 0;j<jobNumbers.size();j++){
                    try {
                        // invoke("方法名",参数1,参数2,参数3....);
                        System.out.println("发送webService接口");
                        objects = client.invoke("SendMessage",jobNumbers.get(j).getJobNumber(), "尊敬的"+jobNumbers.get(j).getJobNumber()+",出现"+alarmList.get(i).getWarn_Content());
                        log.info("推送告警消息到微信webservice接口"+"工号："+jobNumbers.get(j).getJobNumber()+"告警内容:"+alarmList.get(i).getWarn_Content());
                        System.out.println("返回的数据"+objects[0]);
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
