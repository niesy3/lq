package com.iot.demo.entity;

public class Device {
    private String ip;
    private int port;
    private boolean switch1 = false;
    private boolean switch2 = false;
    private boolean switch3 = false;
    private String num1;
    private String num2;
    private String num3;
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
}