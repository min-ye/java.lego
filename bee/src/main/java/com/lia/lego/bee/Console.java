package com.lia.lego.bee;

public class Console 
{
    public static void main( String[] args )
    {
    	try{
            BrickSet brickSet = new BrickSet();
            //brickSet.getSetRaw();
            //brickSet.convertSetToJson();
            brickSet.getBrickRaw();
            //brickSet.convertBrickToJson();
         }
         catch (Exception ex){
            System.out.println(ex.getMessage());
         }
    }
}
