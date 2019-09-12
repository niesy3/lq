package com.iot.demo;

import com.alibaba.fastjson.JSONObject;
import com.iot.demo.entity.Device;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
        Device device = new Device();
        device.setIp("local");
        device.setPort(123);
        device.setOn(true);
        String s = JSONObject.toJSONString(device);
        System.out.println(s);
    }

}
