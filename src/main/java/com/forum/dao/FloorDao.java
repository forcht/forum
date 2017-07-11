package com.forum.dao;

import com.forum.entity.Floor;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by haitang on 2017/6/25.
 */
public interface FloorDao {

    /**
     * 根据查找评论的所有楼中楼评论
     * @param commentId
     * @return
     */
    List<Floor> getFloorByCommentId(@Param("commentId") Integer commentId);
}
