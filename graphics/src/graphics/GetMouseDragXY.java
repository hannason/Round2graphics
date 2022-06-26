package graphics;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

public class GetMouseDragXY extends MouseMotionAdapter{
	private int endX, endY; //X,Y
	private boolean drag=false;
//	GetMouseDragXY(JPanel DrawingPanel){
//		this.DrawingPanel=DrawingPanel;
//	}
	public int getEndX() {
		return endX;
	}
	public int getEndY() {
		return endY;
	}
	public boolean getDrag() {
		return drag;
	}
	public void setDrag() {
		drag=false;
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("drag    " + e.getLocationOnScreen());
		endX=e.getX();
		endY=e.getY();
		Graphics_editor.DrawingPanel.repaint();
	}
}
