/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package companyloginsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Pasindu
 */
public class ULSDB {
    private static Connection C1;
    private static void createnewconnection() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        C1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/wallstreet", "root", "123");
    }
    
    public static void IUD(String SQL) throws Exception{
        if(C1 == null){
            createnewconnection();
        }
        C1.createStatement().executeQuery(SQL);        
    }
    
    public static ResultSet Search(String SQL) throws Exception{
        if(C1 == null){
            createnewconnection();
        }        
        return C1.createStatement().executeQuery(SQL);    
    }
}
