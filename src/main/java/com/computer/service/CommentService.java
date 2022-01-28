package com.computer.service;

import com.computer.bean.Comment;

import java.util.List;

/**
 * @author yangzexian
 * @date 2022/01/28
 */
public interface CommentService {
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
