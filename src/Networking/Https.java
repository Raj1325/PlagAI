package Networking;


import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Https {


    public static Reader executeQuery(String url ,
                                      ArrayList<String>keys,
                                      ArrayList<String>values)
    {

         if(keys.size() != values.size())
         {
             return null;
         }
         List<NameValuePair> formparams = new ArrayList<NameValuePair>();

         for(int itr = 0 ; itr < keys.size() ; itr++)
         {
             formparams.add(new BasicNameValuePair(keys.get(itr), values.get(itr))); // parameters for server in body
         }
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(url);  //server address
        httppost.setEntity(entity);

        try {
            CloseableHttpResponse response = client.execute(httppost);
            HttpEntity Responseentity = response.getEntity();
            InputStream is = Responseentity.getContent();
            Reader reader = new InputStreamReader(is);
            //response.close();
            return reader;
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    public static Reader executeCustomQuery(boolean isPost ,
                                            String url ,
                                            ArrayList<String> keys ,
                                            ArrayList<String> values ,
                                            String encoding,
                                            String Authorization,
                                            String text)
    {
        HttpRequestBase clientPacket = null;
        if(isPost)
        {
            clientPacket  = new HttpPost(url);
            if(keys != null)
            {
                JSONObject bodyData = new JSONObject();
                for(int itr = 0 ; itr < keys.size() ; itr++)
                {
                    bodyData.put(keys.get(itr) , values.get(itr));
                }
                StringEntity params = null;
                try {
                    params = new StringEntity(bodyData.toString());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                ((HttpPost)clientPacket).setEntity(params);
            }
            else if(text != null){
                StringEntity params = null;
                try {
                    params = new StringEntity(text);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                ((HttpPost)clientPacket).setEntity(params);
            }
        }
        else{
            clientPacket = new HttpGet(url);

        }

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        if(encoding != null) {
            clientPacket.addHeader("content-type", encoding);
        }
        if(Authorization != null)
        {
            clientPacket.addHeader("Authorization", "Bearer "+Authorization );
        }
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(clientPacket);
            HttpEntity Responseentity = response.getEntity();
            InputStream is = Responseentity.getContent();
            Reader reader = new InputStreamReader(is);
            return reader;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

}
