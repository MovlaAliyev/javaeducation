package com.pasha.database;

import com.pasha.models.City;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class CityUpdateController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database db = new Database();
        RequestDispatcher dispatcher = req.getRequestDispatcher("update.jsp");
        City c = new City(Integer.parseInt(req.getParameter("id")),
                          req.getParameter("n"), 
                          req.getParameter("cc"),
                          req.getParameter("d")
        );
        
        db.updateCity(c);
        req.setAttribute("city", c);
        dispatcher.forward(req, resp);
    }
    
}
