package cn.tedu.store.controller;

import java.io.File;
import java.io.IOException;
import javax.annotation.Resource;
import javax.management.RuntimeOperationsException;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	@Resource
	private IUserService userService;
	//显示注册的视图
	@RequestMapping("/showRegister.do")
	public String showRegister() {
		return "register";
	}
	 
	//显示登陆的视图
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("/showPersonpage.do")
	public String showPersonpage() {
		return "personpage";
	}

	//检查用户名是否存在
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username){
		ResponseResult<Void> rr=null;
		if(userService.checkUsername(username)) {
			rr=new ResponseResult<Void>(0, "用户名不可以使用");
		}else {
			rr=new ResponseResult<Void>(1, "用户名可以使用");
		}
		return rr;
	}
	
	//检查email是否可用
	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email){
		ResponseResult<Void> rr=null;
		if(userService.checkEmail(email)) {
			rr=new ResponseResult<Void>(0,"邮箱不可使用");
		}else {
			rr=new ResponseResult<Void>(1,"邮箱可使用");
		}
		return rr;
	}
	
	//检查电话是否可用
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone){
		ResponseResult<Void> rr=null;
		if(userService.checkPhone(phone)) {
			rr=new ResponseResult<Void>(0,"电话不可使用");
		}else {
			rr=new ResponseResult<Void>(1,"电话可使用");
		}
		return rr;
	}
	
	//注册
	@RequestMapping("/register.do")
	@ResponseBody
	public ResponseResult<Void> register(@RequestParam("uname") String username,@RequestParam("upwd") String password,
	String email,String phone){
		ResponseResult<Void> rr=null;
		try {
			User user=new User();
			user.setEmail(email);
			user.setUsername(username);
			user.setPassword(password);
			user.setPhone(phone);
			userService.addUser(user);
			rr=new ResponseResult<Void>(1, "添加成功");
		} catch (RuntimeException ex) {
			rr=new ResponseResult<Void>(0, "添加不成功");
		}
		return rr;
	}
	
	//登陆
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<User> login(String username,String password,HttpSession session) {
		ResponseResult<User> rr=null;
		try {
			User user=userService.login(username, password);
			rr=new ResponseResult<User>(1, "登陆成功");
			session.setAttribute("user", user);
		} catch (RuntimeException e) {
			rr=new ResponseResult<User>(0, e.getMessage());
		}
		return rr;

	}
	
	//退出
	@RequestMapping("/exit.do")
	public String exit(HttpSession session) {
		session.invalidate();
		return "redirect:../main/showIndex.do";
	}
	//显示修改密码页面
	@RequestMapping("/showPassword.do")
	public String showPassword() {
		return "personal_password";
	}
	
	//修改密码
	@RequestMapping("/updatePassword.do")
	@ResponseBody
	public ResponseResult<Void> updatePassword(HttpSession session,String oldPwd,String newPwd){
		ResponseResult<Void> rr=null;
		try {
			userService.changePassword(this.getId(session), oldPwd, newPwd);
			rr=new ResponseResult<Void>(1, "修改密码成功");
		} catch (RuntimeException e) {
			rr=new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}
	
	@RequestMapping("updateUser.do")
	@ResponseBody
	public ResponseResult<Void> updateUser(HttpSession session,String username,Integer gender,String email,String phone){
		ResponseResult<Void> rr=null;
		try {
			userService.updateUser(this.getId(session), username, gender, email, phone);
			rr=new ResponseResult<Void>(1, "修改成功");
			User user=userService.getUserById(this.getId(session));
			session.setAttribute("user", user);
		} catch (RuntimeException e) {
			rr=new ResponseResult<Void>(0, e.getMessage());
		}
				return rr;
	}
	
	@RequestMapping("/getImage.do")
	@ResponseBody
	public ResponseResult<Void> getImage(MultipartFile file,HttpSession session) throws Exception{
		System.out.println("file===="+file);
		System.out.println("session===="+session);
		ResponseResult<Void> rr=new ResponseResult<Void>(1,"成功");
		//获取当前应用的真实路径
		String path=session.getServletContext().getRealPath("/");
		System.out.println("path:="+path);
		
		file.transferTo(new File(path,"/upload/"+file.getOriginalFilename()));//路径，文件名
		userService.updateImage(this.getId(session), "/upload/"+file.getOriginalFilename());
		System.out.println("路径==="+ "/upload/"+file.getOriginalFilename());
		return rr;
	}
}


















