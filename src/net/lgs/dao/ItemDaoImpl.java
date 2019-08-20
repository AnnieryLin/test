package net.lgs.dao;

import java.sql.ResultSet;

import net.lgs.util.ConnectMySQL;

/**
 * IItemDao接口的实现类
 * @author Administrator
 *
 */
public class ItemDaoImpl implements IItemDao {

	@Override
	public int[] getProportion() {
		// TODO Auto-generated method stub
		int[] result = new int[16];
		String query_sql = "select proportion from item_list";
		try {
			int i = 1;
			String s = "";
			ConnectMySQL.init();
			System.out.println(query_sql);
	    	ResultSet rs = ConnectMySQL.selectSql(query_sql);
	    	while(rs.next()) {
	    		result[i] = rs.getInt(1);
				s += result[i];
				i++;
			}
	    	System.out.println("ItemDaoImpl.getProportion - (result = " + s + ")");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		ConnectMySQL.closeConn();
		return result;
	}

}
