package com.opms.control;

import java.security.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.opms.entity.PmsOvertimes;
import com.opms.entity.PmsUsers;
import com.opms.service.LeaveService;
import com.opms.service.OvertimeService;
import com.opms.unti.RandomTest;
import com.opms.unti.StringDate;
import com.opms.unti.TimeDate;

/**
 * 
 * @title
 * @author xukang
 * @date 2017年7月30日上午11:37:51
 *
 */
@Controller
public class OvertimeManageController {

	@Autowired
	private OvertimeService overtimeService;

	// 处理提交有时间字符串的值
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor dateEditor = new CustomDateEditor(fmt, true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	// 获取所有加班信息
	@RequestMapping(value = "overtimemanage")
	public String listLeaves(Model mod,HttpServletRequest request) throws ParseException {
		// date = java.sql.Date.valueOf(str);
		PmsUsers user=(PmsUsers)request.getSession().getAttribute("user");
		PmsOvertimes pmsOvertimes=new PmsOvertimes();
		pmsOvertimes.setUserid(user.getUserid());
		List<PmsOvertimes> listOvertime = new ArrayList<PmsOvertimes>();
		for (PmsOvertimes poTimes : overtimeService.listOvertimeInfo(pmsOvertimes)) {
			poTimes.setStarted(new TimeDate().changeDate(poTimes.getStarted()));
			poTimes.setEnded(new TimeDate().changeDate(poTimes.getEnded()));
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			// Date date = sdf.parse(poTimes.getStarted());
			// poTimes.setStarted((new SimpleDateFormat("yyyy-MM-dd
			// HH:mm")).format(date));
			// date = sdf.parse(poTimes.getEnded());
			// poTimes.setEnded((new SimpleDateFormat("yyyy-MM-dd
			// HH:mm")).format(date));
			listOvertime.add(poTimes);
		}
		mod.addAttribute("listOvertime", listOvertime);
		return "overtime_manage";
	}

	// 查看加班详情
	@RequestMapping("overtimedetail")
	public String getOvertimeInfo(Model mod, long overtimeid) throws ParseException {
		PmsOvertimes pmsovertime = overtimeService.getOvertimeInfo(overtimeid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = sdf.parse(pmsovertime.getStarted());
		pmsovertime.setStarted((new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(date));
		date = sdf.parse(pmsovertime.getEnded());
		pmsovertime.setEnded((new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(date));

		mod.addAttribute("oneOvertime", pmsovertime);
		return "overtime_detail";
	}

	// 跳转添加加班信息
	@RequestMapping("addovertimemanage")
	public String goAddOvertimeManage() {
		return "add_overtime_manage";
	}

	// 添加加班信息
	@RequestMapping("addOvertime")
	public String insertOvertimeInfo(PmsOvertimes pmsOvertimes) throws ParseException {

		pmsOvertimes.setOvertimeid(new RandomTest().random());
		
		pmsOvertimes.setCreated(new java.sql.Timestamp(new java.util.Date().getTime()));
		pmsOvertimes.setStarted(new TimeDate().changeDate(pmsOvertimes.getStarted()));
		pmsOvertimes.setEnded(new TimeDate().changeDate(pmsOvertimes.getEnded()));
		pmsOvertimes.setStatus(1);

		overtimeService.insertOvertimeInfo(pmsOvertimes);
		return "redirect:overtimemanage";
	}

	// 修改加班信息状态为正常
	@RequestMapping("updateOvertimeStatus")
	public String updateOvertimeStatus(Long overtimeid) {
		overtimeService.updateStatusInfo(overtimeid);
		return "redirect:overtimemanage";
	}

	// 搜索加班信息
	@RequestMapping("searchOvertimeInfo")
	public String searchOvertimeInfo(Model mod, PmsOvertimes pmsOvertimes,HttpSession session) throws ParseException {
		PmsUsers user=(PmsUsers)session.getAttribute("user");
		pmsOvertimes.setUserid(user.getUserid());
		List<PmsOvertimes> listOvertime = overtimeService.searchOvertimeInfo(pmsOvertimes);
		if (listOvertime != null) {
			for (PmsOvertimes poTimes :listOvertime) {
				poTimes.setStarted(new TimeDate().changeDate(poTimes.getStarted()));
				poTimes.setEnded(new TimeDate().changeDate(poTimes.getEnded()));
				listOvertime.add(poTimes);
			}
		}
		mod.addAttribute("listOvertime", overtimeService.searchOvertimeInfo(pmsOvertimes));
		return "overtime_manage";
	}

	// 获取未审核加班信息
	@RequestMapping("approvalovertime")
	public String goApprovalOvertime(Model mod) {
		mod.addAttribute("listApproverOvertime", overtimeService.listUnApprovalOvertime());
		return "approval_overtime";
	}

	// 删除加班信息
	@RequestMapping("deleteOvertimeInfo")
	public String deleteOvertimeInfo(Long overtimeid) {
		overtimeService.deleteOvertimeInfo(overtimeid);
		return "redirect:overtimemanage";
	}

	// 跳转修改加班信息页面
	@RequestMapping("editovertimemanage")
	public String goEditOvertimeManage(Model mod, Long overtimeid) throws ParseException {
		PmsOvertimes pmsOvertimes = overtimeService.getOvertimeInfo(overtimeid);
		pmsOvertimes.setStarted(new TimeDate().changeDate(pmsOvertimes.getStarted()));
		pmsOvertimes.setEnded(new TimeDate().changeDate(pmsOvertimes.getEnded()));
		mod.addAttribute("oneOvertime", pmsOvertimes);
		return "edit_overtime_manage";
	}

	// 修改加班信息
	@RequestMapping("updateOvertimeInfo")
	public String updateOvertimeInfo(HttpServletRequest request, PmsOvertimes pmsOvertimes) {
		pmsOvertimes.setStatus(1);
		pmsOvertimes.setChanged(new java.sql.Timestamp(new java.util.Date().getTime()));
		int flag = overtimeService.updateOvertime(pmsOvertimes);
		// if (flag==0) {
		// request.setAttribute("updateOvertimemassage", "修改失败请重新再试");
		// return "edit_overtime_manage";
		// }
		return "redirect:overtimemanage";
	}

}
