package com.example.mongodbexamples.cloud;

import com.mongodb.MongoCredential;
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
        MongoClient mongoClient = MongoClients.create("mongodb+srv://admin:pass@cluster0.t7kjst8.mongodb.net/test");
        MongoDatabase database = mongoClient.getDatabase("test");

        // Creating Credentials
        MongoCredential credential;
        credential = MongoCredential.createCredential("admin", "test", "password".toCharArray());

        System.out.println("Credentials ::"+ credential);

        // Get the collection
        MongoCollection<Document> collection = database.getCollection("inspections");

        System.out.println("***All Document***");
        // Find all documents
        FindIterable<Document> allDocuments = collection.find().limit(10);

        for (Document document : allDocuments) {
            System.out.println(document);
        }
        System.out.println("***Selected Document***");

        // Select a particular document
        FindIterable<Document> documents = collection.find(Filters.eq("result", "Violation Issued")).limit(10);
        for (Document document : documents) {
            System.out.println(document);
        }
    }
}

