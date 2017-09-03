package com.opms.service.impl;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opms.control.MyException;
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
import com.opms.mappers.PmsDepartsMapper;
import com.opms.mappers.PmsGroupsMapper;
import com.opms.mappers.PmsGroupsPermissionMapper;
import com.opms.mappers.PmsGroupsUserMapper;
import com.opms.mappers.PmsNoticesMapper;
import com.opms.mappers.PmsPositionsMapper;
import com.opms.mappers.PmsUserPmsMapper;
import com.opms.mappers.PmsUsersMapper;
import com.opms.mappers.PmsUsersProfileMapper;
import com.opms.service.OrganizationService;
import com.opms.unti.IntDate;
import com.opms.unti.RandomTest;
import com.opms.unti.StringDate;


@Service
public class OrganizationServiceImpl  implements OrganizationService{
	@Autowired
	private PmsUsersProfileMapper pmsUsersProfileMapper;
	@Autowired
	private PmsUsersMapper pmsUsersMapper;
	@Autowired
	private PmsDepartsMapper pmsDepartsMapper;
	@Autowired
	private PmsPositionsMapper pmsPositionsMapper;
	@Autowired
	private PmsUserPmsMapper pmsUserPmsMapper;
	@Autowired
	private PmsNoticesMapper pmsNoticesMapper;
	@Autowired
	private PmsGroupsMapper pmsGroupMapper;
	@Autowired
	private PmsGroupsPermissionMapper pmsGroupsPermissionMapper;
	@Autowired
	private PmsGroupsUserMapper pmsGroupsUserMapper;
	int id=1;
	
	
	
	/**
	 * 
	 * description:查看此部门名称是否存在
	 * @author liyanpeng
	 * @date 2017年7月31日
	 */
	@Override
	public int isExistName(String name){
		return  pmsDepartsMapper.isExistName(name);
	}
	
	/**
	 * description:根据用户名查找用户信息
	 * @author liyanpeng
	 * @date 2017年7月28日
	 */
	@Override
	public PmsUsers getPmsUsersByUsername(String username) {
		PmsUsers pms = pmsUsersMapper.getPmsUsersByUsername(username);
		
		return pms;
	}
	/**
	 * description:查找部门的总数
	 * @author liyanpeng
	 * @date 2017年7月28日
	 */
	@RequiresRoles("department-manage")
	@Override
	public int countDeparts() {
		return pmsDepartsMapper.countDeparts();
	}
	
	
	/**
	 * description:修改部门
	 * @author liyanpeng
	 * @date 2017年7月29日
	 */
	@Override
	public int updateDepart(PmsDeparts pmsdepart) {
		PmsDeparts depart= pmsDepartsMapper.getpmsDepartsById(pmsdepart.getDepartid());
		boolean isSameName=depart.getName().equals(pmsdepart.getName());
		if(isSameName||(!isSameName&&pmsDepartsMapper.isExistName(pmsdepart.getName())<1)){
			return pmsDepartsMapper.updateDepart(pmsdepart);
		}else
			return -1;
		
	}
	/**
	 * description:根据部门的ID修改部门的状态
	 * @author liyanpeng
	 * @date 2017年7月29日
	 */
	@Override
	public int updateDepartStatus(long departid, int status) {
		return pmsDepartsMapper.updateDepartStatus(departid, status);
	}
	
