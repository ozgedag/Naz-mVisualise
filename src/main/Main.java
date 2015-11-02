package main;
import java.sql.SQLException;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PGraphics;
import processing.core.PImage;

public class Main extends PApplet {
	
	public static ArrayList<String> bookNames = new ArrayList<>();
	
	public static void main (String[] args) {
		PApplet.main(new String[]{"--present", "main.Main"});
		DBConnection db = new DBConnection(); 
		
		try {
			bookNames = db.selectBook();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	int y = 100;

	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
	  size(displayWidth, displayHeight);  // Size must be the first statement
	  stroke(255);     // Set line drawing color to white
	  frameRate(30);
	}
	
	//String s= bookNames.get(0);
	String s= "hello";
	
	public void draw() { 
		background(0);   
		for(int i=0;i<bookNames.size();i++){
			System.out.println(bookNames.get(i));
		}
		y = y - 1; 
	    if (y < 0) { 
	    	y = height; 
	    }  
	    line(0, y, width, y);  
	    text(s,10,30);
	} 

}
