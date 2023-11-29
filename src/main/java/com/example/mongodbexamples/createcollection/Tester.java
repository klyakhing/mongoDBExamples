package com.example.mongodbexamples.createcollection;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Tester {
    public static void main(String[] args) {
        // Creating a Mongo client
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        // Connect to database
        MongoDatabase database = mongoClient.getDatabase("test");

        // Create the collection
        database.createCollection("newCollection");
        System.out.println("Collection created.");
        // Retrieving a collection
        MongoCollection<Document> collection = database.getCollection("newCollection");
        Document document = new Document("title", "MongoDB")
                .append("description", "database")
                .append("likes", 100)
                .append("url", "http://www.tutorialspoint.com/mongodb/")
                .append("by", "tutorials point");

        //Inserting document into the collection
        collection.insertOne(document);
        System.out.println("document was added to collection.");
    }
}
