package com.pasha.controllers;

import com.pasha.database.Database;
import com.pasha.models.City;
import com.pasha.test.BuildTable;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CitySearchController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database db = new Database();
        BuildTable bt = new BuildTable();
        List<City> list = db.searchCity(req.getParameter("s"));
                                   
        resp.getWriter().write(bt.build(list).toString());
    }
    
}
