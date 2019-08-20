package net.lgs.service;

import net.lgs.dao.IScoreDao;
import net.lgs.dao.ScoreDaoImpl;
import net.lgs.domain.Score;
import net.lgs.exception.ScoreExistException;

/**
 * IScoreServ接口的实现类
 * @author Administrator
 *
 */
public class ScoreServImpl implements IScoreServ {

	private IScoreDao scoredao = new ScoreDaoImpl();

	@Override
	public void addScore(Score score) throws ScoreExistException {
		// TODO Auto-generated method stub
		System.out.println("---------ScoreServImpl.addScore()---------");
		if(scoredao.isScoreExist(score.getUserId(), score.getDevId()) == false) {
			System.out.println("当前用户未对此设备评过分，可以写入数据库……");
			scoredao.addScore(score);
		} else {
			throw new ScoreExistException("当前用户已对此设备评过分，操作失败……");
		}
	}

}
