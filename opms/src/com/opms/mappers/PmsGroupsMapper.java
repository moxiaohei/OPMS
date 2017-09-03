package com.opms.mappers;

import java.util.List;

import com.opms.entity.PmsGroups;

public interface PmsGroupsMapper {

	/**
	 * description:查询所有的组
	 * @author liyanpeng
	 * @date 2017年7月31日
	 */
	List<PmsGroups> listPmsGroups();

	/**
	 * description:根据组的ID来查询
	 * @author liyanpeng
	 * @date 2017年7月31日
	 */
	PmsGroups getPmsGroupById(Long groupid);
   
	
	/**
	 * description:查找组的总数
	 * @author liyanpeng
	 * @date 2017年7月28日
	 */
	public int countGroups();
	
	/**
	 * 
	 * description:修改组的名称和描述
	 * @author liyanpeng
	 * @date 2017年7月29日
	 */
	public int updateGroup(PmsGroups pmsgroup);
	
	
	/**
	 * 
	 * description:增加新组
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	public int addGroup(PmsGroups pmsgroup);
	
	/**
	 * 
	 * description:按照组名称来查询部门
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	public List<PmsGroups> searchGroup(PmsGroups pmsgroup);
	
	/**
	 * 
	 * description:查看此组名称是否存在
	 * @author liyanpeng
	 * @date 2017年7月31日
	 */
	public int isExistGroupName(String name);
	
	/**
	 * 
	 * description:删除组
	 * @author liyanpeng
	 * @date 2017年7月31日
	 */
	public int deleteGroup(long groupid);
	
	/**
	 * 
	 * description:修改这条记录的修改时间
	 * @author liyanpeng
	 * @date 2017年7月31日
	 */
	public int updateGroupTime(long groupid,String changed);
}