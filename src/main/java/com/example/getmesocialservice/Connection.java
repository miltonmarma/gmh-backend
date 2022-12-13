package com.example.getmesocialservice;

//package com.mongodb.quickstart;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Connection {

    public static void main(String[] args) {

        ConnectionString connectionString = new ConnectionString("mongodb+srv://TomMilton:Hiccups123@cluster0.zuodxrk.mongodb.net/?retryWrites=true");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();

        MongoClient mongoClient = MongoClients.create(settings);

    }
//        String connectionString = System.getProperty("mongodb.uri");
//        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
//            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
//            databases.forEach(db -> System.out.println(db.toJson()));
//        }
//    }
}



//mvn compile exec:java -Dexec.mainClass="com.mongodb.quickstart.Connection" -Dmongodb.uri="mongodb+srv://TomMilton:Hiccups123@cluster0.zuodxrk.mongodb.net/?retryWrites=true"
//mvn compile exec:java -Dexec.mainClass="com.mongodb.quickstart.Connection" -Dmongodb.uri="mongodb+srv://TomMilton:Hiccups123@cluster0.zuodxrk.mongodb.net/?retryWrites=true&w=majority"


//mongodb+srv://TomMilton:Hiccups123@cluster0.zuodxrk.mongodb.net/?retryWrites=true&w=majority