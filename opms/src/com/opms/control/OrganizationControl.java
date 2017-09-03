package com.opms.control;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.opms.entity.PmsDeparts;
import com.opms.entity.PmsGroups;
import com.opms.entity.PmsGroupsPermission;
import com.opms.entity.PmsGroupsUser;
import com.opms.entity.PmsNotices;
import com.opms.entity.PmsPermissions;
import com.opms.entity.PmsPositions;
import com.opms.entity.PmsUserPms;
import com.opms.entity.PmsUsers;
import com.opms.entity.PmsUsersProfile;
import com.opms.entity.PmsUsersname;
import com.opms.service.OrganizationService;
import com.opms.unti.IntDate;
import com.opms.unti.RandomTest;

@Controller
public class OrganizationControl extends MyException{
	@Autowired
	private OrganizationService organizationService;
	/**
	 * 
	 * description:查询得到所有的部门
	 * @author liyanpeng
	 * @date 2017年7月28日
	 */
	@RequestMapping("/getDeparts")
	public String listPmsDeparts(Model model){
		List<PmsDeparts> listPmsDeparts=organizationService.listPmsDeparts();
		model.addAttribute("listPmsDeparts",listPmsDeparts);
		int counter=organizationService.countDeparts();
		model.addAttribute("counter", counter);
		return "department_manage";
	}
	
	/**
	 * 
	 * description:添加新部门
	 * @author liyanpeng
	 * @date 2017年7月28日
	 */
	
	@RequestMapping("/toAddDepartment")
	public String toAddDepartment(Model model){
		long departid=organizationService.toAddDepartment();
		model.addAttribute("departid", departid);
		model.addAttribute("status",1);
		return "add_department_manage";
	}
	/**
	 * 
	 * description:添加新部门
	 * @author liyanpeng
	 * @date 2017年7月28日
	 */
	@RequestMapping("addDepartment")
	public void addDepartment(PmsDeparts pmsdepart,HttpServletResponse response){
		String jsondata="";
		int flag=organizationService.addDepartment(pmsdepart);
		if(flag==1)
			jsondata="{\"message\":\"添加部门成功\",\"code\":1}";
		else if(flag==0)
			jsondata="{\"message\":\"添加部门失败\",\"code\":0}";
		else
			jsondata="{\"message\":\"此部门名称已存在，请重新输入\",\"code\":0}";
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsondata);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * description:
	 * @author liyanpeng
	 * @date 2017年8月2日
	 */
	@RequestMapping("toGroupPermission")
	public String toGroupPermission(long groupid,Model model) {
		List<PmsPermissions> listall=new ArrayList<>();
		List<Long> listgrouppermission=organizationService.listGroupsPermission(groupid);
		List<PmsPermissions> listparent=organizationService.listPermissionParent();
		for (PmsPermissions pmsPermissions : listparent) {
			List<PmsPermissions> sonlist=organizationService.listPermissionManageSon(pmsPermissions.getPermissionid());
			for (PmsPermissions pmsPermissions2 : sonlist) {
				if(listgrouppermission.contains(pmsPermissions2.getPermissionid()))
					pmsPermissions2.isexist=1;
				else
					pmsPermissions2.isexist=0;
			}
			sonlist.add(0, pmsPermissions);
			listall.addAll(sonlist);
		}
		model.addAttribute("size",listall.size());
		model.addAttribute("listall",listall);
		PmsGroups group=organizationService.getPmsGroupById(groupid);
		model.addAttribute("group",group);
		return "group_permission";
	}
	
	
	
	/**
	 * 
	 * description:根据部门ID查询部门对象，并且将此对象存入model
	 * @author liyanpeng
	 * @date 2017年7月29日
	 */
	@RequestMapping("/getDepartById")
	public String getDepartById(long departid,Model model){
		PmsDeparts pmsdepart=organizationService.getpmsDepartsById1(departid);
		model.addAttribute("pmsdepart", pmsdepart);
		return "edit_department_manage";
	}
	
