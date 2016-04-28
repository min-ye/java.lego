package com.lia.lego.model.brickset;

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
}
