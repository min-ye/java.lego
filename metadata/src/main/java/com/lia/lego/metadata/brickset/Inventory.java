package com.lia.lego.metadata.brickset;

import java.util.ArrayList;

import com.lia.common.FieldDefinition;

public enum Inventory {
   INSTANCE;
   public String getEntityName(){
      return "Inventory";
   }
   
   public ArrayList<FieldDefinition> getKeyFieldName() {
      ArrayList<FieldDefinition> arrayFieldName = new ArrayList<FieldDefinition>();
      arrayFieldName.add(new FieldDefinition("SetNumber", "string", true));
      arrayFieldName.add(new FieldDefinition("PartID", "string", true));
      return arrayFieldName;
   }
   
   public ArrayList<FieldDefinition> getFieldName() {
      ArrayList<FieldDefinition> arrayFieldName = new ArrayList<FieldDefinition>();
      arrayFieldName.add(new FieldDefinition("SetNumber", "string", true));
      arrayFieldName.add(new FieldDefinition("PartID", "string", true));
      arrayFieldName.add(new FieldDefinition("Quantity", "string", false));
      arrayFieldName.add(new FieldDefinition("Colour", "string", false));
      arrayFieldName.add(new FieldDefinition("Category", "string", false));
      arrayFieldName.add(new FieldDefinition("DesignID", "string", false));
      arrayFieldName.add(new FieldDefinition("PartName", "string", false));
      arrayFieldName.add(new FieldDefinition("ImageURL", "string", false));
      arrayFieldName.add(new FieldDefinition("setCount", "string", false));
      return arrayFieldName;
   }
}
