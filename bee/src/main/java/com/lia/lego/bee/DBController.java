package com.lia.lego.bee;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

import org.json.JSONArray;

import com.lia.common.FileHelper;
import com.lia.lego.model.brickset.Set;

public class DBController {
   private String _driver = "com.mysql.jdbc.Driver";
   private String _url = "jdbc:mysql://127.0.0.1:3306/lego";
   private String _user = "root";
   private String _password = "lia";
   
   public void convertSetFromJsonToMySQL(String jsonFolder){
      try{
            File root = new File(_outputFolder);
            File[] multiFile = root.listFiles();
            ArrayList<Set> multiSet = new ArrayList<Set>();
            for (File file : multiFile) {
               if (file.isFile() && file.toString().contains("csv")) {
                  System.out.println("processing " + file.toString());
                  for (Set set : getMultiSetFromFile(file.toString())) {
                     multiSet.add(set);
                  }
               }
            }
            JSONArray jsonArray = new JSONArray(multiSet);

            String output = jsonArray.toString(3);
            String outputFile = _outputFolder + "set.json";
            FileHelper.INSTANCE.saveContent(output, outputFile);
         }
         catch (Exception ex){
         
         }
   }
   
   public void convertInventoryFromJsonToMySQL(String jsonFolder){
      
   }
}
