package com.onlineSystem.demo.dao.impl;

import com.onlineSystem.demo.bean.Exam;
import com.onlineSystem.demo.bean.PageBean;
import com.onlineSystem.demo.dao.ExamDao;
import com.onlineSystem.demo.util.StringUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Administrator on 2018/7/4.
 */
public class ExamDaoImpl extends BaseDaoHibernate4<Exam> implements ExamDao {
    @Override
    public void saveExam(Exam exam) throws Exception {
        getSessionFactory().getCurrentSession().merge(exam);
    }

    /**
     * 获取考试信息
     * @param s_exam
     * @param pageBean
     * @return
     * @throws Exception
     */
    @Override
    public List<Exam> getExams(Exam s_exam, PageBean pageBean) throws Exception {
        Session session = getSessionFactory().getCurrentSession();
        StringBuffer hql = new StringBuffer("from Exam exam");
        if (s_exam.getStudent() != null && StringUtil.isNotEmpty(s_exam.getStudent().getId())) {
            hql.append(" and exam.student.id like '%" + s_exam.getStudent().getId() + "%'");
        }
        if (s_exam.getStudent() != null && StringUtil.isNotEmpty(s_exam.getStudent().getName())) {
            hql.append(" and exam.student.name like '%" + s_exam.getStudent().getName() + "%'");
        }
        Query query = session.createQuery(hql.toString().replaceFirst("and", "where"));
        if (pageBean != null) {
            query.setFirstResult(pageBean.getStart());
            query.setMaxResults(pageBean.getPageSize());
        }
        @SuppressWarnings("unchecked")
        List<Exam> examList = (List<Exam>) query.list();
        return examList;
    }

    @Override
    public int examCount(Exam s_exam) throws Exception {
        Session session=getSessionFactory().getCurrentSession();
        StringBuffer sql=new StringBuffer("select count(*) from t_exam t1 ,t_student t2 where t1.studentId=t2.id ");
        if(s_exam.getStudent()!=null&&StringUtil.isNotEmpty(s_exam.getStudent().getId())){
            sql.append(" and t2.id like '%"+s_exam.getStudent().getId()+"%'");
        }
        if(s_exam.getStudent()!=null&&StringUtil.isNotEmpty(s_exam.getStudent().getName())){
            sql.append(" and t2.name like '%"+s_exam.getStudent().getName()+"%'");
        }
        Query query=session.createSQLQuery(sql.toString());
        int count=((BigInteger)query.uniqueResult()).intValue();
        return count;
    }
}
