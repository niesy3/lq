package com.iot.demo.controller;

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
    public String send(String msg) throws IOException {
        Socket socket = new Socket(device.getIp(), device.getPort());
        OutputStream out = socket.getOutputStream();
        try{
            out.write(msg.getBytes());
        } finally {
            out.close();
            socket.close();
        }

        return "second";
    }
}
