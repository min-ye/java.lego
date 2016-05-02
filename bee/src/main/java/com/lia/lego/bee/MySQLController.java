package com.lia.lego.bee;

import java.sql.*;

public class MySQLController {
   private String _driver = "com.mysql.jdbc.Driver";
   private String _url = "jdbc:mysql://127.0.0.1:3306/lego";
   private String _user = "root";
   private String _password = "lia";
   
   public void convertSetFromJsonToMySQL(String jsonFolder){
      try{
         Class.forName(_driver);
         Connection connection = DriverManager.getConnection(_url, _user, _password);
         if (connection.isClosed()){
            throw new Exception("Cannot connect the database.");
         }
         //Statement statement  = connection.createStatement();
      }
      catch (Exception ex){
         
      }
   }
   
   public void convertInventoryFromJsonToMySQL(String jsonFolder){
      
   }
}
