package com.lia.common.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;

public enum UpdateHandler {
   INSTANCE;
   private String _driver = "com.mysql.jdbc.Driver";

   public void update(Configure p, CommonObject item) throws Exception{
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
}
