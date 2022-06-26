package graphics;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;

import javafx.scene.layout.Background;


public class Graphics_editor extends JFrame {
	final int lineWidth=2;
	
	static public Color lineColor=Color.BLACK;
	static public Color fillColor=Color.decode("#FFFFFF");
	static public String drawingTool="Default_null";
	static public Stack <SaveInfo> stackForUndo = new Stack<SaveInfo>();
	static public Stack <SaveInfo> stackForRedo = new Stack<SaveInfo>();
	
	static public JPanel DrawingPanel;
	Graphics_editor(){
		setTitle("Graphics Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setScreen();
        setLocationRelativeTo(null);
        setSize(1600,900);
        setVisible(true);
    }
	private void setScreen() {			
		JPanel container=new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
		
			JPanel ButtonGroupPanel=new JPanel(new GridLayout(2,1));
			ButtonGroupPanel.setPreferredSize(new Dimension(200,900));
				JPanel ButtonGroupDrawing=new JPanel(new GridLayout(2,1));
				JPanel ButtonGroupAttribute=new JPanel(new GridLayout(2,1));
				setButtonGroupDrawing(ButtonGroupDrawing);
				setButtonGroupAttribute(ButtonGroupAttribute);
			ButtonGroupPanel.add(ButtonGroupDrawing);
			ButtonGroupPanel.add(ButtonGroupAttribute);
			
			DrawingPanel=new JPanel();
			DrawingPanel.setLayout(new GridLayout(1,1));
			DrawingPanel.setPreferredSize(new Dimension(1400,900));
			DrawingPanel.setBackground(Color.WHITE);
			
			GetMouseDragXY dragxy = new GetMouseDragXY();
			DrawingPanel.addMouseMotionListener(dragxy);
			GetMousePreRelXY prerelxy = new GetMousePreRelXY();
			DrawingPanel.addMouseListener(prerelxy);
			Draw shape = new Draw(prerelxy, dragxy);
			DrawingPanel.add(shape);		
		container.add(ButtonGroupPanel);
		container.add(DrawingPanel);
		
		add(container);
	}
	private void setButtonGroupDrawing(JPanel ButtonGroupDrawing) {
		ButtonGroupDrawing.setLayout(new BoxLayout(ButtonGroupDrawing, BoxLayout.Y_AXIS));
		ButtonGroupDrawing.setBorder(new EmptyBorder(10 , 10 , 10 , 10));
		ButtonGroupDrawing.setBackground(Color.GREEN);
		JLabel DrawingLabel=new JLabel();
		Font DrawingTitleFont = new Font("SansSerif",Font.BOLD, 20);
		DrawingLabel.setFont(DrawingTitleFont);
		DrawingLabel.setText("그리기");
		
		JPanel ButtonDrawing=new JPanel(new GridLayout(2,2,5,5));
		ButtonDrawing.setBorder(new EmptyBorder(10 , 0 , 0 , 0));
		SetButton drawbutton = new SetButton();
		drawbutton.setDrawButton(ButtonDrawing);
		ButtonGroupDrawing.add(DrawingLabel);
		ButtonGroupDrawing.add(ButtonDrawing);
	}
	
	private void setButtonGroupAttribute(JPanel ButtonGroupAttribute) {
		ButtonGroupAttribute.setBackground(Color.PINK);
		JPanel ButtonGroupLineColor=new JPanel();
		JPanel ButtonGroupFillColor=new JPanel();
		setButtonGroupLineColor(ButtonGroupLineColor);
		setButtonGroupFillColor(ButtonGroupFillColor);
		
		ButtonGroupAttribute.add(ButtonGroupLineColor);
		ButtonGroupAttribute.add(ButtonGroupFillColor);
		
	}
	private void setButtonGroupLineColor(JPanel ButtonGroupLineColor) {
		
		ButtonGroupLineColor.setLayout(new BoxLayout(ButtonGroupLineColor, BoxLayout.Y_AXIS));
		ButtonGroupLineColor.setBorder(new EmptyBorder(10 , 10 , 10 , 10));
		ButtonGroupLineColor.setBackground(Color.YELLOW);
		JLabel LineColorLabel=new JLabel();
		Font DrawingTitleFont = new Font("SansSerif",Font.BOLD, 20);
		LineColorLabel.setFont(DrawingTitleFont);
		LineColorLabel.setVerticalAlignment(JLabel.TOP);
		LineColorLabel.setText("선 색");
		
		///팔레트 버튼 생성 
		JPanel ButtonLineColor=new JPanel(new GridLayout(8,8,2,2));
		ButtonLineColor.setBorder(new EmptyBorder(10 , 10 , 10 , 10));
		SetButton drawbutton = new SetButton();
		drawbutton.setColorButton(ButtonLineColor,"Line");
		ButtonGroupLineColor.add(LineColorLabel);
		ButtonGroupLineColor.add(ButtonLineColor);
	}

	private void setButtonGroupFillColor(JPanel ButtonGroupFillColor) {		
		ButtonGroupFillColor.setLayout(new BoxLayout(ButtonGroupFillColor, BoxLayout.Y_AXIS));
		ButtonGroupFillColor.setBorder(new EmptyBorder(10 , 10 , 10 , 10));
		ButtonGroupFillColor.setBackground(Color.RED);
		JLabel FillColorLabel=new JLabel();
		Font DrawingTitleont = new Font("SansSerif",Font.BOLD, 20);
		FillColorLabel.setFont(DrawingTitleont);
		FillColorLabel.setVerticalAlignment(JLabel.TOP);
		FillColorLabel.setText("채우기");
		
		///팔레트 버튼 생성 
		JPanel ButtonFillColor=new JPanel(new GridLayout(8,8,2,2));
		ButtonFillColor.setBorder(new EmptyBorder(10 , 10 , 10 , 10));
		SetButton drawbutton = new SetButton();
		drawbutton.setColorButton(ButtonFillColor,"Fill");
		ButtonGroupFillColor.add(FillColorLabel);
		ButtonGroupFillColor.add(ButtonFillColor);
	}

	public void update(Graphics g) {
		g.drawLine(600,10,10,10);
	}
    public static void main(String[] args) {
    	
    	Graphics_editor screen=new Graphics_editor();
    }
}
