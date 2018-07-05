package com.onlineSystem.demo.dao;

import com.onlineSystem.demo.bean.Paper;

import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */
public interface PaperDao extends BaseDao<Paper> {

    List<Paper> getPaperList();

    void savePaper(Paper paper);

    Paper getPaperById(Integer paperId);

    void deletePaper(Paper paper);
}
