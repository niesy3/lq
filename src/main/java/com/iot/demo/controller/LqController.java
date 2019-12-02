package com.iot.demo.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.iot.demo.entity.Device;
import com.iot.demo.service.DeviceService;

@RestController
public class LqController {
	private Device device = new Device();
	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping("temp")
	public String temp() {
		String[] array=new String[10];
		ArrayList<String> al=new ArrayList<String>();
		String str1 = "";
		String str8 = "[";
		String str9 = "]";
		String strjson = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		ArrayList<Device> deviceList = deviceService.chart();
//		return deviceList;
		//返回list会自动变成json格式
		for (Device device : deviceList) {
			if (device.getNum1()!=null) 
			{
				String date = sdf.format(device.getCreatetime());	
				String temp = device.getNum1();
				str1=strAdd("temp",temp,date);
				al.add(str1);
				}else {
					continue;
				}
			
//			System.out.println(str1);
//			System.out.println(al.toString());
		}
		String arraystr= String.join(",",al);//将list转为string
		String arraystr1 = str8+arraystr+str9;//给arraystr加[ ]
		System.out.println(arraystr1);
		JSONArray array1 = JSON.parseArray(arraystr1);
        for (int i = 0; i < array1.size(); i++) {
            //JSONArray中的数据转换为String类型需要在外边加"";不然会报出类型强转异常！
            strjson = array1.get(i)+"";
            JSONObject object = JSON.parseObject(strjson);
            System.out.println(object.get("temp"));
        }
		return arraystr1;
		
	}
	
	@RequestMapping("humi")
	public String humi() {
		String[] array=new String[10];
		ArrayList<String> al=new ArrayList<String>();
		String str1 = "";
		String str8 = "[";
		String str9 = "]";
		String strjson = "";
		
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		ArrayList<Device> deviceList = deviceService.chart();
		for (Device device : deviceList) {
			if (device.getNum1()!=null) 
			{
				String date = sdf.format(device.getCreatetime());	
				String humi = device.getNum2();
				str1=strAdd("humi",humi,date);
				al.add(str1);
				}else {
					continue;
				}
		}
		String arraystr= String.join(",",al);//将list转为string
		String arraystr1 = str8+arraystr+str9;//给arraystr加[ ]
		System.out.println(arraystr1);
		JSONArray array1 = JSON.parseArray(arraystr1);
        for (int i = 0; i < array1.size(); i++) {
            //JSONArray中的数据转换为String类型需要在外边加"";不然会报出类型强转异常！
            strjson = array1.get(i)+"";
            JSONObject object = JSON.parseObject(strjson);
            System.out.println(object.get("humi"));
        }
		return arraystr1;
		
	}
	
	@RequestMapping("light")
	public String light() {
		String[] array=new String[10];
		ArrayList<String> al=new ArrayList<String>();
		String str1 = "";
		String str8 = "[";
		String str9 = "]";
		String strjson = "";
		
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		ArrayList<Device> deviceList = deviceService.chart();
		for (Device device : deviceList) {
			if (device.getNum1()!=null) 
			{
				String date = sdf.format(device.getCreatetime());	
				String l = device.getNum3();
				str1=strAdd("light",l,date);
				al.add(str1);
				}else {
					continue;
				}
//			String date = sdf.format(device.getCreatetime());	
//			String humi = device.getNum2();
//			str1=strAddhumi(humi,date);
//			al.add(str1);
//			System.out.println(str1);
//			System.out.println(al.toString());
		}
		String arraystr= String.join(",",al);//将list转为string
		String arraystr1 = str8+arraystr+str9;//给arraystr加[ ]
		System.out.println(arraystr1);
		JSONArray array1 = JSON.parseArray(arraystr1);
        for (int i = 0; i < array1.size(); i++) {
            //JSONArray中的数据转换为String类型需要在外边加"";不然会报出类型强转异常！
            strjson = array1.get(i)+"";
            JSONObject object = JSON.parseObject(strjson);
            System.out.println(object.get("l"));
        }
		return arraystr1;
		
	}
	
	//拼接数据为String
	private String strAdd(String thl,String str2,String str3){
		String str4 = "{\"" + thl + "\":\"";
		String str5 = "\",";
		String str6 = "\"time\":\"";
		String str7 = "\"}";
		String result = str4+str2+str5+str6+str3+str7;
		
		System.out.println(result);
		return result;
	}


	@RequestMapping("/getwendu")
	public Device wendu() {
//		String s = "{\"messege\":\"success\"}";
//		JSONObject json = JSONObject.parseObject(s);
		Device device = new Device();
		device.setId(100);
		return device;
	}
}
