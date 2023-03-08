package com.example.restservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.apache.commons.logging.Log;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.stereotype.Component;
@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private final MongoDatabaseFactory mongo;
	@Autowired
    private MongoClient client;
    public GreetingController(MongoDatabaseFactory mongo) {
        this.mongo = mongo;
    }
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "shitsss") String name) {
		final List<String> list = new ArrayList<>();
		MongoDatabase db = this.mongo.getMongoDatabase();
		final MongoCollection<Document> data = client.getDatabase("java").getCollection("users");
		data.find().map(Document::toJson).forEach(list::add);
		System.out.println(list);
		return new Greeting(list);
	}
}