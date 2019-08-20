package net.lgs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.lgs.domain.User;
import net.lgs.util.BCrypt;
import net.lgs.util.ConnectMySQL;

/**
 * IUserDao接口的实现类
 */
public class UserDaoImpl implements IUserDao {

	@Override
	public boolean isUserExist(String userName) {
		// TODO Auto-generated method stub
		String query_sql = "select count(*) from user_info where user_name = '" + userName + "'";
		try {
			ConnectMySQL.init();
			System.out.println(query_sql);
	    	ResultSet rs = ConnectMySQL.selectSql(query_sql);
	    	System.out.println("UserDaoImpl.isUserExist(" + userName + ")");
	    	if(rs.next() && rs.getInt(1) > 0) {
	    		ConnectMySQL.closeConn();
				return true;
			}
		}  catch (SQLException e) {
			return false;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		ConnectMySQL.closeConn();
		return false;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		String insert_sql = "insert into user_info(user_name, user_pwd) values('" + user.getName()
				+ "','" + user.getPassword() + "')";
		try {
			ConnectMySQL.init();
			System.out.println(insert_sql);
	    	int rows = ConnectMySQL.addUpdDel(insert_sql);
	    	System.out.println("UserDaoImpl.addUser - insert " + rows + " rows");
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
	public User findUser(String userName, String userPwd) {
		// TODO Auto-generated method stub
		String query_sql = "select * from user_info where user_name='" + userName + "'"; // + "' and user_pwd='" + userPwd +"'";
		try {
			User user = new User();
			ConnectMySQL.init();
			System.out.println(query_sql);
	    	ResultSet rs = ConnectMySQL.selectSql(query_sql);
	    	System.out.println("UserDaoImpl.findUser(" + userName + ", " + userPwd + ")");
	    	if(rs.next() && BCrypt.checkpw(userPwd, rs.getString("user_pwd"))) {
				user.setId(rs.getInt("user_id"));
				user.setName(userName);
				// user.setPassword(userPwd);
				ConnectMySQL.closeConn();
				return user;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		ConnectMySQL.closeConn();
		return null;
	}

}
