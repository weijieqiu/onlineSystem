package com.onlineSystem.demo.action;

import com.onlineSystem.demo.bean.Paper;
import com.onlineSystem.demo.bean.Question;
import com.onlineSystem.demo.service.PaperService;
import com.onlineSystem.demo.util.ResponseUtil;
import com.onlineSystem.demo.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;


import java.util.*;


/**
 * Created by Administrator on 2018/7/2.
 */
public class PaperAction extends ActionSupport{


    private static final long serialVersionUID = 7704700353002399445L;

    private String mainPage;
    private String paperId;

    private PaperService paperService;
    private List<Paper> paperList = new ArrayList<>();
    private List<Question> squestionList=new ArrayList<Question>();
    private List<Question> mquestionList=new ArrayList<Question>();

    private String title;   // 试卷名字(标题)
    private Paper paper;

    public void setPaperService(PaperService paperService) {
        this.paperService = paperService;
    }

    public String getMainPage() {
        return mainPage;
    }

    public void setMainPage(String mainPage) {
        this.mainPage = mainPage;
    }

    public String getPaperId() {
        return paperId;
    }

    public void setPaperId(String paperId) {
        this.paperId = paperId;
    }

    public List<Paper> getPaperList() {
        return paperList;
    }

    public void setPaperList(List<Paper> paperList) {
        this.paperList = paperList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public List<Question> getSquestionList() {
        return squestionList;
    }

    public void setSquestionList(List<Question> squestionList) {
        this.squestionList = squestionList;
    }

    public List<Question> getMquestionList() {
        return mquestionList;
    }

    public void setMquestionList(List<Question> mquestionList) {
        this.mquestionList = mquestionList;
    }

    /**
     * 显示所有的试卷(学生)
     * @return
     * @throws Exception
     */
    public String stuPaperList() throws Exception{
        paperList = paperService.getPaperList();
        mainPage = "exam/selectPaper.jsp";
        return SUCCESS;
    }

    /**
     * 显示所有的试卷(管理员)
     * @return
     * @throws Exception
     */
    public String paperList() throws Exception{
        paperList = paperService.getPaperList();
        mainPage = "paper/paperList.jsp";
        return SUCCESS;
    }

    /**
     * 预添加试卷或直接修改试卷
     * @return
     * @throws Exception
     */
    public String paperPreSave() throws Exception{
        if(StringUtil.isNotEmpty(paperId)){
            paper = paperService.getPaperById(Integer.valueOf(paperId));
            title = "修改试卷";
        }else {
            title = "添加试卷";
        }
        mainPage = "paper/paperSave.jsp";
        return SUCCESS;
    }


    /**
     * 添加试卷
     * @return
     * @throws Exception
     */
    public String paperSavePaper() throws Exception{
        if(StringUtil.isNotEmpty(paperId)){
            paper.setId(Integer.parseInt(paperId));
        }else {
            paper.setJoinDate(new Date(System.currentTimeMillis()));
        }
        paperService.savePaper(paper);
        return SUCCESS;
    }


    /**
     * 删除试卷
     * @return
     * @throws Exception
     */
    public String paperDelete() throws Exception{
        paper = paperService.getPaperById(Integer.valueOf(paperId));
        JSONObject resultJson=new JSONObject();
        paperService.deletePaper(paper);
        resultJson.put("success", true);
        ResponseUtil.write(resultJson, ServletActionContext.getResponse());
        return SUCCESS;
    }


    /**
     * 获取试卷的题目
     * @return
     * @throws Exception
     */
    public String getDetailPaper() throws Exception{
        paper = paperService.getPaperById(Integer.valueOf(paperId));
        Set<Question> questionList = paper.getQuestions();
        Iterator<Question> it=questionList.iterator();
        while(it.hasNext()){
            Question q=it.next();
            if("1".equals(q.getType())){
                squestionList.add(q);
            }else{
                mquestionList.add(q);
            }
        }
        mainPage = "exam/paper.jsp";
        return SUCCESS;
    }
}
