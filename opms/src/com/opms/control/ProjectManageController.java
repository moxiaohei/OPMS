package com.opms.control;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.opms.entity.NeedSearch;
import com.opms.entity.PmsProjects;
import com.opms.entity.PmsProjectsDoc;
import com.opms.entity.PmsProjectsNeeds;
import com.opms.entity.PmsProjectsTask;
import com.opms.entity.PmsProjectsTeam;
import com.opms.entity.PmsProjectsTest;
import com.opms.entity.PmsProjectsVersion;
import com.opms.entity.PmsResumes;
import com.opms.entity.PmsUsers;
import com.opms.entity.TaskSearch;
import com.opms.service.ProjectService;
import com.opms.service.impl.ProjectServiceImpl;
import com.opms.unti.IntDate;
import com.opms.unti.ProjectNeed;
import com.opms.unti.TimeDate;

@Controller
public class ProjectManageController {
	@Autowired
	private ProjectService projectService;

	private static Long projectId;
	/**
	 * description 
	 * 
	 *  检查项目名称是否重命名
	 * @author xukang
	 * @throws UnsupportedEncodingException 
	 * @time 2017年8月7日
	 */
	@RequestMapping("/CheckedProjectname")
	public void CheckedProjectname(String projectname,HttpServletResponse resp) throws UnsupportedEncodingException{
		projectname=new String(projectname.getBytes("ISO-8859-1"),"utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter writer=null;
		String str=null;
		try {
			writer = resp.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		if(projectService.checkedProjectname(projectname)==1){
			str="1";
		 }else{
			 str="0";
		 }
		 String string = JSON.toJSONString(str);
		 writer.write(string);
	}
	/**
	 * <p>Description:
	 *   检索项目
	 * </p>
	 * @author quanhuan
	 * @time  2017年8月5日下午9:05:06
	 */
	@RequestMapping("/searchProject")
	public String searchProject(Model model,PmsProjects pmsProjects){
		List<PmsProjects> list = projectService.searchProject(pmsProjects);
		model.addAttribute("listProject", list);
		model.addAttribute("count", list.size());
		return "project_manage";
	}
	
	
	// 获取所有的项目信息
	@RequestMapping("/listProjectInfo")
	public String listProjectInfo(Model model) {
		List<PmsProjects> list = projectService.listPmsProjects();
		model.addAttribute("listProject",list);
		model.addAttribute("count", list.size());
		return "project_manage";
	}

	/**
	 * <p>
	 * Description: 获取一条编辑项目的信息
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年7月28日上午10:44:08
	 */
	@RequestMapping("/getEditProjectInfo")
	public String getEditProjectInfo(Model model, Long projectid) {
		model.addAttribute("project", projectService.getPmsProjects(projectid));
		List<PmsProjectsTeam> teamMesg = projectService.listTeamMesg(projectid);
		model.addAttribute("teamMesg", teamMesg);
		return "edit_project_manage";
	}
	
	/**
	 * <p>
	 * Description: 获取一条项目的信息
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年7月30日下午4:05:10
	 */
	@RequestMapping("/getProjectInfo")
	public String getProjectInfo(Model model, Long projectid,HttpSession session) {
		session.setAttribute("projectid", projectid);
		model.addAttribute("project", projectService.getPmsProjects(projectid));
		return "project_detail";
	}

	/**
	 * description:获取团队成员
	 * 
	 * @author hulingtao
	 * @time 2017年7月28日
	 */
	@RequestMapping("/listTeamMesg")
	public String ListTeamMesg(Long projectid, HttpServletRequest req) {
		projectId = projectid;
		List<PmsProjectsTeam> listTeamMesg = projectService
				.listTeamMesg(projectid);
		req.setAttribute("listTeamMesg", listTeamMesg);
		req.setAttribute("projectid", projectid);
		return "project_team";
	}

	/**
	 * description:删除团队成员
	 *
	 * @author hulingtao
	 * @time 2017年7月28日
	 */
	@RequestMapping("deleteMember{userid}")
	public String deleteMember(@PathVariable Long userid, HttpServletRequest req) {
		projectService.deleteMember(userid);
		Long projectid = projectId;
		return "redirect:/listTeamMesg?projectid=" + projectid;
	}

	/**
	 * description:添加团队成员
	 *
	 * @author hulingtao
	 * @time 2017年7月28日
	 */
	@RequestMapping("/toAddTeam")
	public String toAddTeam() {
		return "add_project_team";
	}

	/**
	 *description:联想查询用户
	 *@author hulingtao
	 *@time 2017年8月5日 
	 */
	/*@RequestMapping("/searchUsername")
	public void searchUsername(String username,HttpServletResponse response){
		List<PmsUserPms> listuser=organizationService.listPmsUsersProfile();
		List<PmsUsersname> data=new ArrayList<>();
		for(PmsUserPms user:listuser){
			if(user.getPmsUsers().getUsername().contains(username)||user.getPmsUsersProfile().getRealname().contains(username)){
				data.add(new PmsUsersProfile(user.getPmsUsers().getUserid(),
				user.getPmsUsers().getUsername(),user.getPmsUsersProfile().getRealname()));
			}
		}
		try {
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(JSONArray.toJSONString(data));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
	/**
	 * description:跳转到团队需求页面
	 *
	 * @author hulingtao
	 * @time 2017年7月28日
	 */
	@RequestMapping("/toProjectNeed")
	public String toProjectNeed(Long projectid, HttpServletRequest req) {
		projectId = projectid;
		List<PmsProjectsNeeds> listProjectNeed = projectService
				.listProjectNeed(projectid);
		List<PmsProjectsTeam> listTeamMesg = projectService
				.listTeamMesg(projectid);
		req.setAttribute("listProjectNeed", listProjectNeed);
		req.setAttribute("listTeamMesg", listTeamMesg);
		req.setAttribute("projectid", projectid);
		return "project_need";
	}

	/**
	 * description:跳转到修改需求页面
	 *
	 * @author hulingtao
	 * @time 2017年7月28日
	 */
	@RequestMapping("/toChangeNeed{needsid}")
	public String toChangeNeed(@PathVariable Long needsid,
			HttpServletRequest req) {
		PmsProjectsNeeds projectNeed = projectService.getProjectNeed(needsid);
		List<PmsProjectsTeam> listTeamMesg = projectService
				.listTeamMesg(projectId);
		req.setAttribute("projectNeed", projectNeed);
		req.setAttribute("listTeamMesg", listTeamMesg);
		return "edit_project_need";
	}

	/**
	 * description:更新项目需求
	 *
	 * @author hulingtao
	 * @time 2017年7月30日
	 */
	@RequestMapping("/updateNeed")
	public String updateNeed(PmsProjectsNeeds needs, HttpServletRequest request) {
		Long projectid = needs.getProjectid();
		if (projectid == null) {
			return "error.jsp";
		}
		// 将当前上下文初始化给 CommonsMutipartResolver （多部分解析器）
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getServletContext());
		// 检查form中是否有enctype="multipart/form-data"
		if (multipartResolver.isMultipart(request)) {
			// 将request变成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 获取multiRequest 中所有的文件名
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 一次遍历所有文件
				MultipartFile file = multiRequest.getFile(iter.next()
						.toString());
				if (file != null) {
					String path = request.getServletContext().getRealPath("\\needFile")+"\\"+file.getOriginalFilename();
					needs.setAttachment(path);
					// 上传
					try {
						file.transferTo(new File(path));
						needs.setStatus(1);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}
		needs.setChanged(new Date());
		projectService.updateNeed(needs);
		return "redirect:/toProjectNeed?projectid=" + projectid;
	}
	/**
	 *description:跳转添加需求界面
	 *@author hulingtao
	 *@time 2017年7月30日 
	 */
	@RequestMapping("/toAddNeed")
	public String toAddNeed(HttpServletRequest req){
		List<PmsProjectsTeam> listTeamMesg = projectService
				.listTeamMesg(projectId);
		req.setAttribute("listTeamMesg", listTeamMesg);
		return "add_project_need";
	}
	/**
	 *description:添加需求
	 *@author hulingtao
	 *@time 2017年7月30日 
	 */
	@RequestMapping("/insertNeed")
	public String insertNeed(PmsProjectsNeeds needs,HttpServletRequest request){
		Long projectid = projectId;
		if (projectid == null) {
			return "error";
		}
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getServletContext());
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next()
						.toString());
				if (file != null) {
					String path = request.getServletContext().getRealPath("\\needFile")+"\\"+file.getOriginalFilename();
					try {
						file.transferTo(new File(path));
						needs.setAttachment(path);
						needs.setStatus(1);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}
		needs.setProjectid(projectid);
		needs.setNeedsid(new TimeDate().getTimeStampLongDate());
		PmsUsers user = (PmsUsers)request.getSession().getAttribute("user");
		needs.setUserid(user.getUserid());
		needs.setCreated(new Date());
		needs.setChanged(new Date());
		
		projectService.insertNeed(needs);
		return "redirect:/toProjectNeed?projectid=" + projectid;
	}
	/**
	 *description:根据条件查询需求列表
	 *@author hulingtao
	 *@time 2017年7月30日 
	 */
	@RequestMapping("/searchNeed")
	public String searchNeed(NeedSearch search,HttpServletRequest req){
		Long projectid = projectId;
		/*if(search.getAcceptid()==null&&search.getKeywords()==null
				&&search.getStage()==null&&search.getStatus()==null){
			System.out.println("123");
			return "redirect:/toProjectNeed?projectid="+projectid;
		}*/
		if(search.getKeywords().equals("")){
			search.setKeywords(null);
		}
		search.setProjectid(projectid);
		List<PmsProjectsNeeds> searchNeed = projectService.searchNeed(search);
		List<PmsProjectsTeam> listTeamMesg = projectService
				.listTeamMesg(projectid);
		req.setAttribute("listTeamMesg", listTeamMesg);
		req.setAttribute("listProjectNeed", searchNeed);
		req.setAttribute("projectid", projectid);
		return "project_need";
	}
	/**
	 *description:跳转到需求详情
	 *@author hulingtao
	 *@time 2017年7月31日 
	 */
	@RequestMapping("/toNeedDetail{needsid}")
	public String toNeedDetail(@PathVariable Long needsid,HttpServletRequest req){
		PmsProjectsNeeds projectNeed = projectService.getProjectNeed(needsid);
		Map<Integer, String> statusMap  = new HashMap<Integer,String>();
		for(int i = 0;i<5;i++){
			statusMap.put(i+1, new ProjectNeed().getStatus(i+1));
		}
		req.setAttribute("projectNeed", projectNeed);
		req.setAttribute("statusMap", statusMap);
		return "project_need_detail";
	}
	/**
	 *description:更新项目需求状态
	 *@author hulingtao
	 *@time 2017年8月2日 
	 */
	@RequestMapping("/updateNeedStatus")
	public void updateNeedStatus(int status,long id,HttpServletResponse resp){
		PmsProjectsNeeds need = new PmsProjectsNeeds();
		need.setNeedsid(id);
		need.setStatus(status);
		int updateStatus = projectService.updateStatus(need);
		String jsonData = "";
		if(updateStatus == 1){
			jsonData = "{\"message\":\"更新状态成功\",\"code\":1}";
		}else{
			jsonData = "{\"message\":\"更新状态失败\",\"code\":0}";
		}
		resp.setContentType("text/html;charset=utf-8");
		try {
			resp.getWriter().write(jsonData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 *description:跳转到任务界面
	 *@author hulingtao
	 *@time 2017年8月2日 
	 */
	@RequestMapping("/toProjectTask")
	public String toProjectTask(Long projectid,HttpServletRequest req){
		projectId = projectid;
		List<PmsProjectsTeam> listTeamMesg = projectService
				.listTeamMesg(projectid);
		req.setAttribute("listTeamMesg", listTeamMesg);
		List<PmsProjectsTask> listProjectTask = projectService.listProjectTask(projectid);
		req.setAttribute("listProjectTask", listProjectTask);
		List<PmsProjectsNeeds> listProjectNeed = projectService.listProjectNeed(projectid);
		req.setAttribute("listProjectNeed", listProjectNeed);
		req.setAttribute("projectid", projectid);
		return "project_task";
	}
	/**
	 *description:跳转到任务详情界面
	 *@author hulingtao
	 *@time 2017年8月2日 
	 */
	@RequestMapping("/toTaskDetail{taskid}")
	public String toTaskDetail(@PathVariable Long taskid,HttpServletRequest req){
		PmsProjectsTask task = projectService.getTask(taskid);
		req.setAttribute("task", task);
		return "project_task_detail";
	}
	/**
	 *description:跳转到修改需求页面
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@RequestMapping("/toEditTask{taskid}")
	public String toEditTask(@PathVariable Long taskid,HttpServletRequest req){
		List<PmsProjectsNeeds> listProjectNeed = projectService.listProjectNeed(projectId);
		PmsProjectsTask task = projectService.getTask(taskid);
		List<PmsProjectsTeam> listTeamMesg = projectService.listTeamMesg(projectId);
		req.setAttribute("listProjectNeed", listProjectNeed);
		req.setAttribute("task", task);
		req.setAttribute("listTeamMesg", listTeamMesg);
		return "edit_project_task";
	}
	
	/**
	 *description:更新任务
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@RequestMapping("/updateTask")
	public String updateTask(PmsProjectsTask task,HttpServletRequest request){
		Long projectid = projectId;
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getServletContext());
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next()
						.toString());
				if (file != null) {
					String path = request.getServletContext().getRealPath("\\taskFile")+"\\"+file.getOriginalFilename();
					try {
						file.transferTo(new File(path));
						task.setAttachment(path);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return "redirect:/toProjectTask?projectid="+projectid;
	}
	
	/**
	 *description:跳转到添加任务界面
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@RequestMapping("/toInsertTask")
	public String toInsertTask(HttpServletRequest req){
		Long projectid = projectId;
		List<PmsProjectsNeeds> listProjectNeed = projectService.listProjectNeed(projectid);
		List<PmsProjectsTeam> listTeamMesg = projectService.listTeamMesg(projectid);
		req.setAttribute("listProjectNeed", listProjectNeed);
		req.setAttribute("listTeamMesg", listTeamMesg);
		req.setAttribute("projectid", projectid);
		return "add_project_task";
	}
	/**
	 *description:添加任务
	 *@author hulingtao
	 *@time 2017年8月7日 
	 */
	@RequestMapping("/insertTask")
	public String insertTask(PmsProjectsTask task,HttpServletRequest request){
		Long projectid = projectId;
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getServletContext());
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile(iter.next()
						.toString());
				if (file != null) {
					String path = request.getServletContext().getRealPath("\\uploadFile")+"\\"+file.getOriginalFilename();
					try {
						file.transferTo(new File(path));
						task.setAttachment(path);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		projectService.insertTask(task);
		return "redirect:/toProjectTask?projectid="+projectid;
	}
	/**
	 *description:跳转到批量添加页面
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@RequestMapping("/toInsertTaskbatch")
	public String toInsertTaskbatch(HttpServletRequest req){
		List<PmsProjectsNeeds> listProjectNeed = projectService.listProjectNeed(projectId);
		List<PmsProjectsTeam> listTeamMesg = projectService.listTeamMesg(projectId);
		req.setAttribute("listProjectNeed", listProjectNeed);
		req.setAttribute("listTeamMesg", listTeamMesg);
		return "add_project_taskbatch";
	}
	/**
	 *description:查询指派给我
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@RequestMapping("/acceptTome")
	public String acceptTome(HttpServletRequest req){
		Long projectid = projectId;
		HttpSession session = req.getSession();
		PmsUsers user = (PmsUsers)session.getAttribute("user");
		List<PmsProjectsTeam> listTeamMesg = projectService
				.listTeamMesg(projectid);
		req.setAttribute("listTeamMesg", listTeamMesg);
		List<PmsProjectsTask> listProjectTask = projectService.listProjectTaskByUserid(user.getUserid());
		req.setAttribute("listProjectTask", listProjectTask);
		List<PmsProjectsNeeds> listProjectNeed = projectService.listProjectNeed(projectid);
		req.setAttribute("listProjectNeed", listProjectNeed);
		req.setAttribute("projectid", projectid);
		return "project_task";
	}
	/**
	 *description:查询由我创建
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@RequestMapping("/createByme")
	public String createByme(HttpServletRequest req){
		Long projectid = projectId;
		HttpSession session = req.getSession();
		PmsUsers user = (PmsUsers)session.getAttribute("user");
		List<PmsProjectsTeam> listTeamMesg = projectService
				.listTeamMesg(projectid);
		req.setAttribute("listTeamMesg", listTeamMesg);
		List<PmsProjectsTask> listProjectTask = projectService.listProjectTaskByUserid2(user.getUserid());
		req.setAttribute("listProjectTask", listProjectTask);
		List<PmsProjectsNeeds> listProjectNeed = projectService.listProjectNeed(projectid);
		req.setAttribute("listProjectNeed", listProjectNeed);
		req.setAttribute("projectid", projectid);
		return "project_task";
	}
	/**
	 *description:查询由我解决
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@RequestMapping("/solveByme")
	public String solveByme(HttpServletRequest req){
		Long projectid = projectId;
		HttpSession session = req.getSession();
		PmsUsers user = (PmsUsers)session.getAttribute("user");
		List<PmsProjectsTeam> listTeamMesg = projectService
				.listTeamMesg(projectid);
		req.setAttribute("listTeamMesg", listTeamMesg);
		List<PmsProjectsTask> listProjectTask = projectService.listProjectTaskBySolve(user.getUserid());
		req.setAttribute("listProjectTask", listProjectTask);
		List<PmsProjectsNeeds> listProjectNeed = projectService.listProjectNeed(projectid);
		req.setAttribute("listProjectNeed", listProjectNeed);
		req.setAttribute("projectid", projectid);
		return "project_task";
	}
	/**
	 *description:查询由我关闭
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@RequestMapping("/closeByme")
	public String closeByme(HttpServletRequest req){
		Long projectid = projectId;
		HttpSession session = req.getSession();
		PmsUsers user = (PmsUsers)session.getAttribute("user");
		List<PmsProjectsTeam> listTeamMesg = projectService
				.listTeamMesg(projectid);
		req.setAttribute("listTeamMesg", listTeamMesg);
		List<PmsProjectsTask> listProjectTask = projectService.listProjectTaskByClose(user.getUserid());
		req.setAttribute("listProjectTask", listProjectTask);
		List<PmsProjectsNeeds> listProjectNeed = projectService.listProjectNeed(projectid);
		req.setAttribute("listProjectNeed", listProjectNeed);
		req.setAttribute("projectid", projectid);
		return "project_task";
	}
	/**
	 *description:查询由我取消
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@RequestMapping("/displayByme")
	public String displayByme(HttpServletRequest req){
		Long projectid = projectId;
		HttpSession session = req.getSession();
		PmsUsers user = (PmsUsers)session.getAttribute("user");
		List<PmsProjectsTeam> listTeamMesg = projectService
				.listTeamMesg(projectid);
		req.setAttribute("listTeamMesg", listTeamMesg);
		List<PmsProjectsTask> listProjectTask = projectService.listProjectTaskByDisplay(user.getUserid());
		req.setAttribute("listProjectTask", listProjectTask);
		List<PmsProjectsNeeds> listProjectNeed = projectService.listProjectNeed(projectid);
		req.setAttribute("listProjectNeed", listProjectNeed);
		req.setAttribute("projectid", projectid);
		return "project_task";
	}
	/**
	 *description:根据条件查询
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@RequestMapping("/listTaskBySearch")
	public String listTaskBySearch(TaskSearch search,HttpServletRequest req){
		try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long projectid = projectId;
		List<PmsProjectsTeam> listTeamMesg = projectService
				.listTeamMesg(projectid);
		req.setAttribute("listTeamMesg", listTeamMesg);
		search.setProjectid(projectid);
		List<PmsProjectsNeeds> listProjectNeed = projectService.listProjectNeed(projectid);
		req.setAttribute("listProjectNeed", listProjectNeed);
		List<PmsProjectsTask> listProjectTask = projectService.listTaskBySearch(search);
		req.setAttribute("listProjectTask", listProjectTask);
		req.setAttribute("projectid", projectid);
		return "project_task";
	}
	
	/**
	 *description:更新任务状态
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@RequestMapping("/beginTask")
	public void beginTask(long taskid,int status,HttpServletResponse resp){
		PmsProjectsTask task = new PmsProjectsTask();
		task.setTaskid(taskid);
		task.setStatus(status);
		int flag = projectService.updateTaskStatus(task);
		String jsonData = "";
		if(flag == 1){
			jsonData = "{\"message\":\"更新状态成功\",\"code\":1}";
		}else{
			jsonData = "{\"message\":\"更新状态失败\",\"code\":0}";
		}
		resp.setContentType("text/html;charset=utf-8");
		try {
			resp.getWriter().write(jsonData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 *description:更新指派人
	 *@author hulingtao
	 *@time 2017年8月5日 
	 */
	@RequestMapping("/updateAcceptid")
	public void updateAcceptid(long taskid,long acceptid,String note,HttpServletResponse resp){
		PmsProjectsTask task = new PmsProjectsTask();
		task.setTaskid(taskid);
		task.setAcceptid(acceptid);
		task.setNote(note);
		int flag = projectService.updateAcceptid(task);
		String jsonData = "";
		if(flag == 1){
			jsonData  = "{\"message\":\"指派人成功\";\"code\":1}";
		}else{
			jsonData  = "{\"message\":\"指派人失败\";\"code\":0}";
		}
		resp.setContentType("text/html;charset=utf-8");
		try {
			resp.getWriter().write(jsonData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 *description:跳转到项目图表界面
	 *@author hulingtao
	 *@time 2017年8月5日 
	 */
	@RequestMapping("/toProjectChart")
	public String toProjectChart(Long projectid,HttpServletRequest req){
		projectId = projectid;
		Map<String, String> userPosition = null;
		List<Map<String, String>> listPosition = new ArrayList<Map<String, String>>();
		List<PmsProjectsTeam> listTeamMesg = projectService.listTeamMesg(projectid);
		for (PmsProjectsTeam pmsProjectsTeam : listTeamMesg) {
			userPosition = new HashMap<String,String>();
			String position = projectService.getPosition(pmsProjectsTeam.getUserid());
			userPosition.put("name", pmsProjectsTeam.getUsername());
			userPosition.put("value", position);
			listPosition.add(userPosition);
		}
		String jsonString = JSON.toJSONString(listPosition);
		req.setAttribute("jsonString", jsonString);
		return "project_chart";
	}
	
	/**
	 * <p>
	 * Description: 修改一条项目记录
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年7月28日上午10:45:38
	 */
	@RequestMapping("/updatePmsProjects")
	public String updatePmsProjects(PmsProjects pmsProjects) {
		projectService.updatePmsProjects(pmsProjects);
		return "redirect:/listProjectInfo";
	}

	/**
	 * <p>
	 * Description:修改状态
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年7月28日下午4:03:03
	 */
	@RequestMapping("/updatePmsProjectsState")
	public String updatePmsProjectsState(PmsProjects PmsProjects) {
		projectService.updatePmsProjectsState(PmsProjects);
		return "redirect:/listProjectInfo";
	}

	/**
	 * <p>
	 * Description: 异步请求修改状态
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年7月31日上午10:31:07
	 */
	@RequestMapping("/updatePmsProjectsState1")
	public void updatePmsProjectsState1(PmsProjects pmsProjects) {
		projectService.updatePmsProjectsState(pmsProjects);
	}

	/**
	 * <p>Description:
	 *     跳转页面
	 * </p>
	 * @author quanhuan
	 * @time  2017年8月5日下午9:05:34
	 */
	@RequestMapping("/dispatchPage")
	public String dispatchPage() {
		return "add_project_manage";
	}

	/**
	 * <p>
	 * Description: 增加新项目
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年7月31日上午10:52:04
	 */
	@RequestMapping("/addPmsProjects")
	public String addPmsProjects(PmsProjects pmsProjects,HttpServletRequest req) {
	    HttpSession session = req.getSession();
	    PmsUsers user = (PmsUsers)session.getAttribute("user");
	    pmsProjects.setUserid(user.getUserid());
	    projectService.insertPmsProjects(pmsProjects);
		return "redirect:/listProjectInfo";
	}

	// bug
	/**
	 * <p>
	 * Description: 获取所有Bug
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年7月31日下午3:25:13
	 */
	@RequestMapping("/listPmsProjectsBug")
	public String listPmsProjectsBug(Model m,long projectid) {
		List<PmsProjectsTest> test = projectService.listPmsProjectsTest(projectid);
		m.addAttribute("listbug", test);
		m.addAttribute("acceptUser", ProjectServiceImpl.accpetUser);
		m.addAttribute("id", projectid);
		m.addAttribute("count", test.size());
		return "project_test";
	}

	/**
	 * <p>
	 * Description: 获取一条bug
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年7月31日下午4:17:25
	 */
	@RequestMapping("/getPmsProjectsBug")
	public String getPmsProjectsBug(Model m, long testid) {
		PmsProjectsTest bug = projectService.getPmsProjectsTest(testid);
		m.addAttribute("bug", bug);
		return "edit_project_test";
	}

	/**
	 * <p>
	 * Description: 检索bug
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年8月2日下午4:21:55
	 */
	@RequestMapping("/searchBug")
	public String searchBug(Model m, PmsProjectsTest pmsProjectsTest) {
		List<PmsProjectsTest> bug = projectService.searchBug(pmsProjectsTest);
		m.addAttribute("listbug", bug);
		m.addAttribute("acceptUser", ProjectServiceImpl.accpetUser);
		m.addAttribute("count", bug.size());
		return "project_test";
	}
	
    /**
     * <p>Description:
     *    查询指派给我的bug
     * </p>
     * @author quanhuan
     * @time  2017年8月5日下午3:39:53
     */
    @RequestMapping("/searchByAppoint")
	public String searchByAppoint(Model m,long acceptid,long projectid){
    	List<PmsProjectsTest> appoint = projectService.searchByAppoint(acceptid, projectid);
    	m.addAttribute("listbug", appoint);
    	m.addAttribute("id", projectid);
    	m.addAttribute("count", appoint.size());
		return "project_test";
	}
    
    /**
     * <p>Description:
     *    查询由我创建的bug
     * </p>
     * @author quanhuan
     * @time  2017年8月5日下午3:42:32
     */
    @RequestMapping("/serachByMyCreate")
    public String serachByMyCreate(Model m,long userid,long projectid){
    	List<PmsProjectsTest> create = projectService.searchByMyCreate(userid, projectid);
    	m.addAttribute("listbug", create);
    	m.addAttribute("id", projectid);
    	m.addAttribute("count", create.size());
    	return "project_test";
    }
	
    /**
     * <p>Description:
     *    查询由我解决的的bug
     * </p>
     * @author quanhuan
     * @time  2017年8月5日下午3:42:32
     */
    @RequestMapping("/serachByMySolve")
    public String serachByMySolve(Model m,long completeid,long projectid){
    	List<PmsProjectsTest> solve = projectService.searchByMySolve(completeid, projectid);
    	m.addAttribute("id", projectid);
    	m.addAttribute("listbug", solve);
    	m.addAttribute("count", solve.size());
    	return "project_test";
    }
    
	
	/**
	 * <p>
	 * Description: ajax获取bug修复人
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年7月31日下午4:23:38
	 */
	@RequestMapping("/getdispatchPeople")
	public void getdispatchPeople(HttpServletResponse resp, long projectid) {
		try {
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			List<PmsProjectsTeam> teamMesg = projectService.listTeamMesg(projectid);
			String str = JSON.toJSONString(teamMesg);
			pw.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>
	 * Description: 给bug指定派遣人
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年7月31日下午9:39:01
	 */
	@RequestMapping("/dispatchPeople")
	public String dispatchPeople(PmsProjectsTest pmsProjectsTest) {
		projectService.dispatchPeople(pmsProjectsTest);
		return "redirect:/listPmsProjectsBug?projectid="+pmsProjectsTest.getProjectid();
	}

	/**
	 * <p>
	 * Description: bug解决方案
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年8月2日下午3:48:01
	 */
	@RequestMapping("/resolvent")
	public String resolvent(PmsProjectsTest pmsProjectsTest) {
		projectService.resolvent(pmsProjectsTest);
		return "redirect:/listPmsProjectsBug?projectid="+pmsProjectsTest.getProjectid();
	}

	/**
	 * <p>
	 * Description: 编辑bug
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年8月4日上午10:27:46
	 */
	@RequestMapping("/updateBug")
	public String updateBug(PmsProjectsTest pmsProjectsTest, MultipartFile filename) {
		projectService.updateBug(pmsProjectsTest, filename);
		return "redirect:/listPmsProjectsBug?projectid="+pmsProjectsTest.getProjectid();
	}

	/**
	 * <p>
	 * Description: 查找所有需求跳转到增加bug页面
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年8月4日下午3:22:39
	 */
	@RequestMapping("/skip")
	public String skip(Model m,long projectid) {
		List<PmsProjectsNeeds> needs = projectService.listPmsProjectsNeeds(projectid);
		m.addAttribute("listneeds", needs);
		List<PmsProjectsTeam> list = projectService.listTeamMesg(projectid);
		m.addAttribute("listTeam", list);
		m.addAttribute("id",projectid);
		return "add_project_test";
	}
	
	/**
	 * <p>Description:
	 *    AJAX获取所有的需求
	 * </p>
	 * @author quanhuan
	 * @time  2017年8月4日下午4:05:56
	 */
	@RequestMapping("/listProjectsTask")
	public void listProjectsTask(long needsid,HttpServletResponse resp){
		List<PmsProjectsTask> task = projectService.listPmsProjectsTask(needsid);
		String string = JSON.toJSONString(task);
	    resp.setContentType("text/html;charset=utf-8");
	    try {
			PrintWriter writer = resp.getWriter();
			writer.write(string);
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	}

	/**
	 * <p>
	 * Description: 增加新的bug
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年8月4日下午3:11:50
	 */
	@RequestMapping("/addBug")
	public String addBug(PmsProjectsTest pmsProjectsTest, MultipartFile filename,HttpServletRequest req) {
		pmsProjectsTest.setTestid(new TimeDate().getTimeStampLongDate());
		HttpSession session = req.getSession();
		PmsUsers user = (PmsUsers)session.getAttribute("user");
		pmsProjectsTest.setUserid(user.getUserid());
		projectService.insertPmsProjectsTest(pmsProjectsTest,filename);
		return "redirect:/listPmsProjectsBug?projectid="+pmsProjectsTest.getProjectid();
	}
	
	@RequestMapping("/isExistNeedname")
	public void isExistNeedname(String name,HttpServletResponse resp){
		int flag = projectService.getPmsNeedByName(name);
		String jsonData = "";
		if(flag == 1){
			jsonData = "{\"message\":\"该需求名称已存在,请重新输入\",\"code\":1}";
		}else{
			jsonData = "{\"code\":0}";
		}
		resp.setContentType("text/html;charset=utf8");
		try {
			resp.getWriter().write(jsonData);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//查询项目中的所有版本信息
	@RequestMapping("/listPmsProjectsVersion{pageNum}")
	public String listPmsProjectsVersion(Model model,@RequestParam(required=true,defaultValue="1") Integer pageNum,@RequestParam(required=false,defaultValue="10") Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<PmsProjectsVersion> list = projectService.selectAllPmsProjectsVersion(projectId);
		PageInfo<PmsProjectsVersion> pageInfo = new PageInfo<PmsProjectsVersion>(list);
		if(list.size()>0){
			model.addAttribute("pageInfo",pageInfo);
			model.addAttribute("list",list);
			model.addAttribute("count", list.size());
			return "project_version";
		}else{
			return "404";
		}
	}
	
	//根据版本ID查看对应的详细信息
	@RequestMapping("/getPmsProjectsVersion{versionid}")
	public String getPmsProjectsVersion(@PathVariable Long versionid ,Model model){
		List<PmsProjectsVersion> list = projectService.getPmsProjectsVersion(versionid);
		if(list.size()>0){
			model.addAttribute("list",list);
			return "project_version_detail";
		}else{
			return "404";
		}
	}
	
	//根据版本ID获取版本进行修改
	@RequestMapping("/getPmsProjectsVersionToModify{versionid}")
	public String getPmsProjectsVersionToModify(@PathVariable Long versionid ,Model model){
		List<PmsProjectsVersion> list = projectService.getPmsProjectsVersion(versionid);
		if(list.size()>0){
			model.addAttribute("list",list);
			return "edit_project_version";
		}else{
			return "404";
		}
	}
	
	//根据版本ID删除对应的版本信息
	@RequestMapping("/deleteByVersionId{versionid}")
	public void deleteByVersionId(@RequestParam Long versionid,HttpServletResponse response) throws IOException{
		int flag = projectService.deleteByPrimaryKey(versionid);
		Map<String, Object> map = new HashMap<>();
		map.put("message", "删除成功");
		map.put("code", flag);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(JSONArray.toJSONString(map));
	}
	
	//只是为了添加版本信息的跳转
	@RequestMapping("/toAddPmsProjectsVersion")
	public String toAddPmsProjectsVersion(){
		return "add_project_version";
	}
	
	//新增版本信息
	@RequestMapping("/insertPmsProjectsVersion")
	public String insertPmsProjectsVersion(PmsProjectsVersion pmsProjectsVersion,HttpServletRequest request,HttpSession session,HttpServletResponse response) throws Exception{
		int flag = 0;
		IntDate id = new IntDate();
		Long verisonid = id.getTimeStampLongDate();
		java.util.Date date = new java.util.Date();
		Timestamp created = new Timestamp(date.getTime());
		//时间戳生成verisonid
		pmsProjectsVersion.setVersionid(verisonid);
		//时间戳生成创建时间
		pmsProjectsVersion.setCreated(created);
		pmsProjectsVersion.setChanged(created);//这里先和创建时间设置一样,因为不知道created的意思
		//设置项目ID
		pmsProjectsVersion.setProjectid((Long)session.getAttribute("projectid"));
		//设置userID
		PmsUsers user = (PmsUsers)session.getAttribute("user");
		pmsProjectsVersion.setUserid(user.getUserid());
		//创建一个通用的多部分解析器 
		CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getServletContext());
		//判断 request 是否有文件上传,即多部分请求
		if(resolver.isMultipart(request)){
			//转换成多部分request
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
			//取出一个list的multipartfile
			List<MultipartFile> list = multipartRequest.getFiles("files");
			System.out.println(list.size());
			for (MultipartFile file : list) {
				if(file!=null){
					//取得当前上传文件的文件名称
					String originalFilename = file.getOriginalFilename();
					//如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if(originalFilename.trim()!=""){
						//图片的原始名称（不含路径）  
						String random = UUID.randomUUID().toString().replace("-", "");
						String newFileName = random+file.getOriginalFilename().substring(originalFilename.lastIndexOf("."));  
						//定义上传路径
						String path = request.getServletContext().getRealPath("\\uploadFile")+"\\"+newFileName;
						File localFile = new File(path);
						file.transferTo(localFile);
						pmsProjectsVersion.setAttachment(newFileName);
					}
				}
			}
		}
		flag = projectService.insertPmsProjectsVersion(pmsProjectsVersion);
		if(flag>0){
			return "redirect:/listPmsProjectsVersion";
		}else{
			return "404";
		}
	}
	
	//根据版本id更新版本内容
	@RequestMapping("/updatePmsProjectsVersion")
	public String updatePmsProjectsVersion(PmsProjectsVersion pmsProjectsVersion,HttpServletRequest request,HttpSession session) throws Exception{
		System.out.println(pmsProjectsVersion.getCreated());
		int flag = 0;
		java.util.Date date = new java.util.Date();
		Timestamp time = new Timestamp(date.getTime());
		//时间戳生成创建时间
		pmsProjectsVersion.setChanged(time);//创建时间设置一样,最后一次更新的时间
		//创建一个通用的多部分解析器 
		CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getServletContext());
		//判断 request 是否有文件上传,即多部分请求
		if(resolver.isMultipart(request)){
			//转换成多部分request
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
			//取出一个list的multipartfile
			List<MultipartFile> list = multipartRequest.getFiles("files");
			for (MultipartFile file : list) {
				if(file!=null){
					//取得当前上传文件的文件名称
					String originalFilename = file.getOriginalFilename();
					//如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if(originalFilename.trim()!=""){
						//图片的原始名称（不含路径）  
						String random = UUID.randomUUID().toString().replace("-", "");
						String newFileName = random+file.getOriginalFilename().substring(originalFilename.lastIndexOf("."));  
						//定义上传路径
						String path = request.getServletContext().getRealPath("\\uploadFile")+"\\"+newFileName;
						File localFile = new File(path);
						file.transferTo(localFile);
						pmsProjectsVersion.setAttachment(newFileName);
					}
				}
			}
		}
		flag = projectService.updateByPrimaryKey(pmsProjectsVersion);
		if(flag>0){
			return "redirect:/listPmsProjectsVersion";
		}else{
			return "404";
		}
	}
	
	//模糊查询版本信息
	@RequestMapping("/searchPmsProjectsVersion")
	public String searchPmsProjectsVersion(HttpServletRequest req,HttpSession session){
		List<PmsProjectsVersion> listPmsProjectsVersion = new ArrayList<PmsProjectsVersion>();
		String title =  req.getParameter("title");
		Long projectid = (Long)session.getAttribute("projectid");
		if(title.equals("")){
			return "redirect:/listPmsProjectsVersion";
		}
		listPmsProjectsVersion = projectService.searchPmsProjectsVersion(title,projectid);
		req.setAttribute("count", listPmsProjectsVersion.size());
		req.setAttribute("list", listPmsProjectsVersion);
		return "searchPmsProjectsVersion";
	}
	
	//查询项目中的所有文档信息
	@RequestMapping("/listPmsProjectsDoc{pageNum}")
	public String listPmsProjectsDoc(Model model,@RequestParam(required=true,defaultValue="1") Integer pageNum,@RequestParam(required=false,defaultValue="10") Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<PmsProjectsDoc> list = projectService.selectAllPmsProjectsDoc(projectId);
		PageInfo<PmsProjectsDoc> pageInfo = new PageInfo<PmsProjectsDoc>(list);
		if(list.size()>0){
			model.addAttribute("list",list);
			model.addAttribute("count", list.size());
			model.addAttribute("pageInfo", pageInfo);
			return "project_doc";
		}else{
			return "404";
		}
	}
	//根据文档ID查看对应文档的详细信息
	@RequestMapping("/getPmsProjectsDoc{docid}")
	public String getPmsProjectsDoc(@PathVariable Long docid ,Model model){
		List<PmsProjectsDoc> list = projectService.getPmsProjectsDoc(docid);
		if(list.size()>0){
			model.addAttribute("list",list);
			return "project_doc_detail";
		}else{
			return "404";
		}
	}
	
	//根据文档ID获取文档进行修改
	@RequestMapping("/getPmsProjectsDocToModify{docid}")
	public String getPmsProjectsDocToModify(@PathVariable Long docid ,Model model){
		List<PmsProjectsDoc> list = projectService.getPmsProjectsDoc(docid);
		if(list.size()>0){
			model.addAttribute("list",list);
			return "edit_project_doc";
		}else{
			return "404";
		}
	}
	
	//根据文档ID删除对应的文档信息
	@RequestMapping("/deleteByDocid{docid}")
	public void deleteByDocid(@RequestParam Long docid,HttpServletResponse response) throws IOException{
		int flag = projectService.deleteDocByPrimaryKey(docid);
		Map<String, Object> map = new HashMap<>();
		map.put("message", "删除成功");
		map.put("code", flag);
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(JSONArray.toJSONString(map));
	}
	
	//只是为了添加版本信息的跳转
	@RequestMapping("/toAddPmsProjectsDoc")
	public String toAddPmsProjectsDoc(){
		return "add_project_doc";
	}
	
	//添加文档信息
	@RequestMapping("/insertPmsProjectsDoc")
	public String insertPmsProjectsDoc(PmsProjectsDoc pmsProjectsDoc,HttpServletRequest request,HttpSession session,HttpServletResponse response) throws Exception{
		int flag = 0;
		IntDate id = new IntDate();
		Long docid = id.getTimeStampLongDate();
		java.util.Date date = new java.util.Date();
		Timestamp created = new Timestamp(date.getTime());
		//时间戳生成verisonid
		pmsProjectsDoc.setDocid(docid);
		//时间戳生成创建时间
		pmsProjectsDoc.setCreated(created);
		pmsProjectsDoc.setChanged(created);//这里先和创建时间设置一样,因为不知道created的意思
		//设置项目ID
		pmsProjectsDoc.setProjectid((Long)session.getAttribute("projectid"));
		//设置userID
		PmsUsers user = (PmsUsers)session.getAttribute("user");
		pmsProjectsDoc.setUserid(user.getUserid());
		//创建一个通用的多部分解析器 
		CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getServletContext());
		//判断 request 是否有文件上传,即多部分请求
		if(resolver.isMultipart(request)){
			//转换成多部分request
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
			//取出一个list的multipartfile
			List<MultipartFile> list = multipartRequest.getFiles("files");
			System.out.println(list.size());
			for (MultipartFile file : list) {
				if(file!=null){
					//取得当前上传文件的文件名称
					String originalFilename = file.getOriginalFilename();
					//如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if(originalFilename.trim()!=""){
						//图片的原始名称（不含路径）  
						String random = UUID.randomUUID().toString().replace("-", "");
						String newFileName = random+file.getOriginalFilename().substring(originalFilename.lastIndexOf("."));  
						//定义上传路径
						String path = request.getServletContext().getRealPath("\\uploadFile")+"\\"+newFileName;
						File localFile = new File(path);
						file.transferTo(localFile);
						pmsProjectsDoc.setAttachment(newFileName);
					}
				}
			}
		}
		flag = projectService.insertPmsProjectsDoc(pmsProjectsDoc);
		if(flag>0){
			return "redirect:/listPmsProjectsDoc";
		}else{
			return "404";
		}
	}
	
	//根据版本id更新版本内容
	@RequestMapping("/updatePmsProjectsDoc")
	public String updatePmsProjectsDoc(PmsProjectsDoc pmsProjectsDoc,HttpServletRequest request,HttpSession session) throws Exception{
		int flag = 0;
		java.util.Date date = new java.util.Date();
		Timestamp time = new Timestamp(date.getTime());
		//时间戳生成创建时间
		pmsProjectsDoc.setChanged(time);//创建时间设置一样,最后一次更新的时间
		PmsUsers user = (PmsUsers)session.getAttribute("user");
		pmsProjectsDoc.setUserid(user.getUserid());
		//创建一个通用的多部分解析器 
		CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getServletContext());
		//判断 request 是否有文件上传,即多部分请求
		if(resolver.isMultipart(request)){
			//转换成多部分request
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
			//取出一个list的multipartfile
			List<MultipartFile> list = multipartRequest.getFiles("files");
			for (MultipartFile file : list) {
				if(file!=null){
					//取得当前上传文件的文件名称
					String originalFilename = file.getOriginalFilename();
					//如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if(originalFilename.trim()!=""){
						//图片的原始名称（不含路径）  
						String random = UUID.randomUUID().toString().replace("-", "");
						String newFileName = random+file.getOriginalFilename().substring(originalFilename.lastIndexOf("."));  
						//定义上传路径
						String path = request.getServletContext().getRealPath("\\uploadFile")+"\\"+newFileName;
						File localFile = new File(path);
						file.transferTo(localFile);
						pmsProjectsDoc.setAttachment(newFileName);
					}
				}
			}
		}
		flag = projectService.updateDocByPrimaryKey(pmsProjectsDoc);
		if(flag>0){
			return "redirect:/listPmsProjectsDoc";
		}else{
			return "404";
		}
	}
	
	//模糊查询文档信息
	@RequestMapping("/searchPmsProjectsDoc")
	public String searchPmsProjectsDoc(HttpServletRequest req,HttpSession session){
		List<PmsProjectsDoc> listPmsProjectsDoc = new ArrayList<>();
		String sort =  req.getParameter("sort");
		String title =  req.getParameter("title");
		Long projectid = (Long)session.getAttribute("projectid");
		if(sort.equals("0") && title.equals("")){
			return "redirect:/listPmsProjectsDoc";
		}
		int statues = Integer.parseInt(sort);//1 2
		if(title.equals("")){
			listPmsProjectsDoc = projectService.searchPmsProjectsDoc(statues,null,projectid);
			req.setAttribute("count", listPmsProjectsDoc.size());
			req.setAttribute("list", listPmsProjectsDoc);
			return "searchPmsProjectsDoc";
		}else{
			listPmsProjectsDoc = projectService.searchPmsProjectsDoc(statues,title,projectid);
			req.setAttribute("count", listPmsProjectsDoc.size());
			req.setAttribute("list", listPmsProjectsDoc);
			return "searchPmsProjectsDoc";
		}
	}
	
	//开始报表的书写
	@RequestMapping("/listCharts")
	public String listCharts(){
		return "project_chart";
	}
	
}
