package com.onlineSystem.demo.dao.impl;

import com.onlineSystem.demo.bean.Paper;
import com.onlineSystem.demo.dao.PaperDao;

import java.util.List;

/**
 * Created by Administrator on 2018/7/2.
 */
public class PaperDaoImpl extends BaseDaoHibernate4<Paper> implements PaperDao{
    /**
     * 获取所有试卷
     * @return
     */
    @Override
    public List<Paper> getPaperList(){
        return find("from Paper");
    }

    @Override
    public void savePaper(Paper paper) {
        update(paper);
    }

    @Override
    public Paper getPaperById(Integer paperId) {
        return get(Paper.class, paperId);
    }

    @Override
    public void deletePaper(Paper paper) {
        delete(paper);
    }
}
