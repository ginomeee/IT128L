package com.gabriel.mvc.app;

public class Item {
		int ID;
		int webID;
		String name;
		String code;
		int brand;
		float price;
		int stock;
		
		public void setInfo(int ID, int webID, int brand, String name, String code, float price, int stock) {
			this.ID = ID;
			this.name = name;
			this.code = code;
			this.brand = brand;
			this.price = price;
			this.stock = stock;
		}
		
		public int getID() {
			return ID;
		}

		public void setID(int iD) {
			ID = iD;
		}

		public int getWebID() {
			return webID;
		}

		public void setWebID(int webID) {
			this.webID = webID;
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
		public int getBrand() {
			return brand;
		}
		public void setBrand(int brand) {
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
