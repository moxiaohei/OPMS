package com.opms.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opms.entity.PmsCheckworkandrealname;
import com.opms.entity.PmsCheckworks;
import com.opms.entity.PmsUsers;
import com.opms.entity.Subtotal;
import com.opms.service.CheckworkService;
import com.opms.mappers.PmsCheckworksMapper;

/**
 * @author sunwenke
 * @date 2017年7月27日上午10:37:27
 * @tags 考勤表service层实现
 */
@Service
public class CheckworkServiceImpl implements CheckworkService{
	@Autowired
	private PmsCheckworksMapper PmsCheckworksMapper;
	/**
	 * @tags　根据用户id查询考勤表
	 */
	@Override
	public List<PmsCheckworks> listCheckworkbyPmsCheckworks(PmsCheckworks PmsCheckworks) {
		List<PmsCheckworks> list=PmsCheckworksMapper.listCheckworkbyPmsCheckworks(PmsCheckworks);
		return list;
	}
	/**
	 * @tags 查询所有用户的考勤 
	 */
	@Override
	public List<PmsCheckworkandrealname> listAllCheckwork(PmsCheckworks PmsCheckworks) {
		List<PmsCheckworkandrealname> list = PmsCheckworksMapper.listAllCheckwork(PmsCheckworks);
		return list;
	}

	/* 
	 * @tags 添加用户考勤表
	 */
	@Override
	public void insertCheckwork(PmsCheckworks PmsCheckworks) {
		PmsCheckworksMapper.insertCheckwork(PmsCheckworks);
	}
	/* 
	 * @tags跟据打卡时间查询今天打卡次数
	 */
	@Override
	public List<PmsCheckworks> countCheckwork(PmsCheckworks PmsCheckworks) {
		List<PmsCheckworks> list=PmsCheckworksMapper.countCheckwork(PmsCheckworks);
		return list;
	}
	/* 
	 * @tags查询本月正常早退迟到次数
	 */
	@Override
	public List<Subtotal> typecountCheckwork(PmsCheckworks PmsCheckworks) {
		List<Subtotal> list = PmsCheckworksMapper.typecountCheckwork(PmsCheckworks);
		return list;
	}
	/* 
	 * @tags 查询本月出勤天数
	 */
	@Override
	public float workdays(PmsCheckworks PmsCheckworks) {
		float workdays = PmsCheckworksMapper.workdays(PmsCheckworks);
		return workdays;
	}
	/* 
	 * @tags 根据userid(用户id)和(type)类型查询考勤表
	 */
	@Override
	public List<PmsCheckworks> listCheckworkbytype(PmsCheckworks PmsCheckworks) {
		List<PmsCheckworks> list = PmsCheckworksMapper.listCheckworkbytype(PmsCheckworks);
		return list;
	}
	/* 
	 * @tags根据用户id和打卡日期的年月查询
	 */
	@Override
	public List<PmsCheckworks> listCheckworkbycreated(PmsCheckworks PmsCheckworks) {
		List<PmsCheckworks> list =PmsCheckworksMapper.listCheckworkbycreated(PmsCheckworks);
		return list;
	}
	/* 
	 * @tags根据打卡日期的年月查询全部用户考勤
	 */
	@Override
	public List<PmsCheckworkandrealname> listAllCheckworkbycreated(PmsCheckworks PmsCheckworks) {
		List<PmsCheckworkandrealname> list = PmsCheckworksMapper.listAllCheckworkbycreated(PmsCheckworks);
		return list;
	}
	/* 
	 * @tags 查询所有用户用户名及用户id
	 */
	@Override
	public List<PmsUsers> listusername() {
		List<PmsUsers> list = PmsCheckworksMapper.listusername();
		return list;
	}

}
