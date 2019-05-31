package com.mongo.converter;

import org.bson.types.ObjectId;

import com.mongo.model.Product;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class ProductConverter {

	// convert Person Object to MongoDB DBObject
	// take special note of converting id String to ObjectId
	public static DBObject toDBObject(Product p) {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("name", p.getName()).append("price", p.getPrice()).append("sku", p.getSku()).append("description", p.getDescription()).append("stock", p.getStock());
		if (p.getId() != null)
			builder = builder.append("_id", new ObjectId(p.getId()));
		return builder.get();
	}

	// convert DBObject Object to Person
	// take special note of converting ObjectId to String
	public static Product toPerson(DBObject doc) {
		Product p = new Product();
		p.setName((String) doc.get("name"));
		p.setPrice((String) doc.get("price"));
                p.setSku((String) doc.get("sku"));
                p.setDescription((String) doc.get("description"));
                p.setStock((String) doc.get("stock"));
		ObjectId id = (ObjectId) doc.get("_id");
		p.setId(id.toString());
		return p;

	}
	
}
