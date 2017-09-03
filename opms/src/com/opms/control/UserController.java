package com.opms.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.opms.entity.PmsUsers;
import com.opms.service.OrganizationService;
import com.opms.unti.UserOnlineMap;


/**
 * 
 * description:此类是关于用户登录和退出功能的控制器
 * @author liyanpeng
 * @date 2017年7月28日
 */
@Controller
public class UserController {

	@Autowired
	private OrganizationService organizationService;
	/**
	 * 
	 * description:tologin是登录的唯一入口，通过tologin可以避免非法登录
	 * @author liyanpeng
	 * @date 2017年7月28日
	 */
	@RequestMapping("/tologin")
	public String toLoginjsp(HttpSession session){
		if(session.getAttribute("user")!=null)
			return "redirect:index.jsp";
		else
			return "login";
	}
	
	
	/**
	 * 
	 * description:执行登录的具体过程
	 * @author liyanpeng
	 * @date 2017年7月28日
	 */
	
	@RequestMapping("/signin")
	public void login(PmsUsers user,HttpSession session,HttpServletResponse response){
		//获取subject对象
		String json="";
		Subject subject = SecurityUtils.getSubject();
		PmsUsers sessionUser=(PmsUsers) session.getAttribute("user");
		if(!subject.isAuthenticated()&&user.getUsername()==null&&sessionUser==null)
			try {
				response.sendRedirect("tologin");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		if(user.getUsername()!=null){
			if(!subject.isAuthenticated()){
				UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
				token.setRememberMe(true);
				try {
					subject.login(token);
				}catch(UnknownAccountException e1){
					json="{\"message\":\"登录失败，此用户不存在\",\"code\":0}";
				}catch (Exception e) {
					json="{\"message\":\"登录失败，密码错误\",\"code\":0}";
				}
			}
			if(subject.isAuthenticated()){
				PmsUsers pmsuser=organizationService.getPmsUsersByUsername(user.getUsername());
				organizationService.updateDateLogin(pmsuser.getUserid());
				session.setAttribute("user", pmsuser);
				UserOnlineMap.usermap.put(pmsuser.hashCode(), pmsuser);
				json="{\"message\":\"登录成功\",\"code\":1}";
			}
		}else if(session!=null){
			try {
				response.sendRedirect("index.jsp");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * description:执行退出功能，移除session的user，移除管理的在线用户
	 * @author liyanpeng
	 * @date 2017年7月28日
	 */
	@RequestMapping("/tologout")
	public String tologout(HttpSession session){
		Subject currentuser = SecurityUtils.getSubject();
		PmsUsers user=(PmsUsers) session.getAttribute("user");
		if(currentuser!=null){
			organizationService.updateDateLasted(user.getUserid());
			session.removeAttribute("user");
			UserOnlineMap.usermap.remove(user.hashCode());
		}
		currentuser.logout();
		return "login";
	}
	/**
	 * description
	 * 更改密码
	 * @author ChangZhiwei
	 * @time 2017年8月4日
	 */
	@RequestMapping("/profilePwd")
	public String profilePwd() {
		return "profile_pwd";
	}
	/**
	 * description
	 * 更改密码
	 * @author ChangZhiwei
	 * @time 2017年8月4日
	 */
	@RequestMapping("/passwords")
	public  void passwords(PmsUsers pmsUser,HttpSession session,HttpServletResponse resp) {
		PmsUsers user=(PmsUsers) session.getAttribute("user");
		try {
			int flag=organizationService.updatePasswords(pmsUser,user);
			String name="";
			if(flag==1){
				name="{\"message\":\"密码修改成功\",\"code\":1}";
			}else{
				name="{\"message\":\"旧密码输入有误\",\"code\":0}";
			}
			resp.setContentType("text/html;charset=UTF-8");
			 PrintWriter pw = resp.getWriter();
			 pw.write(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
