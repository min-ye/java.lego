package com.lia.common;

public class Cookie {
   private String _name = new String();
   private String _value = new String();
   private String _path = "/";
   private String _domain = new String();
   
   public Cookie(String name, String value, String path, String domain) {
      this._name = name;
      this._value = value;
      this._path = path;
      this._domain = domain;
   }

   public String getName() {
      return _name;
   }

   public void setName(String name) {
      this._name = name;
   }

   public String getValue() {
      return _value;
   }

   public void setValue(String value) {
      this._value = value;
   }

   public String getPath() {
      return _path;
   }

   public void setPath(String path) {
      this._path = path;
   }
   
   public String getDomain() {
      return _domain;
   }
   
   public void setDomain(String domain) {
      this._domain = domain;
   }
}
