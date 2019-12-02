package com.iot.demo.entity;

import java.sql.Timestamp;

public class Device {
	
	private String mac;
    private String ip;
    private int port;
    private int id;
    private boolean switch1 = false;
    private boolean switch2 = false;
	private boolean switch3 = false;
    private String num1;
    private String num2;
    private String num3;
    private Timestamp createtime;
    
    
    

	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public boolean isSwitch1() {
		return switch1;
	}
	public void setSwitch1(boolean switch1) {
		this.switch1 = switch1;
	}
	public boolean isSwitch2() {
		return switch2;
	}
	public void setSwitch2(boolean switch2) {
		this.switch2 = switch2;
	}
	public boolean isSwitch3() {
		return switch3;
	}
	public void setSwitch3(boolean switch3) {
		this.switch3 = switch3;
	}

	public String getNum1() {
		return num1;
	}
	public void setNum1(String num1) {
		this.num1 = num1;
	}

	public String getNum2() {
		return num2;
	}
	public void setNum2(String num2) {
		this.num2 = num2;
	}

	public String getNum3() {
		return num3;
	}
	public void setNum3(String num3) {
		this.num3 = num3;
	}
	
   //为数据打时间戳
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	
	
	@Override
	public String toString() {
		return "Device [mac=" + mac + ", ip=" + ip + ", port=" + port + ", id=" + id + ", switch1=" + switch1
				+ ", switch2=" + switch2 + ", switch3=" + switch3 + ", num1=" + num1 + ", num2=" + num2 + ", num3="
				+ num3 + ", createtime=" + createtime + "]";
	}
	
	

		
	//重写打印方法
	/**
	 * @Override
    public String toString() {
        return "Greenwall{" +
                "id=" + id +
                ", switch1='" + switch1 + '\'' +
                ", switch2='" + switch2 + '\'' +
                ", switch3='" + switch3 + '\'' +
                ", switch4='" + switch4 + '\'' +
                ", switch5='" + switch5 + '\'' +
                ", t='" + t + '\'' +
                ", h='" + h + '\'' +
                ", l='" + l + '\'' +
                ", ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                '}';
	 */
	
}