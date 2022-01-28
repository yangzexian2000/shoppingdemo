package com.computer.service.impl;

import com.computer.bean.History;
import com.computer.dao.BrowsingHistoryDao;
import com.computer.service.BrowsingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 浏览记录的实现层
 * @author yangzexian
 * @date 2022/01/14
 */
@Service
public class BrowsingHistoryServiceImpl implements BrowsingHistoryService {
    @Autowired
    BrowsingHistoryDao browsingHistoryDao;
    @Override
    public Integer saveBrowsingHistory(History history) {
        return browsingHistoryDao.saveBrowsingHistory(history);
    }

    @Override
    public List<History> listBrowsingHistoryByUserId(Long userId) {
        return browsingHistoryDao.listBrowsingHistoryByUserId(userId);
    }

    @Override
    public List<History> listBrowsingHistory() {
        return browsingHistoryDao.listBrowsingHistory();
    }

    @Override
    public List<History> listBrowsingHistoryId(History history) {
        return browsingHistoryDao.listBrowsingHistoryId(history);
    }


    @Override
    public Integer deleteBrowsingHistory(History history) {
        return browsingHistoryDao.deleteBrowsingHistory(history);
    }
}
