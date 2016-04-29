package com.lia.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;

public enum FileHelper {
   INSTANCE;
   public void saveContent(String content, String fileName) throws Exception {
      File file = new File(fileName);
      if (!file.exists()) {
         if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
         }
         file.createNewFile();
      }
      OutputStream stream = new FileOutputStream(file);
      stream.write(content.getBytes("utf-8"));
      stream.close();
   }

   public String getContent(String fileName) {
      StringBuffer output = new StringBuffer();
      File file = new File(fileName);
      BufferedReader reader = null;
      try {
         String line = null;
         reader = new BufferedReader(new FileReader(file));
         while ((line = reader.readLine()) != null) {
            output.append(line);
         }
         reader.close();
      }
      catch (IOException e) {
         e.printStackTrace();
      }
      finally {
         if (reader != null) {
            try {
               reader.close();
            }
            catch (IOException e) {
               
            }
         }
      }
      return output.toString();
   }
   
   public String getContentAccordingTag(String content, String beginTag, String endTag){
      String output = new String();
      int beginIndex = content.indexOf(beginTag);
      if (beginIndex > 0){
    	  beginIndex += beginTag.length();
    	  int endIndex = content.indexOf(endTag);
    	  if (endIndex > beginIndex) {
    		  output = content.substring(beginIndex, endIndex);
    	  }
      }
      return output;
   }
   
   public String replaceContent(String content, String originValue, String newValue){
      String output = new String();
      output = content.replaceAll(originValue, newValue);
      return output;
   }
}
