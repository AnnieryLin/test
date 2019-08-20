package net.lgs.service;

import net.lgs.domain.Score;
import net.lgs.exception.ScoreExistException;

public interface IScoreServ {

	/**
	 * 把一次评分结果存入数据库
	 * @throws ScoreExistException 
	 */
	void addScore(Score score) throws ScoreExistException;

}
