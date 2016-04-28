package com.lia.common;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class WebHelperTest 
{
   @Test
   public void testGetContent() throws Exception
   {
       String url = "http://brickset.com/sets/year-2016/page-2";
       ArrayList<Cookie> multi_cookie = new ArrayList<Cookie>();
       multi_cookie.add(new Cookie("setsListFormat", "CSV", "/", "brickset.com"));
       String result = WebHelper.INSTANCE.getContent(url, multi_cookie);
       assertEquals(true, result.length() > 0);
   }
}