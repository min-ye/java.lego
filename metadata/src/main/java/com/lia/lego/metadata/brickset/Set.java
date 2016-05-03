package com.lia.lego.metadata.brickset;

import java.util.ArrayList;

public class Set {
   public String getEntityName(){
      return "Set";
   }
   
   public ArrayList<String> getKeyFieldName() {
      ArrayList<String> arrayFieldName = new ArrayList<String>();
      arrayFieldName.add("SetID");
      return arrayFieldName;
   }
   
   public ArrayList<String> getFieldName() {
      ArrayList<String> arrayFieldName = new ArrayList<String>();
      arrayFieldName.add("SetID");
      arrayFieldName.add("Number");
      arrayFieldName.add("Variant");
      arrayFieldName.add("Theme");
      arrayFieldName.add("SubTheme");
      arrayFieldName.add("Year");
      arrayFieldName.add("Name");
      arrayFieldName.add("Minifigs");
      arrayFieldName.add("Pieces");
      arrayFieldName.add("UKPrice");
      arrayFieldName.add("USPrice");
      arrayFieldName.add("CAPrice");
      arrayFieldName.add("EUPrice");
      arrayFieldName.add("ImageURL");
      return arrayFieldName;
   }
}
