package net.lgs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import net.lgs.domain.Score;
import net.lgs.util.ConnectMySQL;

/**
 * IScoreDao接口的实现类
 * @author Administrator
 *
 */
public class ScoreDaoImpl implements IScoreDao {

	@Override
	public boolean isScoreExist(int userId, int devId) {
		// TODO Auto-generated method stub
		String query_sql = "select count(*) from score_table where user_id = " + userId + " and dev_id = " + devId;
		try {
			ConnectMySQL.init();
			System.out.println(query_sql);
	    	ResultSet rs = ConnectMySQL.selectSql(query_sql);
	    	System.out.println("ScoreDaoImpl.isScoreExist(" + userId + ", " + devId + ")");
	    	if(rs.next() && rs.getInt(1) > 0) {
	    		ConnectMySQL.closeConn();
				return true;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		ConnectMySQL.closeConn();
		return false;
	}

	@Override
	public void addScore(Score score) {
		// TODO Auto-generated method stub
		String insert_sql = "insert into score_table(user_id, dev_id, score_code, total_score)"
				+ "values(" + score.getUserId() + ", " + score.getDevId()
				 + ",'" + score.getCode() + "', " + score.getTotal() + ")";
		try {
			ConnectMySQL.init();
			System.out.println(insert_sql);
			int rows = ConnectMySQL.addUpdDel(insert_sql);
			System.out.println("UserDaoImpl.addScore - insert " + rows + " rows");
			if(rows > 0) {
				ConnectMySQL.closeConn();
				return;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		ConnectMySQL.closeConn();
	}

	@Override
	public ArrayList<Score> queryByUser(int userId) {
		// TODO Auto-generated method stub
		String query_sql = "select * from score_table where user_id = " + userId;
		try {
			ConnectMySQL.init();
			System.out.println(query_sql);
	    	ResultSet rs = ConnectMySQL.selectSql(query_sql);
	    	System.out.println("ScoreDaoImpl.queryByUser(" + userId + ")");
	    	ArrayList<Score> scores = new ArrayList<Score>();
	    	while (rs.next()) {
	    		Score score = new Score();
	    		score.setId(rs.getInt("score_id"));
	    		score.setUserId(rs.getInt("user_id"));
	    		score.setDevId(rs.getInt("dev_id"));
	    		score.setCode(rs.getString("score_code"));
	    		Calendar ca = Calendar.getInstance();
	    		ca.setTime(rs.getTimestamp("time"));
	    		ca.add(Calendar.HOUR_OF_DAY, -8);
	    		String str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ca.getTime());
	    		score.setTime(str);
	    		score.setTotal(rs.getInt("total_score"));
				scores.add(score);
			}
	    	ConnectMySQL.closeConn();
	    	return scores;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ArrayList<Integer> queryDevIdByUser(int userId) {
		// TODO Auto-generated method stub
		String query_sql = "select dev_id from score_table where user_id = " + userId;
		try {
			ConnectMySQL.init();
			System.out.println(query_sql);
	    	ResultSet rs = ConnectMySQL.selectSql(query_sql);
	    	System.out.println("ScoreDaoImpl.queryDevIdByUser(" + userId + ")");
	    	ArrayList<Integer> devids = new ArrayList<Integer>();
	    	while (rs.next()) {
				devids.add(rs.getInt("dev_id"));
			}
	    	ConnectMySQL.closeConn();
	    	return devids;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean deleteScore(int id) {
		// TODO Auto-generated method stub
		String delete_sql = "delete from score_table where score_id = " + id;
		try {
			ConnectMySQL.init();
			System.out.println(delete_sql);
			int rows = ConnectMySQL.addUpdDel(delete_sql);
			System.out.println("UserDaoImpl.deleteScore - delete " + rows + " rows");
			if(rows > 0) {
				ConnectMySQL.closeConn();
				return true;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		ConnectMySQL.closeConn();
		return false;
	}

}
