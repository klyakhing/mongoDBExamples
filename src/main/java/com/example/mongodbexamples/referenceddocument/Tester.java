package com.example.mongodbexamples.referenceddocument;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.DBRef;
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
        MongoCollection<Document> collection = database.getCollection("post");
        List<String> tags = new ArrayList<String>();
        tags.add("mongodb");
        tags.add("database");
        tags.add("NoSQL");

        Document comment1 = new Document();
        comment1.put("_id", "comment1");
        comment1.put("user", "User1");
        comment1.put("message", "My First Comment");
        comment1.put("dateCreated", "20/2/2020");
        comment1.put("like", "0");

        DBRef comment1Ref = new DBRef("post", comment1.get("_id"));
        Document comment2 = new Document();
        comment2.put("_id", "comment2");
        comment2.put("user", "User2");
        comment2.put("message", "My Second Comment");
        comment2.put("dateCreated", "20/2/2020");
        comment2.put("like", "0");

        DBRef comment2Ref = new DBRef("post", comment2.get("_id"));

        List<Document> comments = new ArrayList<Document>();
        comments.add(comment1);
        comments.add(comment2);

        Document document = new Document("title", "Java Overview")
                .append("description", "Java is programming language")
                .append("by", "tutorials point")
                .append("url", "http://www.tutorialspoint.com")
                .append("tags",tags)
                .append("comment1", comment1Ref)
                .append("comment2", comment2Ref);

        collection.insertMany(comments);
        collection.insertOne(document);

        FindIterable<Document> documents = collection.find(Filters.eq("title","Java Overview"));

        for (Document doc : documents) {
            System.out.println(doc);
        }
    }
}
