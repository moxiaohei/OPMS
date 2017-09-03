package com.opms.mappers;

import com.opms.entity.PmsUsersProfile;

public interface PmsUsersProfileMapper {

	int countUser();

	PmsUsersProfile getPmsUsersProfileById(long userid);

	/**
	 * description:
	 * @author ChangZhiwei
	 * @date 2017年7月29日
	 */
	void updatePmsUsersProfile(PmsUsersProfile pmsUsersProfilePo);

	/**
	 * description:
	 * @author ChangZhiwei
	 * @date 2017年7月29日
	 */
	void addUsersProfile(PmsUsersProfile pmsUsersProfilePo);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月4日
	 */
	void updateDateLogin(Long userid);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月4日
	 */
	void updateDateLasted(PmsUsersProfile pms);
  
}