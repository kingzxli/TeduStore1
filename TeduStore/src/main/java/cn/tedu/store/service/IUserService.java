package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface IUserService {
	/**
	 * 添加用户信息
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 验证邮箱是否存在
	 * @param email
	 * @return 存在返回true，不存在返回false
	 */
	boolean checkEmail(String email);
	/**
	 * 验证电话是否存在
	 * @param phone
	 * @return 存在返回true，不存在返回false
	 */
	boolean checkPhone(String phone);
	/**
	 * 验证用户名是否存在
	 * @param username
	 * @return 若存在则返回true，否则返回false。
	 */
	boolean checkUsername(String username);
	/**
	 * 用户登陆
	 * @param username
	 * @param password
	 * @return 登陆成功返回User对象，不成功则抛出异常,帐号不存在，或在密码错误
	 */
	User login(String username,String password);
	/**
	 * 修改密码
	 * @param id
	 * @param oldPwd
	 * @param newPwd
	 */
	void changePassword(Integer id,String oldPwd,String newPwd);
	/**
	 * 修改用户信息
	 * @param id
	 * @param username
	 * @param gender
	 * @param email
	 * @param phone
	 */
	void updateUser(Integer id,String username,Integer gender,String email,String phone);
	/**
	 * 根据Id获取User对象
	 * @param id
	 * @return
	 */
	User getUserById(Integer id);
	/**
	 * 修改头像信息
	 * @param id
	 * @param image
	 */
	void updateImage(Integer id,String image);
}
