package com.lia.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

public enum MySQLHelper {
   INSTANCE;
   private String _driver = "com.mysql.jdbc.Driver";
   private HashMap item;
   public void delete(MySQLConnectionParameter p, String name, HashMap item){
      Connection connection = null;
      try {
         DbUtils.loadDriver(_driver);
         connection = DriverManager.getConnection(p.getPassword(), p.getUser(), p.getPassword());
         QueryRunner query = new QueryRunner();
         String script = buildDeleteScript(name, item);
         query.insert();
      }
   }
   
   public void insert(MySQLConnectionParameter p){
      
   }
   
   public void update(MySQLConnectionParameter p){
      
   }
   
   public void getMultiRecord(MySQLConnectionParameter p){
      
   }
   
   public void getRecord(MySQLConnectionParameter p){
      
   }
   
   private String buildDeleteScript(String name, HashMap item){
      String script = String.format("delete from %s ", name);
      Iterator iter = item.entrySet().iterator();
      String condition = "";
      while (iter.hasNext()) {
         Map.Entry entry = (Map.Entry) iter.next();
         String keyField = entry.getKey().toString();
         String keyValue = entry.getValue().toString();
         if (condition.length() > 0){
            condition += " and ";
         }
         condition += String.format("%s = %s", keyField, keyValue);
      }
      if (condition.length() > 0){
         condition = " where " + condition;
      }
      script += condition;
      return script;
   }
   
   private Connection getConnection(){
      
   }
   
   /*private Statement getStatement(MySQLConnectionParameter p) throws Exception{
      Class.forName(_driver);
      Connection connection = DriverManager.getConnection(p.getUrl(), p.getUser(), p.getPassword());
      if (connection.isClosed()){
         throw new Exception("Cannot connect the database.");
      }
      Statement statement  = connection.createStatement();
      return statement;
   }
   
   private PreparedStatement getPreparedStatement(MySQLConnectionParameter p, String script) throws Exception{
      Class.forName(_driver);
      Connection connection = DriverManager.getConnection(p.getUrl(), p.getUser(), p.getPassword());
      if (connection.isClosed()){
         throw new Exception("Cannot connect the database.");
      }
      PreparedStatement statement  = connection.prepareStatement(script);
      return statement;
   }*/
}
