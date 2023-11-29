package com.example.mongodbexamples.embeddeddocument;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        // Creating a Mongo client
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("test");

        // Create the collection
        database.createCollection("post");

        MongoCollection<Document> collection = database.getCollection("post");
        List<String> tags = new ArrayList<String>();
        tags.add("mongodb");
        tags.add("database");
        tags.add("NoSQL");

        BasicDBObject comment1 = new BasicDBObject();
        comment1.put("user", "User1");
        comment1.put("message", "My First Comment");
        comment1.put("dateCreated", "20/2/2020");
        comment1.put("like", "0");

        BasicDBObject comment2 = new BasicDBObject();
        comment2.put("user", "User2");
        comment2.put("message", "My Second Comment");
        comment2.put("dateCreated", "20/2/2020");
        comment2.put("like", "0");

        List<DBObject> comments = new ArrayList<DBObject>();
        comments.add(comment1);
        comments.add(comment2);

        Document document = new Document("title", "MongoDB Overview")
                .append("description", "MongoDB is no SQL database")
                .append("by", "tutorials point")
                .append("url", "http://www.tutorialspoint.com")
                .append("tags",tags)
                .append("comments", comments);

        collection.insertOne(document);

        FindIterable<Document> documents = collection.find(Filters.eq("title","MongoDB Overview"));

        for (Document doc : documents) {
            System.out.println(doc);
        }
    }
}
