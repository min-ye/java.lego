package com.lia.lego.bee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.lia.common.Cookie;
import com.lia.common.FileHelper;
import com.lia.common.Profile;
import com.lia.common.WebHelper;
import com.lia.lego.model.brickset.Inventory;
import com.lia.lego.model.brickset.Set;

public class BrickSet {
   private String _setUrl = "";
   private String _inventoryUrl = "";
   private String _outputFolder = "";
   private String _rawInventoryFolder = "";
   private String _jsonInventoryFolder = "";

   public BrickSet() throws Exception {
      String json = getConfigFile();
      _setUrl = Profile.INSTANCE.getConfigValue(json, "source_url");
      _inventoryUrl = Profile.INSTANCE.getConfigValue(json, "source_inventory_url");
      _outputFolder = Profile.INSTANCE.getConfigValue(json, "target_raw_folder");
      _rawInventoryFolder = _outputFolder + "inventory/";
      _jsonInventoryFolder = _outputFolder + "inventory/json/";
   }

   public void getSetRaw() {
      try {
         for (int year = 1949; year < 2017; year++) {
            int index = 1;
            while (index != 0) {
               String url = String.format(_setUrl, year, index);
               ArrayList<Cookie> multi_cookie = new ArrayList<Cookie>();
               multi_cookie.add(new Cookie("setsListFormat", "CSV", "/", "brickset.com"));
               String content = WebHelper.INSTANCE.getContent(url, multi_cookie);
               String beginTag = "<textarea name=\"ctl00$mainContent$list1$ctl01\">";
               String endTag = "</textarea>";
               content = FileHelper.INSTANCE.getContentAccordingTag(content, beginTag, endTag);
               if (content.length() > 125) {
                  String fileName = _outputFolder + String.valueOf(year) + "-" + String.valueOf(index) + ".csv";
                  FileHelper.INSTANCE.saveContent(content, fileName);
                  System.out.println(fileName);
                  index++;
               } else {
                  index = 0;
               }
            }
         }
      } catch (Exception ex) {
         System.out.println(ex.getMessage());
      } finally {

      }
   }

