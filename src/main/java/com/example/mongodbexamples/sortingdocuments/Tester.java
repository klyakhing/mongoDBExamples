package com.example.mongodbexamples.sortingdocuments;

import org.bson.Document;

import com.mongodb.BasicDBObject;
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
        System.out.println("***Discending Order***");

        // Sort in Descending order
        FindIterable<Document> allDocuments = collection.find().sort(new BasicDBObject("First_Name",-1));

        for (Document document : allDocuments) {
            System.out.println(document);
        }
        System.out.println("***Ascending Order***");

        // Sort in Ascending order
        allDocuments = collection.find().sort(new BasicDBObject("First_Name",1));

        for (Document document : allDocuments) {
            System.out.println(document);
        }
    }
}
