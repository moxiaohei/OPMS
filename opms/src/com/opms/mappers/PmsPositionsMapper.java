package com.opms.mappers;

import java.util.List;

import com.opms.entity.PmsPermissions;
import com.opms.entity.PmsPositions;

public interface PmsPositionsMapper {

	List<PmsPositions> listPmsPositions();

	PmsPositions getPmsPositionsById(Long positionid);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月3日
	 */
	void updatePosition(PmsPositions pmsPositions);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月3日
	 */
	void addPosition(PmsPositions pmsPositions);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月3日
	 */
	List<PmsPositions> searchPositionform(PmsPositions pmsPositions);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月3日
	 */
	int updateStatusPosition(PmsPositions pmsPosition);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月3日
	 */
	List<PmsPermissions> listPermissionManage();

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月3日
	 */
	int deletePermission(long ids);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月3日
	 */
	PmsPermissions getEditPermissionManage(long permissionid);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月3日
	 */
	List<PmsPermissions> listPermissionParent();

	
	/**
	 * 
	 * description:
	 * @author liyanpeng
	 * @date 2017年8月3日
	 */
	List<PmsPermissions> listPermissionManageSon(long permissionid);
	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月3日
	 */
	List<PmsPermissions> getPermissionEname();

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月3日
	 */
	List<PmsPermissions> searchPermission(PmsPermissions pmsPermissions);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月3日
	 */
	void updatePermission(PmsPermissions pmsPermissions);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月3日
	 */
	void addPermission(PmsPermissions pmsPermissions);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月5日
	 */
	List<PmsPermissions> listPmsPermissionsEname(Long userid);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月5日
	 */
	List<PmsPositions> listPmsPositions1();
   
}