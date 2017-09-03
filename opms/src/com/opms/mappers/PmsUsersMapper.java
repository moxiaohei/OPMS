package com.opms.mappers;

import java.util.List;

import com.opms.entity.PmsUsers;

public interface PmsUsersMapper {
	PmsUsers getPmsUsersById(long userid);
	/**
	 * 
	 * description:根据用户名查找用户信息
	 * @author ChangZhiwei
	 * @date 2017年7月28日
	 */
	public PmsUsers getPmsUsersByUsername(String username);
	/**
	 * description:
	 * @author ChangZhiwei
	 * @date 2017年7月29日
	 */
	int updatePms_Users(PmsUsers pmsUsers);
	/**
	 * description:
	 * @author ChangZhiwei
	 * @date 2017年7月29日
	 */
	void updatePmsUser(PmsUsers pmsUsersPo);
	/**
	 * description:
	 * @author ChangZhiwei
	 * @date 2017年7月29日
	 */
	void addUserPmsUser(PmsUsers pmsUsersPo);
	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月3日
	 */
	List<PmsUsers> listPmsUsers();
	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月4日
	 */
	int updatePasswords(PmsUsers user);
	
}