package com.mycompany.userregistr.web;

import com.mycompany.userregistr.dao.AppWareDaoImpl;
import com.mycompany.userregistr.model.AppWare;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "WaresServlet", urlPatterns = "/WaresServlet")
public class WaresServlet extends HttpServlet {
    private AppWareDaoImpl wareDao = new AppWareDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AppWare> wares = wareDao.getAllWares();
        req.setAttribute("wares", wares);
        req.getRequestDispatcher("/home").forward(req, resp);
    }
}