   public void convertSetToJson() throws Exception {
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

   public void getBrickRaw() throws Exception {
      ArrayList<Set> arraySet = getSetFromJSON();
      int index = 1;
      for (Set set : arraySet) {
         if (set.getYear().equals("2013")) {
            getBrickRaw(set);
            System.out.println(String.valueOf(index));
            index++;
         }
      }
      System.out.println(arraySet.size());
   }

   public void convertBrickToJson() throws Exception {
      File root = new File(_rawInventoryFolder);
      File[] multiFile = root.listFiles();
      for (File file : multiFile) {
         if (file.isFile() && file.toString().contains("csv")) {
            ArrayList<Inventory> arrayInventory = new ArrayList<Inventory>();

            System.out.println("processing " + file.toString());
            for (Inventory inventory : getInventoryFromFile(file.toString())) {
               arrayInventory.add(inventory);
            }
            if (arrayInventory.size() > 0) {
               JSONArray jsonArray = new JSONArray(arrayInventory);

               String output = jsonArray.toString(3);
               String outputFile = _jsonInventoryFolder + file. getName().replace("csv", "json");
               FileHelper.INSTANCE.saveContent(output, outputFile);
            }
         }
      }

   }

   private String getConfigFile() throws Exception {
      InputStream url = BrickSet.class.getResourceAsStream("/lego.json");
      return IOUtils.toString(url);
   }

   private ArrayList<Set> getMultiSetFromFile(String fileName) throws Exception {
      ArrayList<Set> multiSet = new ArrayList<Set>();
      FileReader fileReader = new FileReader(fileName);
      BufferedReader bufferReader = new BufferedReader(fileReader);
      String line = "";
      boolean foundTitle = false;
      while ((line = bufferReader.readLine()) != null) {
         String[] arrayItem = line.split(",");
         if (arrayItem[0].toLowerCase().equals("setid")) {
            if (foundTitle) {
               System.out.println(line);
            } else {
               foundTitle = true;
            }
         } else {
            Set set = getSetFromRow(line);
            multiSet.add(set);
         }
      }
      bufferReader.close();
      fileReader.close();

      return multiSet;
   }

   private ArrayList<Inventory> getInventoryFromFile(String fileName) throws Exception {
      ArrayList<Inventory> arrayInventory = new ArrayList<Inventory>();
      FileReader fileReader = new FileReader(fileName);
      BufferedReader bufferReader = new BufferedReader(fileReader);
      String line = "";
      boolean foundTitle = false;
      while ((line = bufferReader.readLine()) != null) {
         String[] arrayItem = line.split(",");
         if (arrayItem.length > 1) {
            if (arrayItem[0].toLowerCase().equals("setnumber")) {
               if (foundTitle) {
                  System.out.println(line);
               } else {
                  foundTitle = true;
               }
            } else {
               Inventory inventory = getInventoryFromRow(line);
               arrayInventory.add(inventory);
            }
         }
      }
      bufferReader.close();
      fileReader.close();

      return arrayInventory;
   }

   private Set getSetFromRow(String row) throws Exception {
      row = row.replace("&quot;", "\"");
      row += ",";
      ArrayList<String> arrayItem = getCSVItem(row);
      if (arrayItem.size() != 14) {
         System.out.println(row);
         throw new Exception("Invalid row;");
      } else {
         Set set = new Set(arrayItem.get(0), arrayItem.get(1), arrayItem.get(2), arrayItem.get(3), arrayItem.get(4),
               arrayItem.get(5), arrayItem.get(6), arrayItem.get(7), arrayItem.get(8), arrayItem.get(9),
               arrayItem.get(10), arrayItem.get(11), arrayItem.get(12), arrayItem.get(13));
         return set;
      }
   }

   private Inventory getInventoryFromRow(String row) throws Exception {
      row = row.replace("&quot;", "\"");
      row += ",";
      ArrayList<String> arrayItem = getCSVItem(row);
      if (arrayItem.size() != 9) {
         System.out.println(row);
         throw new Exception("Invalid row;");
      } else {
         Inventory inventory = new Inventory(arrayItem.get(0), arrayItem.get(1), arrayItem.get(2), arrayItem.get(3),
               arrayItem.get(4), arrayItem.get(5), arrayItem.get(6), arrayItem.get(7), arrayItem.get(8));
         return inventory;
      }
   }

   private ArrayList<String> getCSVItem(String input) {
      Pattern pCells = Pattern.compile("(\"[^\"]*(\"{2})*[^\"]*\")*[^,]*,");
      Matcher mCells = pCells.matcher(input);
      ArrayList<String> output = new ArrayList<String>();// æ¯�è¡Œè®°å½•ä¸€ä¸ªlist
      while (mCells.find()) {
         String item = mCells.group();
         item = item.replaceAll("(?sm)\"?([^\"]*(\"{2})*[^\"]*)\"?.*,", "$1");
         item = item.replaceAll("(?sm)(\"(\"))", "$2");
         output.add(item);
      }
      return output;
   }

   private ArrayList<Set> getSetFromJSON() throws Exception {
      String setJsonFile = _outputFolder + "set.json";
      String jsonSet = FileHelper.INSTANCE.getContent(setJsonFile);
      JSONArray jsonArray = new JSONArray(jsonSet);
      ArrayList<Set> arraySet = new ArrayList<Set>();
      for (int index = 0; index < jsonArray.length(); index++) {
         JSONObject obj = jsonArray.getJSONObject(index);
         Set set = new Set(obj.getString("setID"), obj.getString("number"), obj.getString("variant"),
               obj.getString("theme"), obj.getString("subTheme"), obj.getString("year"), obj.getString("name"),
               obj.getString("minifigs"), obj.getString("pieces"), obj.getString("priceUK"), obj.getString("priceUS"),
               obj.getString("priceCA"), obj.getString("priceEU"), obj.getString("imageURL"));
         arraySet.add(set);
      }
      return arraySet;
   }

   private void getBrickRaw(Set set) throws Exception {
      String fileName = _outputFolder + "inventory/" + set.getSetID() + ".csv";
      File file = new File(fileName);
      if (!file.exists()) {
         String url = String.format(_inventoryUrl, set.getNumber() + "-" + set.getVariant());
         String content = WebHelper.INSTANCE.getContent(url);

         FileHelper.INSTANCE.saveContent(content, fileName);
         System.out.println(fileName + "-" + set.getYear());
      }
   }
}