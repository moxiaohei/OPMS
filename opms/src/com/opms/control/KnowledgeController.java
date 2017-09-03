package com.opms.control;
import com.opms.entity.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.opms.entity.PmsKnowledges;
import com.opms.entity.PmsKnowledgesUser;
import com.opms.entity.PmsUsers;
import com.opms.service.KnowledgeService;
import com.opms.unti.IntDate;
import com.opms.unti.StringDate;
import com.opms.unti.TimeDate;
/**
 * 
 * @author lizhen
 * @data 2017年8月7日下午1:58:45
 * @tags知识分享
 */
@Controller
public class KnowledgeController {
private PmsKnowledgesLaud pmsKnowledgesLaud=new PmsKnowledgesLaud();
private IntDate intDate=new IntDate();
private TimeDate timeDate=new TimeDate();
private StringDate stringDate=new StringDate();
private List<PmsKnowledgesUser>  listPmsKnowledgesUser=new ArrayList<PmsKnowledgesUser>();
private List<PmsCommentUser> listPmsKnowledgesComment=new ArrayList<PmsCommentUser>();
private PmsKnowledges pmsKnowledges;

@Autowired
private KnowledgeService knowledgeService;
/**
 * 
 * description:搜索时，查找相关列表
 */
@RequestMapping("search2")
public void search2(Model model,String keyword,HttpServletRequest request,HttpServletResponse resp)
{
	String b="";
	try {
		//将前台页面的值改成utf-8格式
		b = new String(keyword.getBytes("ISO-8859-1"),"utf-8");
	    List<String> listData=new ArrayList<String>();
	    
		 listData=getData(b);
		//响应给后台为utf-8格式
		resp.setCharacterEncoding("utf-8");
		resp.getWriter().write(JSONArray.toJSONString(listData).toString());
	} catch (Exception e) {
		
		e.printStackTrace();
	}
		
}
/**
 * 
 * description:将所有标签 标题加入静态datas集合中，并根据用户输入框内容模糊查找所有相关标签  标题
 */
private List<String> getData(String keyword) {
	 List<String> datas=new ArrayList<String>();
	 List<String> listTag=knowledgeService.selectAlltag();
	 Iterator it=listTag.iterator();
	while(it.hasNext())
	{
		
		datas.add(it.next().toString());
	}
	List<String> listTitle=knowledgeService.selectAlltitle();
	Iterator it2=listTitle.iterator();
	while(it2.hasNext())
	{
		
		datas.add(it2.next().toString());
	}
	
	List<String> list=new ArrayList<String>();
	
	for(String ds:datas)
	{
		
		if(ds.contains(keyword))
		{
			list.add(ds);
		}
		
	}
	return list;
}
/**
 * 
 * description:根据用户最终选择的内容查找对应知识信息
 */
@RequestMapping("search")
public String search(Model model,HttpServletRequest res,@Param(value="keywords") String keywords)
{
	try {
		res.setCharacterEncoding("utf-8");
	} catch (UnsupportedEncodingException e) {
		
		e.printStackTrace();
	}
	 
	listPmsKnowledgesUser=knowledgeService.selectlistPmsKnowledgesUserBykeywords(keywords);
	model.addAttribute("listPmsKnowledgesUser", listPmsKnowledgesUser);
	model.addAttribute("a","b");
	return "knowledge_manage";
}
/**
 * 
 * description:进入到我的知识
 */
@RequestMapping("knowledge_manage")
public String knowledge_manage(Model model,Long userid)
{
	
	listPmsKnowledgesUser=knowledgeService.selectByKnowledgesUserKey(userid);
	model.addAttribute("listPmsKnowledgesUser", listPmsKnowledgesUser);
	return "knowledge_manage";
}
/**
 * 
 * description:我的主页
 */
@RequestMapping("user_index")
public String user_index()
{
	return "user_index";
}
/**
 * 
 * description:+我的知识
 */
@RequestMapping("add_knowlwdge_manage")
public String add_knowlwdge_manage(Model model,String userid)
{
	
	return "add_knowlwdge_manage";
}
@RequestMapping("add_knowlwdge_manage01")
public String add_knowlwdge_manage01(Model model,PmsKnowledges pmsKnowlwdges)
{

	//将值插入到PmsKnowledges表中
	PmsKnowledges pmsKnowlwdges2=new PmsKnowledges();
	//获得knowid
	long knowid=intDate.getTimeStampLongDate();
	pmsKnowlwdges2.setKnowid(knowid);
	pmsKnowlwdges2.setUserid(pmsKnowlwdges.getUserid());
	pmsKnowlwdges2.setContent(pmsKnowlwdges.getContent());
	pmsKnowlwdges2.setTag(pmsKnowlwdges.getTag());
	pmsKnowlwdges2.setSummary(pmsKnowlwdges.getSummary());
	pmsKnowlwdges2.setTitle(pmsKnowlwdges.getTitle());
	pmsKnowlwdges2.setUrl(pmsKnowlwdges.getUrl());
	pmsKnowlwdges2.setSortid(pmsKnowlwdges.getSortid());
	//获取当前时间
	String created=stringDate.getNowStringDate();
	pmsKnowlwdges2.setCreated(created);
	knowledgeService.insertSelective(pmsKnowlwdges2);
	//应该重定向
	model.addAttribute("userid",pmsKnowlwdges.getUserid());
	return "redirect:/knowledge_manage";
	
}

/**
 * 
 * description:进入到知识分享 和全部知识
 */
@RequestMapping("all_knowledge_manage")
public String all_knowledge_manage(Model model)
{
	listPmsKnowledgesUser=knowledgeService.selectKnowledgesUser();
	model.addAttribute("listPmsKnowledgesUser",listPmsKnowledgesUser );
	model.addAttribute("a","b");
	return "knowledge_manage";
}
/**
 * 
 * description:前台页面遍历枚举类得到枚举的index(sortid)，
 * 查找sortid为index的所有分享
 */
@RequestMapping("sort")
public String sort(Model model,int sortid)
{
	listPmsKnowledgesUser=knowledgeService.selectByKnowledgesUsersortid(sortid);
	model.addAttribute("listPmsKnowledgesUser",listPmsKnowledgesUser);
	model.addAttribute("a","b");
	
	return "knowledge_manage";
}
/**
 * 
 * description:由知识分享页面进入知识页面
 */
@RequestMapping("knowledge_detail")
public String knowledge_detail(Model model,Long knowid)
{

	//进入一次浏览量增加一
	knowledgeService.updateKnowledgeView(knowid);
	model.addAttribute("knowid", knowid);
	return "knowledge_detail";
}
/**
 * 
 * description:点评
 */
@RequestMapping("comment")

public String comment(HttpServletRequest req, Model model,Long knowid,Long userid,String comment)
{
	
	//跟新知识分享表中的id为knowid的分享（给该分享的评论数加1）
	knowledgeService.updateKnowledgeComtnum(knowid);
	//插入到评论表后，再进行查询对应知识及所有评论列表
	String created=stringDate.getNowStringDate();
	//用工具类创建comtid
	Long comtid=timeDate.getTimeStampLongDate();
	PmsKnowledgesComment pmsKnowledgesComment=new PmsKnowledgesComment();
	pmsKnowledgesComment.setCreated(created);
	pmsKnowledgesComment.setComtid(comtid);
	pmsKnowledgesComment.setKnowid(knowid);
	pmsKnowledgesComment.setUserid(userid);
	pmsKnowledgesComment.setContent(comment);
	knowledgeService.insertComment(pmsKnowledgesComment);
	model.addAttribute("knowid", knowid);
	return "knowledge_detail";
}
/**
 * 
 * description:知识点赞
 */
@RequestMapping("laud")
public String laud(Model model,HttpSession session,Long knowid)
{
	
	PmsUsers user= (PmsUsers) session.getAttribute("user");
	Long userid1=user.getUserid();
	 
	/**
	 * 查找点赞表，若该knowid没有对应的评论者  
	 * 1.给点赞表添加对应的  userid  knowid及对应的值
	 * 2.再给知识分享表的对应的knowid的点赞数加1
	 * 若点表存在该userid  则给知识分享表的knowid对应的点赞数减1
	 */
	 Long  userid2=knowledgeService.selectLauderuseridByknowid(knowid);
	
      if(userid2!=null&&userid2.equals(userid1))
      {
    	  //给点赞数减一
    	 knowledgeService.updateKnowledgeLaud2(knowid);
    	 //并刪除該評論信息
    	PmsUseridKnowid pmsUseridKnowid=new PmsUseridKnowid();
    	pmsUseridKnowid.setKnowid(knowid);
    	pmsUseridKnowid.setUserid(userid2); 
    	knowledgeService.delLaudByKnowid(pmsUseridKnowid);
      }
      else{
    	//先在点赞表添加数据
    	  long laudid=intDate.getTimeStampLongDate();
    	  pmsKnowledgesLaud.setLaudid(laudid);
    	  pmsKnowledgesLaud.setKnowid(knowid);
    	  pmsKnowledgesLaud.setUserid(userid1);
    	  knowledgeService.insertLaud(pmsKnowledgesLaud);
    	  knowledgeService.updateKnowledgeLaud(knowid);
      }
	model.addAttribute("knowid", knowid);
	return "knowledge_detail";
}

/**
 * 
 * description:删除分享
 */
@RequestMapping("del")
public String del(Model model,Long knowid)
{  
	//先根据knowid查出userid进入我的知识
		Long userid=knowledgeService.selectKnowledgesuseridByknowid(knowid);
		//删除分享表
		knowledgeService.delKnowledgesByKnowid(knowid);
		//删除评论表
		knowledgeService.delCommentByKnowid(knowid);
		//再查进入我的知识页面
		model.addAttribute("userid", userid);
		return "redirect:/knowledge_manage";
}
/**
 * 
 * description:修改分享
 */
@RequestMapping("update")
public String update(Model model,Long knowid)
{
	//根据knowid查出知识信息，然后传入到add_knowlwdge_manage
	//收获----根据枚举中的sortid在select标签中显示其对应的name
	pmsKnowledges=knowledgeService.selectByKnowledgesKnowid(knowid);
	model.addAttribute("knowid", knowid);
	model.addAttribute("pmsKnowledges", pmsKnowledges);
	return "update_knowlwdge_manage";
}
@RequestMapping("update_knowlwdge")
public String update_knowlwdge(Model model,PmsKnowledges pmsKnowledges,Long knowid)
{
	//更新knowid对应的知识后回到knowledge_manage
	//更新knowid
	pmsKnowledges.setKnowid(knowid);
	knowledgeService.update_knowlwdge(pmsKnowledges);
	Long userid=pmsKnowledges.getUserid();
	model.addAttribute("userid", userid);
	return "redirect:/knowledge_manage";
}
/**
 * 
 * description:异步请求 进入knowledge_manage 就显示用户的知识信息
 */
@RequestMapping("knowledge_manage01")
public void knowledge_manage(Long id,HttpServletResponse resp)
{
	//根据用户id(userid)查找用户知识
	listPmsKnowledgesUser=knowledgeService.selectByKnowledgesUserKey(id);
	
	resp.setCharacterEncoding("utf-8");
	try {
		resp.getWriter().write(JSONArray.toJSONString(listPmsKnowledgesUser));
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}
/**
 * 
 * description:异步查询知识详情
 */
@RequestMapping("detail")
public void detail(HttpServletResponse resp,Long knowid)
{
	listPmsKnowledgesUser=knowledgeService.selectByKnowledgesUserknowid(knowid);
	resp.setCharacterEncoding("utf-8");
	try {
		resp.getWriter().write(JSONArray.toJSONString(listPmsKnowledgesUser));
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}
/**
 * 
 * description:异步查询评论列表
 */
@RequestMapping("list")
public void list(HttpServletResponse resp,Long knowid)
{
	listPmsKnowledgesComment=knowledgeService.selectCommentByKnowledgeKnowid(knowid);
	resp.setCharacterEncoding("utf-8");
	try {
		resp.getWriter().write(JSONArray.toJSONString(listPmsKnowledgesComment));
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}
public PmsKnowledges getPmsKnowledges() {
	return pmsKnowledges;
}
public void setPmsKnowledges(PmsKnowledges pmsKnowledges) {
	this.pmsKnowledges = pmsKnowledges;
}


}
