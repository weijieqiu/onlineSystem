package com.onlineSystem.demo.dao.impl;

import com.onlineSystem.demo.bean.PageBean;
import com.onlineSystem.demo.bean.Student;
import com.onlineSystem.demo.dao.StudentDao;
import com.onlineSystem.demo.util.StringUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */
public class StudentDaoImpl extends BaseDaoHibernate4<Student> implements StudentDao{
    @Override
    public Student validLogin(Student student) {
        Student resultStu = (Student)findUnique("from Student as s where s.id = ?0 and s.password = ?1"
                ,student.getId(), student.getPassword());
        /*Session session=getSessionFactory().getCurrentSession();
        Query query=session.createQuery("from Student as s where s.id=:id and s.password=:password ");
        query.setString("id", student.getId());
        query.setString("password", student.getPassword());
        Student resultStu=(Student)query.uniqueResult();
        return resultStu;*/
        return resultStu;
    }

    @Override
    public Student getStudentById(String id) {
        return get(Student.class, id);
    }

    @Override
    public void updateStudent(Student student) {
        update(student);
    }

    @Override
    public List<Student> getStudents(Student s_student, PageBean pageBean) throws Exception {
        Session session=getSessionFactory().getCurrentSession();
        StringBuffer hql=new StringBuffer("from Student");
        if(StringUtil.isNotEmpty(s_student.getId())){
            hql.append(" and id like '%"+s_student.getId()+"%'");
        }
        if(StringUtil.isNotEmpty(s_student.getName())){
            hql.append(" and name like '%"+s_student.getName()+"%'");
        }
        Query query=session.createQuery(hql.toString().replaceFirst("and", "where"));
        if(pageBean!=null){
            query.setFirstResult(pageBean.getStart());
            query.setMaxResults(pageBean.getPageSize());
        }
        @SuppressWarnings("unchecked")
        List<Student> studentList=(List<Student>)query.list();
        return studentList;
    }

    @Override
    public int studentCount(Student s_student) throws Exception {
        Session session=getSessionFactory().getCurrentSession();
        StringBuffer sql=new StringBuffer("select count(*) from t_student");
        if(StringUtil.isNotEmpty(s_student.getId())){
            sql.append(" and id like '%"+s_student.getId()+"%'");
        }
        if(StringUtil.isNotEmpty(s_student.getName())){
            sql.append(" and name like '%"+s_student.getName()+"%'");
        }
        Query query=session.createSQLQuery(sql.toString().replaceFirst("and", "where"));
        int count=((BigInteger)query.uniqueResult()).intValue();
        return count;
    }

    /**
     * 保存学生实体
     * @param student
     * @throws Exception
     */
    @Override
    public void saveStudent(Student student) throws Exception {
        getSessionFactory().getCurrentSession().merge(student);
    }
}
