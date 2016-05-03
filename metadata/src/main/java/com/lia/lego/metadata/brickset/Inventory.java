package com.lia.lego.metadata.brickset;

import java.util.ArrayList;

public class Inventory {
   public String getEntityName(){
      return "Inventory";
   }
   
   public ArrayList<String> getKeyFieldName() {
      ArrayList<String> arrayFieldName = new ArrayList<String>();
      arrayFieldName.add("SetNumber");
      arrayFieldName.add("PartID");
      return arrayFieldName;
   }
   
   public ArrayList<String> getFieldName() {
      ArrayList<String> arrayFieldName = new ArrayList<String>();
      arrayFieldName.add("SetNumber");
      arrayFieldName.add("PartID");
      arrayFieldName.add("Quantity");
      arrayFieldName.add("Colour");
      arrayFieldName.add("Category");
      arrayFieldName.add("DesignID");
      arrayFieldName.add("PartName");
      arrayFieldName.add("ImageURL");
      arrayFieldName.add("setCount");
      return arrayFieldName;
   }
}
