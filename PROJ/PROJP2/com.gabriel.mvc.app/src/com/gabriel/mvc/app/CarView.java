package com.gabriel.mvc.app;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;	

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.gabriel.mvc.shapeimpl.CarRenderer;
import com.gabriel.mvc.shapeimpl.Polytop;
import com.gabriel.mvc.shapesfx.MyShape;
import com.gabriel.mvc.shapesfx.Renderer;

public class CarView extends JFrame {
	Color flagBlue = new Color(0,56,168);
	Color flagRed = new Color (206,17,38);
	Color flagYellow = new Color(252,209,22);
	MyShape car;
	Renderer renderer = new CarRenderer();
	
	void init(MyShape car) {
		this.car = car;
	}
	void initUI() {				
		setTitle("Viewer | Ginos Toy Car");
		setLayout(null);
		setVisible(true);
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}
	
	public void paint(Graphics g)
	{ 
		
		// Background Color
		g.setColor(Color.black);
		g.fillRect(0,0,600,600);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(20,50,560,530);
		
		// Background Flag
		int u[] = {20,100,180};
		int v[] = {50,180,50};
		int n = 3;
		g.setColor(Color.white);
		g.fillPolygon(u,v,n);
		
		int x[] = {20,20,100,100};
		int y[] = {50,580,580,180};
		n = 4;
		g.setColor(flagBlue);
		g.fillPolygon(x,y,n);
		
		int l[] = {100,100,180,180};
		int m[] = {180,580,580,50};
		n = 4;
		g.setColor(flagRed);
		g.fillPolygon(l,m,n);	
		
		
		g.setColor(flagYellow);
		g.fillOval(75,70,50,50);
		
		 
		renderer.draw(g, car);
	}
}
