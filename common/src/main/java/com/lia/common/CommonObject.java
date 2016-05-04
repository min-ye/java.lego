package com.lia.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CommonObject {
   public abstract String getObjectName();
   
   public abstract String getFieldValue(String fieldName) throws Exception;
   
   public abstract void setValue(String fieldName, String fieldValue) throws Exception;
   
   public abstract void importModel(Map<String, Object> item) throws Exception;
   
   public abstract Map<String, FieldModel> exportModel();
   
   public abstract Map<String, String> exportFieldMap();
   
   public abstract Map<String, String> exportKeyFieldMap();
   
   public abstract Map<String, String> exportValueFieldMap();
   
   public abstract List<String> getFieldName();
   
   public abstract Object[] getObject();
   
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
