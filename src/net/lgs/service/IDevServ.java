package net.lgs.service;

import java.util.ArrayList;

import net.lgs.domain.Device;

public interface IDevServ {

	/**
	 * 获取所有设备id列表
	 * @return ArrayList<Device>
	 */
	ArrayList<Device> getDevList();
	
	/**
	 * 根据用户名获取还未评分的设备
	 * @return ArrayList<Device>
	 */
	ArrayList<Device> getDevByUser(int userId);

}
