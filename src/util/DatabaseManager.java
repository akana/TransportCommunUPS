package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.tisseo.LineEvaluation;


public class DatabaseManager {
    
    private final String DB_URL = "http://127.0.0.1:5984/transport_commun_ups/";
    
    public static DatabaseManager instance = new DatabaseManager();
    
    private DatabaseManager(){
    }
    
    public void lineLike(String id, String rev){
        String lineInfo;
        String lineNumber = "";
        int likeNumber =0;
        int unlikeNumber =0;
        
        try {
            lineInfo = RetrieveHTTPData.getHTTPData(DB_URL+id);
            JSONObject lineInfoJson = new JSONObject(lineInfo);
            lineNumber = lineInfoJson.getString("lineNumber");
            likeNumber = lineInfoJson.getInt("numLike");
            unlikeNumber = lineInfoJson.getInt("numUnlike");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        Map<String,String> lineMap = new HashMap<String,String>();
        lineMap.put("_id", id);
        lineMap.put("_rev", rev);
        lineMap.put("lineNumber", lineNumber);
        lineMap.put("numLike", (likeNumber+1)+"");
        lineMap.put("numUnlike", unlikeNumber+"");
        
        JSONObject lineJson = new JSONObject(lineMap);
        try {
            RetrieveHTTPData.putHTTPData(DB_URL+id, lineJson.toString());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void lineUnlike(String id, String rev){
        String lineInfo;
        String lineNumber = "";
        int likeNumber =0;
        int unlikeNumber =0;
        
        try {
            lineInfo = RetrieveHTTPData.getHTTPData(DB_URL+id);
            JSONObject lineInfoJson = new JSONObject(lineInfo);
            lineNumber = lineInfoJson.getString("lineNumber");
            likeNumber = lineInfoJson.getInt("numLike");
            unlikeNumber = lineInfoJson.getInt("numUnlike");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        Map<String,String> lineMap = new HashMap<String,String>();
        lineMap.put("_id", id);
        lineMap.put("_rev", rev);
        lineMap.put("lineNumber", lineNumber);
        lineMap.put("numLike", likeNumber+"");
        lineMap.put("numUnlike", (unlikeNumber+1)+"");
        
        JSONObject lineJson = new JSONObject(lineMap);
        try {
            RetrieveHTTPData.putHTTPData(DB_URL+id, lineJson.toString());
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<LineEvaluation> getAllLineInfo(){
        ArrayList<LineEvaluation> lines = new ArrayList<LineEvaluation>();
        String allDoc = "";
        try {
            allDoc = RetrieveHTTPData.getHTTPData(DB_URL+"_all_docs");
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        LineEvaluation line;
        try {
            JSONObject allDocJson = new JSONObject(allDoc);
            JSONArray rows = allDocJson.getJSONArray("rows");
            JSONObject row;
            for(int i=0; i<rows.length() ; i++){
                row = rows.getJSONObject(i);
                String idRow = row.getString("id");
                String lineString =  RetrieveHTTPData.getHTTPData(DB_URL+idRow);
                JSONObject lineJson = new JSONObject(lineString);
                line = new LineEvaluation(lineJson.getString("_id"),
                                          lineJson.getString("_rev"),
                                          lineJson.getString("lineNumber"),
                                          lineJson.getInt("numLike"),
                                          lineJson.getInt("numUnlike"));
                lines.add(line);
                
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return lines;
    }
    
    public static void main(String[] args){
//        instance.lineLike("3da2a71b63f52f1493babbf1ba006ac0","1-54c7a40fbd558de821ea6950da441d2f");
//        instance.lineUnlike("3da2a71b63f52f1493babbf1ba006ac0","2-851a162937b3c3cd16ca6ddd7671da38");
        for(LineEvaluation line : instance.getAllLineInfo()){
            System.out.println("line num: "+line.getLineNumber());
//            System.out.println("like: "+line.getNumLike());
//            System.out.println();
        }
        
        
    }
    
}
