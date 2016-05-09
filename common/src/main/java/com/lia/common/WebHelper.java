package com.lia.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

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
   
   public String getContent(String userId, String password) throws Exception{
      String url = "http://huayn.net:9090/nox/checkuser.jsp";  
      StringBuffer content = new StringBuffer();
      CloseableHttpClient httpclient = null;
      try {

         httpclient = HttpClients.createDefault();

         HttpPost httppost = new HttpPost(url);
         
         List<NameValuePair> params=new ArrayList<NameValuePair>();
         
         params.add(new BasicNameValuePair("examcode",userId));
         params.add(new BasicNameValuePair("password",password));
         HttpEntity postParams = new UrlEncodedFormEntity(params);
         httppost.setEntity(postParams);

         CloseableHttpResponse httpResponse = httpclient.execute(httppost);
         int val = httpResponse.getStatusLine().getStatusCode();
         if(val == 302){
            HttpGet httpget = new HttpGet("http://huayn.net:9090/nox/info.jsp?x=x");

            CloseableHttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
               InputStream input = entity.getContent();
               try {
                  BufferedReader reader = new BufferedReader(new InputStreamReader(input, "GBK"));
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
         return content.toString();
      }
      finally {
         //httpclient.close();
      }
   }
}
