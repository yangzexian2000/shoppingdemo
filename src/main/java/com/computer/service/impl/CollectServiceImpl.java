package com.computer.service.impl;

import com.computer.bean.Collect;
import com.computer.dao.CollectDao;
import com.computer.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收藏的实现层
 * @author yangzexian
 * @date 2022/01/15
 */
@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    CollectDao collectDao;
    @Override
    public Integer saveCollect(Collect collect) {
        return collectDao.saveCollect(collect);
    }

    @Override
    public Collect getCollect(Collect collect) {
        return collectDao.getCollect(collect);
    }

    @Override
    public List<Collect> ListUserCollects(Collect collect) {
        return collectDao.ListUserCollects(collect);
    }

    @Override
    public Integer deleteCollect(Collect collect) {
        return collectDao.deleteCollect(collect);
    }
}
