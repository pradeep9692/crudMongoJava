package com.mongo.dao;

import com.mongo.converter.ProductConverter;
import com.mongo.model.Product;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;


public class MongoDBProductDAO {

	private DBCollection col;

	public MongoDBProductDAO(MongoClient mongo) {
		this.col = mongo.getDB("journaldev1").getCollection("Persons");
	}

	public Product createPerson(Product p) {
		DBObject doc = ProductConverter.toDBObject(p);
		this.col.insert(doc);
		ObjectId id = (ObjectId) doc.get("_id");
		p.setId(id.toString());
		return p;
	}

	

	public List<Product> readAllPerson() {
		List<Product> data = new ArrayList<Product>();
		DBCursor cursor = col.find();
		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			Product p = ProductConverter.toPerson(doc);
			data.add(p);
		}
		return data;
	}

	

	public Product readPerson(Product p) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(p.getId())).get();
		DBObject data = this.col.findOne(query);
		return ProductConverter.toPerson(data);
	}
        public List<Product> searchPerson(String q) {
            List<Product> data = new ArrayList<Product>();
            String nq = q.concat(".*");
            BasicDBObject regexQuery = new BasicDBObject();
                regexQuery.put("sku", new BasicDBObject("$regex",nq)
		.append("$options", "i"));			
	System.out.println(regexQuery.toString());			
	DBCursor cursor = col.find(regexQuery);
	while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			Product p = ProductConverter.toPerson(doc);
			data.add(p);
	}
		return data;
	}
}