	/**
	 * 
	 * description:
	 * @author liyanpeng
	 * @date 2017年8月4日
	 */
	@RequestMapping("setGroupPermission")
	public void setGroupPermission(HttpServletRequest request,HttpServletResponse response) {
		long groupid=Long.parseLong(request.getParameter("groupid"));
		String[] permissions=request.getParameterValues("permissions");
		int flag=organizationService.deleteGroupPermissionByGroupid(groupid);
		if(permissions!=null)
			for (String string : permissions) {
				PmsGroupsPermission pgp=new PmsGroupsPermission();
				pgp.setId(RandomTest.random());
				pgp.setGroupid(groupid);
				pgp.setPermissionid(Long.parseLong(string));
				organizationService.addGroupsPermission(pgp);
			}
		String jsondata="";
		jsondata="{\"message\":\"设置权限成功\",\"code\":1}";
		
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsondata);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * description:调用服务层的updatedepart方法对部门信息进行编辑
	 * @author liyanpeng
	 * @date 2017年7月29日
	 */
	@RequestMapping("editDepart")
	public void editDepart(PmsDeparts pmsDepart,HttpServletResponse response){
		String jsondata="";
		int flag=organizationService.updateDepart(pmsDepart);
		if(flag==1)
			jsondata="{\"message\":\"编辑部门成功\",\"code\":1}";
		else if(flag==0)
			jsondata="{\"message\":\"编辑部门失败\",\"code\":0}";
		else
			jsondata="{\"message\":\"此部门名称已存在，请重新输入\",\"code\":0}";
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsondata);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * description:根据用户ID来修改用户的状态
	 * @author liyanpeng
	 * @date 2017年7月29日
	 */
	@RequestMapping("departStatus")
	public void updateDepartStatus(long departid, int status,HttpServletResponse response){
		int flag=organizationService.updateDepartStatus(departid, status);
		String jsondata="";
		if(flag==1)
			jsondata="{\"message\":\"修改部门状态成功\",\"code\":1}";
		else
			jsondata="{\"message\":\"修改部门状态失败\",\"code\":0}";
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsondata);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("isExistName")
	public void isExistName(String name,HttpServletResponse response){
		int flag=organizationService.isExistName(name);
		String jsondata="";
		if(flag>0)
			jsondata="{\"message\":\"此部门名已存在，请重新输入\",\"code\":1}";
		else
			jsondata="{\"message\":\"\",\"code\":0}";
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsondata);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("isExistTitle")
	public void isExistTitle(String title,HttpServletResponse response){
		String jsondata="";
		int flag=organizationService.isExistTitle(title);
		if(flag>0)
			jsondata="{\"message\":\"此公告标题已存在，请重新输入\",\"code\":1}";
		else
			jsondata="{\"message\":\"\",\"code\":0}";
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsondata);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * description:按照状态和部门名称查询部门
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@RequestMapping("searchDeparts")
	public String searchDeparts(PmsDeparts pmsdepart,Model model){
		List<PmsDeparts> listPmsDeparts=organizationService.searchDeparts(pmsdepart);
		model.addAttribute("listPmsDeparts", listPmsDeparts);
		int counter=listPmsDeparts.size();
		model.addAttribute("counter", counter);
		return "department_manage";
		
		
	}
	
