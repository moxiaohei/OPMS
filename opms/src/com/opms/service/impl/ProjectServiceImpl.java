package com.opms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.opms.entity.NeedSearch;
import com.opms.entity.PmsProjects;
import com.opms.entity.PmsProjectsDoc;
import com.opms.entity.PmsProjectsNeeds;
import com.opms.entity.PmsProjectsTask;
import com.opms.entity.PmsProjectsTeam;
import com.opms.entity.PmsProjectsTest;
import com.opms.entity.PmsProjectsVersion;
import com.opms.entity.PmsUsers;
import com.opms.entity.PmsUsersProfile;
import com.opms.entity.TaskSearch;
import com.opms.mappers.PmsDepartsMapper;
import com.opms.mappers.PmsPositionsMapper;
import com.opms.mappers.PmsProjectsDocMapper;
import com.opms.mappers.PmsProjectsMapper;
import com.opms.mappers.PmsProjectsNeedsMapper;
import com.opms.mappers.PmsProjectsTaskMapper;
import com.opms.mappers.PmsProjectsTeamMapper;
import com.opms.mappers.PmsProjectsTestMapper;
import com.opms.mappers.PmsProjectsVersionMapper;
import com.opms.mappers.PmsUsersMapper;
import com.opms.mappers.PmsUsersProfileMapper;
import com.opms.service.ProjectService;
import com.opms.unti.BugState;
import com.opms.unti.ProjectNeed;
import com.opms.unti.ProjectTask;
import com.opms.unti.StringDate;
import com.opms.unti.TimeDate;
import com.opms.unti.UploadImg;

