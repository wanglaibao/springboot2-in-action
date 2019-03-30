package com.laibao.springboot.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@WebServlet(urlPatterns = "/my/servlet")
public class HelloWorldServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long time1 = System.currentTimeMillis();
        for(int i=0;i<1000;i++) {
            resp.getWriter().println("this is the hello world servlet example");
        }
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long time2 = System.currentTimeMillis();
        System.err.println("一共耗时: "+ (time2 - time1) / 1000+"秒");
    }
}
