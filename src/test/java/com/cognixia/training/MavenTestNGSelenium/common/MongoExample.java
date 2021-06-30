package com.cognixia.training.MavenTestNGSelenium.common;


import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoExample {

	public static void main (String[] args)
	{
		readFromMongoDB("personalinfo","firstname","lastname");
	}
	
	
	
	public static void readFromMongoDB(String collectionName, String field1, String field2)
	{
		MongoClient mongoClient =new MongoClient("localhost",27017);
		
		MongoDatabase database = mongoClient.getDatabase("Employee");
		
		MongoCollection<Document> collection=database.getCollection(collectionName);
		
		MongoCursor<Document> cursor =collection.find().iterator();
		
		while(cursor.hasNext())
		{
			Document d=cursor.next();
			System.out.println(d);
			
			String field_1=(String) d.get(field1);
			String field_2=(String) d.get(field2);
			
			System.out.println(field_1 + " : "+ field_2);
			
		}
	}
}