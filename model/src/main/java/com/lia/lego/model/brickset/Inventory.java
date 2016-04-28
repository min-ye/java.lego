package com.lia.lego.model.brickset;

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
   
   
}
