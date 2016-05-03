package com.lia.lego.model.brickset;

import java.util.HashMap;
import java.util.Map.Entry;

import com.lia.common.FieldModel;

public class Inventory {
   private String _setNumber = "";
   private String _partID = "";
   private String _quantity = "";
   private String _colour = "";
   private String _category = "";
   private String _designID = "";
   private String _partName = "";
   private String _imageUrl = "";
   private String _setCount = "";
   
   public Inventory(String setNumber, String partID, String quantity,
                    String colour, String category, String designID,
                    String partName, String imageUrl, String setCount) {
      this._setNumber = setNumber;
      this._partID = partID;
      this._quantity = quantity;
      this._colour = colour;
      this._category = category;
      this._designID = designID;
      this._partName = partName;
      this._imageUrl = imageUrl;
      this._setCount = setCount;
   }
   
   public String getSetNumber() {
      return _setNumber;
   }
   public void setSetNumber(String setNumber) {
      this._setNumber = setNumber;
   }
   public String getPartID() {
      return _partID;
   }
   public void setPartID(String partID) {
      this._partID = partID;
   }
   public String getQuantity() {
      return _quantity;
   }
   public void setQuantity(String quantity) {
      this._quantity = quantity;
   }
   public String getColour() {
      return _colour;
   }
   public void setColour(String colour) {
      this._colour = colour;
   }
   public String getCategory() {
      return _category;
   }
   public void setCategory(String category) {
      this._category = category;
   }
   public String getDesignID() {
      return _designID;
   }
   public void setDesignID(String designID) {
      this._designID = designID;
   }
   public String getPartName() {
      return _partName;
   }
   public void setPartName(String partName) {
      this._partName = partName;
   }
   public String getImageUrl() {
      return _imageUrl;
   }
   public void setImageUrl(String imageUrl) {
      this._imageUrl = imageUrl;
   }
   public String getSetCount() {
      return _setCount;
   }
   public void setSetCount(String setCount) {
      this._setCount = setCount;
   }
   
   public String getFieldValue(String fieldName) throws Exception{
      switch (fieldName){
      case "SetNumber":
         return this._setNumber;
      case "PartID":
         return this._partID;
      case "Quantity":
         return this._quantity;
      case "Colour":
         return this._colour;
      case "Category":
         return this._category;
      case "DesignID":
         return this._designID;
      case "PartName":
         return this._partName;
      case "ImageURL":
         return this._imageUrl;
      case "SetCount":
         return this._setCount;
      default:
         throw new Exception(String.format("Unknown Field Name:[%s]", fieldName));
      }
   }
   
   public void setValue(String fieldName, String fieldValue) throws Exception
   {
      switch (fieldName) {
         case "SetNumber":
            this._setNumber = fieldValue;
            break;
         case "PartID":
            this._partID = fieldValue;
            break;
         case "Quantity":
            this._quantity = fieldValue;
            break;
         case "Colour":
            this._colour = fieldValue;
            break;
         case "Category":
            this._category = fieldValue;
            break;
         case "DesignID":
            this._designID = fieldValue;
            break;
         case "PartName":
            this._partName = fieldValue;
            break;
         case "ImageURL":
            this._imageUrl = fieldValue;
            break;
         case "SetCount":
            this._setCount = fieldValue;
            break;
         default:
            throw new Exception(String.format("Unknown Field Name:[%s]", fieldName));
      }
   }
   
   public void importModel(HashMap<String, String> item) throws Exception{
      for (Entry<String, String> entry : item.entrySet()) {
         setValue(entry.getKey(), entry.getValue());
      }
   }
   
   public HashMap<String, FieldModel> exportModel(){
      HashMap<String, FieldModel> modelMap = new HashMap<String, FieldModel>();
      modelMap.put("SetNumber", new FieldModel("string", this._setNumber, true));
      modelMap.put("PartID", new FieldModel("string", this._partID, false));
      modelMap.put("Quantity", new FieldModel("string", this._quantity, false));
      modelMap.put("Colour", new FieldModel("string", this._colour, false));
      modelMap.put("Category", new FieldModel("string", this._category, false));
      modelMap.put("DesignID", new FieldModel("string", this._designID, false));
      modelMap.put("PartName", new FieldModel("string", this._partName, false));
      modelMap.put("ImageURL", new FieldModel("string", this._imageUrl, false));
      modelMap.put("SetCount", new FieldModel("string", this._setCount, false));

      return modelMap;
   }
}
