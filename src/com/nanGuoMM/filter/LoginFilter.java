package com.nanGuoMM.filter;


import com.nanGuoMM.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Objects;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //强转
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        //登录相关资源
        String[] urls = {"/imgs", "/css", "/login.jsp", "/register.jsp", "/loginServlet", "/registerAndVerificationServlet"};
        //获取访问路径的uri
        String uri = req.getRequestURI();
        for (String url : urls) {
            if (uri.contains(url)) {
                //放行
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        //查询session中的数据
        Enumeration<String> users = req.getSession().getAttributeNames();
        //遍历session
        while (users.hasMoreElements()) {
            String key = users.nextElement();
            User value = (User) req.getSession().getAttribute(key);
            //遍历cookie
            for (Cookie cookie : req.getCookies()) {
                if (cookie.getName().equals("nanGuoMM_football_cookieName" + value.getId().toString())) {
                    String[] cookieValues = cookie.getValue().split("\\|");
                    if (Objects.equals(cookieValues[1], value.getUsername()) && Objects.equals(cookieValues[2], value.getPassword())) {
                        //放行
                        filterChain.doFilter(servletRequest, servletResponse);
                        return;
                    }
                }
            }
        }
        //拦截
        req.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