	/**
	 * description:增加新部门
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@Override
	public int addDepartment(PmsDeparts pmsdepart) {
		int flag=pmsDepartsMapper.isExistName(pmsdepart.getName());
		if(flag<1)
			return pmsDepartsMapper.addDepartment(pmsdepart);
		else
			return -1;
	}
	/**
	 * 
	 * description:根据部门的名称和状态来查找部门
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	
	public List<PmsDeparts> searchDeparts(PmsDeparts pmsdepart){
		return pmsDepartsMapper.searchDeparts(pmsdepart);
	}
	/**
	 * description:获取公告表中的所有的公告
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@RequiresRoles("notice-manage")
	@Override
	public List<PmsNotices> listPmsNotices() {
		
		return pmsNoticesMapper.listPmsNotices();
	}
	/**
	 * description:根据公告的ID来查找公告
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@RequiresRoles("notice-edit")
	@Override
	public PmsNotices getpmsNoticesById(Long noticeid) {
		
		return pmsNoticesMapper.getpmsNoticesById(noticeid);
	}
	/**
	 * description:查看公告表的总记录数
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@Override
	public int countNotices() {
		return pmsNoticesMapper.countNotices();
	}
	/**
	 * description:修改公告标题和内容
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@Override
	public int updateNotices(PmsNotices pmsnotice) {
		PmsNotices notice= pmsNoticesMapper.getpmsNoticesById(pmsnotice.getNoticeid());
		boolean isSameTitle=notice.getTitle().equals(pmsnotice.getTitle());
		if(isSameTitle||(!isSameTitle&&pmsNoticesMapper.isExistTitle(pmsnotice.getTitle())<1)){
			return pmsNoticesMapper.updateNotices(pmsnotice);
		}else
			return -1;
	}
	/**
	 * description:
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@Override
	public int updateNoticesStatus(long noticeid, int status) {
		return pmsNoticesMapper.updateNoticesStatus(noticeid, status);
	}
	/**
	 * description:增加公告
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@Override
	public int addNotices(PmsNotices pmsnotice) {
		java.util.Date date=new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		pmsnotice.setCreated(sdf.format(date));
		pmsnotice.setStatus(1);
		int flag=pmsNoticesMapper.isExistTitle(pmsnotice.getTitle());
		if(flag<1)
			return pmsNoticesMapper.addNotices(pmsnotice);
		else
			return -1;
	}
	/**
	 * description:按照状态和标题查找公告
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@Override
	public List<PmsNotices> searchNotices(PmsNotices pmsnotice) {
		
		return pmsNoticesMapper.searchNotices(pmsnotice);
	}
	/**
	 * description:查看此标题是否存在
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@Override
	public int isExistTitle(String title) {
		
		return pmsNoticesMapper.isExistTitle(title);
	}
	/**
	 * description:删除公告
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@RequiresRoles("notice-delete")
	@Override
	public int deleteNotice(long noticeid) {
		return pmsNoticesMapper.deleteNotice(noticeid);
	}
	/**
	 * description:获取所有组的list集合
	 * @author liyanpeng
	 * @date 2017年7月31日
	 */
	@RequiresRoles("group-manage")
	@Override
	public List<PmsGroups> listPmsGroups() {
		return pmsGroupMapper.listPmsGroups();
	}
	/**
	 * description:根据组的ID来获取组记录
	 * @author liyanpeng
	 * @date 2017年7月31日
	 */
	
	@Override
	public PmsGroups getPmsGroupById(Long groupid) {
		return pmsGroupMapper.getPmsGroupById(groupid);
	}
	@RequiresRoles("group-edit")
	@Override
	public PmsGroups getPmsGroupById1(long groupid) {
		return pmsGroupMapper.getPmsGroupById(groupid);
	}
	/**
	 * description:查看所有组的个数
	 * @author liyanpeng
	 * @date 2017年7月31日
	 */
	@Override
	public int countGroups() {
		return pmsGroupMapper.countGroups();
	}
	/**
	 * description:修改此条组记录的
	 * @author liyanpeng
	 * @date 2017年7月31日
	 */
	@Override
	public int updateGroup(PmsGroups pmsgroup) {
		String changetime=new StringDate().getNowStringDate();
		pmsGroupMapper.updateGroupTime(pmsgroup.getGroupid(), changetime);
		PmsGroups group= pmsGroupMapper.getPmsGroupById(pmsgroup.getGroupid());
		boolean isSameName=group.getName().equals(pmsgroup.getName());
		if(isSameName||(!isSameName&&pmsGroupMapper.isExistGroupName(pmsgroup.getName())<1)){
			return pmsGroupMapper.updateGroup(pmsgroup);
		}else
			return -1;
	}
	/**
	 * description:添加一条新的组记录
	 * @author liyanpeng
	 * @date 2017年7月31日
	 */
	@Override
	public int addGroup(PmsGroups pmsgroup) {
		String createtime=new StringDate().getNowStringDate();
		pmsgroup.setCreated(createtime);
		pmsGroupMapper.updateGroupTime(pmsgroup.getGroupid(), createtime);
		int flag=pmsGroupMapper.isExistGroupName(pmsgroup.getName());
		if(flag<1)
			return pmsGroupMapper.addGroup(pmsgroup);
		else
			return -1;
	}
	/**
	 * description:根据所提供的组的名称来查询符合条件的组
	 * @author liyanpeng
	 * @date 2017年7月31日
	 */
	@Override
	public List<PmsGroups> searchGroup(PmsGroups pmsgroup) {
		return pmsGroupMapper.searchGroup(pmsgroup);
	}
	/**
	 * description:查看是否存在此组名称
	 * @author liyanpeng
	 * @date 2017年7月31日
	 */
	@Override
	public int isExistGroupName(String name) {
		return pmsGroupMapper.isExistGroupName(name);
	}
	/**
	 * description:根据组的ID删除组记录
	 * @author liyanpeng
	 * @date 2017年7月31日
	 */
	@RequiresRoles("group-delete")
	@Override
	public int deleteGroup(long groupid) {
		pmsGroupsPermissionMapper.deleteGroupPermissionByGroupid(groupid);
		pmsGroupsUserMapper.deleteGroupUserBygroupid(groupid);
		return pmsGroupMapper.deleteGroup(groupid);
	}
	/**
	 * description:更新组记录的修改时间
	 * @author liyanpeng
	 * @date 2017年7月31日
	 */
	@Override
	public int updateGroupTime(long groupid, String changed) {
		return pmsGroupMapper.updateGroupTime(groupid, changed);
	}
	@Override
	public List<PmsUserPms> listPmsUsersProfile() {
		List<PmsUserPms> listPmsUserPms=pmsUserPmsMapper.listPmsUserPms();
		return listPmsUserPms;
	}
	@Override
	public List<PmsUserPms> listUsername(){
		return pmsUserPmsMapper.listUsername();
	}
	@Override
	public int countUser() {
		int counter=pmsUsersProfileMapper.countUser();
		return counter;
	}
	
