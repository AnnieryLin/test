package net.lgs.service;

import net.lgs.dao.IUserDao;
import net.lgs.dao.UserDaoImpl;
import net.lgs.domain.User;
import net.lgs.exception.UserExistException;

/**
 * IUserServ接口的实现类
 */
public class UserServImpl implements IUserServ {

	private IUserDao userdao = new UserDaoImpl();

	@Override
	public void register(User user) throws UserExistException {
		// TODO Auto-generated method stub
		System.out.println("---------UserServImpl.register()---------");
		if(userdao.isUserExist(user.getName()) == false) {
			System.out.println("无重复用户名，注册继续……");
			userdao.addUser(user);
		} else {
			throw new UserExistException("用户名已存在");
		}
	}

	@Override
	public User login(String userName, String userPwd) {
		// TODO Auto-generated method stub
		System.out.println("---------UserServImpl.login()---------");
		User user = new User();
		try {
			if(userdao.isUserExist(userName)) {
				user = userdao.findUser(userName, userPwd);
				if(user != null) {
					System.out.println("findUser()执行成功，登录继续……");
				}
				// 传回空user，表示密码错误
			} else {
				// 用户名不存在，传回id=0的user对象
				user.setId(0);
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		return user; 
	}

}
