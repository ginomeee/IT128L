package com.gabriel.mvc.app;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.gabriel.mvc.shapeimpl.CarMover;
import com.gabriel.mvc.shapesfx.MyShape;
import com.gabriel.mvc.shapesfx.Location;
import com.gabriel.mvc.shapesfx.Mover;


public class CarController extends JFrame implements ActionListener{
	
	
	CarView carView;  
	MyShape car;
	Mover mover = new CarMover();
	JButton btnRight = new JButton("→");
	JButton btnLeft = new JButton("←");
	JButton btnUp = new JButton("↑");
	JButton btnDown= new JButton("↓");
	String toyotaModels[] = {"Vios","Camry","Hilux"};
	String hondaModels[] = {"City","CRV","Civic"};
	String vehicleMakes[] = {"Honda","Toyota"};
	JComboBox nameInput = new JComboBox();
	JTextArea priceInput = new JTextArea("Input Vehicle Price here");
	JComboBox brandInput = new JComboBox(vehicleMakes); 
	JTable vehicleDeets = new JTable(5, 2);
	String tableColumn[] = {"Make","Model","Code","Price (PHP)","Stock"};
	String selectedCar;
	
	
	
	JLabel mytitle = new JLabel("Gino's Toy Car Controller");
	JLabel brandTitle = new JLabel("Brand");
	JLabel modelTitle = new JLabel("Model");
	JLabel footer = new JLabel("ARAULLO, Eugenio Emmanuel A.");
	Item viosCar = new Item();
	Item hiluxCar = new Item();
	Item camryCar = new Item();
	Item crvCar = new Item();
	Item civicCar = new Item();
	Item cityCar = new Item();
	//public void setInfo(String brand, String name, String code, float price, int stock)
	
	
	
