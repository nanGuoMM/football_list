package com.nanGuoMM.servlet;

import com.nanGuoMM.pojo.FootballTeam;
import com.nanGuoMM.service.GlobalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateAndSelectServlet")
public class UpdateAndSelectServlet extends HttpServlet {
    private final GlobalService globalService = new GlobalService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取球队的的id
        Integer teamId = Integer.parseInt(req.getParameter("teamId"));
        //回显
        FootballTeam team = globalService.listOneTeam(teamId);
        req.setAttribute("team", team);
        req.getRequestDispatcher("/updateTeam.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //封装数据
        req.setCharacterEncoding("utf-8");
        Integer id = Integer.parseInt(req.getParameter("id"));
        String teamName = req.getParameter("teamName");
        String location = req.getParameter("location");
        Integer ordered = Integer.parseInt(req.getParameter("ordered"));
        String description = req.getParameter("description");
        Integer status = Integer.parseInt(req.getParameter("status"));
        FootballTeam team = new FootballTeam(id,teamName,location,ordered,description,status);

        globalService.updateTeam(team);

        //重定向
        resp.sendRedirect(req.getContextPath() + "/listAndAddServlet");
    }
}
