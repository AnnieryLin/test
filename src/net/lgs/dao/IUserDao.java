package net.lgs.dao;

import net.lgs.domain.User;

/**
 *  实现对User对象(user_info表)的增删查改
 * @author Administrator
 *
 */
public interface IUserDao {

	/**
	 * 根据用户名查找用户是否存在
	 */
	boolean isUserExist(String userName);

	/**
	 * 根据用户名和密码查找用户
	 * @return 查找到的用户
	 */
	User findUser(String userName, String userPwd);
	
	/**
	 * 添加用户
	 */
	void addUser(User user);

}
