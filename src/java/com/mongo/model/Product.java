package com.mongo.model;

public class Product {

	// id will be used for primary key in MongoDB
	// We could use ObjectId, but I am keeping it
	// independent of MongoDB API classes
	private String id, name, price, sku, description, stock ;;

   
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
        public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
        public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
        public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
        public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}
}
