package com.opms.mappers;

import java.util.List;

import com.opms.entity.PmsGroupsPermission;
/**
 * 
 * description:组成员表增删改查的接口
 * @author liyanpeng
 * @date 2017年7月30日
 */
public interface PmsGroupsPermissionMapper {

	
	/**
	 * description:返回所有的组成员信息
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	List<Long> listGroupsPermission(long groupid);

	/**
	 * 
	 * description:增加新组成员
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	public int addGroupsPermission(PmsGroupsPermission pmsgrouppermission);
	
	
	
	
	
	/**
	 * description:删除组成员
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	public int deleteGroupsPermission(long groupid,long permissionid);
	
	public int deleteGroupPermissionByGroupid(long groupid);
}