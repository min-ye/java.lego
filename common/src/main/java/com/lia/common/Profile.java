package com.lia.common;

import org.json.JSONObject;

public enum Profile {
   INSTANCE;
   
   public String getConfigValue(String json, String key) throws Exception {
      JSONObject obj = new JSONObject(json);
      String output = obj.get(key).toString();
      return output;
   }
}