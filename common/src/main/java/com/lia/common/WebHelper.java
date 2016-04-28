package com.lia.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;

public enum WebHelper {
   INSTANCE;
   public String getContent(String url, ArrayList<Cookie> multi_cookie) throws Exception {
      StringBuffer content = new StringBuffer();
      CloseableHttpClient httpclient = null;
      try {
         CookieStore cookieStore = new BasicCookieStore();
         for (Cookie item:multi_cookie)
         {
            BasicClientCookie cookie = new BasicClientCookie(item.getName(), item.getValue());
            cookie.setPath(item.getPath());
            cookie.setDomain(item.getDomain());
            cookie.setValue(item.getValue());
            cookieStore.addCookie(cookie);
         }

         httpclient = HttpClients.custom()  
                  .setDefaultCookieStore(cookieStore).build();

         HttpGet httpget = new HttpGet(url);

         CloseableHttpResponse response = httpclient.execute(httpget);
         HttpEntity entity = response.getEntity();
         if (entity != null) {
            InputStream input = entity.getContent();
            try {
               BufferedReader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
               String line = null;
               while ((line = reader.readLine()) != null){
                  content = content.append(line);
                  content = content.append("\n");
               }
               input.close();
            } finally {
                input.close();
            }
        }
      }
      finally {
         httpclient.close();
      }
      return content.toString();
   }
   
   public String getContent(String url) throws Exception{
      ArrayList<Cookie> multi_cookie = new ArrayList<Cookie>();
      return getContent(url, multi_cookie);
   }
}
