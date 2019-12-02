package com.iot.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.demo.entity.Device;
import com.iot.demo.mapper.DeviceMapper;

@Service
public class DeviceService {
    @Autowired
    DeviceMapper deviceMapper;
    
    public Device Sel(int id){
        return deviceMapper.Sel(id);
    }
    //数据报表
    public ArrayList<Device> prt(){
    	return deviceMapper.prt();
    }
    //新增信息
    public int addDevice(Device device1){
    	return deviceMapper.addDevice(device1);
    }
    
    public int addChart(Device device1){
    	return deviceMapper.addChart(device1);
    }
    //可视化图表
    public ArrayList<Device> chart(){
    	return deviceMapper.chart();
    }
    
}