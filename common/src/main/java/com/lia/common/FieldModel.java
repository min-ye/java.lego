package com.lia.common;

public class FieldModel {
   private String _type;
   private String _value;
   private Boolean _if_primary;
   public FieldModel(String type, String value, Boolean if_primary)
   {
      this._type = type;
      this._value = value;
      this._if_primary = if_primary;
   }
   public String getType() {
      return _type;
   }
   public void setType(String type) {
      this._type = type;
   }
   public String getValue() {
      return _value;
   }
   public void setValue(String value) {
      this._value = value;
   }
   public Boolean getIfPrimary() {
      return _if_primary;
   }
   public void setIfPrimary(Boolean if_primary) {
      this._if_primary = if_primary;
   }
}
