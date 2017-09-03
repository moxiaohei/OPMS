package com.opms.mappers;

import com.opms.entity.PmsAlbumsLaud;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsAlbumsLaudMapper {
	//相片点赞
    int laudAlbums(PmsAlbumsLaud pmsAlbumslaud);
    //根据相片id和用户id查询点赞次数
    int countLaud(PmsAlbumsLaud pmsAlbumslaud);
}