package graphics;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SetColorButtonEvent implements ActionListener {
	private Color pickColor;
	private String Kind;
	//palette 1
	SetColorButtonEvent(String kind, Color type){
		pickColor=type;
		Kind=kind;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(Kind.equals("Line"))
			Graphics_editor.lineColor=pickColor;
		else if (Kind.equals("Fill"))
			Graphics_editor.fillColor=pickColor;

		System.out.println(Graphics_editor.lineColor+"      "+Graphics_editor.fillColor);
	}
}
