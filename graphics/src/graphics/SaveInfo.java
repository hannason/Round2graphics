package graphics;

import java.awt.Color;
import java.awt.Graphics;

public class SaveInfo {
	private Graphics var;
	private String shape;
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private Color lineColor;
	private Color fillColor;
	SaveInfo(){
		
	}
	SaveInfo(Graphics var, String shape, int x1, int y1, int x2, int y2, Color lineColor, Color fillColor){
		this.var=var;
		this.shape=shape;
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		this.lineColor=lineColor;
		this.fillColor=fillColor;
	}
	public Graphics getGraphics() {
		return var;
	}
	public String getShape() {
		return shape;
	}
	public Color getLineColor() {
		return lineColor;
	}
	public Color getFillColor() {
		return fillColor;
	}
	
	public int getStartX() {
		return x1;
	}
	public int getStartY() {
		return y1;
	}
	public int getEndX() {
		return x2;
	}
	public int getEndY() {
		return y2;
	}
}
