package com.opms.mappers;

import java.util.List;

import com.opms.entity.PmsGroupsUser;
/**
 * 
 * description:组成员表增删改查的接口
 * @author liyanpeng
 * @date 2017年7月30日
 */
public interface PmsGroupsUserMapper {

	
	/**
	 * description:返回所有的组成员信息
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	List<PmsGroupsUser> listPmsGroupUser(long groupid);

	/**
	 * description:根据组成员ID查询信息
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	PmsGroupsUser getpmsGroupUserById(Long id);
   
	
	/**
	 * 
	 * description:增加新组成员
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	public int addGroupUser(PmsGroupsUser pmsgroupuser);
	
	
	
	
	
	/**
	 * description:删除组成员
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	public int deleteGroupUser(long id);
	
	
	/**
	 * 
	 * description:
	 * @author liyanpeng
	 * @date 2017年8月5日
	 */
	public int isSameGroupsUser(long groupid,long userid);
	
	
	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月6日
	 */
	public int deleteGroupUserBygroupid(long groupid);
}