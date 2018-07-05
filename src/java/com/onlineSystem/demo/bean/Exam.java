package com.onlineSystem.demo.bean;

import com.sun.javafx.beans.IDProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/1.
 */
@Entity
@Table(name = "t_exam")
public class Exam {
    private Integer id; // 考试编号
    private Student student;    // 学生
    private Paper paper;        // 试卷
    private Integer singleScore;     // 单选题得分
    private Integer moreScore;      // 多选题得分
    private Integer score;          // 总得分
    private Date examDate;          // 考试时间

    @Id
    @GeneratedValue(generator = "_native")
    @GenericGenerator(name = "_native", strategy = "native")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "studentId")
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne
    @JoinColumn(name = "paperId")
    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public Integer getSingleScore() {
        return singleScore;
    }

    public void setSingleScore(Integer singleScore) {
        this.singleScore = singleScore;
    }

    public Integer getMoreScore() {
        return moreScore;
    }

    public void setMoreScore(Integer moreScore) {
        this.moreScore = moreScore;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }
}