	@Override
	public List<PmsDeparts> listPmsDeparts() {
		List<PmsDeparts> listPmsDeparts=pmsDepartsMapper.listPmsDeparts();
		return listPmsDeparts;
	}
	@RequiresRoles("position-manage")
	@Override
	public List<PmsPositions> listPmsPositions() {
		List<PmsPositions>listPmsPositions=pmsPositionsMapper.listPmsPositions();
		return listPmsPositions;
	}
	@Override
	public PmsUsers getPmsUsersById(long userid) {
		PmsUsers pmsUsers=pmsUsersMapper.getPmsUsersById(userid);
		return pmsUsers;
	}
	@RequiresRoles("user-edit")
	@Override
	public PmsUsersProfile getPmsUsersProfileById(long userid) {
		PmsUsersProfile pmsUsersProfile=pmsUsersProfileMapper.getPmsUsersProfileById(userid);
		return pmsUsersProfile;
	}
	@Override
	public PmsDeparts getpmsDepartsById(Long departid) {
		PmsDeparts pmsDeparts=pmsDepartsMapper.getpmsDepartsById(departid);
		return pmsDeparts;
	}
	@RequiresRoles("department-edit")
	@Override
	public PmsDeparts getpmsDepartsById1(long departid) {
		PmsDeparts pmsDeparts=pmsDepartsMapper.getpmsDepartsById(departid);
		return pmsDeparts;
	}
	@Override
	public PmsPositions getPmsPositionsById(Long positionid) {
		PmsPositions pmsPositions=pmsPositionsMapper.getPmsPositionsById(positionid);
		return pmsPositions;
	}
	@Override
	public int updatePms_Users(long userid, int status) {
		PmsUsers pmsUsers=new PmsUsers();
		pmsUsers.setStatus(status);
		pmsUsers.setUserid(userid);
		int flag=pmsUsersMapper.updatePms_Users(pmsUsers);
		return flag;
	}
	@Override
	public int updatePmsUser(PmsUsers pmsUsersPo,PmsUsersProfile pmsUsersProfilePo) {
		
		List<PmsUsers> listPmsUser=pmsUsersMapper.listPmsUsers();
		
		for (PmsUsers pmsUsers : listPmsUser) {
			if(pmsUsers.getUserid().equals(pmsUsersPo.getUserid())){
				continue;
			}
			if(pmsUsers.getUsername().equals(pmsUsersPo.getUsername())){
				return 0;
			}
		}
		
		if(pmsUsersPo.getPassword().equals("")){
			pmsUsersPo.setPassword(pmsUsersPo.getAvatar());
		}else{
			String hashAlgorithmName = "MD5";
			Object salt = ByteSource.Util.bytes(pmsUsersPo.getUsername());
			int hashIterations = 1024;
			String result = new SimpleHash(hashAlgorithmName, pmsUsersPo.getPassword(), salt, hashIterations).toString();
			pmsUsersPo.setPassword(result);
		}
		pmsUsersMapper.updatePmsUser(pmsUsersPo);
		pmsUsersProfileMapper.updatePmsUsersProfile(pmsUsersProfilePo);
		return 1;
	}

