package com.example.mongodbexamples.connect;

import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class Tester {
    public static void main(String[] args) {
        // Creating a Mongo client
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("test");

        // Creating Credentials
        MongoCredential credential;
        credential = MongoCredential.createCredential("sampleUser", "test", "password".toCharArray());

        System.out.println("Credentials ::"+ credential);
    }
}
