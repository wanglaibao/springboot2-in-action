package com.laibao.springboot.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@WebServlet("/sseServlet")
public class ServerSentEventsServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //下面两个响应头是SSE必须要的
        resp.setContentType("text/event-stream");
        resp.setCharacterEncoding("UTF-8");
        for (int i=0;i<100;i++) {
            //sse 数据格式: data:+数据+2个回车
            resp.getWriter().write("data:"+i+"\n\n");
            resp.getWriter().flush();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
