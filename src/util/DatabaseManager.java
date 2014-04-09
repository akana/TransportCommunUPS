package util;

import java.io.IOException;
import java.util.ArrayList;

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
    }
    
    public void lineUnlike(String id, String rev){
        
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
        LineEvaluation l = instance.getAllLineInfo();
        for(LineEvaluation line : instance.getAllLineInfo()){
            System.out.println("line num: "+line.getLineNumber());
            System.out.println("like: "+line.getNumLike());
            System.out.println();
        }
    }
    
}
