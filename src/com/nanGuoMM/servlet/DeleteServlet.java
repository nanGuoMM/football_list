package com.nanGuoMM.servlet;

import com.nanGuoMM.service.GlobalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    private final GlobalService globalService = new GlobalService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取要删除球队的的id
        Integer teamId = Integer.parseInt(req.getParameter("teamId"));
        //调用service
        globalService.deleteTeam(teamId);
        //重定向
        resp.sendRedirect(req.getContextPath() + "/listAndAddServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
