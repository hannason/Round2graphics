package graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class SetButtonEvent implements ActionListener {
	private String pickDraw;
	//drawing 0
	SetButtonEvent(String type){
		pickDraw=type;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		Graphics_editor.drawingTool=pickDraw;	
		//Undo
		if(pickDraw.equals("star")) {
			Graphics_editor.stackForRedo.push(Graphics_editor.stackForUndo.pop());			
			Graphics_editor.DrawingPanel.validate();
			Graphics_editor.DrawingPanel.repaint();
		}
		//Redo
		/*
		if(pickDraw.equals("Redo")) {
			Graphics_editor.stackForUndo.push(Graphics_editor.stackForRedo.pop());			
			Graphics_editor.DrawingPanel.validate();
			Graphics_editor.DrawingPanel.repaint();
		}
		 */
		System.out.println("here is eventbutton  "+Graphics_editor.drawingTool);
	}
	 
}
