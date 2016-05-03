package com.lia.common;

public class FilterCondition {
   private String _fieldName = "";
   private String _operator = "";
   private String _value = "";
   
   public FilterCondition(String fieldName, String operator, String value){
      this._fieldName = fieldName;
      this._operator = operator;
      this._value = value;
   }

   public String getFieldName() {
      return _fieldName;
   }

   public void setFieldName(String fieldName) {
      this._fieldName = fieldName;
   }

   public String getOperator() {
      return _operator;
   }

   public void setOperator(String operator) {
      this._operator = operator;
   }

   public String getValue() {
      return _value;
   }

   public void setValue(String value) {
      this._value = value;
   }

}
