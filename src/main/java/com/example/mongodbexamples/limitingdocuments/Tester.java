package com.example.mongodbexamples.limitingdocuments;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Tester {
    public static void main(String[] args) {
        // Creating a Mongo client
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("test");

        // Get the collection
        MongoCollection<Document> collection = database.getCollection("sample2Collection");

        // Find two documents
        FindIterable<Document> allDocuments = collection.find().limit(3);

        for (Document document : allDocuments) {
            System.out.println(document);
        }
    }
}
