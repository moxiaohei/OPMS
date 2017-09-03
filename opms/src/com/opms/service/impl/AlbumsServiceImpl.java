package com.opms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opms.entity.PmsAlbums;
import com.opms.entity.PmsAlbumsLaud;
import com.opms.mappers.PmsAlbumsLaudMapper;
import com.opms.mappers.PmsAlbumsMapper;
import com.opms.service.AlbumsService;


/**
 * @author mengyongfei
 * @date 2017年7月30日 下午4:40:58
 * 相册服务层
 */
@Service
public class AlbumsServiceImpl implements AlbumsService{
	
	@Autowired
	private PmsAlbumsMapper pmsAlbumsMapper;
	@Autowired
	private PmsAlbumsLaudMapper pmsAlbumslaudMapper;
	
	//获取多条记录  查询所有相册信息
	@Override
	public List<PmsAlbums> listAlbums() {
		return pmsAlbumsMapper.listAlbums();
	}

	@Override
	public PmsAlbums getAlbums(Long albumid) {
		return pmsAlbumsMapper.getAlbums(albumid);
	}

	@Override
	public int insertAlbums(PmsAlbums pmsAlbums) {
		return pmsAlbumsMapper.insertAlbums(pmsAlbums);
	}

	@Override
	public int deleteByPrimaryKey(Long albumid) {
		return pmsAlbumsMapper.deleteByPrimaryKey(albumid);
	}

	@Override
	public List<PmsAlbums> listAlbumsByUserid(Long userid) {
		return pmsAlbumsMapper.listAlbumsByUserid(userid);
	}
	@Override
	public int updateViewnum(PmsAlbums pmsAlbums) {
		// TODO Auto-generated method stub
		return pmsAlbumsMapper.updateViewnum(pmsAlbums);
	}

	@Override
	public int updateAlbums(PmsAlbums pmsAlbums) {
		// TODO Auto-generated method stub
		return pmsAlbumsMapper.updateAlbums(pmsAlbums);
	}

	@Override
	public int laudAlbums(PmsAlbumsLaud pmsAlbumslaud) {		
		return pmsAlbumslaudMapper.laudAlbums(pmsAlbumslaud);
	}

	@Override
	public int updateLaudnum(PmsAlbums pmsAlbums) {
		// TODO Auto-generated method stub
		return pmsAlbumsMapper.updateLaudnum(pmsAlbums);
	}

	@Override
	public int countLaud(PmsAlbumsLaud pmsAlbumslaud) {
		// TODO Auto-generated method stub
		return pmsAlbumslaudMapper.countLaud(pmsAlbumslaud);
	}
	
}
