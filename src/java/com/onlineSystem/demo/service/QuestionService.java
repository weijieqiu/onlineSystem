package com.onlineSystem.demo.service;

import com.onlineSystem.demo.bean.PageBean;
import com.onlineSystem.demo.bean.Question;

import java.util.List;

/**
 * Created by Administrator on 2018/7/3.
 */
public interface QuestionService {

    List<Question> getQuestions(Question s_question, PageBean pageBean) throws Exception;
    int questionCount(Question s_question) throws Exception;
    Question getQuestionById(Integer questionId) throws Exception;
    void saveQuestion(Question question) throws Exception;
    void deleteQuestion(Question question) throws Exception;
}
