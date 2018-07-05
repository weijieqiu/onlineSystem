package com.onlineSystem.demo.service.impl;

import com.onlineSystem.demo.bean.PageBean;
import com.onlineSystem.demo.bean.Student;
import com.onlineSystem.demo.dao.StudentDao;
import com.onlineSystem.demo.service.StudentService;

import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */
public class StudentServiceImpl implements StudentService {
    StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student validLogin(Student student) {
        return studentDao.validLogin(student);
    }

    @Override
    public Student getStudentById(String id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    @Override
    public List<Student> getStudents(Student s_student, PageBean pageBean) throws Exception {
        return studentDao.getStudents(s_student, pageBean);
    }

    @Override
    public int studentCount(Student s_student) throws Exception {
        return studentDao.studentCount(s_student);
    }

    @Override
    public void saveStudent(Student student) throws Exception {
        studentDao.saveStudent(student);
    }


}
