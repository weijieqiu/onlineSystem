package com.onlineSystem.demo.util;

/**
 * Created by Administrator on 2018/7/3.
 */
public class PapeUtil {

    public static String getPagation(String targetUrl, int totalNum, int currentPage, int pageSize){
        int totalPage=totalNum%pageSize==0?totalNum/pageSize:totalNum/pageSize+1;
        StringBuffer pageCode=new StringBuffer();
        pageCode.append("<li><a href='"+targetUrl+"?page=1'>首页</a></li>");
        if(currentPage==1){
            pageCode.append("<li class='disabled'><a href='#'>上一页</a></li>");
        }else{
            pageCode.append("<li><a href='"+targetUrl+"?page="+(currentPage-1)+"'>上一页</a></li>");
        }
        for(int i=currentPage-2;i<=currentPage+2;i++){
            if(i<1||i>totalPage){
                continue;
            }
            if(i==currentPage){
                pageCode.append("<li class='active'><a href='#'>"+i+"</a></li>");
            }else{
                pageCode.append("<li><a href='"+targetUrl+"?page="+i+"'>"+i+"</a></li>");
            }
        }
        if(currentPage==totalPage){
            pageCode.append("<li class='disabled'><a href='#'>下一页</a></li>");
        }else{
            pageCode.append("<li><a href='"+targetUrl+"?page="+(currentPage+1)+"'>下一页</a></li>");
        }
        pageCode.append("<li><a href='"+targetUrl+"?page="+totalPage+"'>尾页</a></li>");
        return pageCode.toString();
    }
}
