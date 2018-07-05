package com.onlineSystem.demo.dao.impl;

import com.onlineSystem.demo.bean.Manager;
import com.onlineSystem.demo.dao.ManagerDao;

import java.util.List;

/**
 * Created by Administrator on 2018/7/1.
 */
public class ManagerDaoImpl extends BaseDaoHibernate4<Manager> implements ManagerDao {


    /**
     * 管理员账号密码验证
     *
     * @param manager 管理员对象
     * @return
     */
    @Override
    public Manager validLogin(Manager manager) {
       /* List<Manager> managerList = find("from Manager as m where m.userName = ?0 and m.password=?1"
                , manager.getUserName(), manager.getPassword());*/

        Manager resultStu = (Manager)findUnique("from Manager as m where m.userName = ?0 and m.password=?1"
                ,manager.getUserName(), manager.getPassword());
        return resultStu;
    }


}
