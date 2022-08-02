package com.gabriel.mvc.app;

public class Brand {
		int ID;
		int webID;
		String name;
		
		public void setInfo(int ID, String name, int webID) {
			this.ID = ID;
			this.name = name;
			this.webID = webID;
		}
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getID() {
			return ID;
		}
		
		public void setID(int ID) {
			this.ID = ID;
		}
		
		public int getWebID() {
			return webID;
		}

		public void setWebID(int webID) {
			this.webID = webID;
		}

		
		
}
