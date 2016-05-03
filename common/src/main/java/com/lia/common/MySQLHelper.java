package com.lia.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

public enum MySQLHelper {
   INSTANCE;
   private String _driver = "com.mysql.jdbc.Driver";

   public void delete(MySQLConfig p, String entityName, HashMap<String, FieldModel> entityItem) throws Exception{
      Connection connection = null;
      try {
         DbUtils.loadDriver(_driver);
         connection = DriverManager.getConnection(p.getPassword(), p.getUser(), p.getPassword());
         QueryRunner query = new QueryRunner();
         String script = buildDeleteScript(entityName, entityItem);
         query.update(script);
      }
      catch (Exception ex){
         throw ex;
      }
      finally {
         connection.close();
      }
   }
   
   public void create(MySQLConfig p, String entityName, HashMap<String, FieldModel> entityItem) throws Exception{
      Connection connection = null;
      try {
         DbUtils.loadDriver(_driver);
         connection = DriverManager.getConnection(p.getPassword(), p.getUser(), p.getPassword());
         QueryRunner query = new QueryRunner();
         String script = buildCreateScript(entityName, entityItem);
         query.update(script);
      }
      catch (Exception ex){
         throw ex;
      }
      finally {
         connection.close();
      }
   }
   
   public void update(MySQLConfig p, String entityName, HashMap<String, FieldModel> entityItem) throws Exception{
      Connection connection = null;
      try {
         DbUtils.loadDriver(_driver);
         connection = DriverManager.getConnection(p.getPassword(), p.getUser(), p.getPassword());
         QueryRunner query = new QueryRunner();
         String script = buildUpdateScript(entityName, entityItem);
         query.update(script);
      }
      catch (Exception ex){
         throw ex;
      }
      finally {
         connection.close();
      }
   }
   
   public void getMultiRecord(MySQLConfig p, String entityName, ArrayList<FilterCondition> filterCondition){
      
   }
   
   public void getRecord(MySQLConfig p, String entityName, ArrayList<FilterCondition> filterCondition) {
      
   }
   
   private String buildDeleteScript(String entityName, HashMap<String, FieldModel> entityItem) throws Exception {
      String script = String.format("delete from %s ", entityName);
      String condition = "";
      for (Entry<String, FieldModel> entry : entityItem.entrySet()) {
         String fieldName = entry.getKey().toString();
         FieldModel fieldModel = entry.getValue();
         if (fieldModel.getIfPrimary()){
            if (condition.length() > 0){
               condition += " and ";
            }
            switch (fieldModel.getType()) {
            case "string":
               condition += String.format("%s = '%s'", fieldName, fieldModel.getValue());
               break;
            default:
               throw new Exception(String.format("Unknown Field Type On the Field [%s]", fieldName));
            }
         }
      }
      if (condition.length() > 0){
         condition = " where " + condition;
      }
      script += condition;
      return script;
   }
   
   private String buildCreateScript(String entityName, HashMap<String, FieldModel> entityItem) throws Exception {
      String fieldScript = "";
      String valueScript = "";
      for (Entry<String, FieldModel> entry : entityItem.entrySet()) {
         String fieldName = entry.getKey().toString();
         FieldModel fieldModel = entry.getValue();
         if (fieldModel.getIfPrimary()){
            if (fieldScript.length() > 0){
               fieldScript += ", ";
            }
            if (valueScript.length() > 0){
               valueScript += ", ";
            }
            fieldScript += fieldName;
            switch (fieldModel.getType()) {
            case "string":
               valueScript += String.format("'%s'", fieldName, fieldModel.getValue());
               break;
            default:
               throw new Exception(String.format("Unknown Field Type On the Field [%s]", fieldName));
            }
         }
      }
      
      String script = String.format("insert into %s(%s) values(%s)", entityName, fieldScript, valueScript);
      return script;
   }
   
   private String buildUpdateScript(String entityName, HashMap<String, FieldModel> entityItem) throws Exception {
      String valueScript = "";
      String condition = "";
      for (Entry<String, FieldModel> entry : entityItem.entrySet()) {
         String fieldName = entry.getKey().toString();
         FieldModel fieldModel = entry.getValue();
         if (valueScript.length() > 0){
            valueScript += ", ";
         }
         switch (fieldModel.getType()) {
         case "string":
            valueScript += String.format("%s = '%s'", fieldName, fieldModel.getValue());
            break;
         default:
            throw new Exception(String.format("Unknown Field Type On the Field [%s]", fieldName));
         }
         
         if (fieldModel.getIfPrimary()){
            if (condition.length() > 0){
               condition += " and ";
            }
            switch (fieldModel.getType()) {
            case "string":
               condition += String.format("%s = '%s'", fieldName, fieldModel.getValue());
               break;
            default:
               throw new Exception(String.format("Unknown Field Type On the Field [%s]", fieldName));
            }
         }

      }
      if (condition.length() > 0){
         condition = " where " + condition;
      }
      
      String script = String.format("update %s set %s %s", entityName, valueScript, condition);
      return script;
   }
   
   private String buildRetrieveScript(String entityName, ArrayList<FieldDefinition> arrayFieldDefinition, ArrayList<FilterCondition> arrayFilterCondition) throws Exception {
      
      /*String condition = "";
      for (Entry<String, FieldModel> entry : entityItem.entrySet()) {
         String fieldName = entry.getKey().toString();
         FieldModel fieldModel = entry.getValue();
         if (fieldModel.getIfPrimary()){
            if (condition.length() > 0){
               condition += " and ";
            }
            switch (fieldModel.getType()) {
            case "string":
               condition += String.format("%s = '%s'", fieldName, fieldModel.getValue());
               break;
            default:
               throw new Exception(String.format("Unknown Field Type On the Field [%s]", fieldName));
            }
         }
      }
      if (condition.length() > 0){
         condition = " where " + condition;
      }
      script += condition;
      return script;*/
      return "";
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
