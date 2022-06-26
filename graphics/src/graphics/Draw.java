package graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Stack;

import javax.swing.JPanel;

public class Draw extends JPanel {
	//Graphics_editor.stackForUndo //string stack
	//Graphics_editor.stackForRedo //string stack
	private GetMousePreRelXY prerelxy;
	private GetMouseDragXY dragxy;
	
	Draw(GetMousePreRelXY prerelxy, GetMouseDragXY dragxy){
		this.prerelxy=prerelxy;
		this.dragxy=dragxy;
	}
	@Override
    public void paintComponent(Graphics var){
		super.paintComponent(var);
        //이전에 그렸던 거 패널세팅해주는 부분 for문으로 작성 
        SaveInfo prev = new SaveInfo(var, "Default_null",0,0,0,0,Color.BLACK,Color.decode("#FFFFFF"));
        for(int i=0; i<Graphics_editor.stackForUndo.size();i++){
        	prev=Graphics_editor.stackForUndo.elementAt(i);
        	DrawShape(var, prev.getShape(), prev.getStartX(), prev.getStartY(), prev.getEndX(), prev.getEndY(), prev.getLineColor(), prev.getFillColor());
        	
        }
        
        //새로운 그림 그려주는 작업을 하기 때문에 계속 그려지겠지. 
		System.out.println("here is draw : "+" "+Graphics_editor.fillColor +"    ");
		DrawShape(var, Graphics_editor.drawingTool, prerelxy.getStartX(), prerelxy.getStartY(), dragxy.getEndX(), dragxy.getEndY(), Graphics_editor.lineColor, Graphics_editor.fillColor);
		
		//stack undo에 저장 
		System.out.println("dkfjadkf       "+ prerelxy.getRelease());
    	
		if(prerelxy.getPress()&&prerelxy.getRelease()) {
			if(!Graphics_editor.drawingTool.equals("Default_null")) {
				Graphics_editor.stackForUndo.push(new SaveInfo(var, Graphics_editor.drawingTool, prerelxy.getStartX(), prerelxy.getStartY(), prerelxy.getEndX(), prerelxy.getEndY(), Graphics_editor.lineColor, Graphics_editor.fillColor));
				Graphics_editor.drawingTool="Default_null";
			}
    		prerelxy.setPress();
    		prerelxy.setRelease();
    		for(int i=0; i<Graphics_editor.stackForUndo.size();i++){
            	prev=Graphics_editor.stackForUndo.elementAt(i);
            	System.out.println("    "+ prev.getShape()+"    "+prev.getStartX()+"    "+ prev.getStartY()+"    "+ prev.getEndX()+"    "+ prev.getEndY()+"    "+ prev.getLineColor()+"    "+ prev.getFillColor());
            }
    	}
    }
	private void DrawShape(Graphics var, String shape, int x1, int y1, int x2, int y2, Color lineColor, Color fillColor) {
		var.setColor(lineColor);
        Graphics2D var2d = (Graphics2D) var;
        this.setBackground(Color.WHITE);
        var2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);//선 부드럽게 
        var2d.setStroke(new BasicStroke(8,BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));//선 끝 둥글,꼭지 둥글
        
		switch(shape) {
        case "line":
        	var2d.drawLine(x1, y1, x2, y2);
        	break;
        case "rect":
        	var2d.drawRect(Math.min(x1, x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
        	var.setColor(fillColor);
        	var2d.fillRect(Math.min(x1, x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
        	break;
        case "circle":
        	var2d.drawOval(Math.min(x1, x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
        	var.setColor(fillColor);
        	var2d.fillOval(Math.min(x1, x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
        	break;
        case "star":
        	//var2d.drawStar(100,100,100,100);
        	//Graphics_editor.DrawingPanel.removeAll();
        	//Graphics_editor.DrawingPanel.repaint();
        	break;
        default:
        	break;
        }
	}
}