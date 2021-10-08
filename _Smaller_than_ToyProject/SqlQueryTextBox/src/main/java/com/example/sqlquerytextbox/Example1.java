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

//to-do: servlet filter

        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

//-----------------------------------------------------------------

        Table table = new Table();
        Comm comm = new Comm();


        String queryInput= request.getParameter("input");
        String queryAfter="";
        ArrayList output= new ArrayList();


        //query taken ';'
        System.out.println("-----input : " + queryInput);
        queryAfter=comm.getQuery(queryInput);
        System.out.println("-----then, query: "+queryAfter);
 //       table.getColumns();
 //       System.out.println("-----Columns: "+table.COLUMNS);
        String keyword="";
        System.out.println(queryAfter.length());
        keyword = comm.getKeyword(queryAfter);
        System.out.println("-----keyword: "+keyword);




/*
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
*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response);
    }
}
