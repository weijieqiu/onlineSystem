package com.onlineSystem.demo.service.impl;

import com.onlineSystem.demo.bean.Exam;
import com.onlineSystem.demo.bean.PageBean;
import com.onlineSystem.demo.dao.ExamDao;
import com.onlineSystem.demo.service.ExamService;

import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 */
public class ExamServiceImpl implements ExamService{
    private ExamDao examDao;

    public void setExamDao(ExamDao examDao) {
        this.examDao = examDao;
    }

    @Override
    public void saveExam(Exam exam) throws Exception {
        examDao.saveExam(exam);
    }

    @Override
    public List<Exam> getExams(Exam s_exam, PageBean pageBean) throws Exception {
        return examDao.getExams(s_exam, pageBean);
    }

    @Override
    public int examCount(Exam s_exam) throws Exception {
        return examDao.examCount(s_exam);
    }
}
