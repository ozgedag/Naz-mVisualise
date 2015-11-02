package main;

import processing.core.PApplet;

public class Child {
	Main parent;
	public Child (Main _parent) {
		parent = _parent;
	}
	
	public void draw () {
		parent.line (0, 0, 100, 100);
		
	}
}
