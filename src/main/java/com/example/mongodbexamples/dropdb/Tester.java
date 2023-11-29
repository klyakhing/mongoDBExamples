package com.example.mongodbexamples.dropdb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class Tester {
    public static void main(String[] args) {
        // Creating a Mongo client
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("myDb");

        // drop the database
        database.drop();
        System.out.println("Database dropped.");

        // print the databases
        MongoIterable<String> list = mongoClient.listDatabaseNames();
        for (String name : list) {
            System.out.println(name);
        }
    }
}
