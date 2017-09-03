package com.opms.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.opms.entity.NeedSearch;
import com.opms.entity.PmsProjects;
import com.opms.entity.PmsProjectsDoc;
import com.opms.entity.PmsProjectsNeeds;
import com.opms.entity.PmsProjectsTask;
import com.opms.entity.PmsProjectsTeam;
import com.opms.entity.PmsProjectsTest;
import com.opms.entity.PmsProjectsVersion;
import com.opms.entity.TaskSearch;

/**
 * @author mengyongfei
 * @date 2017年8月11日 下午4:23:47
 * 
 */
public interface ProjectService {
    List<PmsProjectsTeam> listTeamMesg(Long projectid);
    void deleteMember(Long userid);
    List<PmsProjectsNeeds> listProjectNeed(Long projectid);
    PmsProjectsNeeds getProjectNeed(Long needsid);
    void updateNeed(PmsProjectsNeeds needs);
    void insertNeed(PmsProjectsNeeds needs);
    List<PmsProjectsNeeds> searchNeed(NeedSearch search);
    int updateStatus(PmsProjectsNeeds need);
    List<PmsProjectsTask> listProjectTask(Long projectid);
    PmsProjectsTask getTask(Long taskid);
    List<PmsProjectsTask> listProjectTaskByUserid(Long userid);
    List<PmsProjectsTask> listProjectTaskByUserid2(Long userid);
    List<PmsProjectsTask> listProjectTaskBySolve(Long userid);
    List<PmsProjectsTask> listProjectTaskByClose(Long userid);
    List<PmsProjectsTask> listProjectTaskByDisplay(Long userid);
    List<PmsProjectsTask> listTaskBySearch(TaskSearch search);
    int updateTaskStatus(PmsProjectsTask task);
    int updateAcceptid(PmsProjectsTask task);
    String getPosition(Long userid);
    int getPmsNeedByName(String name);
    void insertTask(PmsProjectsTask task);
    // 项目
    int checkedProjectname(String name);
 	
    List<PmsProjects> searchProject(PmsProjects pmsProjects);
 	
 	PmsProjects getPmsProjects(Long projectid);

 	List<PmsProjects> listPmsProjects();

 	void insertPmsProjects(PmsProjects pmsProjects);

 	void updatePmsProjects(PmsProjects pmsProjects);

 	public void updatePmsProjectsState(PmsProjects pmsProjects);

 	// Bug
 	
 	public List<PmsProjectsTest> searchByAppoint(Long acceptid, Long projectid);//由我指派的bug
 	public List<PmsProjectsTest> searchByMyCreate(Long userid,Long projectid);//由我创建的bug
 	public List<PmsProjectsTest> searchByMySolve(Long completeid,Long projectid);//由我指派的bug
 	
 	public void insertPmsProjectsTest(PmsProjectsTest pmsProjectsTest,MultipartFile filename);
 	
 	public List<PmsProjectsTest> listPmsProjectsTest(long projectid);

 	public PmsProjectsTest getPmsProjectsTest(long testid);

 	public void dispatchPeople(PmsProjectsTest pmsProjectsTest);

 	public void resolvent(PmsProjectsTest pmsProjectsTest);

 	public List<PmsProjectsTest> searchBug(PmsProjectsTest pmsProjectsTest);

 	public void updateBug(PmsProjectsTest pmsProjectsTest, MultipartFile filename);

 	// 查询所有需求

 	public List<PmsProjectsNeeds> listPmsProjectsNeeds(long projectid);

 	// 查询需求相关任务
 	public List<PmsProjectsTask> listPmsProjectsTask(long needsid);
 	
 	
 	
 	//查询项目所有版本
 	List<PmsProjectsVersion> selectAllPmsProjectsVersion(Long projectId);
 	
 	//根据版本ID查询版本信息
 	List<PmsProjectsVersion> getPmsProjectsVersion(Long versionid);
 	
	//根据版本ID删除版本信息
	int deleteByPrimaryKey(Long versionid);
	
	//添加版本信息
	int insertPmsProjectsVersion(PmsProjectsVersion pmsProjectsVersion);
	
	//根据版本ID更新版本信息
	int updateByPrimaryKey(PmsProjectsVersion pmsProjectsVersion);
	
	//根据版本名称进行模糊查询
	List<PmsProjectsVersion> searchPmsProjectsVersion(String title,Long projectid);
	
	//查询项目所有文档
	List<PmsProjectsDoc> selectAllPmsProjectsDoc(Long projectId);
	
	//根据文档ID查询文档信息
	List<PmsProjectsDoc> getPmsProjectsDoc(Long docid);
	
	//根据文档ID删除文档信息
	int deleteDocByPrimaryKey(Long docid);
	
	//根据文档ID添加文档信息
	int insertPmsProjectsDoc(PmsProjectsDoc pmsProjectsDoc);
	
	//根据文档ID更新文档信息
	int updateDocByPrimaryKey(PmsProjectsDoc pmsProjectsDoc);
	
	//根据文档类型,名称进行模糊查询
	List<PmsProjectsDoc> searchPmsProjectsDoc(Integer sort,String title,Long projectid);
}
