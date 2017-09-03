package com.opms.mappers;

import java.util.List;


import com.opms.entity.PmsNotices;
/**
 * 
 * description:公告表增删改查的接口
 * @author liyanpeng
 * @date 2017年7月30日
 */
public interface PmsNoticesMapper {

	
	/**
	 * description:返回所有的公告信息
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	List<PmsNotices> listPmsNotices();

	/**
	 * description:
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	PmsNotices getpmsNoticesById(Long noticeid);
   
	
	/**
	 * description:查找部门的总数
	 * @author liyanpeng
	 * @date 2017年7月28日
	 */
	public int countNotices();
	
	/**
	 * 
	 * description:修改部门的名称和描述
	 * @author liyanpeng
	 * @date 2017年7月29日
	 */
	public int updateNotices(PmsNotices pmsnotice);
	
	
	/**
	 * 
	 * description:根据部门的ID修改部门的状态
	 * @author liyanpeng
	 * @date 2017年7月29日
	 */
	public int updateNoticesStatus(long noticeid,int status);
	/**
	 * 
	 * description:增加新部门
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	public int addNotices(PmsNotices pmsnotice);
	
	/**
	 * 
	 * description:按照部门名称和状态来查询部门
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	public List<PmsNotices> searchNotices(PmsNotices pmsnotice);
	
	
	/**
	 * description:查找是否存在此标题，若存在则返回1，不存在返回0
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	public int isExistTitle(String title);
	
	
	
	/**
	 * description:删除公告
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	public int deleteNotice(long noticeid);
}