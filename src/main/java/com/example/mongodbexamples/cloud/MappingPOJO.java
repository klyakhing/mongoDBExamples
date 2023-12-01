package com.example.mongodbexamples.cloud;

import com.example.mongodbexamples.models.Inspection;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MappingPOJO {

    public static void main(String[] args) {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:pass@cluster0.t7kjst8.mongodb.net/test");
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .codecRegistry(codecRegistry)
                .build();
        try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
            MongoDatabase db = mongoClient.getDatabase("test");
            //MongoCollection<Inspection> grades = db.getCollection("inspections", Inspection.class);

            // Get the collection
            MongoCollection<Document> collection = db.getCollection("inspections");

            System.out.println("***All Document***");
            // Find all documents
            FindIterable<Document> allDocuments = collection.find().limit(10);

            for (Document document : allDocuments) {
                System.out.println(document);
            }
        }
    }
}
