/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pasha.test;

import com.pasha.models.City;
import java.util.List;

/**
 *
 * @author Javatarr
 */
public class BuildTable {

    private StringBuilder builder = new StringBuilder();

    public StringBuilder build(List<City> list) {
        buildTHeader();
        buildTBody(list);
        
        return builder;
    }

    public void buildTHeader() {
        builder.append("<table id =\"t\">") // opening table tag
                .append("<thead>")
                .append("<tr>") // starting append column fields
                .append("<td>ID</td>")
                .append("<td>NAME</td>")
                .append("<td>CountryCode</td>")
                .append("<td>District</td>")
                .append("<td>Update</td>")
                .append("</tr>")
                .append("</thead>");
    }

    public void buildTBody(List<City> list) {
        int count = 0;
        builder.append("<tbody id='tb'>");
        for (City c : list) {
            builder.append("<tr>") // opening tr tag
                    .append("<td>").append(c.getId()).append("</td>") // append id column
                    .append("<td>").append(c.getName()).append("</td>") // append name column
                    .append("<td>").append(c.getCountryCode()).append("</td>") // append country code column
                    .append("<td>").append(c.getDistrict()).append("</td>") // append district column
                    .append("<td><a href=\"cityu?id=").append(c.getId()) // append update button data: id
                    .append("&n=").append(c.getName()) // append update button data: name
                    .append("&cc=").append(c.getCountryCode()) // append update button data: country code
                    .append("&d=").append(c.getDistrict()) // append update button data: district
                    .append("\"></a></td>") // closing a href and td tag
                    .append("</tr>");                                           // closing tr tag
            count++;
        }
       builder.append("</tbody>");
        
        buildTFooter(count);
    }

    public void buildTFooter(int count) {
        builder.append("</table>");

        
    }

}
