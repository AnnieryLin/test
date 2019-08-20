package net.lgs.domain;

/**
 * 评分指标类，对应数据表item_list的一条记录
 */
public class Item {

	private int id; // 评分项编号，主键
	private String descript; // 条目描述
	private double proport; // 占总分比例

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public double getProport() {
		return proport;
	}
	public void setProport(double proport) {
		this.proport = proport;
	}
}
