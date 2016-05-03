package com.lia.lego.metadata;

import java.util.ArrayList;

import com.lia.common.FieldDefinition;

public enum MetaDataFactory {
   INSTANCE;
   public ArrayList<FieldDefinition> getKeyFieldNameAccordingEntity(String entityName) throws Exception{
      switch (entityName) {
      case "brickset.Set":
         return com.lia.lego.metadata.brickset.Set.INSTANCE.getKeyFieldName();
      case "brickset.Inventory":
         return com.lia.lego.metadata.brickset.Inventory.INSTANCE.getKeyFieldName();
         default:
            throw new Exception(String.format("Unknown Entity Name [%s].", entityName));
      }
   }
   
   public ArrayList<FieldDefinition> getFieldNameAccordingEntity(String entityName) throws Exception{
      switch (entityName) {
      case "brickset.Set":
         return com.lia.lego.metadata.brickset.Set.INSTANCE.getFieldName();
      case "brickset.Inventory":
         return com.lia.lego.metadata.brickset.Inventory.INSTANCE.getFieldName();
         default:
            throw new Exception(String.format("Unknown Entity Name [%s].", entityName));
      }
   }
}
