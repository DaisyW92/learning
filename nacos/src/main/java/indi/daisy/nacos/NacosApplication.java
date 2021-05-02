package indi.daisy.nacos;

import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

/**
 * @author: daisyw
 * @data: 2021/5/2 下午5:02
 */
@SpringBootApplication
@RestController
@RefreshScope
public class NacosApplication {


    public static void main(String[] args) {
        SpringApplication.run(NacosApplication.class);
    }
    @Value(value = "${test:aaa}")
    public Set<String> test;


    @Value(value = "#{${test2}}")
    private Map<String,String> test2;

    @GetMapping("/test")
    public String getConf() {
        return test.toArray()[0] + "   " + test.toArray()[1] + "   " + test2.keySet().iterator().next()+
                test2.get("ccc");
    }

}
