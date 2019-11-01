package cn.tedu.store.mapper;

import org.apache.ibatis.annotations.Param;

import cn.tedu.store.bean.User;
/**
 * 学子商城
 * @author king
 *2018/07/30
 */
public interface UserMapper {
	/**
	 * 添加用户
	 * @param user
	 */
	void insertUser(User user);
	/**
	 * 根据用户名查询	
	 * @param username
	 * @return 如果查到了，把结果封装成User对象返回，没查到则返回null
	 */
	User selectByUsername(String username);
	/**
	 * 根据邮箱查询
	 * @param email
	 * @return 如果没有查到返回0,查到了则返回查询条数
	 */
	Integer selectByEmail(String email);
	/**
	 * 根据电话号码查询
	 * @param phone
	 * @return 如果没有查到返回0,查到了则返回查询条数
	 */
	Integer selectByPhone(String phone);
	/**
	 * 修改用户信息
	 * @param user
	 */
	void updateUser(User user);
	/**
	 * 根据Id查询用户
	 * @param id
	 * @return 返回当前记录封装成user对象，如没有则返回null
	 */
	User selectUserById(Integer id);
	/**
	 * 修改图片信息
	 * @param id
	 * @param image
	 */
	void updateImage(@Param("id") Integer id,@Param("image") String image);


}
