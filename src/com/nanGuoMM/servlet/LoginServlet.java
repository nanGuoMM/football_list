package com.nanGuoMM.servlet;

import com.nanGuoMM.pojo.User;
import com.nanGuoMM.service.GlobalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private final GlobalService globalService = new GlobalService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        //获取登录数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        //调用service
        User reUser = globalService.login(username, password);

        if (reUser != null) {
            //封装创建cookie对象
            String userValue = reUser.getId() + "|" + reUser.getUsername() + "|" + reUser.getPassword();
            String cookieName = "nanGuoMM_football_cookieName" + reUser.getId().toString();
            Cookie cookie = new Cookie(cookieName, userValue);
            //是否延长cookie存活时间
            if ("1".equals(remember)) {
                //创建本地数据cookie
                Cookie cookie1 = new Cookie("nanGuoMM_football_username", reUser.getUsername());
                Cookie cookie2 = new Cookie("nanGuoMM_football_password", reUser.getPassword());
                //让cookie在本地保存一周
                cookie1.setMaxAge(604800);
                cookie2.setMaxAge(604800);
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);
                cookie.setMaxAge(-1);//会话结束后立即销毁登录状态cookie
            } else {
                Cookie cookie1 = new Cookie("nanGuoMM_football_username", reUser.getUsername());
                //会话结束后立即销毁cookie
                cookie1.setMaxAge(-1);
                cookie.setMaxAge(-1);
                resp.addCookie(cookie);
                resp.addCookie(cookie1);
            }
            //创建session
            HttpSession session = req.getSession();
            session.setAttribute(reUser.getId().toString(), reUser);
            session.setMaxInactiveInterval(1440);//设置session最大存储时间为4h
            req.setAttribute("sessionID",reUser.getId());//用户登录显示
            //重定向
            resp.sendRedirect(req.getContextPath() + "/listAndAddServlet");
        } else {
            //输出错误信息
            req.setAttribute("err_msg", "用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
