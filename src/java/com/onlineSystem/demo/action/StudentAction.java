package com.onlineSystem.demo.action;

import com.onlineSystem.demo.bean.Exam;
import com.onlineSystem.demo.bean.PageBean;
import com.onlineSystem.demo.bean.Student;
import com.onlineSystem.demo.dao.StudentDao;
import com.onlineSystem.demo.service.StudentService;
import com.onlineSystem.demo.service.impl.StudentServiceImpl;
import com.onlineSystem.demo.util.DateUtil;
import com.onlineSystem.demo.util.PapeUtil;
import com.onlineSystem.demo.util.PropertiesUtil;
import com.onlineSystem.demo.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */
public class StudentAction extends ActionSupport implements ServletRequestAware {

    private static final long serialVersionUID = 4303616871966448282L;
    private HttpServletRequest httpServletRequest;
    private StudentService studentService;
    private String mainPage;

    private Student student;
    private String error;
    private String page;
    private int total;
    private String pageCode;

    private List<Student> studentList;

    private Student s_student;

    private String id;      // 学生编号
    private String title;   // 标题


    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    public String getMainPage() {
        return mainPage;
    }

    public void setMainPage(String mainPage) {
        this.mainPage = mainPage;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getPageCode() {
        return pageCode;
    }

    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Student getS_student() {
        return s_student;
    }

    public void setS_student(Student s_student) {
        this.s_student = s_student;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    /**
     * 学生登录验证
     *
     * @return 成功或失败
     * @throws Exception
     */
    public String login() throws Exception {
        HttpSession session = httpServletRequest.getSession();
        Student currentUser = studentService.validLogin(student);
        if (currentUser == null) {
            error = "准考证号或者密码错误!";
            setError(error);
            return ERROR;
        } else {
            session.setAttribute("currentUser", currentUser);
            return SUCCESS;
        }
    }

    /**
     * 注销用户
     *
     * @throws Exception
     */
    public String logout() throws Exception {
        httpServletRequest.getSession().invalidate();
        return SUCCESS;
    }

    /**
     * 修改密码预处理操作
     *
     * @throws Exception
     */
    public String preUpdatePassword() throws Exception {
        mainPage = "student/updatePassword.jsp";
        return SUCCESS;
    }

    public String updatePassword() throws Exception {
        // 根据ID查询学生
        Student s = studentService.getStudentById(student.getId());
        s.setPassword(student.getPassword());
        studentService.updateStudent(s);
        mainPage = "student/updateSuccess.jsp";
        return SUCCESS;
    }


    /**
     * 查询学生信息
     *
     * @return
     * @throws Exception
     */
    public String studentList() throws Exception {
        HttpSession session = httpServletRequest.getSession();
        if (StringUtil.isEmpty(page)) {
            page = "1";
        }
        if (s_student != null) {
            session.setAttribute("s_student", s_student);
        } else {
            Object o = session.getAttribute("s_student");
            if (o != null) {
                s_student = (Student) o;
            } else {
                s_student = new Student();
            }
        }
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")));
        studentList = studentService.getStudents(s_student, pageBean);
        total = studentService.studentCount(s_student);
        pageCode = PapeUtil.getPagation(httpServletRequest.getContextPath() + "/studentList", total, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")));
        mainPage = "student/studentList.jsp";
        return SUCCESS;
    }

    /**
     * 添加学生信息预处理
     * @return
     * @throws Exception
     */
    public String studentPreSave() throws Exception {
        if(StringUtil.isNotEmpty(id)){
            student=studentService.getStudentById(id);
            title="修改学生信息";
        }else{
            title="添加学生信息";
        }
        mainPage="student/studentSave.jsp";
        return SUCCESS;
    }

    /**
     * 保存学生信息
     * @return
     * @throws Exception
     */
    public String saveStudent() throws Exception{
        if(StringUtil.isEmpty(student.getId())){
            student.setId("TX"+ DateUtil.getCurrentDateStr());
        }
       studentService.saveStudent(student);
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.httpServletRequest = request;
    }
}
