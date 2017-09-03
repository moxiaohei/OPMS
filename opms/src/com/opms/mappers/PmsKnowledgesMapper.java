package com.opms.mappers;

import com.opms.entity.PmsCommentUser;
import com.opms.entity.PmsKnowledges;
import com.opms.entity.PmsKnowledgesComment;

import com.opms.entity.PmsKnowledgesLaud;
import com.opms.entity.PmsKnowledgesUser;
import com.opms.entity.PmsUseridKnowid;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PmsKnowledgesMapper {
    
    int deleteByPrimaryKey(Long knowid);

    int insert(PmsKnowledges record);

    int insertSelective(PmsKnowledges record);

   

    PmsKnowledges selectByPrimaryKey(Long knowid);

   
    int updateByPrimaryKeySelective(PmsKnowledges record);

    int updateByPrimaryKeyWithBLOBs(PmsKnowledges record);

    int updateByPrimaryKey(PmsKnowledges record);

	List<String> listFindTitleAll();
	List<PmsKnowledges> selectByKnowledgesKey(long userid);

	List<PmsKnowledgesUser> selectByKnowledgesUserKey(Long id);

	List<PmsKnowledgesUser> selectByKnowledgesUsersortid(int sortid);

	List<PmsKnowledgesUser> selectKnowledgesUser();

	List<PmsKnowledgesUser> selectByKnowledgesUserknowid(Long knowid);

	List<PmsCommentUser> selectCommentByKnowledgeKnowid(Long knowid);

	void insertComment(PmsKnowledgesComment pmsKnowledgesComment);

	PmsCommentUser selectCommentByKnowledgecomtid(Long comtid);

	Long selectKnowledgesuseridByknowid(Long knowid);

	void delKnowledgesByKnowid(Long knowid);

	void delCommentByKnowid(Long knowid);

	void updateKnowledgeComtnum(Long knowid);

	PmsKnowledges selectByKnowledgesKnowid(Long knowid);

	void update_knowlwdge(PmsKnowledges pmsKnowledges);

	void updateKnowledgeLaud(Long knowid);

	void updateKnowledgeView(Long knowid);

	List<PmsKnowledgesUser> selectlistPmsKnowledgesUserBykeywords(
			String keywords);

	List<String> selectAlltag();

	List<String> selectAlltitle();

	Long selectCommentuseridByknowid(Long knowid);

	void updateKnowledgeLaud2(Long knowid);

	void insertLaud(PmsKnowledgesLaud pmsKnowledgesLaud);

	Long selectLauderuseridByknowid(Long knowid);

	void delLaudByKnowid(PmsUseridKnowid pmsUseridKnowid);
}