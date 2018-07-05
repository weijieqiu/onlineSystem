package com.onlineSystem.demo.service;

import com.onlineSystem.demo.bean.Paper;
import com.onlineSystem.demo.dao.PaperDao;

import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */
public interface PaperService {
    List<Paper> getPaperList();

    void savePaper(Paper paper);

    /**
     * 通过Id得到试卷
     * @param paperId
     * @return
     */
    Paper getPaperById(Integer paperId);

    /**
     * 删除试卷
     * @param paper
     */
     void deletePaper(Paper paper);
}
