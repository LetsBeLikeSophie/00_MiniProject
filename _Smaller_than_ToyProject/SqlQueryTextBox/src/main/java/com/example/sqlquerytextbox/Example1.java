package com.example.sqlquerytextbox;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

@WebServlet(name = "Example1", value = "/Example1")
public class Example1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String query= request.getParameter("input");
        ArrayList output= new ArrayList();

        System.out.println("input : " + query);

        if(query.contains(";")){

            StringBuffer sb = new StringBuffer();
            sb.append(query);
            int index = sb.indexOf(";");
            sb.deleteCharAt(index);
            query = sb.toString().toUpperCase();
            System.out.println("; << deleted");
        }
        else
            query = query.toUpperCase();

        try {
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclKOSMO00", "csi00","csi1234");
            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet resultSet = pstmt.executeQuery();

            while(resultSet.next()){
                int i =1;
                output.add(resultSet.getString(i));
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(output);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}
