package curs20;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoExample {

	//connect to mongo
	public static MongoClient connectToMongo() {
		
		try {
			ConnectionString connectionString = new ConnectionString("mongodb+srv://testuser:testuser@cluster0.bkai1.mongodb.net/sample_analytics?retryWrites=true&w=majority");
			MongoClientSettings setting = MongoClientSettings.builder()
					.applyConnectionString(connectionString)
					.serverApi(ServerApi.builder().version(ServerApiVersion.V1).build())
					.build();
			
		MongoClient mongoClient = MongoClients.create(setting);
		return mongoClient;
			
			
		}catch(MongoException e) {
			System.out.println("Could not make a connection!");
			
		}
		
		return null;
		
	}
	
	//close mongo connection
	
	public static void closeConnection(MongoClient mongoClient) {
		
		try {
			System.out.println("Trying to close the connection!");
			mongoClient.close();
			System.out.println("Connection successfully closed!");
			
		}catch(MongoException e) {
			System.out.println("Could not establish a connection to db");
		}
	}
	
	public static void createMongoCollection(MongoDatabase db, String collectionName) {
		
		try {
			System.out.println("Trying to create collection :" + collectionName);
			db.createCollection(collectionName);			
			System.out.println(collectionName + " created sucessfully !");
			
		}catch(MongoException e) {
			System.out.println("Could not create a new collection !");
		}
		
	}
	
	public static void main(String[] args) {
		
		MongoClient mongoClinet =  connectToMongo();
		
		MongoDatabase databaseSampleAnalyctics = mongoClinet.getDatabase("sample_analytics");
		
		for (String name : databaseSampleAnalyctics.listCollectionNames()) {
			System.out.println("Collection name :" + name);
		}
		
		createMongoCollection(databaseSampleAnalyctics, "test_dragos");
		
		
		for (String name : databaseSampleAnalyctics.listCollectionNames()) {
			System.out.println("Collection name :" + name);
		}
		
		closeConnection(mongoClinet);
	}

}
