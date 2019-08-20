package net.lgs.service;

import net.lgs.domain.User;
import net.lgs.exception.UserExistException;

public interface IUserServ {

	/**
	 * 用户注册服务
	 */
	void register(User user) throws UserExistException;
	
	/**
	 * 用户登录服务
	 */
	User login(String userName, String userPwd);
}
