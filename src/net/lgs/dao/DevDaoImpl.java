package net.lgs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.lgs.domain.Device;
import net.lgs.util.ConnectMySQL;

/**
 * IDevDao接口的实现类
 * @author Administrator
 *
 */
public class DevDaoImpl implements IDevDao {

	@Override
	public Device queryById(int devId) {
		// TODO Auto-generated method stub
		String query_sql = "select * from dev_info where dev_id = " + devId;
		try {
			ConnectMySQL.init();
			System.out.println(query_sql);
	    	ResultSet rs = ConnectMySQL.selectSql(query_sql);
	    	System.out.println("DevDaoImpl.queryById(" + devId + ")");
	    	if (rs.next()) {
	    		Device device = new Device();
	    		device.setId(devId);
	    		device.setName(rs.getString("dev_name"));
	    		ConnectMySQL.closeConn();
		    	return device;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		ConnectMySQL.closeConn();
		return null;
	}


	@Override
	public ArrayList<Device> queryByIds(ArrayList<Integer> devIds) {
		// TODO Auto-generated method stub
		String query_sql = "select dev_id, dev_name from dev_info where dev_id not in (";
		// 多值查询：... where dev_id in (1, 2, 3)
		for (int i = 0; i < devIds.size() - 1; i++) {
			query_sql += devIds.get(i) + ", ";
		}
		query_sql += devIds.get(devIds.size() - 1) + ")";
		try {
			ConnectMySQL.init();
			System.out.println(query_sql);
	    	ResultSet rs = ConnectMySQL.selectSql(query_sql);
	    	System.out.println("DevDaoImpl.queryByIds(...)");
	    	ArrayList<Device> devs = new ArrayList<Device>();
	    	while (rs.next()) {
	    		Device device = new Device();
	    		device.setId(rs.getInt("dev_id"));
	    		device.setName(rs.getString("dev_name"));
	    		devs.add(device);
			}
	    	ConnectMySQL.closeConn();
	    	return devs;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public ArrayList<Device> queryAll() {
		// TODO Auto-generated method stub
		ArrayList<Device> devList = new ArrayList<Device>();
		String query_sql = "select dev_id, dev_name from dev_info";
		try {
			ConnectMySQL.init();
			System.out.println(query_sql);
	    	ResultSet rs = ConnectMySQL.selectSql(query_sql);
	    	System.out.println("DevDaoImpl.queryAll()");
	    	while (rs.next()) {
	    		Device dev = new Device();
	    		dev.setId(rs.getInt("dev_id"));
	    		dev.setName(rs.getString("dev_name"));
	    		devList.add(dev);
			}
	    	ConnectMySQL.closeConn();
	    	return devList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