	@Override
	public List<PmsUserPms> searchUser(PmsUsers pmsUsersPo) {
			List<PmsUserPms> listPmsUserPms=pmsUserPmsMapper.searchUser(pmsUsersPo);
			return listPmsUserPms;
	}
	@Override
	public int addUserPmsUser(PmsUsers pmsUsersPo,PmsUsersProfile pmsUsersProfilePo) {
		List<PmsUsers> listPmsUserPms=pmsUsersMapper.listPmsUsers();
		for (PmsUsers pmsUsers : listPmsUserPms) {
			if(pmsUsers.getUsername().equals(pmsUsersPo.getUsername())){
				return 0;
			}
		}
		if(pmsUsersPo.getPassword().equals("")){
			pmsUsersPo.setPassword("000000");
		}
		long userid=RandomTest.random();
		String hashAlgorithmName = "MD5";
		Object salt = ByteSource.Util.bytes(pmsUsersPo.getUsername());
		int hashIterations = 1024;
		String result = new SimpleHash(hashAlgorithmName, pmsUsersPo.getPassword(), salt, hashIterations).toString();
		pmsUsersPo.setStatus(id);
        pmsUsersPo.setUserid(userid);
        pmsUsersPo.setPassword(result);
        pmsUsersProfilePo.setUser_id(userid);
        pmsUsersProfilePo.setLognum(0);
        pmsUsersMapper.addUserPmsUser(pmsUsersPo);
        pmsUsersProfileMapper.addUsersProfile(pmsUsersProfilePo);
		return 1;
	}
	@Override
	public int isUsername(String username,long uid) {
		List<PmsUsers> listPmsUserPms=pmsUsersMapper.listPmsUsers();
			for (PmsUsers pmsUsers : listPmsUserPms) {
			if(uid==pmsUsers.getUserid()) continue;
			if(username.equals(pmsUsers.getUsername())){
				return 1;
			}
		}
		
		return 0;
	}
	@Override
	public int isPositionname(String positionname,long pid) {
		List<PmsPositions> listPmsPositions=pmsPositionsMapper.listPmsPositions();
		for (PmsPositions pmsPositions : listPmsPositions) {
			if(pmsPositions.getPositionid()==pid){
				continue;
			}
			if(positionname.equals(pmsPositions.getName())){
				return 1;
			}
		}
		
		return 0;
	}
	
	@Override
	public int updatePosition(PmsPositions pmsPositions) {
		List<PmsPositions>listPmsPositions=pmsPositionsMapper.listPmsPositions();
		for (PmsPositions pmsPositions2 : listPmsPositions) {
			if(pmsPositions.getPositionid()==pmsPositions2.getPositionid()){
				continue;
			}
			if(pmsPositions.getName().equals(pmsPositions2.getName())){
				return 0;
			}
		}
		pmsPositions.setStatus(id);
		pmsPositionsMapper.updatePosition(pmsPositions);
		return 1;
	}
	
	@Override
	public int addPosition(PmsPositions pmsPositions) {
		List<PmsPositions>listPmsPositions=pmsPositionsMapper.listPmsPositions();
		for (PmsPositions pmsPositions2 : listPmsPositions) {
			if(pmsPositions2.getName().equals(pmsPositions.getName())){
				return 0;
			}
		}
		long positionid = RandomTest.random();
		pmsPositions.setPositionid(positionid);
		pmsPositions.setStatus(id);
		pmsPositionsMapper.addPosition(pmsPositions);
		return 1;
	}
	
	@Override
	public List<PmsPositions> searchPositionform(PmsPositions pmsPositions) {
		List<PmsPositions> listPmsPositions=pmsPositionsMapper.searchPositionform(pmsPositions);
		return listPmsPositions;
	}
	
	@Override
	public int updateStatusPosition(long positionid, int status) {
		PmsPositions pmsPosition=new PmsPositions();
		pmsPosition.setStatus(status);
		pmsPosition.setPositionid(positionid);
		int flag=pmsPositionsMapper.updateStatusPosition(pmsPosition);
		return flag;
	}
	@RequiresRoles("permission-manage")
	@Override
	public List<PmsPermissions> listPermissionManage() {
		List<PmsPermissions> listPermission=pmsPositionsMapper.listPermissionManage();
		return listPermission;
	}
	@RequiresRoles("permission-delete")
	@Override
	public int deletePermission(long ids) {
		int flag=pmsPositionsMapper.deletePermission(ids);
		return flag;
	}
	@RequiresRoles("permission-edit")
	@Override
	public PmsPermissions getEditPermissionManage(long permissionid) {
		PmsPermissions pmsPermissions=pmsPositionsMapper.getEditPermissionManage(permissionid);
		return pmsPermissions;
	}
	
