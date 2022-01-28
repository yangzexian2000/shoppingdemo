package com.computer.dao;

import com.computer.bean.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 评论类的dao
 * @author yangzexian
 * @date 2022/01/28
 */
@Mapper
public interface CommentDao {
    /**
     * 添加评论
     * @param comment
     * @return
     */
    Integer saveComment(Comment comment);

    /**
     * 根据商品id查询商品的评论内容
     * @param goodsId
     * @return
     */
    List<Comment> listCommentByGoodsId(Long goodsId);
}
