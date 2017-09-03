package com.opms.mappers;

import java.util.List;

import com.opms.entity.PmsUserPms;
import com.opms.entity.PmsUsers;

public interface PmsUserPmsMapper {

	List<PmsUserPms> listPmsUserPms();
	
	List<PmsUserPms> listUsername();

	PmsUserPms getPmsUsersProfileById(long userid);

	/**
	 * description:
	 * @author ChangZhiwei
	 * @date 2017年7月29日
	 */
	List<PmsUserPms> searchUser(PmsUsers pmsUsersPo);
    
}