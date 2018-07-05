package com.onlineSystem.demo.action;

import com.mchange.v2.util.PropertiesUtils;
import com.onlineSystem.demo.bean.PageBean;
import com.onlineSystem.demo.bean.Paper;
import com.onlineSystem.demo.bean.Question;
import com.onlineSystem.demo.service.PaperService;
import com.onlineSystem.demo.service.QuestionService;
import com.onlineSystem.demo.util.PapeUtil;
import com.onlineSystem.demo.util.PropertiesUtil;
import com.onlineSystem.demo.util.ResponseUtil;
import com.onlineSystem.demo.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/7/3.
 */
public class QuestionAction extends ActionSupport implements ServletRequestAware{

    private static final long serialVersionUID = 5353036176690040543L;
    private HttpServletRequest request;
    private QuestionService questionService;
    private PaperService paperService;
    private List<Question> questionList;
    private List<Paper> paperList;
    private String mainPage;

    private String questionId;
    private Question question;
    private String title;

    private String page;
    private int total;
    private String pageCode;

    private Question s_question;

    public void setPaperService(PaperService paperService) {
        this.paperService = paperService;
    }

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public List<Paper> getPaperList() {
        return paperList;
    }

    public void setPaperList(List<Paper> paperList) {
        this.paperList = paperList;
    }

    public String getMainPage() {
        return mainPage;
    }

    public void setMainPage(String mainPage) {
        this.mainPage = mainPage;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Question getS_question() {
        return s_question;
    }

    public void setS_question(Question s_question) {
        this.s_question = s_question;
    }


    /**
     * 查询试题信息
     * @return
     * @throws Exception
     */
    public String questionList() throws Exception{
        HttpSession session = request.getSession();
        if(StringUtil.isEmpty(page)){
            page = "1";
        }
        if(s_question != null){
            session.setAttribute("s_question", s_question);
        }else {
            Object o = session.getAttribute("s_question");
            if(o != null){
                s_question = (Question)o;
            }else {
                s_question = new Question();
            }
        }
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")));
        questionList = questionService.getQuestions(s_question, pageBean);
        total = questionService.questionCount(s_question);
        pageCode=PapeUtil.getPagation(request.getContextPath()+"/questionList",total, Integer.parseInt(page), Integer.parseInt(PropertiesUtil.getValue("pageSize")));
        mainPage = "question/questionList.jsp";
        return SUCCESS;
    }

    /**
     * 通过id获取试题
     * @return
     * @throws Exception
     */
    public String getQuestionById() throws Exception{
        question = questionService.getQuestionById(Integer.valueOf(questionId));
        mainPage = "question/questionShow.jsp";
        return SUCCESS;
    }

    /**
     * 添加题目预处理
     * @return
     * @throws Exception
     */
    public String preSave() throws Exception{
        paperList=paperService.getPaperList();
        if(StringUtil.isNotEmpty(questionId)){
            question=questionService.getQuestionById(Integer.parseInt(questionId));
            title="修改试题信息";
        }else{
            title="添加试题信息";
        }
        mainPage = "question/questionSave.jsp";
        return SUCCESS;
    }

    /**
     * 保存试题
     * @return
     * @throws Exception
     */
    public String saveQuestion() throws Exception{
        if(StringUtil.isNotEmpty(questionId)){
            question.setId(Integer.parseInt(questionId));
        }
        question.setAnswer(question.getAnswer().toUpperCase());
        questionService.saveQuestion(question);
        return SUCCESS;
    }

    /**
     * 通过id删除试卷
     * @return
     * @throws Exception
     */
    public String questionDelete() throws Exception{
        question = questionService.getQuestionById(Integer.parseInt(questionId));
        questionService.deleteQuestion(question);
        JSONObject resultJson=new JSONObject();
        resultJson.put("success",true);
        ResponseUtil.write(resultJson,ServletActionContext.getResponse());
        return SUCCESS;
    }
    @Override
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
}

