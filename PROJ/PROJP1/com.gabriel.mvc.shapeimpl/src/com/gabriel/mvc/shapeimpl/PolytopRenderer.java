package com.gabriel.mvc.shapeimpl;

import java.awt.Graphics;
import java.awt.Color;

import com.gabriel.mvc.shapesfx.MyShape;
import com.gabriel.mvc.shapesfx.Renderer;

public class PolytopRenderer implements Renderer {

	@Override
	public void draw(Object context, MyShape shape) {
		
		
		
		Graphics g = (Graphics) context;
		Polytop polyTop = (Polytop) shape;	
		int n = polyTop.getpoints();
		int xpoints[] = polyTop.getx1();
		int ypoints[] = polyTop.gety1();
		
		for(int i=0;i<n;i++) {
            xpoints[i]=xpoints[i] + polyTop.getLocation().getX();   //Add location to X
        }
		
		for(int i=0;i<n;i++) {
            ypoints[i]=ypoints[i] + polyTop.getLocation().getY();   //Add location to Y
        }
		
		g.setColor(Color.black);
		g.fillPolygon(xpoints,ypoints,n);
		polyTop.location.setX(0);
		polyTop.location.setY(0);
		
		
	}
}
