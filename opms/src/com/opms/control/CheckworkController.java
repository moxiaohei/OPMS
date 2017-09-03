package com.opms.control;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONArray;
import com.opms.entity.PmsCheckworkandrealname;
import com.opms.entity.PmsCheckworks;
import com.opms.entity.PmsUsers;
import com.opms.entity.Subtotal;
import com.opms.service.CheckworkService;
import com.opms.unti.IntDate;
import com.opms.unti.getIP;
/**
 * @author sunwenke
 * @date 2017年7月27日上午10:30:57
 * @tags 考勤表的Controller
 */
/**
 * @author sunwenke
 * @date 2017年8月4日下午12:53:02
 * @tags 
 */
@Controller
public class CheckworkController {
	@Autowired
	private CheckworkService CheckworkService;
	private PmsCheckworks PmsCheckworks;
	Time clockon=Time.valueOf("09:00:59");
	Time clockoff=Time.valueOf("18:00:59");
	/**
	 * @tags获取当前登录用户的userid和当前时间
	 */
	public PmsCheckworks getPmsCheckworks(HttpSession session){
		PmsUsers user=(PmsUsers) session.getAttribute("user");
		PmsCheckworks PmsCheckworks=new PmsCheckworks();
		if(user!=null){
			PmsCheckworks.setUserid(user.getUserid());
			Long date = Calendar.getInstance().getTimeInMillis();
			Date created=new Date(date);
			PmsCheckworks.setCreated(created);
			return PmsCheckworks;
		}		
		return null;
	}
	/**
	 * @tags 根据用户id查询考勤表
	 */
	@RequestMapping("listCheckworkbyuserid")
	public String listCheckworkbyuserid(Model model,HttpSession session){
		PmsCheckworks PmsCheckworks=getPmsCheckworks(session);
		if(PmsCheckworks!=null){
			List<PmsCheckworks> list=CheckworkService.listCheckworkbyPmsCheckworks(PmsCheckworks);
			model.addAttribute("list", list);
			Subtotal subtotal = Subtotal(PmsCheckworks);
			model.addAttribute("subtotal", subtotal);			
			return "checkwork_index";
		}else{
			return "404";
		}
		
		
	}
	/**
	 * @tags今日打卡次数
	 */
	public int CheckNum(PmsCheckworks PmsCheckworks){
		List<PmsCheckworks> list=CheckworkService.countCheckwork(PmsCheckworks);
		int CheckNum=list.size();
		return CheckNum;
	}
	