	@Override
	public List<PmsPermissions> listPermissionParent() {
		List<PmsPermissions> listPermissionParent=pmsPositionsMapper.listPermissionParent();
		return listPermissionParent;
	}
	
	@Override
	public int isPermissionName(String ename, long ppid) {
		List<PmsPermissions> listPermissionEname=pmsPositionsMapper.getPermissionEname();
		for (PmsPermissions pmsPermissions : listPermissionEname) {
			if(pmsPermissions.getPermissionid()==ppid){
				continue;
			}
			if(pmsPermissions.getEname().equals(ename)){
				return 1;
			}
		}
		return 0;
	}
	
	@Override
	public List<PmsPermissions> searchPermission(PmsPermissions pmsPermissions) {
		List<PmsPermissions> listPermission=pmsPositionsMapper.searchPermission(pmsPermissions);
		return listPermission;
	}
	
	@Override
	public int updatePermission(PmsPermissions pmsPermissions) {
		List<PmsPermissions> listPermission=pmsPositionsMapper.listPermissionManage();
		for (PmsPermissions pmsPermissions2 : listPermission) {
			if(pmsPermissions.getPermissionid().equals(pmsPermissions2.getPermissionid())){
				continue;
			}
			if(pmsPermissions.getEname().equals(pmsPermissions2.getEname())){
				return 0;
			}
		}
		pmsPositionsMapper.updatePermission(pmsPermissions);
		return 1;
	}
	
	@Override
	public int addPermission(PmsPermissions pmsPermissions) {
		List<PmsPermissions> listPermission=pmsPositionsMapper.listPermissionManage();
		for (PmsPermissions pmsPermissions2 : listPermission) {
			if(pmsPermissions.getEname().equals(pmsPermissions2.getEname())){
				return 0;
			}
		}
		long id=RandomTest.random();
		pmsPermissions.setPermissionid(id);
		pmsPositionsMapper.addPermission(pmsPermissions);
		return 1;
	}
	
	@Override
	public int pageSize(int counter){
		int page=0;
		if(counter%5==0){
			page=counter/5;
		}else{
			page=counter/5+1;
		}
		return page;
	}

	@Override
	public void updateDateLogin(Long userid) {
		pmsUsersProfileMapper.updateDateLogin(userid);
	}

	@Override
	public void updateDateLasted(Long userid) {
		PmsUsersProfile pms=new PmsUsersProfile();
		pms.setLasted(new Date());
		pms.setUser_id(userid);
		pmsUsersProfileMapper.updateDateLasted(pms);
	}

	@Override
	public int updatePasswords(PmsUsers pmsUser, PmsUsers user) {
		String hashAlgorithmName = "MD5";
		Object salt = ByteSource.Util.bytes(user.getUsername());
		int hashIterations = 1024;
		String result = new SimpleHash(hashAlgorithmName, pmsUser.getOldpwd(), salt, hashIterations).toString();
		if(!(result.equals(user.getPassword()))){
			return 0;
		}
		String result1 = new SimpleHash(hashAlgorithmName, pmsUser.getNewpwd(), salt, hashIterations).toString();
		user.setPassword(result1);
		int flag=pmsUsersMapper.updatePasswords(user);
		return flag;
	}
	
	/**
	 * 
	 * description:
	 * @author liyanpeng
	 * @date 2017年8月4日
	 */
	public int deleteGroupPermissionByGroupid(long groupid){
		return pmsGroupsPermissionMapper.deleteGroupPermissionByGroupid(groupid);
	}
	
