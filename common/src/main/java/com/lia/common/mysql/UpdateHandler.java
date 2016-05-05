package com.lia.common.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

public enum UpdateHandler {
   INSTANCE;
   private String _driver = "com.mysql.jdbc.Driver";

   public void delete(Config p, CommonObject item) throws Exception{
      Connection connection = null;
      try {
         DbUtils.loadDriver(_driver);
         connection = DriverManager.getConnection(p.getPassword(), p.getUser(), p.getPassword());
         QueryRunner query = new QueryRunner();
         String script = buildDeleteScript(item.getObjectName(), item.exportKeyFieldMap());
         query.update(script);
      }
      catch (Exception ex){
         throw ex;
      }
      finally {
         connection.close();
      }
   }
   
   public void create(Config p, CommonObject item) throws Exception{
      Connection connection = null;
      try {
         DbUtils.loadDriver(_driver);
         connection = DriverManager.getConnection(p.getPassword(), p.getUser(), p.getPassword());
         QueryRunner query = new QueryRunner();
         String script = buildCreateScript(item.getObjectName(), item.exportFieldMap());
         query.update(script);
      }
      catch (Exception ex){
         throw ex;
      }
      finally {
         connection.close();
      }
   }
   
   public void update(Config p, CommonObject item) throws Exception{
      Connection connection = null;
      try {
         DbUtils.loadDriver(_driver);
         connection = DriverManager.getConnection(p.getPassword(), p.getUser(), p.getPassword());
         QueryRunner query = new QueryRunner();
         String script = buildUpdateScript(item.getObjectName(), item.exportKeyFieldMap(), item.exportValueFieldMap());
         query.update(script);
      }
      catch (Exception ex){
         throw ex;
      }
      finally {
         connection.close();
      }
   }
   
   public void create(Config c, List<CommonObject> objectList) throws Exception {
      Connection connection = null;
      CommonObject obj = null;
      if (objectList.size() > 0){
         obj = objectList.get(0);
      }
      try {
         if (obj != null) {
            DbUtils.loadDriver(_driver);
            connection = DriverManager.getConnection(c.getPassword(), c.getUser(), c.getPassword());
            QueryRunner query = new QueryRunner();
         
            query.batch(buildBatchCreateScript(obj.getObjectName(), obj.getFieldName()), buildBatchCreateValue(obj.getObjectName(), objectList));
         }
      }
      catch (Exception ex){
         throw ex;
      }
      finally {
         connection.close();
      }
   }
   
   public List<Map<String, Object>> getMultiRecord(Config p, CommonObject item, ArrayList<FilterCondition> conditionArray) throws Exception{
      Connection connection = null;
      try {
         DbUtils.loadDriver(_driver);
         connection = DriverManager.getConnection(p.getPassword(), p.getUser(), p.getPassword());
         QueryRunner runner = new QueryRunner();
         String query = buildRetrieveScript(item.getObjectName(), item.getFieldName(), conditionArray);
         ArrayList<Map<String, Object>> list = (ArrayList<Map<String, Object>>) runner.query(query, new MapListHandler());
         return list;
      }
      catch (Exception ex){
         throw ex;
      }
      finally {
         connection.close();
      }
   }
   
   public Map<String, Object> getRecord(Config p, CommonObject item, List<FilterCondition> conditionList) throws Exception {
      Connection connection = null;
      try {
         DbUtils.loadDriver(_driver);
         connection = DriverManager.getConnection(p.getPassword(), p.getUser(), p.getPassword());
         QueryRunner runner = new QueryRunner();
         String query = buildRetrieveScript(item.getObjectName(), item.getFieldName(), conditionList);
         Map<String, Object> map = (Map<String, Object>) runner.query(query, new MapHandler());
         return map;
      }
      catch (Exception ex){
         throw ex;
      }
      finally {
         connection.close();
      }

   }
   
   private String buildDeleteScript(String entityName, Map<String, String> keyFieldMap) throws Exception {
      String script = String.format("delete from %s ", entityName);
      String condition = "";
      for (Entry<String, String> entry : keyFieldMap.entrySet()) {
         String fieldName = entry.getKey();
         String fieldValue = entry.getValue();
         if (condition.length() > 0){
            condition += " and ";
         }
         condition += String.format("%s = %s", fieldName, fieldValue);         
      }
      if (condition.length() > 0){
         condition = " where " + condition;
      }
      script += condition;
      return script;
   }
   
   private String buildCreateScript(String entityName, Map<String, String> fieldMap) throws Exception {
      String fieldScript = "";
      String valueScript = "";
      for (Entry<String, String> entry : fieldMap.entrySet()) {
         String fieldName = entry.getKey();
         String fieldValue = entry.getValue();
         if (fieldScript.length() > 0){
            fieldScript += ", ";
         }
         if (valueScript.length() > 0){
            valueScript += ", ";
         }
         fieldScript += fieldName;
         valueScript += fieldValue;   
      }
      
      String script = String.format("insert into %s(%s) values(%s)", entityName, fieldScript, valueScript);
      return script;
   }
   
   private String buildUpdateScript(String entityName, Map<String, String> keyFieldMap, Map<String, String> valueFieldMap) throws Exception {
      String valueScript = "";
      String condition = "";
      for (Entry<String, String> entry : valueFieldMap.entrySet()) {
         String fieldName = entry.getKey();
         String fieldValue = entry.getValue();
         if (valueScript.length() > 0){
            valueScript += ", ";
         }
         valueScript += String.format("%s = '%s'", fieldName, fieldValue);
      }

      for (Entry<String, String> entry : keyFieldMap.entrySet()) {
         String fieldName = entry.getKey();
         String fieldValue = entry.getValue();
         if (condition.length() > 0){
            condition += " and ";
         }
         condition += String.format("%s = %s", fieldName, fieldValue);         
      }
      if (condition.length() > 0){
         condition = " where " + condition;
      }
      
      String script = String.format("update %s set %s %s", entityName, valueScript, condition);
      return script;
   }
   
   private String buildRetrieveScript(String entityName, List<String> fieldNameArray, List<FilterCondition> conditionArray) throws Exception {
      String fieldName = "";
      
      for (String name : fieldNameArray) {
         if (fieldName.length() >0 ){
            fieldName += ", ";
         }
         fieldName += name;
      }
      
      String where = "";
      for (FilterCondition condition : conditionArray) {
         if (where.length() > 0) {
            where += " and ";
         }
         where += String.format(" %s %s %s ", condition.getFieldName(), condition.getOperator(), condition.getValue());
      }
      
      String script = String.format("select %s from %s %s", fieldName, entityName, where);
      return script;
   }
   
   private String buildBatchCreateScript(String entityName, List<String> fieldNameList) throws Exception {
      String fieldScript = "";
      String valueScript = "";
      for (String fieldName : fieldNameList) {
         if (fieldScript.length() > 0){
            fieldScript += ", ";
         }
         if (valueScript.length() > 0){
            valueScript += ", ";
         }
         fieldScript += fieldName;
         valueScript += "?";   
      }
      
      String script = String.format("insert into %s(%s) values(%s)", entityName, fieldScript, valueScript);
      return script;
   }
   
   private Object[][] buildBatchCreateValue(String entityName, List<CommonObject> objectList) throws Exception {
      Object[][] obj = new Object[objectList.size()][];
      int index = 0;
      for (CommonObject commonObject : objectList){
         obj[index] = commonObject.getObject();
         index ++;
      }
      return obj;
   }

}
