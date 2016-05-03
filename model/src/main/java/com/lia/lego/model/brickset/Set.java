package com.lia.lego.model.brickset;

import java.util.HashMap;
import java.util.Map.Entry;

import com.lia.common.FieldModel;

public class Set {
   private String _setID = "";
   private String _number = "";
   private String _variant = "";
   private String _theme = "";
   private String _subTheme = "";
   private String _year = "";
   private String _name = "";
   private String _minifigs = "";
   private String _pieces = "";
   private String _priceUK = "";
   private String _priceUS = "";
   private String _priceCA = "";
   private String _priceEU = "";
   private String _imageURL = "";
   
   public Set(String setID, String number, String variant,
              String theme, String subTheme, String year,
              String name, String minifigs, String pieces,
              String priceUK, String priceUS, String priceCA,
              String priceEU, String imageURL){
      this._setID = setID;
      this._number = number;
      this._variant = variant;
      this._theme = theme;
      this._subTheme = subTheme;
      this._year = year;
      this._name = name;
      this._minifigs = minifigs;
      this._pieces = pieces;
      this._priceUK = priceUK;
      this._priceUS = priceUS;
      this._priceCA = priceCA;
      this._priceEU = priceEU;
      this._imageURL = imageURL;
   }
   
   public String getSetID() {
      return _setID;
   }
   public void setSetID(String _setID) {
      this._setID = _setID;
   }
   public String getNumber() {
      return _number;
   }
   public void setNumber(String _number) {
      this._number = _number;
   }
   public String getVariant() {
      return _variant;
   }
   public void setVariant(String _variant) {
      this._variant = _variant;
   }
   public String getTheme() {
      return _theme;
   }
   public void setTheme(String _theme) {
      this._theme = _theme;
   }
   public String getSubTheme() {
      return _subTheme;
   }
   public void setSubTheme(String _subTheme) {
      this._subTheme = _subTheme;
   }
   public String getYear() {
      return _year;
   }
   public void setYear(String _year) {
      this._year = _year;
   }
   public String getName() {
      return _name;
   }
   public void setName(String _name) {
      this._name = _name;
   }
   public String getMinifigs() {
      return _minifigs;
   }
   public void setMinifigs(String _minifigs) {
      this._minifigs = _minifigs;
   }
   public String getPieces() {
      return _pieces;
   }
   public void setPieces(String _pieces) {
      this._pieces = _pieces;
   }
   public String getPriceUK() {
      return _priceUK;
   }
   public void setPriceUK(String _priceUK) {
      this._priceUK = _priceUK;
   }
   public String getPriceUS() {
      return _priceUS;
   }
   public void setPriceUS(String _priceUS) {
      this._priceUS = _priceUS;
   }
   public String getPriceCA() {
      return _priceCA;
   }
   public void setPriceCA(String _priceCA) {
      this._priceCA = _priceCA;
   }
   public String getPriceEU() {
      return _priceEU;
   }
   public void setPriceEU(String _priceEU) {
      this._priceEU = _priceEU;
   }
   public String getImageURL() {
      return _imageURL;
   }
   public void setImageURL(String _imageURL) {
      this._imageURL = _imageURL;
   }
   
   public String getFieldValue(String fieldName) throws Exception{
      switch (fieldName){
      case "SetID":
         return this._setID;
      case "Number":
         return this._number;
      case "Variant":
         return this._variant;
      case "Theme":
         return this._theme;
      case "SubTheme":
         return this._subTheme;
      case "Year":
         return this._year;
      case "Name":
         return this._name;
      case "Minifigs":
         return this._minifigs;
      case "Pieces":
         return this._pieces;
      case "UKPrice":
         return this._priceUK;
      case "USPrice":
         return this._priceUS;
      case "CAPrice":
         return this._priceCA;
      case "EUPrice":
         return this._priceEU;
      case "ImageURL":
         return this._imageURL;
      default:
         throw new Exception(String.format("Unknown Field Name:[%s]", fieldName));
      }
   }
   
   public void setValue(String fieldName, String fieldValue) throws Exception
   {
      switch (fieldName) {
         case "SetID":
            this._setID = fieldValue;
            break;
         case "Number":
            this._number = fieldValue;
            break;
         case "Variant":
            this._variant = fieldValue;
            break;
         case "Theme":
            this._theme = fieldValue;
            break;
         case "SubTheme":
            this._subTheme = fieldValue;
            break;
         case "Year":
            this._year = fieldValue;
            break;
         case "Name":
            this._name = fieldValue;
            break;
         case "Minifigs":
            this._minifigs = fieldValue;
            break;
         case "Pieces":
            this._pieces = fieldValue;
            break;
         case "UKPrice":
            this._priceUK = fieldValue;
            break;
         case "USPrice":
            this._priceUS = fieldValue;
            break;
         case "CAPrice":
            this._priceCA = fieldValue;
            break;
         case "EUPrice":
            this._priceEU = fieldValue;
            break;
         case "ImageURL":
            this._imageURL = fieldValue;
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
      modelMap.put("SetID", new FieldModel("string", this._setID, true));
      modelMap.put("Number", new FieldModel("string", this._number, false));
      modelMap.put("Variant", new FieldModel("string", this._variant, false));
      modelMap.put("Theme", new FieldModel("string", this._theme, false));
      modelMap.put("SubTheme", new FieldModel("string", this._subTheme, false));
      modelMap.put("Year", new FieldModel("string", this._year, false));
      modelMap.put("Name", new FieldModel("string", this._name, false));
      modelMap.put("Minifigs", new FieldModel("string", this._minifigs, false));
      modelMap.put("Pieces", new FieldModel("string", this._pieces, false));
      modelMap.put("UKPrice", new FieldModel("string", this._priceUK, false));
      modelMap.put("USPrice", new FieldModel("string", this._priceUS, false));
      modelMap.put("CAPrice", new FieldModel("string", this._priceCA, false));
      modelMap.put("EUPrice", new FieldModel("string", this._priceEU, false));
      modelMap.put("ImageURL", new FieldModel("string", this._imageURL, false));

      return modelMap;
   }
}
