package com.onlineSystem.demo.action;

import com.onlineSystem.demo.bean.Manager;
import com.onlineSystem.demo.service.ManagerService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/7/1.
 */
public class ManagerAction extends ActionSupport implements ServletRequestAware {


    private static final long serialVersionUID = -1240726875408817394L;
    private HttpServletRequest httpServletRequest;
    private Manager manager;
    private String error;
    private ManagerService managerService;

    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    /**
     * 登录验证
     *
     * @return
     * @throws Exception
     */
    public String login() throws Exception {
        HttpSession session = httpServletRequest.getSession();
        Manager currentUser = managerService.validLogin(manager);
        if(currentUser == null){
            error = "用户名或者密码错误!";
            return ERROR;
        }else {
            session.setAttribute("currentUser", currentUser);
            return SUCCESS;
        }
    }

    /**
     * 注销用户
     * @throws Exception
     */
    public String logout()throws Exception{
        httpServletRequest.getSession().invalidate();
        return SUCCESS;
    }



    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.httpServletRequest = request;
    }
}
