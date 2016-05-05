package com.lia.common.mysql;

public class Config {
   private String _url = "";
   private String _user = "";
   private String _password = "";
   
   public Config(String url, String user, String password){
      this._url = url;
      this._user = user;
      this._password = password;
   }
   
   public String getUrl() {
      return _url;
   }
   public void setUrl(String url) {
      this._url = url;
   }
   public String getUser() {
      return _user;
   }
   public void setUser(String user) {
      this._user = user;
   }
   public String getPassword() {
      return _password;
   }
   public void setPassword(String password) {
      this._password = password;
   }
}
