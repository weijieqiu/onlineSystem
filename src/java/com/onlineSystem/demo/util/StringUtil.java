package com.onlineSystem.demo.util;

/**
 * Created by Administrator on 2018/7/2.
 */
public class StringUtil {
    /**
     * 判断是否是空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if("".equals(str)|| str==null){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 判断是否不是空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        if(!"".equals(str)&&str!=null){
            return true;
        }else{
            return false;
        }
    }
}
