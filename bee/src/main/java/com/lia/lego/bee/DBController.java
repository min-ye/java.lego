package com.lia.lego.bee;

import java.util.List;

import com.lia.common.mysql.CommonObject;
import com.lia.common.mysql.Configure;
import com.lia.common.mysql.CreateHandler;
import com.lia.common.mysql.DeleteHandler;

public class DBController {
   private String _url = "jdbc:mysql://127.0.0.1:3306/lego";
   private String _user = "root";
   private String _password = "lia";
   
   public void convertSetFromJsonToMySQL(){
      try{
         Configure c = new Configure(_url, _user, _password);
         DeleteHandler deleteHandler = new DeleteHandler();
         deleteHandler.empty(c, "BrickSet");
         JsonController jsonController = new JsonController();
         List<CommonObject> setList = jsonController.getSetList();
         CreateHandler createHandler = new CreateHandler();
         createHandler.create(c, setList);
      }
      catch (Exception ex){
         
      }
   }
   
   public void convertInventoryFromJsonToMySQL(String jsonFolder){
      
   }
}
