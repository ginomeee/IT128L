package com.gabriel.mvc.app;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.gabriel.mvc.shapeimpl.CarMover;
import com.gabriel.mvc.shapesfx.MyShape;
import com.gabriel.mvc.shapesfx.Location;
import com.gabriel.mvc.shapesfx.Mover;


public class CarController extends JFrame implements ActionListener{
	public CarController() {
	}
	
	CarView carView;  
	MyShape car;
	Mover mover = new CarMover();
	JButton btnRight = new JButton("→");
	JButton btnLeft = new JButton("←");
	JButton btnUp = new JButton("↑");
	JButton btnDown= new JButton("↓");
	JButton btnUpdate= new JButton("Update");
	JButton btnCreate = new JButton("Create");
	JButton btnDelete = new JButton("Delete");
	JComboBox nameInput = new JComboBox();
	JTextArea priceInput = new JTextArea("Input Vehicle Price here");
	JComboBox brandInput = new JComboBox(); 
	JComboBox customBrandInput = new JComboBox(); 
	JTextField newModelText = new JTextField("Input Model Here");
	JTextField newPriceText = new JTextField("Input Price Here");
	JTextField newCodeText = new JTextField("Input Code Here");
	JTextField newStockText = new JTextField("Input Stock Here");
	JTable vehicleDeets = new JTable(5, 2) {
		@Override
	    public boolean isCellEditable(int row, int column) {                
	        return (column==1);
	    };
	};
	String selectedCar;
	static Connection connection = null;
	
	
	JLabel mytitle = new JLabel("IT128 PROJ Car Web Inventory");
	JLabel brandTitle = new JLabel("Brand");
	JLabel modelTitle = new JLabel("Model");
	JLabel footer = new JLabel("ARAULLO, Eugenio Emmanuel A.");
	JLabel customInput = new JLabel("Input a new vehicle");
	JLabel r1 = new JLabel("Brand");
	JLabel r2 = new JLabel("Model");
	JLabel r3 = new JLabel("Code");
	JLabel r4 = new JLabel("Price");
	JLabel r5 = new JLabel("Stock");
	Item webItem[];
	Brand webBrand[];
	int brandCount=0;
	int countBrand=0;
	int itemCount=0;
	int countItem;
	int pointer;
	String brands[];
	String allmodels[];
	//public void setInfo(String brand, String name, String code, float price, int stock)
	
	
	
