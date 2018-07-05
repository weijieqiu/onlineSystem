package com.onlineSystem.demo.dao;

import com.onlineSystem.demo.bean.PageBean;
import com.onlineSystem.demo.bean.Student;

import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */
public interface StudentDao extends BaseDao<Student> {
    /**
     * 登录验证
     *
     * @param student 学生对象
     * @return 根据用户名和密码返回的学生对象
     */
    Student validLogin(Student student);

    /**
     * 根据准考证查找学生对象
     *
     * @param id 学生准考证号
     * @return 返回符合准考证号的学生对象
     */
    Student getStudentById(String id);

    /**
     * 保存实体对象
     */
    void updateStudent(Student student);

    /**
     * 获取所有学生
     *
     * @param s_student
     * @param pageBean
     * @return
     * @throws Exception
     */
    List<Student> getStudents(Student s_student, PageBean pageBean) throws Exception;


    /**
     * 查询学生记录数
     * @param s_student
     * @return
     * @throws Exception
     */
    int studentCount(Student s_student)throws Exception;

    /**
     * 保存学生实体
     */
    void saveStudent(Student student) throws Exception;



}
