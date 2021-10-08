package com.example.sqlquerytextbox;

import java.sql.*;

public class Table {
    public static String TABLE = "TABLE01";
    public static String QUERY ="";

    public static String[] COLUMNS ={};


    public void getColumns() {

        try {
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclKOSMO00", "csi00", "csi1234");
            PreparedStatement pstmt = connection.prepareStatement("SELECT COLUMN_NAME FROM ALL_TAB_COLUMNS WHERE TABLE_NAME ='" + TABLE + "\'");
            ResultSet resultSet = pstmt.executeQuery();

            for (int i = 0; resultSet.next() ; i++) {
                COLUMNS[i]= resultSet.getString(i);
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }
}