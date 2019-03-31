# AsyncServlet

### 为什么要使用AsyncServlet

### 同步AsyncServlet阻塞了什么

   同步Servlet阻塞了Tomcat容器Servlet线程
   每一个请求到来的时候，tomcat都会创建一个线程来对请求进行处理，线程内部会调用我们【开发人员】编写的Servlet来进行处理。
   当我们采用同步Servlet的时候，我们的业务逻辑代码花多少时间，与这个Servlet关联的线程也就需要等待多少时间，这就是阻塞。

### AsyncServlet是如何工作的

### 启动mongodb
\bin\mongod --dbpath d:\DB\mongodb\data --smallfiles