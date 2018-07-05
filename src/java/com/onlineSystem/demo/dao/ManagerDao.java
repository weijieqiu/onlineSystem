package com.onlineSystem.demo.dao;

import com.onlineSystem.demo.bean.Manager;

import java.util.List;

/**
 * Created by Administrator on 2018/7/1.
 */
public interface ManagerDao extends BaseDao<Manager>{


    /**
     * 管理员账号密码验证
     * @param manager 管理员对象
     * @return 管理员
     */
    Manager validLogin(Manager manager);
}
