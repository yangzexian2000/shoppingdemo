package com.computer.service.impl;

import com.computer.bean.Comment;
import com.computer.dao.CommentDao;
import com.computer.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yangzexian
 * @date 2022/01/28
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;
    @Override
    public Integer saveComment(Comment comment) {
        return commentDao.saveComment(comment);
    }

    @Override
    public List<Comment> listCommentByGoodsId(Long goodsId) {
        return commentDao.listCommentByGoodsId(goodsId);
    }
}
