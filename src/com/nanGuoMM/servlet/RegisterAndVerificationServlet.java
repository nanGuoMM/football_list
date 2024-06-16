package com.nanGuoMM.servlet;

import com.nanGuoMM.pojo.User;
import com.nanGuoMM.service.GlobalService;
import com.nanGuoMM.utils.CheckCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registerAndVerificationServlet")
public class RegisterAndVerificationServlet extends HttpServlet {

    private final GlobalService globalService = new GlobalService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用工具类，生成验证码
        ServletOutputStream os = resp.getOutputStream();
        String checkCode = CheckCodeUtil.outputVerifyImage(100, 50, os, 4);
        //将验证码存入session
        HttpSession session = req.getSession();
        session.setAttribute("checkCode",checkCode);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取注册信息
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCodeUserInput = req.getParameter("checkCode");
        String checkCode = (String) req.getSession().getAttribute("checkCode");

        //判断用户名是否合法(最长12的字母)
        String regex1 = "^[a-zA-Z0-9]{3,16}$";
        if(!username.matches(regex1)) {
            req.setAttribute("register_err","用户名只能字母数字，长度3到16");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
            return;
        }
        //判断密码是否合法（至少8位字符）
        String regex2 = "^.{8,}$";
        if(!password.matches(regex2)) {
            System.out.println("password_err");
            req.setAttribute("register_err","密码至少8字符");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
            return;
        }

        //验证码检查(忽略大小写)
        if(!checkCode.equalsIgnoreCase(checkCodeUserInput)) {
            req.setAttribute("register_err","验证码错误");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
            return;
        }


        //调用service
        User reUser = globalService.regist(username);

        //处理数据
        if(reUser == null) {
            //封装数据
            User user = new User(null,username,password);
            //调用service
            globalService.addUser(user);
            //重定向
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }else {
            req.setAttribute("register_err","用户名已存在");
            req.getRequestDispatcher("/register.jsp").forward(req,resp);
        }
    }
}
