/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companyloginsystem;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class newApp {

    public static void main(String[] args) {

        // Connect to database
        String hostName = "pasindudil.database.windows.net";
        String dbName = "mydb";
        String user = "pasindu";
        String password = "p@sinduDil123";
        String url = String.format("jdbc:sqlserver://pasindudil.database.windows.net:1433;database=mydb;user=pasindu@pasindudil;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;", hostName, dbName, user, password);
        Connection connection = null;

        try {
                connection = DriverManager.getConnection(url);
                String schema = connection.getSchema();
                System.out.println("Successful connection - Schema: " + schema);

                System.out.println("Query data example:");
                System.out.println("=========================================");

                // Create and execute a SELECT SQL statement.
                String selectSql = "SELECT TOP 20 pc.Name as CategoryName, p.name as ProductName " 
                    + "FROM [SalesLT].[ProductCategory] pc "  
                    + "JOIN [SalesLT].[Product] p ON pc.productcategoryid = p.productcategoryid";

                try (Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(selectSql)) {

                        // Print results from select statement
                        System.out.println("Top 20 categories:");
                        while (resultSet.next())
                        {
                            System.out.println(resultSet.getString(1) + " "
                                + resultSet.getString(2));
                        }
                }
        }
        catch (Exception e) {
                e.printStackTrace();
        }
    }
}
