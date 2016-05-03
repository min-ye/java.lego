package com.lia.common;

public class FieldDefinition {
   private String _fieldName = "";
   private String _dataType = "";
   private Boolean _ifPrimary = false;
   
   public FieldDefinition(String fieldName, String dataType, Boolean ifPrimary) {
      this._fieldName = fieldName;
      this._dataType = dataType;
      this._ifPrimary = ifPrimary;
   }

   public String getFieldName() {
      return _fieldName;
   }

   public void setFieldName(String fieldName) {
      this._fieldName = fieldName;
   }

   public String getDataType() {
      return _dataType;
   }

   public void setDataType(String dataType) {
      this._dataType = dataType;
   }

   public Boolean getIfPrimary() {
      return _ifPrimary;
   }

   public void setIfPrimary(Boolean ifPrimary) {
      this._ifPrimary = ifPrimary;
   }
}
