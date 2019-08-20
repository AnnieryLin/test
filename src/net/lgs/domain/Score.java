package net.lgs.domain;

/**
 * 信息安全相关条目评分实体类，对应数据表score_table的一条记录
 */
public class Score {

	private int id; // 编号，主键
	private String code; // 评分序列编码
	private String time; // 评分提交时间
	private int total; // 总分
	private int userId; // 用户id
	private int devId; // 评分设备的id
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String date) {
		this.time = date;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getDevId() {
		return devId;
	}
	public void setDevId(int devId) {
		this.devId = devId;
	}
}
