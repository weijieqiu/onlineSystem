package com.onlineSystem.demo.service.impl;

import com.onlineSystem.demo.bean.PageBean;
import com.onlineSystem.demo.bean.Question;
import com.onlineSystem.demo.dao.QuestionDao;
import com.onlineSystem.demo.service.QuestionService;

import java.util.List;

/**
 * Created by Administrator on 2018/7/3.
 */
public class QuestionServiceImpl implements QuestionService{
    private QuestionDao questionDao;

    public void setQuestionDao(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }


    @Override
    public List<Question> getQuestions(Question s_question, PageBean pageBean) throws Exception{
        return questionDao.getQuestions(s_question, pageBean);
    }

    @Override
    public int questionCount(Question s_question) throws Exception {
        return questionDao.questionCount(s_question);
    }

    @Override
    public Question getQuestionById(Integer questionId) throws Exception {
        return questionDao.getQuestionById(questionId);
    }

    @Override
    public void saveQuestion(Question question) throws Exception {
        questionDao.saveQuestion(question);
    }

    @Override
    public void deleteQuestion(Question question) throws Exception {
        questionDao.deleteQuestion(question);
    }
}
