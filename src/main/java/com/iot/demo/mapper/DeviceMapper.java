package com.iot.demo.mapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.iot.demo.entity.Device;

@Repository
public interface DeviceMapper {
    Device Sel(int id);
    ArrayList<Device> prt();//throws SQLException
    int addDevice(Device device1);
    ArrayList<Device> chart();
    int addChart(Device device);
}