	/**
	 * @tags 添加考勤表
	 */
	@RequestMapping("insertCheckwork")
	public void insertCheckwork(HttpServletRequest request,@RequestParam Time clock,HttpServletResponse resp,HttpSession session){ 
		Map<String,Object> map = new HashMap<String,Object>();  
		PmsCheckworks PmsCheckworks=getPmsCheckworks(session);
		if(PmsCheckworks!=null){
			Long checkid=new IntDate().getTimeStampLongDate();//随机生成checkid
			String ip=getIP.getLocalIp(request);//获得ip
			if(ip.equals("0:0:0:0:0:0:0:1")){
				ip="127.0.0.1";
			}
			PmsCheckworks.setCheckid(checkid);
			PmsCheckworks.setClock(clock);
			PmsCheckworks.setIp(ip);
			int CheckNum=CheckNum(PmsCheckworks);
			if(CheckNum>=2){
				 map.put("message", "今日打卡次数超过两次");		
			}else{
				int type=0;
				int t1=clock.compareTo(clockon);
				int t2=clock.compareTo(clockoff);
				if(CheckNum<=0){
					if(t1<0){
						 type=1;
					}else{
						 type=2;
					}			
				}else if(CheckNum==1){
					if(t2<0){
						 type=3;
					}else{
						 type=4;				
					}
				}
				PmsCheckworks.setType(type);
				CheckworkService.insertCheckwork(PmsCheckworks);
				map.put("message", "打卡成功");			
			}
			
			try {
				resp.setCharacterEncoding("utf-8");
				resp.getWriter().print(JSONArray.toJSONString(map));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}
	
	/**
	 * @tags 查询全部用户考勤
	 */
	@RequestMapping("listAllCheckwork")
	public String listAllCheckwork(Model model,HttpSession session){
		PmsCheckworks PmsCheckworks=new PmsCheckworks();
		Long date = Calendar.getInstance().getTimeInMillis();
		Date created=new Date(date);
		PmsCheckworks.setCreated(created);
		List<PmsCheckworkandrealname> list = CheckworkService.listAllCheckwork(PmsCheckworks);
		model.addAttribute("list", list);		
		PmsUsers user=(PmsUsers) session.getAttribute("user");		
		if(user!=null){
			PmsCheckworks.setUserid(user.getUserid());
			String userid=String.valueOf(PmsCheckworks.getUserid());
			model.addAttribute("userid", userid);
			Subtotal subtotal =Subtotal(PmsCheckworks);
			model.addAttribute("subtotal", subtotal);
			return "checkwork_all";
		}else{
			return "404";
		}
		
	}
	/**
	 * @tags  根据用户id查询用户本月小计
	 */
	public Subtotal Subtotal(PmsCheckworks PmsCheckworks){
		//统计正常早退迟到次数
		List<Subtotal> countlist = CheckworkService.typecountCheckwork(PmsCheckworks);
		Subtotal subtotal=new Subtotal();
		for(Subtotal Subtotal:countlist){
			if(Subtotal.getType()==1){
				subtotal.setNormal(Subtotal.getCount());
			}else if(Subtotal.getType()==2){
				subtotal.setLate(Subtotal.getCount()) ;
			}else if(Subtotal.getType()==3){
				subtotal.setEarly(Subtotal.getCount());
			}
		}
		//统计本月出勤天数
		float workdays = CheckworkService.workdays(PmsCheckworks);
		subtotal.setWorkdays(workdays);
		return subtotal;
	}
	/**
	 * @tags 根据userid(用户id)和(type)类型查询考勤表
	 */
	@RequestMapping("listCheckworkbytype")
	public void listCheckworkbytype(PmsCheckworks PmsCheckworks,Model model,HttpSession session,HttpServletResponse resp){
		PmsUsers user=(PmsUsers) session.getAttribute("user");
		Map<String,Object> map=new HashMap<String,Object>();
		if(user.getUserid()!=null){
			PmsCheckworks.setUserid(user.getUserid());
			Long date = Calendar.getInstance().getTimeInMillis();
			Date created=new Date(date);
			PmsCheckworks.setCreated(created);			
			List<PmsCheckworks> list = CheckworkService.listCheckworkbytype(PmsCheckworks);
			map.put("list", list);
			//model.addAttribute("list", list);
			Subtotal subtotal =Subtotal(PmsCheckworks);
			map.put("subtotal", subtotal);
			//model.addAttribute("subtotal", subtotal);
			try {
				resp.getWriter().print(JSONArray.toJSONString(map));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//return "checkwork_index";		
		}
		
	}
	/**
	 * @tags 根据用户id和考勤年月查询
	 */
	@RequestMapping("listCheckworkbycreated")
	public void listCheckworkbycreated(@RequestParam String created,Model model,HttpSession session,HttpServletResponse resp){
		Map<String,Object> map=new HashMap<String,Object>();
		created=created+"-1";
		PmsCheckworks PmsCheckworks=new PmsCheckworks();
		PmsUsers user=(PmsUsers) session.getAttribute("user");
		PmsCheckworks.setUserid(user.getUserid());;
		PmsCheckworks.setCreated(Date.valueOf(created));
		List<PmsCheckworks> list = CheckworkService.listCheckworkbyPmsCheckworks(PmsCheckworks);
		//model.addAttribute("list", list);
		Subtotal subtotal =Subtotal(PmsCheckworks);
		map.put("subtotal", subtotal);
		map.put("list", list);
		//session.setAttribute("created", created);
		try {
			resp.getWriter().println(JSONArray.toJSONString(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//return "checkwork_index";		
	}
	
	@RequestMapping("listAllCheckworkcreated")
	public void listAllCheckworkcreated(@RequestParam String created,@RequestParam String userid,Model model,HttpServletResponse resp){
		created=created+"-1";	
		Long id=Long.parseLong(userid);
		Map<String,Object> map=new HashMap<String,Object>();
		PmsCheckworks PmsCheckworks=new PmsCheckworks();
		PmsCheckworks.setUserid(id);
		PmsCheckworks.setCreated(Date.valueOf(created));
		List<PmsCheckworkandrealname> list = CheckworkService.listAllCheckworkbycreated(PmsCheckworks);
		map.put("list", list);
		Subtotal subtotal =Subtotal(PmsCheckworks);
		map.put("subtotal", subtotal);
		//model.addAttribute("list", list);
		
		try {
			resp.setCharacterEncoding("utf-8");
			resp.getWriter().print(JSONArray.toJSONString(map));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "checkwork_all";
	}
	/**
	 * @tags 查询所有用户用户名及用户id
	 */
	@RequestMapping("listusername2")
	public void listusername(@RequestParam String username,HttpServletResponse resp){
		List<PmsUsers> list = CheckworkService.listusername();
		List<PmsUsers> data=new ArrayList<PmsUsers>();
		for(PmsUsers PmsUsers:list){
			if(PmsUsers.getUsername().contains(username)){
				data.add(PmsUsers);
			}
		}
		try {
			resp.setCharacterEncoding("utf-8");
			resp.getWriter().println(JSONArray.toJSONString(data));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("listAllCheckworkbyusername")
	public String listAllCheckworkbyusername(@RequestParam String username,Model model,HttpServletResponse resp){
		if(username==""){
			return "redirect:listAllCheckwork";
		}else{
			PmsCheckworks PmsCheckworks=new PmsCheckworks();
			List<PmsUsers> userlist = CheckworkService.listusername();
			for(PmsUsers PmsUsers:userlist){
				if(PmsUsers.getUsername().equals(username)){
					PmsCheckworks.setUserid(PmsUsers.getUserid());
					String userid = String.valueOf(PmsUsers.getUserid());
					model.addAttribute("userid", userid);
					//map.put("userid",userid);
				}
			}
			Date created=new Date(Calendar.getInstance().getTimeInMillis());		
			PmsCheckworks.setCreated(created);
			List<PmsCheckworkandrealname> list = CheckworkService.listAllCheckworkbycreated(PmsCheckworks);
			//map.put("list", list);
			Subtotal subtotal =Subtotal(PmsCheckworks);
			model.addAttribute("subtotal",subtotal);
			model.addAttribute("list", list);
			return "checkwork_all";
		}		
	}

}
