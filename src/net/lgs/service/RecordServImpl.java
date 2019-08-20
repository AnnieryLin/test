package net.lgs.service;

import java.util.ArrayList;

import net.lgs.dao.DevDaoImpl;
import net.lgs.dao.IDevDao;
import net.lgs.dao.IScoreDao;
import net.lgs.dao.ScoreDaoImpl;
import net.lgs.domain.Record;
import net.lgs.domain.Score;

/**
 * IRecordServ接口的实现类
 * @author Administrator
 *
 */
public class RecordServImpl implements IRecordServ {

	private IScoreDao scoredao = new ScoreDaoImpl();
	private IDevDao devdao = new DevDaoImpl();
	
	@Override
	public ArrayList<Record> queryByUser(int userId) {
		// TODO Auto-generated method stub
		System.out.println("---------RecordServImpl.queryByUser()---------");
		ArrayList<Score> scores = scoredao.queryByUser(userId);
		ArrayList<Record> records = new ArrayList<Record>();
		for (int i = 0; i < scores.size(); i++) {
			Score s = scores.get(i);
			Record record = new Record();
			record.setId(s.getId());
			record.setDevId(s.getDevId());
			record.setDevName(devdao.queryById(s.getDevId()).getName()); // 这里每次循环都要查询数据库一次，可以改成外连接查询
			record.setScoreCode(s.getCode());
			record.setTotalScore(s.getTotal());
			record.setTime(s.getTime());
			record.setUserId(s.getUserId());
			records.add(record);
		}
		return records;
	}

	@Override
	public boolean deleteRecord(int scoreId) {
		// TODO Auto-generated method stub
		System.out.println("---------RecordServImpl.deleteRecord()---------");
		return scoredao.deleteScore(scoreId);
	}

}
