package net.lgs.domain;

/**
 * 查询记录临时表tmp_record
 * @author Administrator
 *
 */
public class Record {

	private int id; // 编号，=对应score的id
	private int devId; // 评分设备的id
	private String devName; // 评分设备的名称
	private String scoreCode; // 评分序列编码
	private int totalScore; // 总分
	private String time; // 评分提交时间
	private int userId; // 用户id
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDevId() {
		return devId;
	}
	public void setDevId(int devId) {
		this.devId = devId;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public String getScoreCode() {
		return scoreCode;
	}
	public void setScoreCode(String scoreCode) {
		this.scoreCode = scoreCode;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String date) {
        this.time = date;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
