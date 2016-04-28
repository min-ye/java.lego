package com.lia.common;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ProfileTest 
{
   @Test
   public void testGetConfigValue() throws Exception
   {
      String json = new String();
      json += "{" +"\r";
      json += "source_url: 'http://www.brickset.com'," + "\r";
      json += "target_raw_folder: 'raw'" + "\r";
      json += "}";
      String key = "source_url";
      String result = Profile.INSTANCE.getConfigValue(json, key);
      assertEquals("http://www.brickset.com", result);
   }
}