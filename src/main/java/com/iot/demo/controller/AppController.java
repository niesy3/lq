package com.iot.demo.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.iot.demo.entity.Device;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Controller
public class AppController {

	private Device device = new Device();

	@RequestMapping("device")
	public String device(Model model) throws IOException {
		if (device.getIp() == null || device.getPort() == 0) {
			return "index";
		}
		
		String url = "http://"+device.getIp()+":"+device.getPort()+"/data";
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
	    	device.setSwitch1(boolean1);
	    	device.setSwitch2(boolean2);
	    	device.setSwitch3(boolean3);
	    	device.setNum1(num1);
	    	device.setNum2(num2);
	    }
		model.addAttribute("device", device);
		return "device";
	}

	@RequestMapping("getIpPort")
	public String getIpPort(String ip, int port, Model model) {
		device.setIp(ip);
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
}
