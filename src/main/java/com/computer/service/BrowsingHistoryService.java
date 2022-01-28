package com.computer.service;

import com.computer.bean.History;

import java.util.List;

/**
 * 浏览记录的service
 * @author yangzexian
 * @date 2022/01/14
 */
public interface BrowsingHistoryService {
    /**
     * 添加浏览信息
     * @param history
     * @return
     */
    Integer saveBrowsingHistory(History history);

    /**
     * 根据用户id查找用户的浏览记录
     * @param userId
     * @return
     */
    List<History> listBrowsingHistoryByUserId(Long userId);

    /**
     * 查找浏览记录
     * @param
     * @return
     */
    List<History> listBrowsingHistory();
    /**
     * 查找浏览记录根据商品id 和用户id
     * @param
     * @return
     */
    List<History> listBrowsingHistoryId(History history);
    /**
     * 删除浏览记录
     * @param history
     * @return
     */
    Integer deleteBrowsingHistory(History history);
}
