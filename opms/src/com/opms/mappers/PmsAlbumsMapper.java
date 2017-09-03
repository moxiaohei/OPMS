package com.opms.mappers;

import java.util.List;

import com.opms.entity.PmsAlbums;

public interface PmsAlbumsMapper {
	//查询所有相册信息
	List<PmsAlbums> listAlbums();
	
	//根据相片ID查询相片详细信息
	PmsAlbums getAlbums(Long albumid);
	
	//插入相片信息
	int insertAlbums(PmsAlbums pmsAlbums);
	//根据相片ID删除相片信息
    int deleteByPrimaryKey(Long albumid);

    //查询自己的相册
    List<PmsAlbums> listAlbumsByUserid(Long userid);
    
   //根据相片id修改查看次数
    int updateViewnum(PmsAlbums pmsAlbums);
    //根据相片id修改标题，说明，状态
    int updateAlbums(PmsAlbums pmsAlbums);
    //根据相片id修改点赞次数
    int updateLaudnum(PmsAlbums pmsAlbums);
    
}