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
    
    public static void main(String[] args){
    	try {
			String test = getHTTPData("http://Ziyan:0917@localhost:5984");
			System.out.println(test);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}