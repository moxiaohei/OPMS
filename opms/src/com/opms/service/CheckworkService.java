package com.opms.service;

import java.sql.Date;
import java.util.List;

import com.opms.entity.PmsCheckworks;
import com.opms.entity.PmsUsers;
import com.opms.entity.Subtotal;
import com.opms.entity.PmsCheckworkandrealname;

/**
 * @author sunwenke
 * @date 2017年7月27日上午10:38:15
 * @tags 考勤表Service层接口
 */
public interface CheckworkService {
	/**
	 * @tags　根据用户id查询考勤表
	 */
	List<PmsCheckworks> listCheckworkbyPmsCheckworks(PmsCheckworks PmsCheckworks);
	/**
	 * @tags查询全部用户考勤
	 */
	List<PmsCheckworkandrealname> listAllCheckwork(PmsCheckworks PmsCheckworks);
	
	/**
	 * @tags添加用户
	 */
	void insertCheckwork(PmsCheckworks PmsCheckworks);
	/**
	 * @tags今日打卡次数
	 */
	List<PmsCheckworks> countCheckwork(PmsCheckworks PmsCheckworks);
	/**
	 * @tags查询本月正常早退迟到的次数
	 */
	List<Subtotal> typecountCheckwork(PmsCheckworks PmsCheckworks);
	/**
	 * @tags查询本月出勤天数
	 */
	float workdays(PmsCheckworks PmsCheckworks);
	/**
	 * @tags根据用户id和考勤状态查询
	 */
	List<PmsCheckworks> listCheckworkbytype(PmsCheckworks PmsCheckworks);	
	/**
	 * @tags根据用户id和打卡日期的年月查询
	 */
	List<PmsCheckworks> listCheckworkbycreated(PmsCheckworks PmsCheckworks);
	/**
	 * @tags根据打卡日期的年月查询全部用户考勤
	 */
	List<PmsCheckworkandrealname> listAllCheckworkbycreated(PmsCheckworks PmsCheckworks);
	
	/**
	 * @tags 获取全部用户的用户名和用户id
	 */
	List<PmsUsers> listusername();

}
