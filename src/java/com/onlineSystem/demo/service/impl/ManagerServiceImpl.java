package com.onlineSystem.demo.service.impl;

import com.onlineSystem.demo.bean.Manager;
import com.onlineSystem.demo.dao.ManagerDao;
import com.onlineSystem.demo.service.ManagerService;

/**
 * Created by Administrator on 2018/7/1.
 */
public class ManagerServiceImpl implements ManagerService {

    private ManagerDao managerDao;

    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }


    /**
     * 管理员账号密码验证
     * @param manager 管理员
     * @return 符合账号密码的管理员
     */
    @Override
    public Manager validLogin(Manager manager) {
        return managerDao.validLogin(manager);
    }
}
