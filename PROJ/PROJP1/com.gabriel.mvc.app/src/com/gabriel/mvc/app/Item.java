package com.gabriel.mvc.app;

public class Item {
		String name;
		String code;
		String brand;
		float price;
		int stock;
		
		public void setInfo(String brand, String name, String code, float price, int stock) {
			this.name = name;
			this.code = code;
			this.brand = brand;
			this.price = price;
			this.stock = stock;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		public float getPrice() {
			return price;
		}
		public void setPrice(float price) {
			this.price = price;
		}
		public int getStock() {
			return stock;
		}
		public void setStock(int stock) {
			this.stock = stock;
		}
		
		
}
