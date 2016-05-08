package com.lia.common.mysql;

import java.util.List;
import java.util.Map;

public abstract class CommonObject {
   public abstract String fetchObjectName();
   
   public abstract String getFieldValue(String fieldName) throws Exception;
   
   public abstract void setValue(String fieldName, String fieldValue) throws Exception;
   
   public abstract void importModel(Map<String, Object> item) throws Exception;
   
   //public abstract Map<String, FieldModel> exportModel();
   
   public abstract Map<String, String> exportFieldMap();
   
   public abstract Map<String, String> exportKeyFieldMap();
   
   public abstract Map<String, String> exportValueFieldMap();
   
   public abstract List<String> fetchFieldName();
   
   public abstract Object[] fetchObject();
   
   protected String getFieldValueString(String value) {
      return String.format("'%s'", value);
   }
   
   protected String getFieldValueString(int value) {
      return String.format("%d", value);
   }
   
   protected String getFieldValueString(double value) {
      return String.format("%d", value);
   }
}