	/**
	 * description:返回所有的组权限信息
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@RequiresRoles("group-permission")
	@Override
	public List<Long> listGroupsPermission(long groupid){
		 return pmsGroupsPermissionMapper.listGroupsPermission(groupid);
	}

	/**
	 * 
	 * description:增加新组成员
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	public int addGroupsPermission(PmsGroupsPermission pmsgrouppermission){
		return pmsGroupsPermissionMapper.addGroupsPermission(pmsgrouppermission);
	}
	/**
	 * description:删除组成员
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	public int deleteGroupsPermission(long groupid,long permissionid){
		return pmsGroupsPermissionMapper.deleteGroupsPermission(groupid, permissionid);
	}
	
	/**
	 * description:返回所有的组成员信息
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@RequiresRoles("group-user")
	@Override
	public List<PmsGroupsUser> listPmsGroupUser(long groupid){
		return pmsGroupsUserMapper.listPmsGroupUser(groupid);
	}

	/**
	 * description:根据组成员ID查询信息
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	public PmsGroupsUser getpmsGroupUserById(Long id){
		return pmsGroupsUserMapper.getpmsGroupUserById(id);
	}
   
	
	/**
	 * 
	 * description:增加新组成员
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	public int addGroupUser(PmsGroupsUser pmsgroupuser){
		return pmsGroupsUserMapper.addGroupUser(pmsgroupuser);
	}
	
	/**
	 * 
	 * description:
	 * @author liyanpeng
	 * @date 2017年8月3日
	 */
	@Override
	public List<PmsPermissions> listPermissionManageSon(long parentid){
		return pmsPositionsMapper.listPermissionManageSon(parentid);
	}
	
	/**
	 * description:删除组成员
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	@RequiresRoles("group-user-delete")
	@Override
	public int deleteGroupUser(long id){
		return pmsGroupsUserMapper.deleteGroupUser(id);
	}

	@Override
	public List<PmsPermissions> listPmsPermissionsEname(Long userid){
		List<PmsPermissions> list=pmsPositionsMapper.listPmsPermissionsEname(userid);
		return list;
	}
	
	@RequiresRoles("position-add")
	@Override
	public void addPositionManage() {
	}
	
	/**
	 * 
	 * description:增加新组成员
	 * @author liyanpeng
	 * @date 2017年7月30日
	 */
	public int addGroupUser(String username,long id,long groupid){
		username=username.trim();
		PmsUsers userbyname=pmsUsersMapper.getPmsUsersByUsername(username);
		if(userbyname==null)
			return -1;
		if(pmsGroupsUserMapper.isSameGroupsUser(groupid, userbyname.getUserid())>0)
			return -2;
		PmsGroupsUser groupsuser=new PmsGroupsUser();
		groupsuser.setGroupid(groupid);
		groupsuser.setId(id);
		groupsuser.setUserid(userbyname.getUserid());
		return pmsGroupsUserMapper.addGroupUser(groupsuser);
	}
	@RequiresRoles("permission-add")
	@Override
	public List<PmsPermissions> listPermissionParent1() {
		List<PmsPermissions> listPermissionParent=pmsPositionsMapper.listPermissionParent();
		return listPermissionParent;
	}
	@Override
	public List<PmsDeparts> listPmsDeparts1() {
		List<PmsDeparts> listPmsDeparts=pmsDepartsMapper.listPmsDeparts1();
		return listPmsDeparts;
	}
	@RequiresRoles("user-add")
	@Override
	public List<PmsPositions> listPmsPositions1() {
		List<PmsPositions>listPmsPositions=pmsPositionsMapper.listPmsPositions1();
		return listPmsPositions;
	}

	@Override
	public List<PmsPositions> listPmsPositions2() {
		List<PmsPositions>listPmsPositions=pmsPositionsMapper.listPmsPositions1();
		return listPmsPositions;
	}
	@RequiresRoles("department-add")
	@Override
	public long toAddDepartment() {
		long id=RandomTest.random();
		return id;
	}
	@RequiresRoles("notice-add")
	@Override
	public long toAddNotice() {
		long id=new IntDate().getTimeStampLongDate();
		return id;
	}
	@RequiresRoles("group-add")
	@Override
	public long toAddGroup() {
		long id=new IntDate().getTimeStampLongDate();
		return id;
	}
	@RequiresRoles("group-user-add")
	@Override
	public long toAddGroupUser() {
		long id=RandomTest.random();
		return id;
	}
	@RequiresRoles("position-edit")
	@Override
	public PmsPositions getPmsPositionsById1(Long positionid) {
		PmsPositions pmsPositions=pmsPositionsMapper.getPmsPositionsById(positionid);
		return pmsPositions;
	}
	@RequiresRoles("user-manage")
	@Override
	public List<PmsUserPms> listPmsUsersProfile1() {
		List<PmsUserPms> listPmsUserPms=pmsUserPmsMapper.listPmsUserPms();
		return listPmsUserPms;
	}

}