package com.opms.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.session.Session;
import org.apache.shiro.web.session.HttpServletSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opms.entity.PmsBusinesstrips;
import com.opms.entity.PmsExpenses;
import com.opms.entity.PmsUsers;
import com.opms.service.BusinesstripService;
import com.opms.unti.RandomTest;

@Controller
public class BusinesstripManageControl {

	@Autowired
	private BusinesstripService businesstripService;
	//查询所有出差事件
		@RequestMapping("businesstripmanage")
		public String listBusinesstripInfo(HttpServletRequest request,Model model){
			HttpSession session=request.getSession();
			PmsUsers user=(PmsUsers)session.getAttribute("user");
			long userid=user.getUserid();
		  model.addAttribute("listBusinesstrip", businesstripService.listBusinesstripInfo(userid));
			return "businesstrip_manage";
		}
		
	//跳转添加出差事件
	@RequestMapping("addbusinesstripmanage")	
	public String goAddBusinesstrip(){
		return "add_businesstrip_manage";
	}
	//添加出差事件
	@RequestMapping("insertbusinesstripinfo")
	public void insertBusinesstripInfo(HttpServletRequest request,HttpServletResponse response,String jsondata) throws IOException{
		PmsBusinesstrips pmsBusinesstrips=(PmsBusinesstrips)JSONObject.parseObject(jsondata, PmsBusinesstrips.class);
		HttpSession session=request.getSession();
		PmsUsers user=(PmsUsers)session.getAttribute("user");
		pmsBusinesstrips.setUserid(user.getUserid());
		pmsBusinesstrips.setDestinations(pmsBusinesstrips.getDestinations().substring(0,pmsBusinesstrips.getDestinations().length()-1));
		pmsBusinesstrips.setStarteds(pmsBusinesstrips.getStarteds().substring(0, pmsBusinesstrips.getStarteds().length()-1));
		pmsBusinesstrips.setEndeds(pmsBusinesstrips.getEndeds().substring(0,pmsBusinesstrips.getEndeds().length()-1));
		pmsBusinesstrips.setBusinesstripid(new RandomTest().random());
		pmsBusinesstrips.setCreated(new java.sql.Timestamp(new java.util.Date().getTime()));
		int flag=businesstripService.insertBusinesstripInfo(pmsBusinesstrips);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (flag == 1) {
				out.write(JSONArray.toJSONString("添加成功！"));
			} else if (flag == 0) {
				out.write(JSONArray.toJSONString("添加成功！"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
	//跳转编辑出差信息页面
	@RequestMapping("editbusinesstripmanage")
	public String goEditBusinesstrip(Model model,Long businesstripid){
		model.addAttribute("EBusinesstrip", businesstripService.getBusinesstripInfo(businesstripid));
		return "edit_businesstrip_manage";
	}
	//修改更新出差信息
	@RequestMapping("updatebusinesstripinfo")
	public void updateBusinesstripInfo(HttpServletRequest request,HttpServletResponse response,String jsondata) throws IOException{
		PmsBusinesstrips pmsBusinesstrips=(PmsBusinesstrips)JSONObject.parseObject(jsondata, PmsBusinesstrips.class);
		pmsBusinesstrips.setChanged(new java.sql.Timestamp(new java.util.Date().getTime()));
		pmsBusinesstrips.setDestinations(pmsBusinesstrips.getDestinations().substring(0,pmsBusinesstrips.getDestinations().length()-1));
		pmsBusinesstrips.setStarteds(pmsBusinesstrips.getStarteds().substring(0, pmsBusinesstrips.getStarteds().length()-1));
		pmsBusinesstrips.setEndeds(pmsBusinesstrips.getEndeds().substring(0,pmsBusinesstrips.getEndeds().length()-1));
		int flag=businesstripService.updateBusinesstripInfo(pmsBusinesstrips);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (flag == 1) {
				out.write(JSONArray.toJSONString("添加成功！"));
			} else if (flag == 0) {
				out.write(JSONArray.toJSONString("添加成功！"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
		//按条件查找出差信息
	   @RequestMapping("searchbusinesstrip")
	   public String  listSearchBusinesstrip(HttpServletRequest request,Model model,PmsBusinesstrips pmsBusinesstrips){
		   PmsUsers user=(PmsUsers)request.getSession().getAttribute("user");
		   pmsBusinesstrips.setUserid(user.getUserid());
		   model.addAttribute("listBusinesstrip", businesstripService.listSearchBusinesstrip(pmsBusinesstrips));
		   return "businesstrip_manage";
	 
	   }
	//更改出差信息状态
	   @RequestMapping("updatebusinesstripstatus")
	public String updatebusinesstripstatus(Long businesstripid){
		   businesstripService.updateBusinesstripStatus(businesstripid);
		   return "redirect:businesstripmanage";
	   }
	   //删除出差信息
	   @RequestMapping("deletebusinesstripinfo")
	   public String deletebusinesstripinfo(Long businesstripid){
		   businesstripService.deleteBusinesstrip(businesstripid);
		   return "redirect:businesstripmanage"; 
	   }
	   //跳转待审批，查询待审批出差信息
	   @RequestMapping("approvalbusinesstrip")
	   public String approvalBusinesstrip(HttpServletRequest request,Model model){
		   PmsBusinesstrips pmsBusinesstrips=new PmsBusinesstrips();
		   PmsUsers user=(PmsUsers)request.getSession().getAttribute("user");
		   long userid=user.getUserid();
		   model.addAttribute("approvalbusinesstrip", businesstripService.listApprovalBusinesstrip(userid));
		   return "approval_businesstrip";
	   }
	
	}
	
	

