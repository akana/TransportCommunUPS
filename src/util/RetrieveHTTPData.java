package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RetrieveHTTPData
{       
     
    public static String getHTTPData(String url) throws ClientProtocolException, IOException
    {
        HttpGet httpGet=null;
        HttpClient httpClient=null;
        httpClient = HttpClientBuilder.create().build();
        httpGet = new HttpGet(url);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK)
        {
                InputStream inputStream = httpResponse.getEntity().getContent();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                
                try
                {
                        String line = "";
                        while ((line = bufferedReader.readLine()) != null)
                                stringBuilder.append(line + "\n");
                }
                catch (IOException e) { e.printStackTrace(); }
                finally
                {
                        try { inputStream.close(); }
                        catch (IOException e) { e.printStackTrace(); }
                }
                
                inputStream.close();
                httpGet.abort();
                return stringBuilder.toString();
        }
        httpGet.abort();
        return "";
    }
    
    public static void postHTTPData(String url, String data) throws ClientProtocolException, IOException
    {
        HttpClient httpClient=null;
        httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        StringEntity params =new StringEntity(data);
        httpPost.addHeader("content-type", "application/json");
        httpPost.setEntity(params);
        httpClient.execute(httpPost);
    }
    
    public static void putHTTPData(String url, String data) throws ClientProtocolException, IOException
    {
        HttpClient httpClient=null;
        httpClient = HttpClientBuilder.create().build();
        HttpPut httpPut = new HttpPut(url);
        StringEntity params =new StringEntity(data);
        httpPut.addHeader("content-type", "application/json");
        httpPut.setEntity(params);
        httpClient.execute(httpPut);
    }
    
    public static void main(String[] args){
        
    }
}