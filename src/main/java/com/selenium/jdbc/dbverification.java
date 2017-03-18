package com.selenium.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * Created by THOODI on 3/18/2017.
 */
public class dbverification {
    static Connection conn = null;
    ReadPropertyFile file = null;
    // Create Connection to DB
    // String connectionString =
    // "jdbc:mysql://localhost:3306/emp?user=root&password=ankita@123&useUnicode=true&characterEncoding=UTF-8";
    public ArrayList<String> db(String query, String[] dbColumn)
            throws Throwable {
        try {
            String value = null;
            file = new ReadPropertyFile();
			/*
			 * String dbUrl = "jdbc:mysql://192.168.1.100:3306/lotus_phase2";
			 * String username = "root"; String password = "root";
			 */
            conn = DriverManager.getConnection(file.getConnectionString());
            Class.forName("com.mysql.jdbc.Driver");
            // Create statement for database connection
            Statement stat = conn.createStatement();
            // Send query to db
            ResultSet rs = stat.executeQuery(query);
			/*
			 * java.sql.ResultSetMetaData metaData = rs.getMetaData(); int count
			 * = metaData.getColumnCount(); System.out.println(count);
			 */
            ArrayList<String> values = new ArrayList<>();
            while (rs.next()) {
                for (int i = 0; i < dbColumn.length; i++) {
                    values.add(rs.getString(dbColumn[i]));
                    System.out.println("Stored Username in DB:" +" " +values);
                }
                // value[] = rs.getString(dbColumn);
            }
            return values;

        } catch (Throwable e) {
            throw e;
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

}
