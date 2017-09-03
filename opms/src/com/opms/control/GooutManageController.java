package com.opms.control;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.opms.entity.PmsGoouts;
import com.opms.entity.PmsUsers;
import com.opms.service.GooutService;
import com.opms.unti.RandomTest;
import com.opms.unti.TimeDate;

@Controller
public class GooutManageController {
	@Autowired
	private GooutService gooutService;
     //跳转外出管理界面
	@RequestMapping("gooutmanage")
	public String gooutManage(HttpServletRequest request,Model model) throws ParseException{
		PmsUsers user=(PmsUsers)request.getSession().getAttribute("user");
		long userid=user.getUserid();
		List<PmsGoouts> pmsGoouts=gooutService.listGooutmanage(userid);
		for (PmsGoouts pmsGoout : pmsGoouts) {
			pmsGoout.setStarted(new TimeDate().changeDate(pmsGoout.getStarted()));
			pmsGoout.setEnded(new TimeDate().changeDate(pmsGoout.getEnded()));
		}
		model.addAttribute("listGoout", pmsGoouts);
		return "goout_manage";
	}

	//跳转添加外出申请信息
	@RequestMapping("addgooutmanage")
	public String goAddGooutManage(){
		return "add_goout_manage";
	}
	
	//添加外出申请信息
	@RequestMapping("insertgooutmanage")
	public String insertGooutmanage(PmsGoouts pmsGoouts){
		pmsGoouts.setGooutid(new RandomTest().random());
		pmsGoouts.setCreated(new java.sql.Timestamp(new java.util.Date().getTime()));
		gooutService.insertGooutmanage(pmsGoouts);
		
		return "redirect:gooutmanage";
	}
	//按条件搜索外出信息
	@RequestMapping("searchgooutinfo")
	public String searchGooutInfo(HttpServletRequest request,Model model,PmsGoouts pmsGoouts) throws ParseException{
		PmsUsers user=(PmsUsers)request.getSession().getAttribute("user");
        pmsGoouts.setUserid(user.getUserid());
		List<PmsGoouts> list=gooutService.listSearchGooutManage(pmsGoouts);
		for (PmsGoouts pmsGoout : list) {
			pmsGoout.setStarted(new TimeDate().changeDate(pmsGoout.getStarted()));
			pmsGoout.setEnded(new TimeDate().changeDate(pmsGoout.getEnded()));
		}
		model.addAttribute("listGoout", list);
		return "goout_manage";
	}
	//跳转修改外出信息
	@RequestMapping("editgooutmanage")
	public String goEditGoout(Model model,Long gooutid) throws ParseException{
		PmsGoouts pmsGoouts= gooutService.getGooutInfo(gooutid);
		pmsGoouts.setStarted(new TimeDate().changeDate(pmsGoouts.getStarted()));
		pmsGoouts.setEnded(new TimeDate().changeDate(pmsGoouts.getEnded()));
		model.addAttribute("editgoout",pmsGoouts);
		return "edit_goout_manage";
	}
	//修改外出信息
	@RequestMapping("updategooutinfo")
	public String updateGooutInfo(PmsGoouts pmsGoouts){
		pmsGoouts.setChanged(new java.sql.Timestamp(new java.util.Date().getTime()));
		gooutService.updateGooutInfo(pmsGoouts);
		return "redirect:gooutmanage";
	}
	//删除外出信息
	@RequestMapping("deletegooutinfo")
	public String deleteGooutInfo(Long gooutid){
		gooutService.deleteGooutInfo(gooutid);
		return "redirect:gooutmanage";
	}
	//修改外出事件状态为正常
	@RequestMapping("updategooutstatus")
	public String updategooutstatus(Long gooutid){
		gooutService.uodateGooutStatus(gooutid);
		return "redirect:gooutmanage";
	}
	//查看外出事件详情
	@RequestMapping("gooutdetail")
	public  String goGooutDetail(Model model,Long gooutid){
		model.addAttribute("gooutdetil", gooutService.getGooutInfo(gooutid));
		return "goout_detail";
	}
}
