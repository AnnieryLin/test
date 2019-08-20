package net.lgs.dao;

import java.util.ArrayList;

import net.lgs.domain.Device;

/**
 * 实现对Device对象(dev_info表)的增删查改
 * @author Administrator
 *
 */
public interface IDevDao {

	/**
	 * 根据设备id查找设备
	 * @return Device
	 */
	Device queryById(int devId);
	
	/**
	 * 根据设备id列表查询不匹配的设备列表 (not in)
	 * @return ArrayList<Device>
	 */
	ArrayList<Device> queryByIds(ArrayList<Integer> devIds);
	
	/**
	 * 查询所有设备，返回设备id列表
	 * @return ArrayList<Device>
	 */
	ArrayList<Device> queryAll();

}
