package graphics;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class GetMousePreRelXY extends MouseAdapter{
	private int startX,startY; //X,Y
	private int endX, endY; //X,Y
	private boolean press=false;
	private boolean release=false;
//	
//	GetMousePreRelXY(){
//		this.DrawingPanel=DrawingPanel;
//	}
	public int getStartX() {
		return startX;
	}
	public int getStartY() {
		return startY;
	}
	public int getEndX() {
		return endX;
	}
	public int getEndY() {
		return endY;
	}
	public void setRelease() {
		press=false;
	}
	public void setPress() {
		release=false;
	}
	public boolean getRelease() {
		return release;
	}
	public boolean getPress() {
		return press;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		press=true;
		startX=e.getX();
		startY=e.getY();
	}
	@Override 
	public void mouseReleased(MouseEvent e) { 
		release=true;
		endX=e.getX();
		endY=e.getY();
		Graphics_editor.DrawingPanel.validate();
		Graphics_editor.DrawingPanel.repaint();
	}
	
}
