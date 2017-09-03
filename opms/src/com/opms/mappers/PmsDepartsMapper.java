package com.opms.mappers;

import java.util.List;

import com.opms.entity.PmsDeparts;

public interface PmsDepartsMapper {

	List<PmsDeparts> listPmsDeparts();

	PmsDeparts getpmsDepartsById(Long departid);
   
	
	/**
	 * description:查找部门的总数
	 * @author liyanpeng
	 * @date 2017年7月28日
	 */
	public int countDeparts();
	
	/**
	 * 
	 * description:修改部门的名称和描述
	 * @author liyanpeng
	 * @date 2017年7月29日
	 */
	public int updateDepart(PmsDeparts pmsdepart);
	
	
	/**
	 * 
	 * description:根据部门的ID修改部门的状态
	 * @author liyanpeng
	 * @date 2017年7月29日
	 */
	public int updateDepartStatus(long departid,int status);
	/**
	 * 
	 * description:增加新部门
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	public int addDepartment(PmsDeparts pmsdepart);
	
	/**
	 * 
	 * description:按照部门名称和状态来查询部门
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	public List<PmsDeparts> searchDeparts(PmsDeparts pmsdepart);
	
	/**
	 * 
	 * description:查看此部门名称是否存在
	 * @author liyanpeng
	 * @date 2017年7月31日
	 */
	public int isExistName(String name);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月5日
	 */
	List<PmsDeparts> listPmsDeparts1();
	
	PmsDeparts getDeptByUserid(Long userid);
}