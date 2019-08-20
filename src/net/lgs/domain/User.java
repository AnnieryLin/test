package net.lgs.domain;

/**
 * 用户实体类，对应数据表user_info的一条记录
 */
public class User {

	private int id; // 用户编号
	private String name; // 用户名
	private String password; // 登录密码

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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
