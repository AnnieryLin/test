package net.lgs.dao;

import java.util.ArrayList;

import net.lgs.domain.Score;

/**
 * 实现对Score对象(score_table表)的增删查改
 * @author Administrator
 *
 */
public interface IScoreDao {

	/**
	 * 根据用户id和设备id查找评分记录是否存在
	 */
	boolean isScoreExist(int userId, int devId);

	/**
	 * 新增一条记录
	 * @param score
	 */
	void addScore(Score score);

	/**
	 * 根据用户id查询其所有历史评分记录
	 * @param userId
	 * @return ArrayList<Score>
	 */
	ArrayList<Score> queryByUser(int userId);
	
	/**
	 * 根据用户id查询其所有已评分设备编号
	 * @param userId
	 * @return ArrayList<Integer>
	 */
	ArrayList<Integer> queryDevIdByUser(int userId);

	/**
	 * 根据id删除某条评分记录
	 * @param id
	 * @return
	 */
	boolean deleteScore(int id);
	
}
