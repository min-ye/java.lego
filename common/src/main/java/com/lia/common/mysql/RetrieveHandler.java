package com.lia.common.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

public class RetrieveHandler {
   private String _driver = "com.mysql.jdbc.Driver";

   public List<Map<String, Object>> getMultiRecord(Configure p, CommonObject item, ArrayList<FilterCondition> conditionArray) throws Exception{
      Connection connection = null;
      try {
         DbUtils.loadDriver(_driver);
         connection = DriverManager.getConnection(p.getPassword(), p.getUser(), p.getPassword());
         QueryRunner runner = new QueryRunner();
         String query = buildRetrieveScript(item.fetchObjectName(), item.fetchFieldName(), conditionArray);
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
   
   public Map<String, Object> getRecord(Configure p, CommonObject item, List<FilterCondition> conditionList) throws Exception {
      Connection connection = null;
      try {
         DbUtils.loadDriver(_driver);
         connection = DriverManager.getConnection(p.getPassword(), p.getUser(), p.getPassword());
         QueryRunner runner = new QueryRunner();
         String query = buildRetrieveScript(item.fetchObjectName(), item.fetchFieldName(), conditionList);
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
   
}
