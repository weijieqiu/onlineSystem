package com.onlineSystem.demo.util;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2018/7/3.
 */
public class ResponseUtil {
    public static void write(Object o,HttpServletResponse response)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.println(o.toString());
        out.flush();
        out.close();
    }
}
