package com.opms.mappers;

import com.opms.entity.PmsProjectsTeam;
import com.opms.entity.PmsProjectsTeamExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PmsProjectsTeamMapper {
    int countByExample(PmsProjectsTeamExample example);

    int deleteByExample(PmsProjectsTeamExample example);

    int deleteByPrimaryKey(Long id);
    
    void deleteByUserid(Long userid);

    int insert(PmsProjectsTeam record);

    int insertSelective(PmsProjectsTeam record);

    List<PmsProjectsTeam> selectByExample(PmsProjectsTeamExample example);

    PmsProjectsTeam selectByPrimaryKey(Long id);
    
    List<PmsProjectsTeam> selectByProjectid(Long projectid);

    int updateByExampleSelective(@Param("record") PmsProjectsTeam record, @Param("example") PmsProjectsTeamExample example);

    int updateByExample(@Param("record") PmsProjectsTeam record, @Param("example") PmsProjectsTeamExample example);

    int updateByPrimaryKeySelective(PmsProjectsTeam record);

    int updateByPrimaryKey(PmsProjectsTeam record);
}