@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    private PmsProjectsMapper pmsProjectsMapper;
    @Autowired
    private PmsProjectsTeamMapper pmsProjectsTeamMapper;
    @Autowired
    private PmsProjectsNeedsMapper pmsProjectsNeedsMapper;
    @Autowired
    private PmsProjectsTaskMapper pmsProjectsTaskMapper;
    @Autowired
    private PmsUsersProfileMapper pmsUsersProfileMapper;
    @Autowired
    private PmsPositionsMapper pmsPositionsMapper;
	@Autowired
	PmsUsersMapper pmsUsersMapper;
	@Autowired
	private PmsDepartsMapper pmsDepartsMapper;
	@Autowired
	PmsProjectsTestMapper pmsProjectsTestMapper;// bug
	
	@Autowired
	private PmsProjectsVersionMapper pmsProjectsVersionMapper;
	
	@Autowired
	private PmsProjectsDocMapper pmsProjectsDocMapper;
	
	
	private List<PmsUsers> listUser = null;
	private Object obj = new Object();
	public static List<PmsProjectsTest> accpetUser = new ArrayList<PmsProjectsTest>();

	
	
	
	/**
	 * description 
	 *   检查项目名称是否重名
	 * @author xukang
	 * @time 2017年8月7日
	 */
	public int checkedProjectname(String name){
		PmsProjects projectname = pmsProjectsMapper.checkedProjectname(name);
		if(projectname!=null){
			return 1;
		}
		return 0;
	}
	/**
	 * <p>Description:
	 *   搜索项目
	 * </p>
	 * @author quanhuan
	 * @time  2017年8月5日下午7:40:46
	 */
	@Override
	public List<PmsProjects> searchProject(PmsProjects pmsProjects) {
		List<PmsProjects> project = pmsProjectsMapper.searchProject(pmsProjects);
		return project;
	}
	/**
	 * <p>
	 * Description: 获取项目的一条记录
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年7月28日上午10:41:14
	 */
	@Override
	public PmsProjects getPmsProjects(Long projectid) {
		PmsProjects projects = pmsProjectsMapper.getPmsProjects(projectid);
		if(projects == null){
			return null;
		}
		{
			if (listUser == null) {
				synchronized (obj) {
					if (listUser == null) {
						listUser = pmsUsersMapper.listPmsUsers();
					}
				}
			}
		}
		for (int i = 0; i < listUser.size(); i++) {
			if (projects.getUserid() != null && projects.getUserid().equals(listUser.get(i).getUserid())) {
				projects.setProjectResponsePeople(listUser.get(i).getUsername());
			}
			if (projects.getProduserid() != null && projects.getProduserid().equals(listUser.get(i).getUserid())) {
				projects.setProductResponsePeople(listUser.get(i).getUsername());
			}

			if (projects.getPubluserid() != null && projects.getPubluserid().equals(listUser.get(i).getUserid())) {
				projects.setPublishResponsePeople(listUser.get(i).getUsername());
			}

			if (projects.getTestuserid() != null && projects.getTestuserid().equals(listUser.get(i).getUserid())) {
				projects.setTestResponsePeople(listUser.get(i).getUsername());
			}
		}
		return projects;
	}
	/**
	 * <p>
	 * Description: 获取多条项目记录
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年7月28日上午10:40:42
	 */
	@Override
	public List<PmsProjects> listPmsProjects() {
		List<PmsProjects> list = pmsProjectsMapper.listPmsProjects();
		{
			if (listUser == null) {
				synchronized (obj) {
					if (listUser == null) {
						listUser = pmsUsersMapper.listPmsUsers();
					}
				}
			}
		}
		for (PmsProjects pmsProjects : list) {
			for (int i = 0; i < listUser.size(); i++) {
				if (pmsProjects.getUserid().equals(listUser.get(i).getUserid())) {
					pmsProjects.setCreatePeople(listUser.get(i).getUsername());
				}
				if (pmsProjects.getProjuserid() != null
						&& pmsProjects.getProjuserid().equals(listUser.get(i).getUserid())) {
					pmsProjects.setProjectResponsePeople(listUser.get(i).getUsername());
				}
				if (pmsProjects.getProduserid() != null
						&& pmsProjects.getProduserid().equals(listUser.get(i).getUserid())) {
					pmsProjects.setProductResponsePeople(listUser.get(i).getUsername());
				}
				if (pmsProjects.getTestuserid() != null
						&& pmsProjects.getTestuserid().equals(listUser.get(i).getUserid())) {
					pmsProjects.setTestResponsePeople(listUser.get(i).getUsername());
				}
				if (pmsProjects.getPubluserid() != null
						&& pmsProjects.getPubluserid().equals(listUser.get(i).getUserid())) {
					pmsProjects.setPublishResponsePeople(listUser.get(i).getUsername());
				}
			}
		}
		return list;
	}
	
	/**
	 *description:获取团队队员
	 *@author hulingtao
	 *@time 2017年7月27日 
	 */
	@Override
	public List<PmsProjectsTeam> listTeamMesg(Long projectid) {
		List<PmsProjectsTeam> list = pmsProjectsTeamMapper.selectByProjectid(projectid);
		for (PmsProjectsTeam pmsProjectsTeam : list) {
			pmsProjectsTeam.setJoinTime(new StringDate().getStringDate(pmsProjectsTeam.getCreated()));
			String username = pmsUsersMapper.getPmsUsersById(pmsProjectsTeam.getUserid())
					.getUsername();
			if(pmsDepartsMapper.getDeptByUserid(pmsProjectsTeam.getUserid()) != null){
				String deptName = pmsDepartsMapper.getDeptByUserid(pmsProjectsTeam.getUserid()).getName();
				pmsProjectsTeam.setDeptname(deptName);
			}
			pmsProjectsTeam.setUsername(username);
		}
		return list;
	}
	
	/**
	 *description:删除团队成员
	 *@author hulingtao
	 *@time 2017年7月27日 
	 */
	@Override
	public void deleteMember(Long userid) {
		pmsProjectsTeamMapper.deleteByUserid(userid);
	}
	/**
	 *description:获取项目需求信息
	 *@author hulingtao
	 *@time 2017年7月28日 
	 */
	@Override
	public List<PmsProjectsNeeds> listProjectNeed(Long projectid) {
		List<PmsProjectsNeeds> list = pmsProjectsNeedsMapper.selectByProjectid(projectid);
		for (PmsProjectsNeeds pmsProjectsNeeds : list) {
			pmsProjectsNeeds.setCreateTime(new StringDate().getStringDate(pmsProjectsNeeds.getCreated()));
			pmsProjectsNeeds.setChangeTime(new StringDate().getStringDate(pmsProjectsNeeds.getChanged()));
			String username = pmsUsersMapper.getPmsUsersById(pmsProjectsNeeds.getUserid()).getUsername();
			if(pmsProjectsNeeds.getAcceptid() != null){
				String acceptname = pmsUsersMapper.getPmsUsersById(pmsProjectsNeeds.getAcceptid()).getUsername();
				pmsProjectsNeeds.setAcceptname(acceptname);
			}
			String needStage = ProjectNeed.getStage(pmsProjectsNeeds.getStage());
			String needStatus = ProjectNeed.getStatus(pmsProjectsNeeds.getStatus());
			String projectName = getPmsProjects(projectid).getName();
			pmsProjectsNeeds.setUsername(username);
			pmsProjectsNeeds.setNeedStage(needStage);
			pmsProjectsNeeds.setNeedSatus(needStatus);
			pmsProjectsNeeds.setProjectName(projectName);
		}
		return list;
	}
	/**
	 *description:获取单个需求信息
	 *@author hulingtao
	 *@time 2017年7月28日 
	 */
	@Override
	public PmsProjectsNeeds getProjectNeed(Long needsid) {
		PmsProjectsNeeds pmsProjectsNeeds = pmsProjectsNeedsMapper.selectByNeedsid(needsid);
		if(pmsProjectsNeeds == null){
			return null;
		}else{
			if(pmsProjectsNeeds.getCreated() != null){
				pmsProjectsNeeds.setCreateTime(new StringDate().getStringDate(pmsProjectsNeeds.getCreated()));
			}
			pmsProjectsNeeds.setChangeTime(new StringDate().getStringDate(pmsProjectsNeeds.getChanged()));
			String username = pmsUsersMapper.getPmsUsersById(pmsProjectsNeeds.getUserid()).getUsername();
			if(pmsProjectsNeeds.getAcceptid() != null){
				String acceptname = pmsUsersMapper.getPmsUsersById(pmsProjectsNeeds.getAcceptid()).getUsername();
				pmsProjectsNeeds.setAcceptname(acceptname);
			}
			String needStage = ProjectNeed.getStage(pmsProjectsNeeds.getStage());
			String needStatus = ProjectNeed.getStatus(pmsProjectsNeeds.getStatus());
			String needSource = ProjectNeed.getSource(pmsProjectsNeeds.getSource());
			if(getPmsProjects(pmsProjectsNeeds.getProjectid()) != null){
				String projectName = getPmsProjects(pmsProjectsNeeds.getProjectid()).getName();
				pmsProjectsNeeds.setProjectName(projectName);
			}
			pmsProjectsNeeds.setUsername(username);
			pmsProjectsNeeds.setNeedStage(needStage);
			pmsProjectsNeeds.setNeedSatus(needStatus);
			pmsProjectsNeeds.setNeedSource(needSource);
			return pmsProjectsNeeds;
		}
		
	}
	/**
	 *description:修改需求
	 *@author hulingtao
	 *@time 2017年7月31日 
	 */
	@Override
	public void updateNeed(PmsProjectsNeeds needs) {
		pmsProjectsNeedsMapper.updateByNeedsid(needs);
	}
	/**
	 *description:添加需求
	 *@author hulingtao
	 *@time 2017年7月31日 
	 */
	@Override
	public void insertNeed(PmsProjectsNeeds needs) {
		pmsProjectsNeedsMapper.insertNeed(needs);
	}
	/**
	 *description:获取搜索信息
	 *@author hulingtao
	 *@time 2017年7月31日 
	 */
	@Override
	public List<PmsProjectsNeeds> searchNeed(NeedSearch search) {
		List<PmsProjectsNeeds> list = pmsProjectsNeedsMapper.selectBySearch(search);
		for (PmsProjectsNeeds pmsProjectsNeeds : list) {
			pmsProjectsNeeds.setCreateTime(new StringDate().getStringDate(pmsProjectsNeeds.getCreated()));
			pmsProjectsNeeds.setChangeTime(new StringDate().getStringDate(pmsProjectsNeeds.getChanged()));
			String username = pmsUsersMapper.getPmsUsersById(pmsProjectsNeeds.getUserid()).getUsername();
			if(pmsProjectsNeeds.getAcceptid() != null){
				String acceptname = pmsUsersMapper.getPmsUsersById(pmsProjectsNeeds.getAcceptid()).getUsername();
				pmsProjectsNeeds.setAcceptname(acceptname);
			}
			String needStage = ProjectNeed.getStage(pmsProjectsNeeds.getStage());
			String needStatus = ProjectNeed.getStatus(pmsProjectsNeeds.getStatus());
			pmsProjectsNeeds.setUsername(username);
			pmsProjectsNeeds.setNeedStage(needStage);
			pmsProjectsNeeds.setNeedSatus(needStatus);
		}
		return list;
	}
	/**
	 *description:更新需求状态
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@Override
	public int updateStatus(PmsProjectsNeeds need) {
		int status = pmsProjectsNeedsMapper.updateStatus(need);
		return status;
	}
	/**
	 *description:获取项目任务
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@Override
	public List<PmsProjectsTask> listProjectTask(Long projectid) {
		List<PmsProjectsTask> list = pmsProjectsTaskMapper.selectByProjectid(projectid);
		for (PmsProjectsTask pmsProjectsTask : list) {
			pmsProjectsTask.setTaskStatus(ProjectTask.getStatus(pmsProjectsTask.getStatus()));
			if(pmsProjectsTask.getEnded() != null){
				pmsProjectsTask.setEndDate(new StringDate().getStringDate(pmsProjectsTask.getEnded()));
			}
			if(pmsProjectsTask.getCompleteid() != null){
				String finishName = pmsUsersMapper.getPmsUsersById(pmsProjectsTask.getCompleteid()).getUsername();
				pmsProjectsTask.setFinishName(finishName);
			}
			if(pmsProjectsTask.getAcceptid() != null){
				String acceptname = pmsUsersMapper.getPmsUsersById(pmsProjectsTask.getAcceptid()).getUsername();
				pmsProjectsTask.setAcceptName(acceptname);
			}
		}
		return list;
	}
	/**
	 *description:获取单个任务信息
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@Override
	public PmsProjectsTask getTask(Long taskid) {
		PmsProjectsTask pmsProjectsTask = pmsProjectsTaskMapper.selectByTaskid(taskid);
		pmsProjectsTask.setTaskStatus(ProjectTask.getStatus(pmsProjectsTask.getStatus()));
		pmsProjectsTask.setTaskType(ProjectTask.getType(pmsProjectsTask.getStatus()));
		if(pmsProjectsTask.getEnded() != null){
			pmsProjectsTask.setEndDate(new StringDate().getStringDate(pmsProjectsTask.getEnded()));
		}
		if(pmsProjectsTask.getStarted() != null){
			pmsProjectsTask.setStartDate(new StringDate().getStringDate(pmsProjectsTask.getStarted()));
		}
		if(pmsProjectsTask.getCompleteid() != null){
			String finishName = pmsUsersMapper.getPmsUsersById(pmsProjectsTask.getCompleteid()).getUsername();
			pmsProjectsTask.setFinishName(finishName);
		}if(pmsProjectsTask.getAcceptid() != null){
			String acceptname = pmsUsersMapper.getPmsUsersById(pmsProjectsTask.getAcceptid()).getUsername();
			pmsProjectsTask.setAcceptName(acceptname);
		}
		String userName = pmsUsersMapper.getPmsUsersById(pmsProjectsTask.getUserid()).getUsername();
		if(getProjectNeed(pmsProjectsTask.getNeedsid()) != null){
			String needName = getProjectNeed(pmsProjectsTask.getNeedsid()).getName();
			pmsProjectsTask.setNeedName(needName);
		}
		String projectName = getPmsProjects(pmsProjectsTask.getProjectid()).getName();
		pmsProjectsTask.setUserName(userName);
		pmsProjectsTask.setProjectName(projectName);
		return pmsProjectsTask;
	}
	/**
	 *description:查询指派给我
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@Override
	public List<PmsProjectsTask> listProjectTaskByUserid(Long userid) {
		List<PmsProjectsTask> list = pmsProjectsTaskMapper.selectByAcceptid(userid);
		for (PmsProjectsTask pmsProjectsTask : list) {
			pmsProjectsTask.setTaskStatus(ProjectTask.getStatus(pmsProjectsTask.getStatus()));
			if(pmsProjectsTask.getEnded() != null){
				pmsProjectsTask.setEndDate(new StringDate().getStringDate(pmsProjectsTask.getEnded()));
			}
			if(pmsProjectsTask.getAcceptid() != null){
				String acceptname = pmsUsersMapper.getPmsUsersById(pmsProjectsTask.getAcceptid()).getUsername();
				pmsProjectsTask.setAcceptName(acceptname);
			}
			if(pmsProjectsTask.getCompleteid() != null){
				String finishName = pmsUsersMapper.getPmsUsersById(pmsProjectsTask.getCompleteid()).getUsername();
				pmsProjectsTask.setFinishName(finishName);
			}
		}
		return list;
	}
	/**
	 *description:查询由我创建
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@Override
	public List<PmsProjectsTask> listProjectTaskByUserid2(Long userid) {
		List<PmsProjectsTask> list = pmsProjectsTaskMapper.selectByUserid(userid);
		for (PmsProjectsTask pmsProjectsTask : list) {
			pmsProjectsTask.setTaskStatus(ProjectTask.getStatus(pmsProjectsTask.getStatus()));
			if(pmsProjectsTask.getEnded() != null){
				pmsProjectsTask.setEndDate(new StringDate().getStringDate(pmsProjectsTask.getEnded()));
			}
			if(pmsProjectsTask.getAcceptid() != null){
				String acceptname = pmsUsersMapper.getPmsUsersById(pmsProjectsTask.getAcceptid()).getUsername();
				pmsProjectsTask.setAcceptName(acceptname);
			}
			if(pmsProjectsTask.getCompleteid() != null){
				String finishName = pmsUsersMapper.getPmsUsersById(pmsProjectsTask.getCompleteid()).getUsername();
				pmsProjectsTask.setFinishName(finishName);
			}
		}
		return list;
	}
	/**
	 *description:查询由我解决
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@Override
	public List<PmsProjectsTask> listProjectTaskBySolve(Long userid) {
		List<PmsProjectsTask> list = pmsProjectsTaskMapper.selectByCompleteid(userid);
		for (PmsProjectsTask pmsProjectsTask : list) {
			pmsProjectsTask.setTaskStatus(ProjectTask.getStatus(pmsProjectsTask.getStatus()));
			if(pmsProjectsTask.getEnded() != null){
				pmsProjectsTask.setEndDate(new StringDate().getStringDate(pmsProjectsTask.getEnded()));
			}
			if(pmsProjectsTask.getAcceptid() != null){
				String acceptname = pmsUsersMapper.getPmsUsersById(pmsProjectsTask.getAcceptid()).getUsername();
				pmsProjectsTask.setAcceptName(acceptname);
			}
			if(pmsProjectsTask.getCompleteid() != null){
				String finishName = pmsUsersMapper.getPmsUsersById(pmsProjectsTask.getCompleteid()).getUsername();
				pmsProjectsTask.setFinishName(finishName);
			}
		}
		return list;
	}
	/**
	 *description:查询由我关闭
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@Override
	public List<PmsProjectsTask> listProjectTaskByClose(Long userid) {
		List<PmsProjectsTask> list = pmsProjectsTaskMapper.selectByCloseid(userid);
		for (PmsProjectsTask pmsProjectsTask : list) {
			pmsProjectsTask.setTaskStatus(ProjectTask.getStatus(pmsProjectsTask.getStatus()));
			if(pmsProjectsTask.getEnded() != null){
				pmsProjectsTask.setEndDate(new StringDate().getStringDate(pmsProjectsTask.getEnded()));
			}
			if(pmsProjectsTask.getAcceptid() != null){
				String acceptname = pmsUsersMapper.getPmsUsersById(pmsProjectsTask.getAcceptid()).getUsername();
				pmsProjectsTask.setAcceptName(acceptname);
			}
			if(pmsProjectsTask.getCompleteid() != null){
				String finishName = pmsUsersMapper.getPmsUsersById(pmsProjectsTask.getCompleteid()).getUsername();
				pmsProjectsTask.setFinishName(finishName);
			}
		}
		return list;
	}
	/**
	 *description:查询由我取消
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@Override
	public List<PmsProjectsTask> listProjectTaskByDisplay(Long userid) {
		List<PmsProjectsTask> list = pmsProjectsTaskMapper.selectByCancelid(userid);
		for (PmsProjectsTask pmsProjectsTask : list) {
			pmsProjectsTask.setTaskStatus(ProjectTask.getStatus(pmsProjectsTask.getStatus()));
			if(pmsProjectsTask.getEnded() != null){
				pmsProjectsTask.setEndDate(new StringDate().getStringDate(pmsProjectsTask.getEnded()));
			}
			if(pmsProjectsTask.getAcceptid() != null){
				String acceptname = pmsUsersMapper.getPmsUsersById(pmsProjectsTask.getAcceptid()).getUsername();
				pmsProjectsTask.setAcceptName(acceptname);
			}
			if(pmsProjectsTask.getCompleteid() != null){
				String finishName = pmsUsersMapper.getPmsUsersById(pmsProjectsTask.getCompleteid()).getUsername();
				pmsProjectsTask.setFinishName(finishName);
			}
		}
		return list;
	}
	/**
	 *description:通过搜索查询任务
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@Override
	public List<PmsProjectsTask> listTaskBySearch(TaskSearch search) {
		List<PmsProjectsTask> list = pmsProjectsTaskMapper.selectBySearch(search);
		for (PmsProjectsTask pmsProjectsTask : list) {
			pmsProjectsTask.setTaskStatus(ProjectTask.getStatus(pmsProjectsTask.getStatus()));
			if(pmsProjectsTask.getEnded() != null){
				pmsProjectsTask.setEndDate(new StringDate().getStringDate(pmsProjectsTask.getEnded()));
			}
			if(pmsProjectsTask.getAcceptid() != null){
				String acceptname = pmsUsersMapper.getPmsUsersById(pmsProjectsTask.getAcceptid()).getUsername();
				pmsProjectsTask.setAcceptName(acceptname);
			}
			if(pmsProjectsTask.getCompleteid() != null){
				String finishName = pmsUsersMapper.getPmsUsersById(pmsProjectsTask.getCompleteid()).getUsername();
				pmsProjectsTask.setFinishName(finishName);
			}
		}
		return list;
	}
	/**
	 *description:更新任务状态
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@Override
	public int updateTaskStatus(PmsProjectsTask task) {
		int flag = pmsProjectsTaskMapper.updateTaskStatus(task);
		if(flag == 1){
			return 1;
		}else{
			return 0;
		}
	}
	/**
	 *description:更新指派人
	 *@author hulingtao
	 *@time 2017年8月4日 
	 */
	@Override
	public int updateAcceptid(PmsProjectsTask task) {
		int flag = pmsProjectsTaskMapper.updateAcceptid(task);
		if(flag == 1){
			return 1;
		}else{
			return 0;
		}
	}
	@Override
	public String getPosition(Long userid) {
		PmsUsersProfile pmsUsersProfile = pmsUsersProfileMapper.getPmsUsersProfileById(userid);
		String name = pmsPositionsMapper.getPmsPositionsById(pmsUsersProfile.getPositionid()).getName();
		return name;
	}
	
	/**
	 * <p>
	 * Description: 增加一条项目记录
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年7月28日上午10:41:37
	 */
	@Override
	public void insertPmsProjects(PmsProjects pmsProjects) {
		pmsProjects.setProjectid(new TimeDate().getTimeStampLongDate());
		pmsProjects.setCreated(new Date());
		pmsProjectsMapper.insertPmsProjects(pmsProjects);
	}

	/**
	 * description:获取团队队员
	 * 
	 * @author hulingtao
	 * @time 2017年7月27日
	 *//*
	@Override
	public List<PmsProjectsTeam> listTeamMesg(Long projectid) {
		List<PmsProjectsTeam> list = pmsProjectsTeamMapper.getProjectsTeam(projectid);
		{
			if (listUser == null) {
				synchronized (obj) {
					if (listUser == null) {
						PmsUsersExample example2 = new PmsUsersExample();
						listUser = pmsUsersMapper.selectByExample(example2);
					}
				}
			}
		}
		for (PmsProjectsTeam pmsProjectsTeam : list) {
			for (int i = 0; i < listUser.size(); i++) {
				if (pmsProjectsTeam.getUserid() != null
						&& pmsProjectsTeam.getUserid().equals(listUser.get(i).getUserid())) {
					pmsProjectsTeam.setUsername(listUser.get(i).getUsername());
				}
			}
		}
		return list;
	}
*/
	/**
	 * <p>
	 * Description: 修改项目信息
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年7月28日上午11:31:24
	 */
	@Override
	public void updatePmsProjects(PmsProjects pmsProjects) {
		pmsProjectsMapper.updatePmsProjects(pmsProjects);
	}

	/**
	 * <p>
	 * Description: 修改项目状态
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年7月28日下午4:09:32
	 */
	@Override
	public void updatePmsProjectsState(PmsProjects pmsProjects) {
		pmsProjectsMapper.updatePmsProjectsState(pmsProjects);
	}

	// bug

	/**
	 * <p>
	 * Description: 获取所有bug
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年7月31日下午3:10:10
	 */
	@Override
	public List<PmsProjectsTest> listPmsProjectsTest(long projectid) {
		List<PmsProjectsTest> listbug = pmsProjectsTestMapper.listPmsProjectsTest(projectid);
		{
			if (listUser == null) {
				synchronized (obj) {
					if (listUser == null) {
						listUser = pmsUsersMapper.listPmsUsers();
					}
				}
			}
		}
		for (PmsProjectsTest pmsProjectsTest : listbug) {
			pmsProjectsTest.setState(BugState.getState(pmsProjectsTest.getStatus()));
			for (int i = 0; i < listUser.size(); i++) {
				if (pmsProjectsTest.getUserid().equals(listUser.get(i).getUserid())) {
					pmsProjectsTest.setCreateUser(listUser.get(i).getUsername());
				}
				if (pmsProjectsTest.getAcceptid() != null
						&& pmsProjectsTest.getAcceptid().equals(listUser.get(i).getUserid())) {
					pmsProjectsTest.setAcceptPeople(listUser.get(i).getUsername());
					PmsProjectsTest accept = new PmsProjectsTest();
					accept.setAcceptid(pmsProjectsTest.getAcceptid());
					accept.setAcceptPeople(listUser.get(i).getUsername());
					accpetUser.add(accept);
				}
				if (pmsProjectsTest.getCompleteid() != null
						&& pmsProjectsTest.getCompleteid().equals(listUser.get(i).getUserid())) {
					pmsProjectsTest.setAcceptPeople(listUser.get(i).getUsername());
				}
			}
		}
		return listbug;
	}

	/**
	 * <p>
	 * Description: 获取一条bug
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年7月31日下午3:10:40
	 */
	@Override
	public PmsProjectsTest getPmsProjectsTest(long testid) {
		PmsProjectsTest bug = pmsProjectsTestMapper.getPmsProjectsTest(testid);
		if(bug==null){
			return null;
		}
		{
			if (listUser == null) {
				synchronized (obj) {
					if (listUser == null) {
						listUser = pmsUsersMapper.listPmsUsers();
					}
				}
			}
		}
		for (int i = 0; i < listUser.size(); i++) {
			if (bug.getUserid().equals(listUser.get(i).getUserid())) {
				bug.setCreateUser(listUser.get(i).getUsername());
			}
			if (bug.getAcceptid() != null && bug.getAcceptid().equals(listUser.get(i).getUserid())) {
				bug.setAcceptPeople(listUser.get(i).getUsername());
			}
			if (bug.getCompleteid() != null && bug.getCompleteid().equals(listUser.get(i).getUserid())) {
				bug.setAcceptPeople(listUser.get(i).getUsername());
			}
			if (bug.getCcid() != null && bug.getCcid().equals(listUser.get(i).getUserid())) {
				bug.setcPeople(listUser.get(i).getUsername());
			}
		}
		return bug;
	}

	/**
	 * <p>
	 * Description: bug指派人
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年8月2日下午3:13:47
	 */
	@Override
	public void dispatchPeople(PmsProjectsTest pmsProjectsTest) {
		pmsProjectsTestMapper.dispatchPeople(pmsProjectsTest);
	}

	/**
	 * <p>
	 * Description: 解决方案
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年8月2日下午3:59:15
	 */
	@Override
	public void resolvent(PmsProjectsTest pmsProjectsTest) {
		pmsProjectsTestMapper.resolvent(pmsProjectsTest);
	}

	/**
	 * <p>
	 * Description: 检索符合条件的bug
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年8月2日下午4:24:51
	 */
	@Override
	public List<PmsProjectsTest> searchBug(PmsProjectsTest pmsProjectsTest) {
		List<PmsProjectsTest> searchBug = pmsProjectsTestMapper.searchBug(pmsProjectsTest);
		{
			if (listUser == null) {
				synchronized (obj) {
					if (listUser == null) {
						listUser = pmsUsersMapper.listPmsUsers();
					}
				}
			}
		}
		for (PmsProjectsTest p : searchBug) {
			for (int i = 0; i < listUser.size(); i++) {
				if (p.getUserid().equals(listUser.get(i).getUserid())) {
					p.setCreateUser(listUser.get(i).getUsername());
				}
				if (p.getAcceptid() != null && p.getAcceptid().equals(listUser.get(i).getUserid())) {
					p.setAcceptPeople(listUser.get(i).getUsername());
				}
				if (p.getCompleteid() != null && p.getCompleteid().equals(listUser.get(i).getUserid())) {
					p.setAcceptPeople(listUser.get(i).getUsername());
				}
			}
		}
		return searchBug;
	}

	/**
	 * <p>
	 * Description: 修改bug并且上传文件
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年8月4日下午2:26:47
	 */
	@Override
	public void updateBug(PmsProjectsTest pmsProjectsTest, MultipartFile filename) {
		String file = UploadImg.uploadImg(filename, "OPMS" + new StringDate().getTimeStampStringDate());
		pmsProjectsTest.setAttachment(file);
		pmsProjectsTest.setChanged(new Date());
		pmsProjectsTestMapper.updatePmsProjectsTest(pmsProjectsTest);
	}

	/**
	 * <p>
	 * Description: 查询所有的需求
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年8月4日下午3:16:06
	 */
	@Override
	public List<PmsProjectsNeeds> listPmsProjectsNeeds(long projectid) {
		List<PmsProjectsNeeds> listneeds = pmsProjectsNeedsMapper.selectByProjectid(projectid);
		return listneeds;
	}

	/**
	 * <p>
	 * Description: 查询所有的任务
	 * </p>
	 * 
	 * @author quanhuan
	 * @time 2017年8月4日下午3:16:21
	 */
	@Override
	public List<PmsProjectsTask> listPmsProjectsTask(long needsid) {
		List<PmsProjectsTask> listtask = pmsProjectsTaskMapper.selectByNeedsid(needsid);
		return listtask;
	}

	/**
	 * <p>Description:
	 *    增加bug
	 * </p>
	 * @author quanhuan
	 * @time  2017年8月4日下午5:24:40
	 */
	@Override
	public void insertPmsProjectsTest(PmsProjectsTest pmsProjectsTest,MultipartFile filename) {
		pmsProjectsTest.setCreated(new Date());
		pmsProjectsTest.setTestid(new TimeDate().getTimeStampLongDate());
		String attachment=new UploadImg().uploadImg(filename, "OPMS"+new StringDate().getTimeStampStringDate());
		pmsProjectsTest.setAttachment(attachment);
		pmsProjectsTestMapper.inssertPmsProjectsTest(pmsProjectsTest);
	}

	/**
	 * <p>Description:
	 *    搜索我指派的bug
	 * </p>
	 * @author quanhuan
	 * @time  2017年8月5日下午7:39:12
	 */
	@Override
	public List<PmsProjectsTest> searchByAppoint(Long acceptid,Long projectid) {
		List<PmsProjectsTest> appoint = pmsProjectsTestMapper.searchByAppoint(acceptid, projectid);
		return appoint;
	}

	/**
	 * <p>Description:
	 *    搜索我创建的bug
	 * </p>
	 * @author quanhuan
	 * @time  2017年8月5日下午7:39:45
	 */
	@Override
	public List<PmsProjectsTest> searchByMyCreate(Long userid,Long projectid) {
		List<PmsProjectsTest> create = pmsProjectsTestMapper.searchByMyCreate(userid, projectid);
		return create;
	}

	/**
	 * <p>Description:
	 *   搜索我解决的bug
	 * </p>
	 * @author quanhuan
	 * @time  2017年8月5日下午7:40:11
	 */
	@Override
	public List<PmsProjectsTest> searchByMySolve(Long completeid,Long projectid) {
		List<PmsProjectsTest> solve = pmsProjectsTestMapper.searchByMySolve(completeid, projectid);
		return solve;
	}
	@Override
	public int getPmsNeedByName(String name) {
		int flag = pmsProjectsNeedsMapper.selectByName(name);
		if(flag == 1){
			return 1;
		}
		return 0;
	}
	/**
	 *description:添加任务
	 *@author hulingtao
	 *@time 2017年8月7日 
	 */
	@Override
	public void insertTask(PmsProjectsTask task) {
		task.setTaskid(new TimeDate().getTimeStampLongDate());
		task.setStarted(new TimeDate().getDate(task.getStartDate()));
		task.setEnded(new TimeDate().getDate(task.getStartDate()));
		task.setCreated(new Date());
		task.setChanged(new Date());
		task.setStatus(1);
		pmsProjectsTaskMapper.insertTask(task);
	}
	@Override
	public List<PmsProjectsVersion> selectAllPmsProjectsVersion(Long projectId) {
		return pmsProjectsVersionMapper.selectAllPmsProjectsVersion(projectId);
	}
	@Override
	public List<PmsProjectsVersion> getPmsProjectsVersion(Long versionid) {
		return pmsProjectsVersionMapper.getPmsProjectsVersion(versionid);
	}
	@Override
	public int deleteByPrimaryKey(Long versionid) {
		return pmsProjectsVersionMapper.deleteByPrimaryKey(versionid);
	}
	@Override
	public int insertPmsProjectsVersion(PmsProjectsVersion pmsProjectsVersion) {
		return pmsProjectsVersionMapper.insertPmsProjectsVersion(pmsProjectsVersion);
	}
	@Override
	public int updateByPrimaryKey(PmsProjectsVersion pmsProjectsVersion) {
		return pmsProjectsVersionMapper.updateByPrimaryKey(pmsProjectsVersion);
	}
	@Override
	public List<PmsProjectsDoc> selectAllPmsProjectsDoc(Long projectId) {
		return pmsProjectsDocMapper.selectAllPmsProjectsDoc(projectId);
	}
	@Override
	public List<PmsProjectsDoc> getPmsProjectsDoc(Long docid) {
		return pmsProjectsDocMapper.getPmsProjectsDoc(docid);
	}
	@Override
	public int deleteDocByPrimaryKey(Long docid) {
		return pmsProjectsDocMapper.deleteDocByPrimaryKey(docid);
	}
	@Override
	public int insertPmsProjectsDoc(PmsProjectsDoc pmsProjectsDoc) {
		return pmsProjectsDocMapper.insertPmsProjectsDoc(pmsProjectsDoc);
	}
	@Override
	public int updateDocByPrimaryKey(PmsProjectsDoc pmsProjectsDoc) {
		return pmsProjectsDocMapper.updateDocByPrimaryKey(pmsProjectsDoc);
	}
	@Override
	public List<PmsProjectsDoc> searchPmsProjectsDoc(Integer sort, String title,Long projectid) {
		return pmsProjectsDocMapper.searchPmsProjectsDoc(sort, title,projectid);
	}
	@Override
	public List<PmsProjectsVersion> searchPmsProjectsVersion(String title, Long projectid) {
		return pmsProjectsVersionMapper.searchPmsProjectsVersion(title, projectid);
	}
	
}
