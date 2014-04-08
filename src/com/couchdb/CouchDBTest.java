package com.couchdb;  
  
import java.net.MalformedURLException;  
  
import org.ektorp.CouchDbConnector;  
import org.ektorp.CouchDbInstance;  
import org.ektorp.http.HttpClient;  
import org.ektorp.http.StdHttpClient;  
import org.ektorp.impl.StdCouchDbConnector;  
import org.ektorp.impl.StdCouchDbInstance;  

import com.couchdb.Sofa;
  
public class CouchDBTest {  
  
    public static void main(String[] args) throws MalformedURLException {  
          
        HttpClient httpClient = new StdHttpClient.Builder().url("http://Ziyan:0917@localhost:5984").build();  
        CouchDbInstance dbInstance = new StdCouchDbInstance(httpClient);  
        CouchDbConnector db = new StdCouchDbConnector("myfirstcouchdb", dbInstance);
        db.createDatabaseIfNotExists();  
  
        Sofa sofa = db.get(Sofa.class, "001");  
        if(sofa != null) db.delete(sofa);  
          
        sofa = new Sofa();  
        sofa.setId("001");  
        sofa.setColor("red");  
        db.create(sofa);  
          
        Sofa tmpSofa = db.get(Sofa.class, "001");  
        System.out.println(tmpSofa.getRevision() + " : " + tmpSofa.getColor());  
        tmpSofa.setColor("blue");  
        db.update(tmpSofa);  
        tmpSofa = db.get(Sofa.class, "001");  
        System.out.println(tmpSofa.getRevision() + " : " + tmpSofa.getColor());  
    }  
}  