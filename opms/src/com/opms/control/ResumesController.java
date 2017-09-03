package com.opms.control;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.opms.entity.PmsResumes;
import com.opms.service.ResumesService;
import com.opms.unti.IntDate;

/**
 * @author mengyongfei
 * @date 2017年7月28日 上午11:04:32
 * 控制层
 */
@Controller
public class ResumesController {
	
	@Autowired
	private ResumesService resumesService;
	
	//查询所有简历信息   pageNum:当前页   pageSize:当前页大小,默认为10
	@RequiresRoles("resume-manage")
	@RequestMapping("/listResumes{pageNum}")
	public String listResumes(Model model,@RequestParam(required=true,defaultValue="1") Integer pageNum,@RequestParam(required=false,defaultValue="10") Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<PmsResumes> listResumes = resumesService.listResumes();
		PageInfo<PmsResumes> pageInfo = new PageInfo<PmsResumes>(listResumes);
		model.addAttribute("count", listResumes.size());
		model.addAttribute("listResumes", listResumes);
		model.addAttribute("pageInfo", pageInfo);
		return "resume_manage";
	}
	
	//根据简历ID删除简历信息
	@RequiresRoles("resume-delete")
	@RequestMapping("/deleteResumes{resumeid}")
	public String deleteResumes(@RequestParam Long resumeid,HttpServletResponse response) throws Exception{
		int flag = resumesService.deletePmsResumes(resumeid);
		if(flag>0){
			return "redirect:/listResumes";
		}else{
			return "404";
		}
	}
	
	//根据简历ID更新简历状态
	@RequestMapping("/updateStateById{resumeid,status}")
	public String updateStateById(@RequestParam Long resumeid,@RequestParam Integer status,HttpServletResponse response) throws Exception{
		int flag = resumesService.updateStateById(resumeid, status);
		if(flag>0){
			return "redirect:/listResumes";
		}else{
			return "404";
		}
	}
	
	//添加简历信息
	@RequestMapping("insertResumes")
	public String insertResumes(PmsResumes pmsResumes,@RequestParam("files")CommonsMultipartFile file,HttpServletRequest req,HttpServletResponse resp) throws Exception{
		int flag = 0;
		IntDate id = new IntDate();
		Long resumeid = id.getTimeStampLongDate();
		java.util.Date date = new java.util.Date();
		Timestamp created = new Timestamp(date.getTime());
		//时间戳生成resumeid
		pmsResumes.setResumeid(resumeid);
		//时间戳生成创建时间
		pmsResumes.setCreated(created);
		//上传简历
		if(file.getOriginalFilename().equals("")){
			pmsResumes.setAttachment("暂无");
		}else{
			String path = req.getServletContext().getRealPath("\\uploadFile");
			String origanlFileName = file.getOriginalFilename();
			File newFile = new File(path+"\\"+origanlFileName);
			file.transferTo(newFile);
	        pmsResumes.setAttachment("uploadFile\\"+origanlFileName);
		}
		flag = resumesService.insertResumes(pmsResumes);
		if(flag>0){
			return "redirect:/listResumes";
		}else{
			return "404";
		}
	}
	//根据简历ID获取简历信息
	@RequiresRoles("resume-edit")
	@RequestMapping("/getResumes{resumeid}")
	public String getResumes(@PathVariable Long resumeid,Model model){
		PmsResumes pmsResumes = resumesService.getResumes(resumeid);
		if(pmsResumes != null){
			model.addAttribute("pmsResumes", pmsResumes);
			return "edit_resume_manage";
		}else{
			return "404";
		}
	}
	
	//跳转到要添加的JSP页面
	@RequiresRoles("resume-add")
	@RequestMapping("/toAddResumes")
	public String toAddResumes(){	
		return "add_resume_manage";
	}
	
	//根据简历ID更新简历信息
	@RequestMapping("/updateResumes")
	public String updateResumes(PmsResumes pmsResumes,@RequestParam("file")CommonsMultipartFile  file,HttpServletRequest req) throws Exception{
		int flag = 0;
		//上传简历
		if(file.isEmpty()){
			flag = resumesService.updateByPrimaryKey(pmsResumes);
		}else{
			String path = req.getServletContext().getRealPath("\\uploadFile");
			String origanlFileName = file.getOriginalFilename();
			File newFile = new File(path+"\\"+origanlFileName);
			file.transferTo(newFile);
	        pmsResumes.setAttachment("uploadFile\\"+origanlFileName);
	        flag = resumesService.updateByPrimaryKey(pmsResumes);
		}
		if(flag>0){
			return "redirect:/listResumes";
		}else{
			return "404";
		}
	}
	
	//模糊查询简历信息
	@RequestMapping("/searchResumes")
	public String searchResumes(HttpServletRequest req,HttpSession session){
		List<PmsResumes> listResumes = new ArrayList<>();
		String status =  req.getParameter("status");
		String realname = req.getParameter("realname");
		if(status.equals("0") && realname.equals("")){
			return "redirect:/listResumes";
		}
		int statues = Integer.parseInt(status);//1 2 3 4 5
		if(realname.equals("")){
			listResumes = resumesService.searchResumes(statues,null);
			req.setAttribute("count", listResumes.size());
			req.setAttribute("listResumes", listResumes);
			return "searchResumes";
		}else{
			listResumes = resumesService.searchResumes(statues,realname);
			req.setAttribute("count", listResumes.size());
			req.setAttribute("listResumes", listResumes);
			return "searchResumes";
		}
	}
	
}
