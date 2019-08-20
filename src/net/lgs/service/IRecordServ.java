package net.lgs.service;

import java.util.ArrayList;

import net.lgs.domain.Record;

public interface IRecordServ {

	/**
	 * 根据用户id查询其所有历史评分记录（联合score_table表和dev_info表）
	 * @return ArrayList<Record>
	 */
	ArrayList<Record> queryByUser(int userId);

	/**
	 * 根据score_id删除某项评分记录（包括score_table表和dev_info表）
	 * @param scoreId
	 * @return
	 */
	boolean deleteRecord(int scoreId);

}
