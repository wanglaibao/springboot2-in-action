package com.laibao.springboot.web.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/my/asyncServlet",asyncSupported = true)
public class HelloAsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.isAsyncSupported()) {
            //req.getAsyncContext(); 这样使用是错误的用下面的方式
            AsyncContext asyncContext =  req.startAsync();
            //启动异步Servlet上下文
            asyncContext.start(() -> {
                try {
                    resp.getWriter().println("this is the hello world servlet example in the Async way");
                    //触发异步操作
                    asyncContext.complete();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
