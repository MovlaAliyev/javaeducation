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


public class CityPagiController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database db = new Database();
        BuildTable bt = new BuildTable();
        int s = Integer.parseInt(req.getParameter("start"));
        int e =   Integer.parseInt(req.getParameter("limit"));
        List<City> list = db.paginate(req.getParameter("s"), 
                Integer.parseInt(req.getParameter("start")), 
                Integer.parseInt(req.getParameter("limit")));
        
        resp.getWriter().write(build(list).toString());
    }
    
    private StringBuilder build(List<City> list){
        StringBuilder builder = new StringBuilder();
         for (City c : list) {
             
            builder.append("<tr>")                                              // opening tr tag
                    .append("<td>").append(c.getId()).append("</td>")           // append id column
                    .append("<td>").append(c.getName()).append("</td>")         // append name column
                    .append("<td>").append(c.getCountryCode()).append("</td>")  // append country code column
                    .append("<td>").append(c.getDistrict()).append("</td>")     // append district column
                    .append("<td><a href=\"cityu?id=").append(c.getId())        // append update button data: id
                    .append("&n=").append(c.getName())                          // append update button data: name
                    .append("&cc=").append(c.getCountryCode())                  // append update button data: country code
                    .append("&d=").append(c.getDistrict())                      // append update button data: district
                    .append("\"></a></td>")                                     // closing a href and td tag
                    .append("</tr>");                                           // closing tr tag
            
        }
        return builder;
    }
    
}
