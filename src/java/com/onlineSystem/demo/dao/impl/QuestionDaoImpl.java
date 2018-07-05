package com.onlineSystem.demo.dao.impl;

import com.onlineSystem.demo.bean.PageBean;
import com.onlineSystem.demo.bean.Question;
import com.onlineSystem.demo.dao.QuestionDao;
import com.onlineSystem.demo.util.StringUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Administrator on 2018/7/3.
 */
public class QuestionDaoImpl extends BaseDaoHibernate4<Question> implements QuestionDao{

    /**
     * 获取所有的题目
     * @param s_question
     * @param pageBean
     * @return
     */
    @Override
    public List<Question> getQuestions(Question s_question, PageBean pageBean) throws Exception{

        Session session=getSessionFactory().getCurrentSession();
        StringBuffer hql=new StringBuffer("from Question");
        if(StringUtil.isNotEmpty(s_question.getSubject())){
            hql.append(" and subject like '%"+s_question.getSubject()+"%'");
        }
        Query query=session.createQuery(hql.toString().replaceFirst("and", "where"));
        if(pageBean!=null){
            query.setFirstResult(pageBean.getStart());
            query.setMaxResults(pageBean.getPageSize());
        }
        @SuppressWarnings("unchecked")
        List<Question> questionList=(List<Question>)query.list();
        return questionList;
    }

    /**
     * 获取题目总数
     * @param s_question
     * @return
     */
    @Override
    public int questionCount(Question s_question) throws Exception{

        StringBuffer sql=new StringBuffer("select count(*) from t_question");
        if(StringUtil.isNotEmpty(s_question.getSubject())){
            sql.append(" and subject like '%"+s_question.getSubject()+"%'");
        }
        Query query=getSessionFactory().getCurrentSession().createSQLQuery(sql.toString().replaceFirst("and", "where"));
        int count=((BigInteger)query.uniqueResult()).intValue();
        return count;
    }

    @Override
    public Question getQuestionById(Integer questionId) throws Exception {
        return get(Question.class, questionId);
    }

    @Override
    public void saveQuestion(Question question) throws Exception {
        Session session = getSessionFactory().getCurrentSession();
        session.merge(question);
    }

    @Override
    public void deleteQuestion(Question question) throws Exception {
        delete(question);
    }


}
