package com.opms.service;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.ui.Model;

import com.opms.entity.PmsDeparts;
import com.opms.entity.PmsGroups;
import com.opms.entity.PmsGroupsPermission;
import com.opms.entity.PmsGroupsUser;
import com.opms.entity.PmsNotices;
import com.opms.entity.PmsPermissions;
import com.opms.entity.PmsPositions;
import com.opms.entity.PmsUserPms;
import com.opms.entity.PmsUsers;
import com.opms.entity.PmsUsersProfile;
import com.opms.mappers.PmsGroupsMapper;

public interface OrganizationService {

	/**
	 * 
	 * description:根据用户名查找用户信息
	 * @author liyanpeng
	 * @date 2017年7月28日
	 */
	public PmsUsers getPmsUsersByUsername(String username);
	
	/**
	 * description:查找部门的总数
	 * @author liyanpeng
	 * @date 2017年7月28日
	 */
	public int countDeparts();
	
	
	/**
	 * 
	 * description:
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
	 * description:根据部门名称和状态查询部门
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
	 * 
	 * description:删除公告
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	public int deleteNotice(long noticeid);
	
	
	
	
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
	List<PmsUserPms> listPmsUsersProfile();

	int countUser();
	
	List<PmsDeparts> listPmsDeparts();

	List<PmsPositions> listPmsPositions();


	PmsUsers getPmsUsersById(long userid);
	
	PmsUsersProfile getPmsUsersProfileById(long userid);

	PmsDeparts getpmsDepartsById(Long departid);

	PmsPositions getPmsPositionsById(Long positionid);

	int updatePmsUser(PmsUsers pmsUsersPo,PmsUsersProfile pmsUsersProfilePo);

	int updatePms_Users(long userid, int status);
	

	List<PmsUserPms> searchUser(PmsUsers pmsUsersPo);

	int addUserPmsUser(PmsUsers pmsUsersPo, PmsUsersProfile pmsUsersProfilePo);

	

	/**
	 * description
	 * @author ChangZhiwei
	 * @param uid 
	 * @time 2017年7月30日
	 */
	int isUsername(String username, long uid);

	/**
	 * description
	 * @author ChangZhiwei
	 * @param pid 
	 * @time 2017年7月30日
	 */
	int isPositionname(String positionname, long pid);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年7月30日
	 */
	int updatePosition(PmsPositions pmsPositions);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年7月30日
	 */
	int addPosition(PmsPositions pmsPositions);

	/**
	 * description
	 * @author ChangZhiwei
	 * @return 
	 * @time 2017年7月30日
	 */
	List<PmsPositions> searchPositionform(PmsPositions pmsPositions);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年7月30日
	 */
	int updateStatusPosition(long positionid, int status);

	

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年7月31日
	 */
	List<PmsPermissions> listPermissionManage();

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年7月31日
	 */
	int deletePermission(long ids);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年7月31日
	 */
	PmsPermissions getEditPermissionManage(long permissionid);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月2日
	 */
	List<PmsPermissions> listPermissionParent();

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月2日
	 */
	int isPermissionName(String ename, long ppid);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月2日
	 */
	List<PmsPermissions> searchPermission(PmsPermissions pmsPermissions);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月2日
	 */
	int updatePermission(PmsPermissions pmsPermissions);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月2日
	 */
	int addPermission(PmsPermissions pmsPermissions);
	public int pageSize(int counter);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月4日
	 */
	public void updateDateLogin(Long userid);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月4日
	 */
	public void updateDateLasted(Long userid);

	/**
	 * description
	 * @author ChangZhiwei
	 * @param user 
	 * @time 2017年8月4日
	 */
	public int updatePasswords(PmsUsers pmsUser, PmsUsers user);

	/**
	 * 
	 * description:
	 * @author liyanpeng
	 * @date 2017年8月4日
	 */
	public int deleteGroupPermissionByGroupid(long groupid);
	
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
	 * 
	 * description:
	 * @author liyanpeng
	 * @date 2017年8月3日
	 */
	List<PmsPermissions> listPermissionManageSon(long parentid);
	
	
	
	/**
	 * description:删除组成员
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	public int deleteGroupUser(long id);

	/**
	 * description
	 * @author ChangZhiwei
	 * @param long1 
	 * @time 2017年8月5日
	 */
	public List<PmsPermissions> listPmsPermissionsEname(Long userid);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月5日
	 */
	public void addPositionManage();
	
	/**
	 * 
	 * description:增加新组成员
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	public int addGroupUser(String username,long id,long groupid);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月5日
	 */
	public List<PmsDeparts> listPmsDeparts1();

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月5日
	 */
	public List<PmsPositions> listPmsPositions1();

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月5日
	 */
	public List<PmsPositions> listPmsPositions2();

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月5日
	 */
	public List<PmsPermissions> listPermissionParent1();

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月6日
	 */
	public long toAddDepartment();

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月6日
	 */
	public long toAddNotice();

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月6日
	 */
	public long toAddGroup();

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月6日
	 */
	public long toAddGroupUser();

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月6日
	 */
	public PmsPositions getPmsPositionsById1(Long positionid);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月6日
	 */
	public List<PmsUserPms> listPmsUsersProfile1();

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月6日
	 */
	public PmsGroups getPmsGroupById1(long groupid);

	/**
	 * description
	 * @author ChangZhiwei
	 * @time 2017年8月6日
	 */
	public PmsDeparts getpmsDepartsById1(long departid);
	
	
	public List<PmsUserPms> listUsername();
	
}
