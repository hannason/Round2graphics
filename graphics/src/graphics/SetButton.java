package graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class SetButton {
	final public String[] Draw= {"line","rect","circle","star"};
	final private String[] DrawButtonIconAddr= {"drawimage/line.png","drawimage/rect.png","drawimage/circle.png","drawimage/star.png"};
	private String[] PickColor= {"#FFFFFF","#999999","#666666","#000000","#ccffff","#ccccff","#ffcccc","#ffffcc",
								"#ccffcc","#66ccff","#6666ff","#9966ff","#ff66cc","#ff6666","#ffff66","#66ff66",
								"#66ffcc","#33ffff","#3399ff","#3333ff","#cc33ff","#ff3399","#ff3333","#ffcc33",
								"#ccff33","#33ff33","#33ff99","#00ffff","#0099ff","#0033ff","#3300ff","#9900ff",
								"#ff00ff","#ff0099","#ff0033","#ff0000","#ff6600","#ffff00","#99ff00","#33ff00",
								"#00ff33","#00ffcc","#00cccc","#0099cc","#0033cc","#3300cc","#9900cc","#cc00cc",
								"#cc0033","#cc9900","#cccc00","#66cc00","#00cc00","#00cc66","#00cccc","#009999",
								"#006699","#000099","#990099","#990033","#999900","#339900","#009966","#009999"};


	public void setColorButton(JPanel buttonDrawing, String type) {
		// TODO Auto-generated method stub
		JButton[] buttonN = new JButton[PickColor.length];
		Font DrawingIconFont = new Font("SansSerif",Font.BOLD, 1);
		for(int i=0; i<PickColor.length; i++) {
			buttonN[i]=new JButton(".");
			buttonN[i].setFont(DrawingIconFont);
			
			buttonN[i].setOpaque(true);//배경색 적용을 허용하겠다.
			buttonN[i].setBorderPainted(false);	//포커스 표시 설명 
			buttonN[i].setBackground(Color.decode(PickColor[i]));
			buttonN[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
			buttonN[i].addActionListener(new SetColorButtonEvent(type, Color.decode(PickColor[i])));
			buttonDrawing.add(buttonN[i]);
		}
	}


	public void setDrawButton(JPanel buttonDrawing) {
		// TODO Auto-generated method stub
		JButton[] buttonN = new JButton[Draw.length];
		Font DrawingIconFont = new Font("SansSerif",Font.BOLD, 15);
		for(int i=0; i<Draw.length; i++) {
			buttonN[i]=new JButton(Draw[i],new ImageIcon(DrawButtonIconAddr[i]));
			buttonN[i].setFont(DrawingIconFont);
			buttonN[i].setAlignmentX(SwingConstants.NORTH);
			buttonN[i].setVerticalTextPosition(SwingConstants.TOP);// Centered Text
			buttonN[i].setHorizontalTextPosition(SwingConstants.CENTER);
			buttonN[i].setOpaque(true);//배경색 적용을 허용하겠다.
			buttonN[i].setBorderPainted(false);	//포커스 표시 설
			buttonN[i].setBackground(Color.RED);
			buttonN[i].addActionListener(new SetButtonEvent(Draw[i]));
			buttonDrawing.add(buttonN[i]);
			
		}
	}
}
