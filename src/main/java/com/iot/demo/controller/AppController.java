package com.iot.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.iot.demo.entity.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

@Controller
public class AppController {

    private Device device = new Device();

    @RequestMapping("getIpPort")
    public String getIpPort(Device dev,Model model){
        device.setIp(dev.getIp());
        device.setPort(dev.getPort());
        model.addAttribute("device",device);
        return "device";
    }
    @RequestMapping("send")
    public String send(Model model) throws IOException {
        Socket socket = new Socket(device.getIp(), device.getPort());
        OutputStream out = socket.getOutputStream();
        String json = JSONObject.toJSONString(device);
        try{
            out.write(json.getBytes());
        } finally {
            out.close();
            socket.close();
        }
        model.addAttribute("device",device);
        return "device";
    }
    @RequestMapping("switch")
    public String switchChange(boolean on) {
    	device.setOn(on);
    	return "redirect:send";
    }
}
