package cn.tedu.store.service;

import javax.annotation.Resource;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UsernameAlreadyExistException;
import cn.tedu.store.service.ex.UsernameNotFountException;

@Service
public class UserService implements IUserService{
	@Resource
	private UserMapper userMapper;
	@Value("#{config.salt}")
	private String salt;
	
	public void addUser(User user) {
		
		if(userMapper.selectByUsername(user.getUsername())==null) {
			String pwd=user.getPassword();
			String md5pwd=DigestUtils.md5Hex(pwd+salt);
			user.setPassword(md5pwd);
			userMapper.insertUser(user);
		}else {
			throw new UsernameAlreadyExistException("用户名已经存在");
		}
	}
	
	
	public boolean checkEmail(String email) {
		return userMapper.selectByEmail(email)>0;
	}
	
	public boolean checkPhone(String phone) {
		return userMapper.selectByPhone(phone)>0;
	}
	
	public boolean checkUsername(String username) {
		return userMapper.selectByUsername(username)!=null;
	}
	
	public User login(String username,String password) {
		User user=userMapper.selectByUsername(username);
		if(user==null) {
			throw new UsernameNotFountException("用户不存在");
		}else {
			String md5Str=DigestUtils.md5Hex(password+salt);
			if(user.getPassword().equals(md5Str)) {
				return user;
			}else {
				throw new PasswordNotMatchException("密码错误");
			}
		}
	}

	public void changePassword(Integer id, String oldPwd, String newPwd) {
		User user=userMapper.selectUserById(id);
		if(user!=null) {
			String oldMD5=DigestUtils.md5Hex(oldPwd+salt);
			if(user.getPassword().equals(oldMD5)) {
				User user1=new User();
				user1.setId(id);
				String newMD5=DigestUtils.md5Hex(newPwd+salt);
				user1.setPassword(newMD5);
				userMapper.updateUser(user1);
			}else {
				throw new PasswordNotMatchException("旧密码输入错误");
			}
		}else {
			throw new UsernameNotFountException("用户不存在");
		}
	}


	public void updateUser(Integer id, String username, Integer gender, String email, String phone) {
		User user1=userMapper.selectUserById(id);
		if(user1!=null) {
			User user2=userMapper.selectByUsername(username);
			if(user2!=null&&!user1.getUsername().equals(username)) {
				throw new UsernameAlreadyExistException("用户名已经存在");
			}else {
				User user=new User();
				user.setId(id);
				user.setUsername(username);
				user.setGender(gender);
				user.setEmail(email);
				user.setPhone(phone);
				userMapper.updateUser(user);
			}   
		}else {
			throw new UsernameNotFountException("用户不存在");
		}
	}


	public User getUserById(Integer id) {
		return userMapper.selectUserById(id);
	}


	public void updateImage(Integer id, String image) {
		userMapper.updateImage(id, image);
		
	}
}
