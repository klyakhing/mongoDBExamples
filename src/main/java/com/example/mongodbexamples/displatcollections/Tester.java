package com.example.mongodbexamples.displatcollections;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class Tester {
    public static void main(String[] args) {
        // Creating a Mongo client
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        // Get the database
        MongoDatabase database = mongoClient.getDatabase("test");

        // Create the collection
        database.createCollection("sample1Collection");

        // Get the list of collection names
        MongoIterable<String> collections = database.listCollectionNames();

        for (String name : collections) {
            System.out.println(name);
        }
    }
}
