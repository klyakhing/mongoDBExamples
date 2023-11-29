package com.example.mongodbexamples.deletedocument;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Tester {
    public static void main(String[] args) {
        // Creating a Mongo client
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("test");

        // Get the collection
        MongoCollection<Document> collection = database.getCollection("sample2Collection");

        // Find all documents
        collection.deleteOne(Filters.eq("First_Name","Mahesh"));
        System.out.println("Document deleted.");
        System.out.println("***Documents***");

        // Select a particular document
        FindIterable<Document> documents = collection.find();

        for (Document document : documents) {
            System.out.println(document);
        }
    }
}