	/**
	 * description:获取全部的公告
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@RequestMapping("getNotices")
	public String getNotices(Model model){
		List<PmsNotices> listnotices=organizationService.listPmsNotices();
		model.addAttribute("listnotices",listnotices);
		int counter=organizationService.countNotices();
		model.addAttribute("counter", counter);
		return "notice_manage";
	}
	
	
	/**
	 * description:
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@RequestMapping("toEditNotice")
	public String toEditNotice(long noticeid,Model model){
		PmsNotices notice=organizationService.getpmsNoticesById(noticeid);
		model.addAttribute("notice",notice);
		return "edit_notice_manage";
	}
	/**
	 * description:
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@RequestMapping("editNotice")
	public void editNotice(PmsNotices notice,HttpServletResponse response){
		String jsondata="";
		int flag=organizationService.updateNotices(notice);
		if(flag==1)
			jsondata="{\"message\":\"编辑公告成功\",\"code\":1}";
		else if(flag==0)
			jsondata="{\"message\":\"编辑公告失败\",\"code\":0}";
		else
			jsondata="{\"message\":\"此公告标题已存在\",\"code\":0}";
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsondata);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * description:
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@RequestMapping("searchNotices")
	public String searchNotices(PmsNotices pmsnotice,Model model){
		List<PmsNotices> listnotices=organizationService.searchNotices(pmsnotice);
		model.addAttribute("listnotices",listnotices);
		int counter=listnotices.size();
		model.addAttribute("counter", counter);
		return "notice_manage";
	}
	
	
	/**
	 * description:
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@RequestMapping("updateNoteceStatus")
	public void updateNoteceStatus(HttpServletResponse response,long noticeid,int status){
		int flag=organizationService.updateNoticesStatus(noticeid, status);
		String jsondata="";
		if(flag==1)
			jsondata="{\"message\":\"修改公告状态成功\",\"code\":1}";
		else
			jsondata="{\"message\":\"修改公告状态失败\",\"code\":0}";
		try {
			
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsondata);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * description:
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@RequestMapping("deleteNotice")
	public void deleteNotice(HttpServletResponse response,long noticeid){
		int flag=organizationService.deleteNotice(noticeid);
		String jsondata="";
		if(flag==1)
			jsondata="{\"message\":\"删除公告成功\",\"code\":1}";
		else
			jsondata="{\"message\":\"删除公告失败\",\"code\":0}";
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsondata);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * description:跳转到新增公告页面
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@RequestMapping("toAddNotice")
	public String toAddNotice(Model model){
		long noticeid=organizationService.toAddNotice();
		model.addAttribute("noticeid",noticeid);
		return "add_notice_manage";
	}
	/**
	 * description:增加一个新的公告
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@RequestMapping("addNotice")
	public void addNotice(PmsNotices notice,HttpServletResponse response){
		String jsondata="";
		int flag=organizationService.addNotices(notice);
		if(flag==1)
			jsondata="{\"message\":\"添加公告成功\",\"code\":1}";
		else if(flag==0)
			jsondata="{\"message\":\"添加公告失败\",\"code\":0}";
		else
			jsondata="{\"message\":\"此公告标题已存在\",\"code\":0}";
		
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsondata);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * description:获取所有的组
	 * @author liyanpeng
	 * @date 2017年8月2日
	 */
	@RequestMapping("GetGroups")
	public String GetGroups(Model model) {
		List<PmsGroups> listgroups=organizationService.listPmsGroups();
		int count=listgroups.size();
		model.addAttribute("count",count);
		model.addAttribute("listgroups",listgroups);
		return "group_manage";
	}
	
	
	
	
	/**
	 * description:
	 * @author liyanpeng
	 * @date 2017年8月2日
	 */
	@RequestMapping("toEditGroup")
	public String toEditGroup(long groupid,Model model) {
		PmsGroups group=organizationService.getPmsGroupById1(groupid);
		model.addAttribute("group",group);
		return "edit_group_manage";
	}
	
	
	/**
	 * description:
	 * @author liyanpeng
	 * @date 2017年8月3日
	 */
	@RequestMapping("editGroup")
	public void editGroup(PmsGroups group,HttpServletResponse response) {
		int flag=organizationService.updateGroup(group);
		String jsondata="";
		if(flag==1)
			jsondata="{\"message\":\"编辑组成功\",\"code\":1}";
		else if(flag==0)
			jsondata="{\"message\":\"编辑组失败\",\"code\":0}";
		else
			jsondata="{\"message\":\"此名称已存在,不能提交\",\"code\":0}";
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsondata);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * description:检查是否存在此组名称
	 * @author liyanpeng
	 * @date 2017年8月3日
	 */
	@RequestMapping("isExistGroupName")
	public void isExistGroupName(String name,HttpServletResponse response) {
		int flag=organizationService.isExistGroupName(name);
		String jsondata="";
		if(flag>0)
			jsondata="{\"message\":\"此名称已存在，请更换名称\",\"code\":1}";
		else
			jsondata="{\"message\":\"\",\"code\":0}";
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsondata);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * description:
	 * @author liyanpeng
	 * @date 2017年8月2日
	 */
	@RequestMapping("deleteGroup")
	public void deleteGroup(long groupid,HttpServletResponse response) {
		int flag=organizationService.deleteGroup(groupid);
		String jsondata="";
		if(flag==1)
			jsondata="{\"message\":\"删除组成功\",\"code\":1}";
		else
			jsondata="{\"message\":\"删除组失败\",\"code\":0}";
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsondata);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * description:按照组名称的关键字来搜索相关的组
	 * @author liyanpeng
	 * @date 2017年8月2日
	 */
	@RequestMapping("searchGroups")
	public String searchGroups(PmsGroups pmsgroup,Model model) {
		List<PmsGroups> listgroups=organizationService.searchGroup(pmsgroup);
		int count=listgroups.size();
		model.addAttribute("count",count);
		model.addAttribute("listgroups",listgroups);
		return "group_manage";
	}
	
