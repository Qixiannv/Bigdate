package com.front.user.service;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.front.actor.service.ActorServiceImpl;
import com.front.movie.service.MovieServiceImpl;
import com.front.user.dao.UserDaoImp;
import com.front.user.entity.User;

@Service
public class UserImp {
	@Resource
	private UserDaoImp userRegisterDaoImp;
	
	@Resource
	private MovieServiceImpl msi;
	@Resource
	private ActorServiceImpl asi;
	/**
	 * 用户注册
	 * @param u
	 * @return 主页
	 * @throws Exception
	 */
	public String RegisterUser(User u,HttpSession session,HttpServletRequest request)throws Exception{
		this.userRegisterDaoImp.UserRegister(u);
		session.setAttribute("user", u);
		return "redirect:/indexshow";
	}
	/**
	 * 用户登录 同时把user 放进session 中
	 * @param email   邮箱
	 * @param password   密码
	 * @param request   
	 * @param session  
	 * @return 注册或者错误呀界面
	 */
	public String UserLogin(String email,String password,HttpServletRequest request,HttpSession session){
		try{
		User u=this.userRegisterDaoImp.Userlogin(email);
			if(password.equals(u.getPassword())){
				session.setAttribute("user", u);
				return "redirect:/indexshow";
			}else{
				return "cuowu";
			}
		
		}catch(Exception e){
			e.printStackTrace();
			return "cuowu";
		}
	}
	
	public String UserLogin1(String email,String password,HttpServletRequest request,HttpSession session){
		try{
			int id=Integer.parseInt(request.getParameter("id"));
		User u=this.userRegisterDaoImp.Userlogin(email);
			if(password.equals(u.getPassword())){
				session.setAttribute("user", u);
				return "redirect:/gotosingle?id="+id;
			}else{
				return "cuowu";
			}
		
		}catch(Exception e){
			e.printStackTrace();
			return "cuowu";
		}
	}
	public String UserLogin2(String email,String password,HttpServletRequest request,HttpSession session){
		try{
			int id=Integer.parseInt(request.getParameter("actor_id"));
		User u=this.userRegisterDaoImp.Userlogin(email);
			if(password.equals(u.getPassword())){
				session.setAttribute("user", u);
				return "redirect:/gotoactor?actor_id="+id;
			}else{
				return "cuowu";
			}
		
		}catch(Exception e){
			e.printStackTrace();
			return "cuowu";
		}
	}
	
	/**
	 * 根据user_id 查询出user
	 * @param user_id   用户ID
	 * @return
	 * @throws Exception
	 */
	public User UserSelect(Integer user_id)throws Exception{
		return this.userRegisterDaoImp.UserSelect(user_id);
	}
	/**
	 * 更改用户信息
	 * @param u
	 * @throws Exception
	 */
	public void UserChange(User u)throws Exception{
		this.userRegisterDaoImp.UserChange(u);
	}
	public void AvatarUpdate(String a,int user_id)throws Exception{
		this.userRegisterDaoImp.avatarUpdate(a, user_id);
	}
	public void SignatureUpdate(String signature,int user_id)throws Exception{
		this.userRegisterDaoImp.SignatureUpdate(signature, user_id);
	}
	
	public List<User>  searchAllUser()throws Exception {
		 return this.userRegisterDaoImp.searchAllUser();
	}
	
	
	
	
}
