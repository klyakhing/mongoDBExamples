package com.example.mongodbexamples.showdb;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class Tester {
    public static void main(String[] args) {
        // Creating a Mongo client
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("test");
        database.createCollection("sampleCollection");

        // Retrieving a collection
        MongoCollection<Document> collection = database.getCollection("sampleCollection");
        Document document = new Document("title", "MongoDB")
                .append("description", "database")
                .append("likes", 100)
                .append("url", "http://www.tutorialspoint.com/mongodb/")
                .append("by", "tutorials point");

        //Inserting document into the collection
        collection.insertOne(document);

        MongoIterable<String> list = mongoClient.listDatabaseNames();
        for (String name : list) {
            System.out.println(name);
        }
    }
}