	/**
	 * description:
	 * @author liyanpeng
	 * @date 2017年8月3日
	 */
	
	@RequestMapping("toAddGroup")
	public String toAddGroup(Model model) {
		long groupid=organizationService.toAddGroup();
		model.addAttribute("groupid",groupid);
		return "add_group_manage";
	}
	
	/**
	 * description:
	 * @author liyanpeng
	 * @date 2017年8月3日
	 */
	@RequestMapping("addGroup")
	public void addGroup(PmsGroups group,HttpServletResponse response) {
		int flag=organizationService.addGroup(group);
		String jsondata="";
		if(flag==1)
			jsondata="{\"message\":\"添加组成功\",\"code\":1}";
		else if(flag==0)
			jsondata="{\"message\":\"添加组失败\",\"code\":0}";
		else
			jsondata="{\"message\":\"此名称已存在，不能提交\",\"code\":0}";
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsondata);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/*
	  * description
	 * 便利用户信息
	 * @author ChangZhiwei
	 * @time 2017年7月27日
	 */
	@RequestMapping("/listPmsUsersProfile")
	public String listPmsUsersProfile(Model model){
		List<PmsUserPms> listPmsUserPms=organizationService.listPmsUsersProfile1();
		model.addAttribute("listPmsUserPms", listPmsUserPms);
		int counter=organizationService.countUser();
		model.addAttribute("counter", counter);
		return "user_manage";
	}
	/*
	  * description
	 * 根据用户ID查找用户获得部门
	 * @author ChangZhiwei
	 * @time 2017年7月27日
	 */
	@RequestMapping("/getUserManageById")
	public String getUserManageById(long userid,Model model){
		PmsUsers pmsUsers=organizationService.getPmsUsersById(userid);
		model.addAttribute("pmsUsers", pmsUsers);
		PmsUsersProfile pmsUsersProfile=organizationService.getPmsUsersProfileById(userid);
		model.addAttribute("pmsUsersProfile", pmsUsersProfile);
		List<PmsDeparts> listPmsDeparts=organizationService.listPmsDeparts1();
		model.addAttribute("listPmsDeparts", listPmsDeparts);
		List<PmsPositions>listPmsPositions=organizationService.listPmsPositions2();
		model.addAttribute("listPmsPositions", listPmsPositions);
		PmsDeparts pmsDeparts=organizationService.getpmsDepartsById(pmsUsersProfile.getDepartid());
		model.addAttribute("pmsDeparts", pmsDeparts);
		PmsPositions pmsPositions=organizationService.getPmsPositionsById(pmsUsersProfile.getPositionid());
		model.addAttribute("pmsPositions", pmsPositions);
		return "edit_user_manage";
	}
	/**
	 * 
	 * description
	 * 得到所要改变的状态
	 * @author ChangZhiwei
	 * @time 2017年7月28日
	 */
	@RequestMapping("/userStates")
	public	void  userStates(int status,long id,HttpServletRequest req,HttpServletResponse resp){	
		try {
			int flag=organizationService.updatePms_Users(id,status);
			String name="";
			if(flag==1){
				name="{\"message\":\"状态修改成功\",\"code\":1}";
			}else{
				name="{\"message\":\"状态修改失败\",\"code\":0}";
			}
			resp.setContentType("text/html;charset=UTF-8");
			 PrintWriter pw = resp.getWriter();
			 pw.write(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * description
	 * 更改用户信息
	 * 得到所要改变的状态
	 * @author ChangZhiwei
	 * @time 2017年7月28日
	 */
	@RequestMapping("/updateUser")
	public void updateUser(PmsUsers pmsUsersPo,PmsUsersProfile pmsUsersProfilePo,HttpServletResponse resp){
			try{
				int flag=organizationService.updatePmsUser(pmsUsersPo, pmsUsersProfilePo);
				String name="";
				if(flag==0){
				 name="{\"message\":\"该用户名已存在\",\"code\":0}";
				}else{
					 name="{\"message\":\"修改成功\",\"code\":1}";
				}
				resp.setContentType("text/html;charset=UTF-8");
				 PrintWriter pw = resp.getWriter();
				 pw.write(name);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	/**
	 * description
	 * 查找用户信息
	 * @author ChangZhiwei
	 * @time 2017年7月28日
	 */
	@RequestMapping("/searchUser")
	public String searchUser(PmsUsers pmsUsersPo,Model model){
			List<PmsUserPms> listPmsUserPms=organizationService.searchUser(pmsUsersPo);
			model.addAttribute("listPmsUserPms", listPmsUserPms);
			int counter=listPmsUserPms.size();
			model.addAttribute("counter", counter);
		return "user_manage";
		
		
	}
	/**
	 * description
	 * 获取添加user需要的数据
	 * @author ChangZhiwei
	 * @time 2017年7月28日
	 */
	@RequestMapping("/addUserManage")
	public String addUserManage(Model model){
		List<PmsDeparts>  listPmsDeparts=organizationService.listPmsDeparts1();
		model.addAttribute("listPmsDeparts", listPmsDeparts);
		List<PmsPositions>listPmsPositions=organizationService.listPmsPositions1();
		model.addAttribute("listPmsPositions", listPmsPositions);
		return "add_user_manage";
	}
	/**
	 * description
	 * 添加user
	 * @author ChangZhiwei
	 * @time 2017年7月28日
	 */
	@RequestMapping("/addUser")
	public void addUser(PmsUsers pmsUsersPo,PmsUsersProfile pmsUsersProfilePo,HttpServletRequest req,HttpServletResponse resp){
		try{
		int flag=organizationService.addUserPmsUser(pmsUsersPo,pmsUsersProfilePo);
		String name="";
		if(flag==0){
		 name="{\"message\":\"该用户名已存在\",\"code\":0}";
		}else{
			 name="{\"message\":\"添加成功\",\"code\":1}";
		}
		resp.setContentType("text/html;charset=UTF-8");
		 PrintWriter pw = resp.getWriter();
		 pw.write(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 个人资料
	 * description
	 * @author ChangZhiwei
	 * @time 2017年7月29日
	 */
	@RequestMapping("/userIndex")
	public String userIndex(){
		return  "user_index";
	}
	/**
	 * description
	 * 判断新添加用户与修改用户是否与数据库重复
	 * @author ChangZhiwei
	 * @time 2017年7月30日
	 */
	@RequestMapping("/getUserName")
	public void getUserName(String username,long uid, HttpServletRequest req,HttpServletResponse resp) {
	try {
			int flag=organizationService.isUsername(username,uid);
			String name="";
			if(flag==1){
			 name="{\"message\":\"该用户名已存在\",\"code\":1}";
			}else{
				 name="{\"code\":0}";
			}
			resp.setContentType("text/html;charset=UTF-8");
			 PrintWriter pw = resp.getWriter();
			 pw.write(name);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
	}
	/**
	 * 便利职称列表
	 * description
	 * @author ChangZhiwei
	 * @time 2017年7月29日
	 */
	@RequestMapping("/positionManage")
	public String listPositionManage(Model model){
		List<PmsPositions>listPmsPositions=organizationService.listPmsPositions();
		int counter=listPmsPositions.size();
		model.addAttribute("listPmsPositions", listPmsPositions);
		model.addAttribute("counter", counter);
		return  "position_manage";
	}
	/**
	 * description
	 * 得到所要更改职位的信息
	 * @author ChangZhiwei
	 * @time 2017年7月30日
	 */
	@RequestMapping("/getPositionManageById")
	public String getPositionManageById(Long positionid,Model model) {
		PmsPositions pmsPositions=organizationService.getPmsPositionsById1(positionid);
		model.addAttribute("pmsPositions", pmsPositions);
		return "edit_position_manage";
	}
	/**
	 * description
	 * 更改职位得到信息
	 * @author ChangZhiwei
	 * @time 2017年7月30日
	 */
	@RequestMapping("/updatePosition")
	public void updatePosition(PmsPositions pmsPositions,HttpServletResponse resp) {
		try{
			int flag=organizationService.updatePosition(pmsPositions);
			String name="";
			if(flag==0){
			 name="{\"message\":\"该职称已存在\",\"code\":0}";
			}else{
				 name="{\"message\":\"修改成功\",\"code\":1}";
			}
			resp.setContentType("text/html;charset=UTF-8");
			 PrintWriter pw = resp.getWriter();
			 pw.write(name);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	/**
	 * description
	 * 判断职称与修改职称是否与数据库重复
	 * @author ChangZhiwei
	 * @time 2017年7月30日
	 */
	@RequestMapping("/getPositionname")
	public void getPositionname(String positionname,long pid,HttpServletRequest req,HttpServletResponse resp) {
		try {
			int flag=organizationService.isPositionname(positionname,pid);
			String name="";
			if(flag==1){
			 name="{\"message\":\"该职称名已存在\",\"code\":1}";
			}else{
				 name="{\"code\":0}";
			}
			resp.setContentType("text/html;charset=UTF-8");
			 PrintWriter pw = resp.getWriter();
			 pw.write(name);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	/**
	 * description
	 * 跳转到添加新职称
	 * @author ChangZhiwei
	 * @time 2017年7月30日
	 */
	@RequestMapping("/addPositionManage")
	public String addPositionManage() {
		organizationService.addPositionManage();
		return "add_position_manage";
	}
	/**
	 * description
	 * 添加新职称
	 * @author ChangZhiwei
	 * @time 2017年7月30日
	 */
	@RequestMapping("/addPosition")
	public void addPosition(PmsPositions pmsPositions,HttpServletResponse resp) {
		try{
			int flag=organizationService.addPosition(pmsPositions);
			String name="";
			if(flag==0){
			 name="{\"message\":\"该职称已存在\",\"code\":0}";
			}else{
				 name="{\"message\":\"添加成功\",\"code\":1}";
			}
			resp.setContentType("text/html;charset=UTF-8");
			 PrintWriter pw = resp.getWriter();
			 pw.write(name);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	/**
	 * description
	 * 搜索职位信息
	 * @author ChangZhiwei
	 * @time 2017年7月30日
	 */
	@RequestMapping("/searchPositionform")
	public String searchPositionform(PmsPositions pmsPositions,Model model) {
		List<PmsPositions> listPmsPositions=organizationService.searchPositionform(pmsPositions);
		model.addAttribute("listPmsPositions", listPmsPositions);
		int counter=listPmsPositions.size();
		model.addAttribute("counter", counter);
		return  "position_manage";
	}
	/**
	 * description
	 * 更改职位职位状态
	 * @author ChangZhiwei
	 * @time 2017年7月30日
	 */
	@RequestMapping("/positionStates")
	public void positionStates(int status,long id,HttpServletRequest req,
			HttpServletResponse resp) {
		try {
			int flag=organizationService.updateStatusPosition(id,status);
			String name="";
			if(flag==1){
				name="{\"message\":\"状态修改成功\",\"code\":1}";
			}else{
				name="{\"message\":\"状态修改失败\",\"code\":0}";
			}
			resp.setContentType("text/html;charset=UTF-8");
			 PrintWriter pw = resp.getWriter();
			 pw.write(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * description
	 * 便利权限列表
	 * @author ChangZhiwei
	 * @time 2017年7月30日
	 */
	@RequestMapping("/permissionManage{pageNum}")
	public String permissionManage(Model model,@RequestParam(required=true,defaultValue="1") Integer pageNum,@RequestParam(required=false,defaultValue="10") Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<PmsPermissions> listPermission=organizationService.listPermissionManage();
		int counter=listPermission.size();
		PageInfo<PmsPermissions> pageInfo = new PageInfo<PmsPermissions>(listPermission);
		List<PmsPermissions> listPermissionParent=organizationService.listPermissionParent();
		/*int pageSize=organizationService.pageSize(counter);
		model.addAttribute("pageSize", pageSize);*/
		model.addAttribute("listPermissionParent", listPermissionParent);
		model.addAttribute("listPermission", listPermission);
		model.addAttribute("counter", counter);
		model.addAttribute("pageInfo", pageInfo);
		return "permission_manage";
		
	}
	/**
	 * description
	 * 权限的删除
	 * @author ChangZhiwei
	 * @time 2017年7月31日
	 */
	@RequestMapping("/deletePermission")
	public void deletePermission(long ids,HttpServletRequest req,HttpServletResponse resp) {
		try {
			int flag=organizationService.deletePermission(ids);
			String name="";
			if(flag==1){
				name="{\"message\":\"权限删除成功\",\"code\":1}";
			}else{
				name="{\"message\":\"权限删除失败\",\"code\":0}";
			}
			resp.setContentType("text/html;charset=UTF-8");
			 PrintWriter pw = resp.getWriter();
			 pw.write(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * description的数据
	 * 获取编辑权限所需要的
	 * @author ChangZhiwei
	 * @time 2017年7月31日
	 */
	@RequestMapping("/editPermissionManage")
	public String editPermissionManage(long permissionid,Model model) {
		PmsPermissions pmsPermissions=organizationService.getEditPermissionManage(permissionid);
		model.addAttribute("pmsPermissions", pmsPermissions);
		List<PmsPermissions> listPermissionParent=organizationService.listPermissionParent();
		model.addAttribute("listPermissionParent", listPermissionParent);
		return "edit_permission_manage";
	
	}
	/**
	 * description
	 * 判断英文名是否重复
	 * @author ChangZhiwei
	 * @time 2017年8月2日
	 */
	@RequestMapping("/isPermissionName")
	public void isPermissionName(String ename,long ppid,HttpServletRequest req,HttpServletResponse resp) {
		
		try {
			int flag=organizationService.isPermissionName(ename,ppid);
			String name="";
			if(flag==1){
			 name="{\"message\":\"该ename已存在\",\"code\":1}";
			}else{
				 name="{\"code\":0}";
			}
			resp.setContentType("text/html;charset=UTF-8");
			 PrintWriter pw = resp.getWriter();
			 pw.write(name);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	/**
	 * description
	 * 搜索权限列表
	 * @author ChangZhiwei
	 * @time 2017年8月2日
	 */
	@RequestMapping("/searchPermission")
	public String searchPermission(PmsPermissions pmsPermissions,Model model) {
		List<PmsPermissions> listPermissionParent=organizationService.listPermissionParent();
		model.addAttribute("listPermissionParent", listPermissionParent);
		List<PmsPermissions> listPermission=organizationService.searchPermission(pmsPermissions);
		model.addAttribute("listPermission", listPermission);
		int counter=listPermission.size();
		model.addAttribute("counter", counter);
		return "permission_manage";
	}
	/**
	 * description
	 * 更改权限列表
	 * @author ChangZhiwei
	 * @time 2017年8月2日
	 */
	@RequestMapping("/updatePermission")
	public void updatePermission(PmsPermissions pmsPermissions,HttpServletResponse resp) {
		try{
			int flag=organizationService.updatePermission(pmsPermissions);
			String name="";
			if(flag==0){
			 name="{\"message\":\"该ename已存在\",\"code\":0}";
			}else{
				 name="{\"message\":\"修改成功\",\"code\":1}";
			}
			resp.setContentType("text/html;charset=UTF-8");
			 PrintWriter pw = resp.getWriter();
			 pw.write(name);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}
	/**
	 * description
	 * 跳转到添加权限
	 * @author ChangZhiwei
	 * @time 2017年8月2日
	 */
	@RequestMapping("/addPermissionManage")
	public String addPermissionManage(Model model) {
		List<PmsPermissions> listPermissionParent=organizationService.listPermissionParent1();
		model.addAttribute("listPermissionParent", listPermissionParent);
		return "add_permission_manage";
	}
	/**
	 * description
	 * 添加权限
	 * @author ChangZhiwei
	 * @time 2017年8月2日
	 */
	@RequestMapping("/addPermission")
	public void addPermission(PmsPermissions pmsPermissions,HttpServletResponse resp) {
		try{
			int flag=organizationService.addPermission(pmsPermissions);
			String name="";
			if(flag==0){
			 name="{\"message\":\"该ename已存在\",\"code\":0}";
			}else{
				 name="{\"message\":\"添加成功\",\"code\":1}";
			}
			resp.setContentType("text/html;charset=UTF-8");
			 PrintWriter pw = resp.getWriter();
			 pw.write(name);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * description:根据组ID获得组的全部成员
	 * @author liyanpeng
	 * @date 2017年8月3日
	 */
	@RequestMapping("getGroupUsers")
	public String getGroupUsers(long groupid,Model model) {
		List<PmsGroupsUser> listgroupsusers=organizationService.listPmsGroupUser(groupid);
		model.addAttribute("listgroupsusers",listgroupsusers);
		PmsGroups group=organizationService.getPmsGroupById(groupid);
		model.addAttribute("group",group);
		int count=listgroupsusers.size();
		model.addAttribute("count",count);
		return "group_user";
	}
	
	/**
	 * description:
	 * @author liyanpeng
	 * @date 2017年8月5日
	 */
	@RequestMapping("toAddGroupUser")
	public String toAddGroupUser(long groupid,Model model) {
		PmsGroups group=organizationService.getPmsGroupById(groupid);
		model.addAttribute("group",group);
		long id=organizationService.toAddGroupUser();
		model.addAttribute("id",id);
		return "add_group_user";
	}
	/**
	 * description:
	 * @author liyanpeng
	 * @date 2017年8月5日
	 */
	@RequestMapping("addGroupsUser")
	public void addGroupsUser(String username,long id,long groupid,HttpServletResponse response) {
		String jsondata="";
		int flag=organizationService.addGroupUser(username,id,groupid);
		switch (flag) {
		case 1:
			jsondata="{\"message\":\"添加成员成功\",\"code\":1}";
			break;
		case 0:
			jsondata="{\"message\":\"添加成员失败\",\"code\":0}";
			break;
		case -1:
			jsondata="{\"message\":\"此员工不存在，请检查后提交\",\"code\":0}";
			break;
		case -2:
			jsondata="{\"message\":\"此员工已是组内成员,不能重复提交\",\"code\":0}";
			break;
		}
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(jsondata);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * description:
	 * @author liyanpeng
	 * @date 2017年8月5日
	 */
	@RequestMapping("listusername")
	public void listusername(String username,HttpServletResponse response) {
		List<PmsUserPms> listuser=organizationService.listUsername();
		List<PmsUsersname> data=new ArrayList<>();
		for(PmsUserPms user:listuser){
			if(user.getPmsUsers().getUsername().contains(username)||user.getPmsUsersProfile().getRealname().contains(username)){
				data.add(new PmsUsersname(user.getPmsUsers().getUserid(),
				user.getPmsUsers().getUsername(),user.getPmsUsersProfile().getRealname()));
			}
		}
		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(JSONArray.toJSONString(data));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * description:删除组成员
	 * @author liyanpeng
	 * @date 2017年8月5日
	 */
	@RequestMapping("deleteGroupUser")
	public void deleteGroupUser(long id,HttpServletResponse response) {
		int flag=organizationService.deleteGroupUser(id);
		String jsondata="";
		if(flag==1)
			jsondata="{\"message\":\"删除组成员成功\",\"code\":1}";
		else
			jsondata="{\"message\":\"删除组成员失败\",\"code\":0}";
		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(jsondata);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

