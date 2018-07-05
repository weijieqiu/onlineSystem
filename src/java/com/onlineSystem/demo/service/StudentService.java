package com.onlineSystem.demo.service;

import com.onlineSystem.demo.bean.PageBean;
import com.onlineSystem.demo.bean.Student;

import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */
public interface StudentService {

    Student validLogin(Student student);

    /**
     * 根据id 得到学生对象
     * @param id
     * @return
     */
    Student getStudentById(String id);

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

    int studentCount(Student s_student)throws Exception;

    /**
     * 保存学生实体
     */
    void saveStudent(Student student) throws Exception;

}
