package com.onlineSystem.demo.action;

import com.onlineSystem.demo.bean.Exam;
import com.onlineSystem.demo.bean.PageBean;
import com.onlineSystem.demo.bean.Question;
import com.onlineSystem.demo.service.ExamService;
import com.onlineSystem.demo.service.QuestionService;
import com.onlineSystem.demo.util.PapeUtil;
import com.onlineSystem.demo.util.PropertiesUtil;
import com.onlineSystem.demo.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/4.
 */
public class ExamAction extends ActionSupport implements ServletRequestAware {
    private static final long serialVersionUID = -6706565118622497941L;
    private HttpServletRequest httpServletRequest;
    private QuestionService questionService;
    private ExamService examService;

    private String mainPage;

    private Exam exam;
    private Exam s_exam;

    private List<Exam> examList;

    private String page;
    private int total;
    private String pageCode;

    public void setExamService(ExamService examService) {
        this.examService = examService;
    }

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    public String getMainPage() {
        return mainPage;
    }

    public void setMainPage(String mainPage) {
        this.mainPage = mainPage;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Exam getS_exam() {
        return s_exam;
    }

    public void setS_exam(Exam s_exam) {
        this.s_exam = s_exam;
    }

    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
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

    /**
     * 计算/添加考试成绩
     *
     * @return
     * @throws Exception
     */
    public String addExam() throws Exception {
        Map<String, String[]> keyMap = new HashMap<>();
        keyMap = httpServletRequest.getParameterMap();
        Iterator<Map.Entry<String, String[]>> it2 = keyMap.entrySet().iterator();
        int totalScore = 0;
        int singleScore = 0;
        int moreScore = 0;
        while (it2.hasNext()) {
            Map.Entry<String, String[]> entry = it2.next();
            String keyStr = entry.getKey();
            String values[] = entry.getValue();
            String key;
            String value = "";
            if (keyStr.equals("exam.student.id") || keyStr.equals("exam.paper.id")) {
                continue;
            }
            if (keyStr.split("-")[1].equals("r")) {  // 单选
                key = keyStr.split("-")[2];
                value = values[0];
                singleScore += this.calScore(key, value, "1");
            } else {  // 多选
                key = keyStr.split("-")[2];
                for (String s : values) {
                    value += s + ",";
                }
                value = value.substring(0, value.length() - 1);
                moreScore += this.calScore(key, value, "2");
            }
        }
        totalScore = singleScore + moreScore;
        exam.setSingleScore(singleScore);
        exam.setMoreScore(moreScore);
        exam.setScore(totalScore);
        exam.setExamDate(new Date(System.currentTimeMillis()));
        examService.saveExam(exam);
        mainPage = "exam/examResult.jsp";
        return SUCCESS;
    }

    /**
     * 计算每道题目的得分
     *
     * @param questionId
     * @param userAnswer
     * @return
     */
    private int calScore(String questionId, String userAnswer, String type) throws Exception {
        Question question = questionService.getQuestionById(Integer.valueOf(questionId));
        if (userAnswer.equals(question.getAnswer())) {
            if ("1".equals(type)) {
                return 20;
            } else {
                return 30;
            }
        } else {
            return 0;
        }
    }

    /**
     * 获取所有考试成绩（该考生）
     * @return
     * @throws Exception
     */
    public String examList() throws Exception{
        HttpSession session = httpServletRequest.getSession();
        if (StringUtil.isEmpty(page)) {
            page = "1";
        }
        if (s_exam != null) {
            session.setAttribute("s_exam", s_exam);
        } else {
            Object o = session.getAttribute("s_exam");
            if (o != null) {
                s_exam = (Exam) o;
            } else {
                s_exam = new Exam();
            }
        }
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")));
        examList = examService.getExams(s_exam, pageBean);
        total = examService.examCount(s_exam);
        pageCode = PapeUtil.getPagation(httpServletRequest.getContextPath() + "/examList", total, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")));
        mainPage = "exam/examList.jsp";
        return SUCCESS;
    }

    /**
     * 获取考试成绩
     *
     * @return
     * @throws Exception
     */
    public String getExams() throws Exception {
        examList = examService.getExams(s_exam, null);
        mainPage = "exam/myExam.jsp";
        return SUCCESS;
    }

    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.httpServletRequest = request;
    }
}
