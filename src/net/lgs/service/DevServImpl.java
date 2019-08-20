package net.lgs.service;

import java.util.ArrayList;

import net.lgs.dao.DevDaoImpl;
import net.lgs.dao.IDevDao;
import net.lgs.dao.IScoreDao;
import net.lgs.dao.ScoreDaoImpl;
import net.lgs.domain.Device;
/**
 * IDevServ接口的实现类
 * @author Administrator
 *
 */
public class DevServImpl implements IDevServ {

	private IDevDao devdao = new DevDaoImpl();
	private IScoreDao scoredao = new ScoreDaoImpl();

	@Override
	public ArrayList<Device> getDevList() {
		// TODO Auto-generated method stub
		System.out.println("---------DevServImpl.getDevList()---------");
		return devdao.queryAll();
	}

	@Override
	public ArrayList<Device> getDevByUser(int userId) {
		// TODO Auto-generated method stub
		ArrayList<Integer> devIds = new ArrayList<Integer> ();
		devIds = scoredao.queryDevIdByUser(userId);
		return devdao.queryByIds(devIds);
	}

}
