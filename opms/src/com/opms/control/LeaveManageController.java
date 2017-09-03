package com.opms.control;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSONArray;
import com.opms.entity.PmsLeaves;
import com.opms.entity.PmsUsers;
import com.opms.service.LeaveService;
import com.opms.unti.IntDate;
import com.opms.unti.RandomTest;
import com.opms.unti.StringDate;
import com.opms.unti.TimeDate;


@Controller
public class LeaveManageController {

	@Autowired
	private LeaveService leaveservice;
	
	@RequestMapping("approvalindex")
	public String goApprovalIndex(){
		return "approval_index";
	}
	
	
    //查询所有请假记录
	@RequestMapping("leavemanage")
	public String listLeaves(Model mod,HttpServletRequest request ) {
		PmsUsers user=(PmsUsers)request.getSession().getAttribute("user");
		PmsLeaves pmsLeaves=new PmsLeaves();
		pmsLeaves.setUserid(user.getUserid());
		mod.addAttribute("listleave", leaveservice.listLeave(pmsLeaves));
		return "leave_manage";

	}
	
	
	

	
	//跳转添加请假信息页面
	@RequestMapping("goaddleavemanage")
	public String  goaddleave() {	
		return "add_leave_manage";
	}
	
	/**
	 * 
	 * description 添加请假信息
	 * @author xukang
	 * @throws UnsupportedEncodingException 
	 * @time 2017年7月28日
	 */
	@RequestMapping("addleave")	   
	public String  insertLeaveInfo(PmsLeaves pmsLeaves) {
		pmsLeaves.setStatus(1) ;
		pmsLeaves.setLeaveid(new RandomTest().random());
	//	java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
//		System.out.println(new StringDate().getNowStringDate());
//		Date currentDate=Date.valueOf(new StringDate().getNowStringDate());
		pmsLeaves.setCreated(new java.sql.Timestamp(new java.util.Date().getTime()));
	  leaveservice.insertLeave(pmsLeaves);
	return "redirect:leavemanage";
	}
	//图片上传查看
	@RequestMapping("uploadPicture")
	public void uploadPicture(String image,HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		String path = request.getServletContext().getRealPath("/");	
			java.io.FileInputStream fis = new java.io.FileInputStream(image);
			String jpgpath="uploadFile/"+new RandomTest().random()+".jpg";
			java.io.FileOutputStream fos = new java.io.FileOutputStream(path+jpgpath);
			int t= 0;
			while((t = fis.read())!= -1){
				fos.write(t);
			}
			fos.close();
			fis.close();
			response.getWriter().write(JSONArray.toJSONString(jpgpath));
		
	
		}
	
	
	
	
	//跳转编辑请假信息
	@RequestMapping("editleavemanage")
	public String goEditLeave(Long leaveid,Model mod){	
		
		mod.addAttribute("editleave", leaveservice.getleaveInfo(leaveid));
		return "edit_leave_manage";
	}
	
	//提交修改请假信息
	@RequestMapping("updateLeaveInfo")
	public String updateLeaveInfo(PmsLeaves pmsleaves){	
		pmsleaves.setCreated(new java.sql.Timestamp(new java.util.Date().getTime()));
		leaveservice.updateLeaveInfo(pmsleaves);
		return "redirect:leavemanage";
	}
	//搜索请假信息
	@RequestMapping("searchLeaveInfo")
	public String selectLeaveInfo(Model mod,PmsLeaves pmsLeaves,HttpSession session){	
		PmsUsers user=(PmsUsers)session.getAttribute("user");
		pmsLeaves.setUserid(user.getUserid());
		mod.addAttribute("listleave", leaveservice.listSearchLeave(pmsLeaves));
		return "leave_manage";
	}
	
	//获取未审批案件信息并且跳转待审批界面
	@RequestMapping("approvalleave")
	public String goapprovalleave(Model mod){
		//int result=1;//1:未审批，2：已审批   null：等待中
		PmsLeaves pmsLeaves=new PmsLeaves();
		pmsLeaves.setStatus(2);//1:草稿  2：正常
		//pmsLeaves.setResult();
		//mod.addAttribute("listUnApproval", leaveservice.getApprovalLeave(pmsLeaves));
		return "approval_leave";
	}
	
	//删除请假信息
	@RequestMapping("deleteLeave")
	public String deleteLeaveInfo(Long leaveid){
		leaveservice.deleteLeave(leaveid);
		return "redirect:leavemanage";
	}
//修改请假状态
	@RequestMapping("updateLeaveStatus")
	public String updateStatusInfo(Long leaveid){
		leaveservice.updateStatus(leaveid);
		return "redirect:leavemanage";
	}
//查看请假信息详情
	@RequestMapping("leavedetail")
	public String  getLeaveDetail(Model mod, Long leaveid){
	 mod.addAttribute("leavedetail",leaveservice.getLeaveDetail( leaveid));
		
	 return "leave_detail";
	}
	
	/*@RequestMapping("add_oagood_manage")
    public String add_oagood_manager()
    {   
    	return "add_oagood_manage";
    }*/
	
}
