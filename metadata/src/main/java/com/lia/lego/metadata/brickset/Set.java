package com.lia.lego.metadata.brickset;

import java.util.ArrayList;
import com.lia.common.FieldDefinition;

public enum Set {
   INSTANCE;
   public String getEntityName(){
      return "Set";
   }
   
   public ArrayList<FieldDefinition> getKeyFieldName() {
      ArrayList<FieldDefinition> arrayFieldName = new ArrayList<FieldDefinition>();
      arrayFieldName.add(new FieldDefinition("SetID", "string", true));
      return arrayFieldName;
   }
   
   public ArrayList<FieldDefinition> getFieldName() {
      ArrayList<FieldDefinition> arrayFieldName = new ArrayList<FieldDefinition>();
      arrayFieldName.add(new FieldDefinition("SetID", "string", true));
      arrayFieldName.add(new FieldDefinition("Number", "string", false));
      arrayFieldName.add(new FieldDefinition("Variant", "string", false));
      arrayFieldName.add(new FieldDefinition("Theme", "string", false));
      arrayFieldName.add(new FieldDefinition("SubTheme", "string", false));
      arrayFieldName.add(new FieldDefinition("Year", "string", false));
      arrayFieldName.add(new FieldDefinition("Name", "string", false));
      arrayFieldName.add(new FieldDefinition("Minifigs", "string", false));
      arrayFieldName.add(new FieldDefinition("Pieces", "string", false));
      arrayFieldName.add(new FieldDefinition("UKPrice", "string", false));
      arrayFieldName.add(new FieldDefinition("USPrice", "string", false));
      arrayFieldName.add(new FieldDefinition("CAPrice", "string", false));
      arrayFieldName.add(new FieldDefinition("EUPrice", "string", false));
      arrayFieldName.add(new FieldDefinition("ImageURL", "string", false));
      return arrayFieldName;
   }
}
