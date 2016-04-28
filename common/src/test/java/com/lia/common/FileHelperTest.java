package com.lia.common;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

import org.junit.Test;

public class FileHelperTest 
{
   @Test
   public void testSaveContent() throws Exception
   {
       String url = "http://brickset.com/sets/year-2016/page-2";
       ArrayList<com.lia.common.Cookie> multi_cookie = new ArrayList<com.lia.common.Cookie>();
       multi_cookie.add(new Cookie("setsListFormat", "CSV", "/", "brickset.com"));
       String content = WebHelper.INSTANCE.getContent(url, multi_cookie);
       FileHelper.INSTANCE.saveContent(content, "C:\\Users\\mye\\workspace\\lego\\raw\\2016.xml");
       
       assertEquals(true, content.length() > 0);
   }
   
   @Test
   public void testGetContent() throws Exception
   {
       String content = FileHelper.INSTANCE.getContent("C:\\Users\\mye\\workspace\\lego\\raw\\2016.xml");
       boolean result = (content.length() > 0);
       assertEquals(true, result);
   }
   
   @Test
   public void testGetContentAccordingTag() throws Exception{
      String content = FileHelper.INSTANCE.getContent("C:\\Users\\mye\\workspace\\lego\\raw\\2016.xml");
      String beginTag = "<textarea name=\"ctl00$mainContent$list1$ctl01\">";
      String endTag = "</textarea>";
      String result = FileHelper.INSTANCE.getContentAccordingTag(content, beginTag, endTag);
      FileHelper.INSTANCE.saveContent(result, "C:\\Users\\mye\\workspace\\lego\\raw\\2016.txt");
      assertEquals(true, result.length() > 0);
   }
}