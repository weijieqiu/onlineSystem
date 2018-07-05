package com.onlineSystem.demo.service.impl;

import com.onlineSystem.demo.bean.Paper;
import com.onlineSystem.demo.dao.PaperDao;
import com.onlineSystem.demo.service.PaperService;

import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */
public class PaperServiceImpl implements PaperService {
    private PaperDao paperDao;

    public void setPaperDao(PaperDao paperDao) {
        this.paperDao = paperDao;
    }

    @Override
    public List<Paper> getPaperList() {
        return paperDao.getPaperList();
    }

    @Override
    public void savePaper(Paper paper) {
        paperDao.savePaper(paper);
    }

    @Override
    public Paper getPaperById(Integer paperId) {
        return paperDao.getPaperById(paperId);
    }

    @Override
    public void deletePaper(Paper paper) {
        paperDao.deletePaper(paper);
    }
}
