package com.computer.dao;

import com.computer.bean.Collect;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户收藏的dao层
 * @author yangzexian
 * @date 2022/01/15
 */
@Mapper
public interface CollectDao {
    /**
     * 添加收藏
     * @param collect
     * @return
     */
    Integer saveCollect(Collect collect);

    /**
     * 判读是否收藏过
     * @param collect
     * @return
     */
    Collect getCollect(Collect collect);

    /**
     * 查询用户所有的收藏信息
     * @param collect
     * @return
     */
    List<Collect> ListUserCollects(Collect collect);
    /**
     * 删除用户收藏记录
     * @param collect
     * @return
     */
    Integer deleteCollect(Collect collect);
}
