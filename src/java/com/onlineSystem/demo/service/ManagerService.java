package com.onlineSystem.demo.service;

import com.onlineSystem.demo.bean.Manager;

/**
 * Created by Administrator on 2018/7/1.
 */
public interface ManagerService {

    // 验证管理员登录
    Manager validLogin(Manager manager);
}
