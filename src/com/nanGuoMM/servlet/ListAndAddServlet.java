package com.nanGuoMM.servlet;

import com.nanGuoMM.pojo.FootballTeam;
import com.nanGuoMM.service.GlobalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listAndAddServlet")
public class ListAndAddServlet extends HttpServlet {

    private final GlobalService globalService = new GlobalService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<FootballTeam> teams = globalService.listAllTeams();

        //服务器内资源重定向
        req.setAttribute("teams",teams);
        req.getRequestDispatcher("/teamList.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //封装数据
        req.setCharacterEncoding("utf-8");
        String teamName = req.getParameter("teamName");
        String location = req.getParameter("location");
        Integer ordered = Integer.parseInt(req.getParameter("ordered"));
        String description = req.getParameter("description");
        Integer status = Integer.parseInt(req.getParameter("status"));
        FootballTeam team = new FootballTeam(null,teamName,location,ordered,description,status);

        globalService.addTeam(team);

        //重定向
        resp.sendRedirect(req.getContextPath() + "/listAndAddServlet");
    }
}
