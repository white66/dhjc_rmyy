package com.rtst.dhjc;

import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.nio.file.Paths;

@RunWith(SpringRunner.class)
@SpringBootTest
class DhjcApplicationTests {
    private final static String WEB_SERVICE_URL = "http://192.168.1.99:9095/WebService.asmx?WSDL";
    @Test
    public void generateAsciiDocs() throws Exception {
        //    输出Ascii格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
                .withGeneratedExamples()
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .build();

        Swagger2MarkupConverter.from(new URL("http://localhost:8088/v2/api-docs"))
                .withConfig(config)
                .build()
                .toFile(Paths.get("src/main/resources/docs/asciidoc/generated/api"));
    }
    @Test
    public void sendMsg(){
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(WEB_SERVICE_URL);
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));
        Object[] objects = new Object[0];
                try {
                    // invoke("方法名",参数1,参数2,参数3....);
                    System.out.println("发送webService接口");
                    objects = client.invoke("HelloWorld");//,jobNumbers.get(j).getJobNumber(), alarmList.get(i).getWarn_Content()
                    System.out.println("返回的数据"+objects[0]);
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
    }
}
