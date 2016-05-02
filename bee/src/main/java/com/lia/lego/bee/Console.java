package com.lia.lego.bee;

public class Console {
   public static void main(String[] args) {
      try {
         String choice = "";
         while (!choice.equals("0")) {
            java.io.Console console = System.console();
            console.printf("Please input your choice:\n");
            console.printf("1. Set output folder;");
            console.printf("2. Get set raw data from brickset.com\n");
            console.printf("3. Convet set data from csv format to json format\n");
            console.printf("5. Get brick raw data from brickset.com\n");
            console.printf("6. Convert brick data from csv format to json format\n");
            console.printf("7. Check set \n");
            console.printf("0. Quit\n");
            choice = console.readLine("Choice: \n");
            switch (choice){
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
               String setID = console.readLine("Set id: \n");
               console.printf("%s\n", setID);
               break;
            case "0":
               
            }
         }
         //BrickSet brickSet = new BrickSet();
         //brickSet.getSetRaw();
         //brickSet.convertSetToJson();
         //brickSet.getBrickRaw();
         //brickSet.convertBrickToJson();
      } catch (Exception ex) {
         System.out.println(ex.getMessage());
      }
   }
}
