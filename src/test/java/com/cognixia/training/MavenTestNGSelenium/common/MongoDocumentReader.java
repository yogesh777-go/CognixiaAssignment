package com.cognixia.training.MavenTestNGSelenium.common;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.bson.Document;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDocumentReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient mongoClient = new MongoClient("localhost",27017);
		
		MongoDatabase database = mongoClient.getDatabase("Employee");
		
		MongoCollection<Document> collection = database.getCollection("personalinfo");
				MongoCursor<Document> cursor = collection.find().iterator();

				while(cursor.hasNext()) {
					Document d= cursor.next();
					System.out.println(d);
					String firstname=(String) d.get("firstname");
					System.out.println(firstname);
				}

	}

}
