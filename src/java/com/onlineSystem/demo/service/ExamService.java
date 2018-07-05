package com.onlineSystem.demo.service;

import com.onlineSystem.demo.bean.Exam;
import com.onlineSystem.demo.bean.PageBean;

import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 */
public interface ExamService {

    /**
     * 保存考试信息
     * @param exam
     * @throws Exception
     */
    void saveExam(Exam exam)throws Exception;

    /**
     * 获取考试信息
     * @param s_exam
     * @param pageBean
     * @return
     * @throws Exception
     */
    List<Exam> getExams(Exam s_exam, PageBean pageBean)throws Exception;

    /**
     * 查询考试信息记录数
     * @param s_exam
     * @return
     * @throws Exception
     */
    int examCount(Exam s_exam)throws Exception;
}