	public void init(MyShape car, CarView carView ) {
		this.car = car;
		this.carView = carView;
	}
	
	
	public void initUI() {
		setTitle("Controller | IT128 PROJECT");
		try {
	         Connection con = DriverManager.getConnection(
	            "jdbc:mysql://127.0.0.1:3306/it128","root", "");
	         
	         Statement stmt = con.createStatement();
	         ResultSet countBrands = stmt.executeQuery("SELECT COUNT('ID') FROM `brands`");
	         while (countBrands.next()) {
	        	 brandCount = countBrands.getInt("COUNT('ID')");
	        	 System.out.println(brandCount+" is the total count\n");
	         }
	         webBrand = new Brand[brandCount+1];
	         brands = new String[brandCount+1];
	         
	         ResultSet rs = stmt.executeQuery("SELECT * FROM brands");
	         System.out.println("id  brand");
	         countBrand = 0;
	         while (rs.next()) {
	            int id = rs.getInt("ID");
	            webBrand[countBrand] = new Brand();
	            String BrandName = rs.getString("name");
	            brands[id] = BrandName;
	            webBrand[countBrand].setID(countBrand);
	            webBrand[countBrand].setWebID(id);
	            webBrand[countBrand].setName(BrandName);
	            countBrand++;
	         }
	         
	         for (int i=0;i<brandCount;i++) {
	        	 System.out.println("Local:  " + webBrand[i].getName());
	         }
	         
	         rs = stmt.executeQuery("SELECT COUNT('ID') FROM `items`");
	         while (rs.next()) {
	        	 itemCount = rs.getInt("COUNT('ID')");
	        	 System.out.println(itemCount+" is the total item count\n");
	         }
	         allmodels = new String[itemCount];
	         webItem = new Item[itemCount];
	         
	         rs = stmt.executeQuery("SELECT * FROM `items`");
	         // Debug lods System.out.println("id  model");
	         countItem = 0;
	         while (rs.next()) {
	            webItem[countItem] = new Item();
	            int id = rs.getInt("ID");
	            String ModelName = rs.getString("model");
	            float ModelPrice = rs.getFloat("price");
	            int ModelQty = rs.getInt("qty");
	            int ModelBrand = rs.getInt("brand");
	            String ModelCode = rs.getString("code");
	            webItem[countItem].setID(countItem);
	            webItem[countItem].setWebID(id);
	            webItem[countItem].setName(ModelName);
	            webItem[countItem].setPrice(ModelPrice);
	            webItem[countItem].setPrice(ModelPrice);
	            webItem[countItem].setBrand(ModelBrand);
	            webItem[countItem].setCode(ModelCode);
	            webItem[countItem].setStock(ModelQty);
	            countItem++;
	         }
	         
	      } catch(SQLException e1) {
	    	  JOptionPane.showMessageDialog(null, "SQL Exception Occured");
	         System.out.println("SQL exception occured" + e1);
	      }

		
		getContentPane().setBackground(Color.black); 
		btnRight.setFont(new Font("Consolas", Font.PLAIN, 40));
		btnRight.setBounds(210,150,100,100);
		btnLeft.setFont(new Font("Consolas", Font.PLAIN, 40));
		btnLeft.setBounds(10,150,100,100);
		btnUp.setFont(new Font("Consolas", Font.PLAIN, 40));
		btnUp.setBounds(110,50,100,100);
		btnDown.setFont(new Font("Consolas", Font.PLAIN, 40));
		btnDown.setBounds(110,250,100,100);
		btnDown.setFont(new Font("Consolas", Font.PLAIN, 28));
		btnUpdate.setFont(new Font("Consolas", Font.PLAIN, 20));
		btnUpdate.setBounds(330,310,150,50);
		btnDelete.setBounds(480,310,140,50);
		btnDelete.setFont(new Font("Consolas", Font.PLAIN, 20));
		btnCreate.setBounds(700,310,200,50);
		newModelText.setBounds(700,110,200,30);
		newModelText.setFont(new Font("Consolas", Font.PLAIN, 20));
		newStockText.setBounds(700,160,200,30);
		newStockText.setFont(new Font("Consolas", Font.PLAIN, 20));
		newPriceText.setBounds(700,210,200,30);
		newPriceText.setFont(new Font("Consolas", Font.PLAIN, 20));
		newCodeText.setBounds(700,270,200,30);
		newCodeText.setFont(new Font("Consolas", Font.PLAIN, 20));
		customBrandInput.setBounds(700,40,200,40);
		customBrandInput.setFont(new Font("Consolas", Font.PLAIN, 20));
		// Jcombo1 - Makes
		brandInput.setBounds(330,40,290,40);
		brandInput.setFont(new Font("Consolas", Font.PLAIN, 20));
		// Jcombo2 - Models
		nameInput.setBounds(330,110,290,40);
		nameInput.setFont(new Font("Consolas", Font.PLAIN, 20));
		// Vehicle Deets
		vehicleDeets.setBounds(330,160,290,140);
		vehicleDeets.setFont(new Font("Consolas", Font.PLAIN, 24));
		vehicleDeets.setValueAt("Brand",0,0);
		vehicleDeets.setValueAt("Model",1,0);
		vehicleDeets.setValueAt("Code",2,0);
		vehicleDeets.setValueAt("Price",3,0);
		vehicleDeets.setValueAt("Stock",4,0);
		vehicleDeets.setRowHeight(25);
		
		// Background and text
		mytitle.setForeground(Color.white);
		mytitle.setFont(new Font("Consolas", Font.PLAIN, 20));
		mytitle.setBounds(10,0,310,50);
		customInput.setBounds(700,0,300,50);
		customInput.setForeground(Color.GRAY);
		customInput.setFont(new Font("Consolas", Font.PLAIN, 18));
		mytitle.setFont(new Font("Consolas", Font.PLAIN, 20));
		r1.setBounds(20,0,300,50);
		footer.setForeground(Color.GRAY);
		footer.setFont(new Font("Consolas", Font.PLAIN, 18));
		footer.setBounds(20,350,300,50);
		brandTitle.setForeground(Color.GRAY);
		brandTitle.setFont(new Font("Consolas", Font.PLAIN, 18));
		brandTitle.setBounds(327,0,300,50);
		modelTitle.setForeground(Color.GRAY);
		modelTitle.setFont(new Font("Consolas", Font.PLAIN, 18));
		modelTitle.setBounds(327,70,300,50);
		
		getContentPane().add(btnRight);
		getContentPane().add(btnLeft);
		getContentPane().add(btnUp);
		getContentPane().add(btnDown);
		getContentPane().add(btnUpdate);
		getContentPane().add(btnDelete);
		btnDelete.setEnabled(false);
		getContentPane().add(btnCreate);
		btnCreate.setEnabled(false);
		btnUpdate.setEnabled(false);
		getContentPane().add(mytitle);
		getContentPane().add(footer);
		getContentPane().add(brandInput);
		getContentPane().add(nameInput);	
		nameInput.setEnabled(false);
		getContentPane().add(brandTitle);
		getContentPane().add(modelTitle);
		getContentPane().add(vehicleDeets);
		getContentPane().add(newModelText);
		getContentPane().add(newStockText);
		getContentPane().add(newPriceText);
		getContentPane().add(newCodeText);
		getContentPane().add(customInput);
		getContentPane().add(customBrandInput);
		getContentPane().add(r1);
		getContentPane().add(r2);
		getContentPane().add(r3);
		getContentPane().add(r4);
		getContentPane().add(r5);
		vehicleDeets.setEnabled(false);
		newModelText.setEditable(false);
		newCodeText.setEditable(false);
		newPriceText.setEditable(false);
		newStockText.setEditable(false);
		btnCreate.setEnabled(false);
		
		btnRight.addActionListener(this);
		btnLeft.addActionListener(this);
		btnUp.addActionListener(this);
		btnDown.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnCreate.addActionListener(this);
		btnDelete.addActionListener(this);
		brandInput.addActionListener(this);
		brandInput.setModel(new DefaultComboBoxModel (brands));
		customBrandInput.addActionListener(this);
		customBrandInput.setModel(new DefaultComboBoxModel (brands));
		nameInput.addActionListener(this);
		nameInput.setModel(new DefaultComboBoxModel (allmodels));

		getContentPane().setLayout(null);
		setVisible(true);
		setBounds(600,10,500,500);
		setSize(940,430);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		 Location changedLocation = new Location();
		if(e.getSource() == btnRight)
		{
			 changedLocation.setX(10);
			 changedLocation.setY(0);
			 mover.move(car, changedLocation);			 
			 carView.repaint();
		}
		else if(e.getSource() == btnLeft)
		{
			 changedLocation.setX(-10);
			 changedLocation.setY(0);
			 mover.move(car, changedLocation);			
			 carView.repaint();
		}
		else if(e.getSource() == btnUp)
		{
			 changedLocation.setX(0);
			 changedLocation.setY(-10);
			 mover.move(car, changedLocation);			
			 carView.repaint();
		}
		else if(e.getSource() == btnDown)
		{
			 changedLocation.setX(0);
			 changedLocation.setY(10);
			 mover.move(car, changedLocation);
			 carView.repaint();
		}	
		else if(e.getSource() == brandInput) {
			System.out.println("Brand Dropdown Detected");
			nameInput.removeAllItems();
			for (int i=0;i<itemCount;i++) {
				// Checks if gSI = same brand
				if (webItem[i].getBrand() == brandInput.getSelectedIndex()) {
					nameInput.addItem(webItem[i].getName());
					nameInput.setEnabled(true);
				}
			}
		} else if(e.getSource() == nameInput) {
			int modelbrandcnt = 0;
			for (int i=0;i<itemCount;i++) {
				System.out.println("LOOPIT. NameSelected " + brandInput.getSelectedIndex());
				// Checks if gSI = same brand
				if (webItem[i].getBrand() == brandInput.getSelectedIndex()) {
					modelbrandcnt++;
					System.out.println("Currently on: " + webItem[i].getCode() + " and modelbrandcnt " + modelbrandcnt);
					if (nameInput.getSelectedIndex() + 1 == modelbrandcnt) {
						System.out.println("THIS IS IT PANCIT " + webItem[i].getCode());
						vehicleDeets.setValueAt(webBrand[webItem[i].getBrand()-1].getName(),0,1);
						vehicleDeets.setValueAt(webItem[i].getName(),1,1);
						vehicleDeets.setValueAt(webItem[i].getCode(),2,1);
						vehicleDeets.setValueAt(webItem[i].getPrice(),3,1);
						vehicleDeets.setValueAt(webItem[i].getStock(),4,1);
						btnUpdate.setEnabled(true);
						btnDelete.setEnabled(true);
						vehicleDeets.setEnabled(true);
						pointer = webItem[i].getWebID();
					}
				}
			}
			
		} else if (e.getSource() == btnUpdate) {
			 // DEBUG ONLY System.out.println("Changed table cell at: " + vehicleDeets.getValueAt(0,1));
			 try {
		         Connection con = DriverManager.getConnection(
		            "jdbc:mysql://127.0.0.1:3306/it128","root", "");
		         String newModel = (String) vehicleDeets.getValueAt(1,1);
		         String newCode = (String) vehicleDeets.getValueAt(2,1);
		         float newPrice = Float.parseFloat(vehicleDeets.getValueAt(3,1).toString());
		         int newStock = Integer.parseInt(vehicleDeets.getValueAt(4,1).toString());
		         Statement stmt = con.createStatement();
		         stmt.executeUpdate("UPDATE `items` SET `model`='" + newModel + "', `price`='"+newPrice+"', `qty`='"+newStock+"', `code` = '"+newCode+"' WHERE ID = " + pointer);
		         System.out.println("Pointer is currently at: " + pointer);
		         System.out.println("id  name    price");
		        initUI();
		      } catch(SQLException e1) {
		    	  JOptionPane.showMessageDialog(null, "SQL Exception Occured");
		    	  JOptionPane.showMessageDialog(null, "SQL Exception Occured");
		         System.out.println("SQL exception occured" + e1);
		      }
		} else if (e.getSource() == btnCreate) {
			 try {
		         Connection con = DriverManager.getConnection(
		            "jdbc:mysql://127.0.0.1:3306/it128","root", "");
		         int newBrand = customBrandInput.getSelectedIndex();
		         String newModel = newModelText.getText();
		         String newCode = newCodeText.getText();
		         float newPrice = Float.parseFloat(newPriceText.getText());
		         int newStock = Integer.parseInt(newStockText.getText());
		         Statement stmt = con.createStatement();
		         stmt.executeUpdate("INSERT INTO `items`(`model`, `price`, `qty`, `brand`, `code`) VALUES ('" + newModel + "', '"+newPrice+"', '"+newStock+"', '"+newBrand+"', '"+newCode+"')");
		         System.out.println("Pointer is currently at: " + pointer);
		         System.out.println("id  name    price");
		         JOptionPane.showMessageDialog(null, "Successfully Created Record for " + newBrand + " " + newModel);
		         newModelText.setText("Input Model here");
		         newCodeText.setText("Input Code here");
		         newPriceText.setText("Input Price here");
		         newStockText.setText("Input Stock here");
		        initUI();
		      } catch(SQLException e1) {
		    	  JOptionPane.showMessageDialog(null, "SQL Exception Occured");
		         System.out.println("SQL exception occured" + e1);
		      }
		} else if (e.getSource() == customBrandInput) {
			if (customBrandInput.getSelectedIndex()!=0) {
					btnCreate.setEnabled(true);
					newModelText.setEditable(true);
					newCodeText.setEditable(true);
					newPriceText.setEditable(true);
					newStockText.setEditable(true);
					btnCreate.setEnabled(true);
				}
		} else if (e.getSource() == btnDelete) {
			try {
		         Connection con = DriverManager.getConnection(
		            "jdbc:mysql://127.0.0.1:3306/it128","root", "");
		         Statement stmt = con.createStatement();
		         stmt.executeUpdate("DELETE FROM `items` WHERE `items`.`ID` = " + pointer);
		         JOptionPane.showMessageDialog(null,"Deleted Record");
		        initUI();
		      } catch(SQLException e1) {
		    	 JOptionPane.showMessageDialog(null, "SQL Exception Occured");
		         System.out.println("SQL exception occured" + e1);
		      }
		}
		

	      try {
	         Connection con = DriverManager.getConnection(
	            "jdbc:mysql://127.0.0.1:3306/it128","root", "");
	         
	         Statement stmt = con.createStatement();
	         ResultSet rs = stmt.executeQuery("SELECT * FROM items");
	         System.out.println("id  name    price");
	         while (rs.next()) {
	            int id = rs.getInt("id");
	            String model = rs.getString("model");
	            String price = rs.getString("price");
	            System.out.println(id+"   "+model+"    "+price);
	         }
	      } catch(SQLException e1) {
	    	  JOptionPane.showMessageDialog(null, "SQL Exception Occured");
	         System.out.println("SQL exception occured" + e1);
	      }
		
	}
}
