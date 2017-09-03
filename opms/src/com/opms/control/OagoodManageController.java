package com.opms.control;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opms.entity.PmsOagoods;
import com.opms.entity.PmsUsers;
import com.opms.service.OagoodManageService;
import com.opms.unti.IntDate;
/**
 * 
 * @author lizhen
 * @data 2017年8月4日下午3:19:03
 * @tags审批管理
 */
@Controller
public class OagoodManageController {
	@Autowired
	private OagoodManageService oagoodManageService;
	List<PmsOagoods> listpmsOagoods=new ArrayList<PmsOagoods>();
	private IntDate intDate=new IntDate();
	/**
	 * 
	 * description:审批管理主页面
	 */

	/**
	 * 
	 * description:物品页面
	 */
    @RequestMapping("oagood_manage")
    public String oagood_manage(Model model,HttpSession session)
    {
    	PmsUsers user = (PmsUsers)session.getAttribute("user");
    	//查询领用列表
    	listpmsOagoods=oagoodManageService.selectlistOagoodManage(user.getUserid());
    	model.addAttribute("listpmsOagoods", listpmsOagoods);
    	model.addAttribute("count", listpmsOagoods.size());
    	//1.遍历每个pmsOagoods中Approverids，再根据每个approverid查出对应的userid根据userID查出username 和图片
    	//2.整体封装在一个对象  (pmsOagoods+username1,username2+图片1，图片2)
    	//查询领用列数目
    	int count=oagoodManageService.selectOagoodManageCount();
    	
    	//1.同步实现 刚进入oagood_manage显示本人全部物品列表
    	//2.点击待审批  ，在pms_oagoods_appriover中查找对应userid未同意的（指我没有审批别人的请求),根据我的id查找我审批别人的审批结果
    	//3.
    	return "oagood_manage";
    }
    /**
     * 
     * description:我要领取页面
     */
    @RequestMapping("add_oagood_manage")
    public String add_oagood_manager()
    {   
    	return "add_oagood_manage";
    	
    }
    @RequestMapping("add_oagood_manage01")
    public void add_oagood_manager01(HttpServletResponse resp,Long userid,String jsons)
    {   //1.在add_oagood_manage添加完之后  进入该方法  添加到数据库添加到pms_oagoods 前台响应一个“添加成功”  
    	//2.form表单进入一个Controller查处本人所有物品
    	//3.返回到oagood_manage展示物品列表
    	//将前台的json对象解析成实体类对象
    	
    	PmsOagoods pmsOagoods=JSONObject.parseObject(jsons,PmsOagoods.class);
    	
    	//获得oagoodid
    	Long  oagoodid=intDate.getTimeStampLongDate();
    	//获得created
    	
    	Timestamp created=new java.sql.Timestamp(new java.util.Date().getTime());
    	pmsOagoods.setCreated(created);
    	pmsOagoods.setOagoodid(oagoodid);
    	/*System.out.println(pmsOagoods.getApproverid());*/
    	if(pmsOagoods.getApproverid().equals(""))
    	{
    		pmsOagoods.setApproverid(pmsOagoods.getApproverid());
    	}
    	else{
        	pmsOagoods.setApproverid(pmsOagoods.getApproverid().substring(1));

    	}
    	pmsOagoods.setQuantitys(pmsOagoods.getQuantitys().substring(0,pmsOagoods.getQuantitys().lastIndexOf(",")));
    	pmsOagoods.setNames((pmsOagoods.getNames().substring(0,pmsOagoods.getNames().lastIndexOf(","))));
    	pmsOagoods.setPurpose(pmsOagoods.getPurpose());
    	pmsOagoods.setContent(pmsOagoods.getContent());
    	pmsOagoods.setPicture(pmsOagoods.getPicture());
    	pmsOagoods.setStatus(1);
    	
    	pmsOagoods.setChanged(null);
    	pmsOagoods.setUserid(pmsOagoods.getUserid());
    	System.out.println(pmsOagoods);
    	oagoodManageService.insertOagoodsManage(pmsOagoods);
    	try {
    		//添加成功给前台响应"添加成功"
    		resp.setCharacterEncoding("utf-8");
    			resp.getWriter().write(JSONArray.toJSONString("添加成功"));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
    }
    //按条件搜索
    @RequestMapping("searchOagood")
    public String searchOagood(Model model,HttpSession session,PmsOagoods pmsOagoods){
    	PmsUsers user=(PmsUsers)session.getAttribute("user");
    	pmsOagoods.setUserid(user.getUserid());
    	model.addAttribute("listpmsOagoods",oagoodManageService.searchOagoods(pmsOagoods));
    	
    	return "redirect:oagood_manage";
    }
}
