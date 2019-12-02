package com.iot.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.iot.demo.entity.Device;
import com.iot.demo.service.DeviceService;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Controller
public class AppController {
	private Device device1 = new Device();
	private Device device = new Device();
	@Autowired
	private DeviceService deviceService;
	

    @Scheduled(cron = "0 0 * * * ?")
     	public void chartAdd() throws IOException{
    	   if (device1.getIp() != null || device1.getPort() != 0) {
    		    getDevice(device1);
				deviceService.addChart(device1);
				System.out.println("cron: test");
    		}
    		
    	
    	}
           
	//数据报表
	@RequestMapping("sql")
	public String getSqlid(Model model){
		ArrayList<Device> deviceList = deviceService.prt();
		model.addAttribute("deviceList",deviceList);
		for (Device device : deviceList) {
			System.out.println(device);
		}
        return "sql";
    }
	
//	@RequestMapping("sql1")
//	public String getSqlid1(Model model){
//		ArrayList<Device> deviceList = deviceService.chart();
//		model.addAttribute("deviceList",deviceList);
//		for (Device device : deviceList) {
//			System.out.println(device);
//		}
//        return "sq1";
//    }
	//向表中增加数据
	@RequestMapping("addDevice")
	public String addsql(Model model){
		//device1.setId(6);
		device1.setIp("123.234.234");
		device1.setPort(99);
		device1.setSwitch1(true);
		device1.setSwitch2(true);
		device1.setSwitch3(true);
		device1.setNum1("123");
		device1.setNum2("23");
		device1.setNum3("245");
		int result = deviceService.addChart(device1);
		model.addAttribute("result",result);						
		
		System.out.println(device);
		return "redirect:sql";
	
	}
	public Device getDevice(Device device3) throws IOException {
		String url = "http://"+device3.getIp()+":"+device3.getPort()+"/data";
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(url).build();
	    Response response = client.newCall(request).execute();
	    if (response.isSuccessful()) {
	    	ResponseBody body = response.body();
	    	String string = body.string();
	    	JSONObject json = JSONObject.parseObject(string);
	    	Boolean boolean1 = json.getBoolean("switch1");
	    	Boolean boolean2 = json.getBoolean("switch2");
	    	Boolean boolean3 = json.getBoolean("switch3");
	    	String num1 = json.getString("t");
	    	String num2 = json.getString("h");
	    	String num3 = json.getString("l");
	    	
	    	device3.setSwitch1(boolean1);
	    	device3.setSwitch2(boolean2);
	    	device3.setSwitch3(boolean3);
	    	device3.setNum1(num1);
	    	device3.setNum2(num2);
	    	device3.setNum3(num3);
	    }
		return device3;
		
	}
	@RequestMapping("device")
	public String deviceControll(Model model) throws IOException {
		if (device.getIp() == null || device.getPort() == 0) {
			return "index";
		}
		getDevice(device);
	    
		model.addAttribute("device", device);
		int result = deviceService.addDevice(device);
//		int result1 = deviceService.addChart(device);
		
		model.addAttribute("result",result);		
//		System.out.println("chart表"+result1);
		System.out.println(device);
		return "device";
	}

	@RequestMapping("getIpPort")
	public String getIpPort(String ip, int port, Model model) {
		device.setIp(ip);
		device1.setIp(ip);
		device1.setPort(port);
		device.setPort(port);
		return "redirect:device";
	}

	@RequestMapping("send")
	public String send(Model model) throws IOException {
		OkHttpClient client = new OkHttpClient();
		HttpUrl.Builder urlBuilder = HttpUrl.parse("http://"+device.getIp()+":"+device.getPort()+"/opera").newBuilder();
		urlBuilder.addQueryParameter("switch1", String.valueOf(device.isSwitch1()));
		urlBuilder.addQueryParameter("switch2", String.valueOf(device.isSwitch2()));
		urlBuilder.addQueryParameter("switch3", String.valueOf(device.isSwitch3()));
		HttpUrl httpUrl = urlBuilder.build();
		Request.Builder reqBuilder = new Request.Builder();
		reqBuilder.url(httpUrl);
		Request request = reqBuilder.build();
	    Response response = client.newCall(request).execute();
	    if (response.isSuccessful()) {
	    	return "redirect:device";
	    } else {
	        throw new IOException("Unexpected code " + response);
	    }
	}

	@RequestMapping("switch")
	public String switchChange(String switches, boolean on) {
		switch (switches) {
		case "switch1":
			device.setSwitch1(on);
			break;
		case "switch2":
			device.setSwitch2(on);
			break;
		case "switch3":
			device.setSwitch3(on);
			break;
		default:
			break;
		}
		return "redirect:send";
	}
	
	@RequestMapping("wendu")
	public String wendu(Model model){
		List<Device> deviceList = deviceService.prt();
		model.addAttribute("deviceList",deviceList);
		for (Device device : deviceList) {
			System.out.println(device.getNum1());
		}
        return "wenduzhexiantu";



	}
}