	public void init(MyShape car, CarView carView ) {
		this.car = car;
		this.carView = carView;
	}
	
	
	public void initUI() {
		setTitle("Controller | Ginos Toy Car");

		viosCar.setInfo("Toyota", "Vios", "A0", 750000, 39);
		hiluxCar.setInfo("Toyota", "Hilux", "A2", 1200400, 33);
		camryCar.setInfo("Toyota", "Camry", "A1", 1100250, 22);
		crvCar.setInfo("Honda", "CR-V", "B1", 1750455, 5);
		cityCar.setInfo("Honda", "City", "B0", 1100030, 12);
		civicCar.setInfo("Honda", "Civic", "B2", 1250422, 8);
		
		getContentPane().setBackground(Color.black); 
		btnRight.setFont(new Font("Consolas", Font.PLAIN, 40));
		btnRight.setBounds(210,150,100,100);
		btnLeft.setFont(new Font("Consolas", Font.PLAIN, 40));
		btnLeft.setBounds(10,150,100,100);
		btnUp.setFont(new Font("Consolas", Font.PLAIN, 40));
		btnUp.setBounds(110,50,100,100);
		btnDown.setFont(new Font("Consolas", Font.PLAIN, 40));
		btnDown.setBounds(110,250,100,100);
		// Jcombo1 - Makes
		brandInput.setBounds(330,40,270,30);
		brandInput.setFont(new Font("Consolas", Font.PLAIN, 20));
		// Jcombo2 - Models
		nameInput.setBounds(330,110,270,40);
		nameInput.setFont(new Font("Consolas", Font.PLAIN, 20));
		// Vehicle Deets
		vehicleDeets.setBounds(330,170,270,200);
		vehicleDeets.setFont(new Font("Consolas", Font.PLAIN, 16));
		vehicleDeets.setValueAt("Brand",0,0);
		vehicleDeets.setValueAt("Model",1,0);
		vehicleDeets.setValueAt("Code",2,0);
		vehicleDeets.setValueAt("Price",3,0);
		vehicleDeets.setValueAt("Stock",4,0);
		
		// Background and text
		mytitle.setForeground(Color.white);
		mytitle.setFont(new Font("Consolas", Font.PLAIN, 20));
		mytitle.setBounds(20,0,300,50);
		footer.setForeground(Color.GRAY);
		footer.setFont(new Font("Consolas", Font.PLAIN, 18));
		footer.setBounds(20,350,300,50);
		brandTitle.setForeground(Color.GRAY);
		brandTitle.setFont(new Font("Consolas", Font.PLAIN, 18));
		brandTitle.setBounds(327,0,300,50);
		modelTitle.setForeground(Color.GRAY);
		modelTitle.setFont(new Font("Consolas", Font.PLAIN, 18));
		modelTitle.setBounds(327,70,300,50);
		
		add(btnRight);
		add(btnLeft);
		add(btnUp);
		add(btnDown);
		add(mytitle);
		add(footer);
		add(brandInput);
		add(nameInput);	
		add(brandTitle);
		add(modelTitle);
		add(vehicleDeets);
		
		btnRight.addActionListener(this);
		btnLeft.addActionListener(this);
		btnUp.addActionListener(this);
		btnDown.addActionListener(this);
		brandInput.addActionListener(this);
		nameInput.addActionListener(this);
		nameInput.setModel(new DefaultComboBoxModel (hondaModels));

		
		setLayout(null);
		setVisible(true);
		setBounds(600,10,500,500);
		setSize(630,430);
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
			if (brandInput.getSelectedIndex() == 0) {
				nameInput.setModel(new DefaultComboBoxModel (hondaModels));
			} else if (brandInput.getSelectedIndex() == 1) {
				nameInput.setModel(new DefaultComboBoxModel (toyotaModels));
			}
		}
		else if(e.getSource() == nameInput) {
			selectedCar = (String) nameInput.getSelectedItem();
			switch(selectedCar) {
				case "City":
					vehicleDeets.setValueAt(cityCar.getBrand(),0,1);
					vehicleDeets.setValueAt(cityCar.getName(),1,1);
					vehicleDeets.setValueAt(cityCar.getCode(),2,1);
					vehicleDeets.setValueAt(cityCar.getPrice(),3,1);
					vehicleDeets.setValueAt(cityCar.getStock(),4,1);
					break;
				case "CRV":
					vehicleDeets.setValueAt(crvCar.getBrand(),0,1);
					vehicleDeets.setValueAt(crvCar.getName(),1,1);
					vehicleDeets.setValueAt(crvCar.getCode(),2,1);
					vehicleDeets.setValueAt(crvCar.getPrice(),3,1);
					vehicleDeets.setValueAt(crvCar.getStock(),4,1);
					break;
				case "Civic":
					vehicleDeets.setValueAt(civicCar.getBrand(),0,1);
					vehicleDeets.setValueAt(civicCar.getName(),1,1);
					vehicleDeets.setValueAt(civicCar.getCode(),2,1);
					vehicleDeets.setValueAt(civicCar.getPrice(),3,1);
					vehicleDeets.setValueAt(civicCar.getStock(),4,1);
					break;
				case "Vios":
					vehicleDeets.setValueAt(viosCar.getBrand(),0,1);
					vehicleDeets.setValueAt(viosCar.getName(),1,1);
					vehicleDeets.setValueAt(viosCar.getCode(),2,1);
					vehicleDeets.setValueAt(viosCar.getPrice(),3,1);
					vehicleDeets.setValueAt(viosCar.getStock(),4,1);
					break;
				case "Camry":
					vehicleDeets.setValueAt(camryCar.getBrand(),0,1);
					vehicleDeets.setValueAt(camryCar.getName(),1,1);
					vehicleDeets.setValueAt(camryCar.getCode(),2,1);
					vehicleDeets.setValueAt(camryCar.getPrice(),3,1);
					vehicleDeets.setValueAt(camryCar.getStock(),4,1);
					break;
				case "Hilux":
					vehicleDeets.setValueAt(hiluxCar.getBrand(),0,1);
					vehicleDeets.setValueAt(hiluxCar.getName(),1,1);
					vehicleDeets.setValueAt(hiluxCar.getCode(),2,1);
					vehicleDeets.setValueAt(hiluxCar.getPrice(),3,1);
					vehicleDeets.setValueAt(hiluxCar.getStock(),4,1);
					break;
			}
		}
		
	}
}
