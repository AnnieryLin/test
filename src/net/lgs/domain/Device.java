package net.lgs.domain;

/**
 * 车载终端设备实体类，对应数据表dev_info的一条记录
 */
public class Device {

	private int id; // 设备编号
	private String name; //设备名称

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
