package com.opms.mappers;

import com.opms.entity.PmsProjectsTask;
import com.opms.entity.PmsProjectsTaskExample;
import com.opms.entity.PmsProjectsTaskWithBLOBs;
import com.opms.entity.TaskSearch;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PmsProjectsTaskMapper {
	
	void insertTask(PmsProjectsTask task);
	
	List<PmsProjectsTask> selectByNeedsid(Long needsid);
	
	int updateAcceptid(PmsProjectsTask task);
	
	int updateTaskStatus(PmsProjectsTask task);
	
	List<PmsProjectsTask> selectByProjectid(Long projectid);
	
	PmsProjectsTask selectByTaskid(Long taskid);
	
	List<PmsProjectsTask> selectBySearch(TaskSearch search);
	
	List<PmsProjectsTask> selectByAcceptid(Long userid);
	
	List<PmsProjectsTask> selectByCloseid(Long userid);
	
	List<PmsProjectsTask> selectByUserid(Long userid);
	
	List<PmsProjectsTask> selectByCompleteid(Long userid);
    
	List<PmsProjectsTask> selectByCancelid(Long userid);
	
	int countByExample(PmsProjectsTaskExample example);

    int deleteByExample(PmsProjectsTaskExample example);

    int deleteByPrimaryKey(Long taskid);

    int insert(PmsProjectsTaskWithBLOBs record);

    int insertSelective(PmsProjectsTaskWithBLOBs record);

    List<PmsProjectsTaskWithBLOBs> selectByExampleWithBLOBs(PmsProjectsTaskExample example);

    List<PmsProjectsTask> selectByExample(PmsProjectsTaskExample example);

    PmsProjectsTaskWithBLOBs selectByPrimaryKey(Long taskid);

    int updateByExampleSelective(@Param("record") PmsProjectsTaskWithBLOBs record, @Param("example") PmsProjectsTaskExample example);

    int updateByExampleWithBLOBs(@Param("record") PmsProjectsTaskWithBLOBs record, @Param("example") PmsProjectsTaskExample example);

    int updateByExample(@Param("record") PmsProjectsTask record, @Param("example") PmsProjectsTaskExample example);

    int updateByPrimaryKeySelective(PmsProjectsTaskWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PmsProjectsTaskWithBLOBs record);

    int updateByPrimaryKey(PmsProjectsTask record);
}