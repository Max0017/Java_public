import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
import java.awt.event.*;
public class BubblePanel extends JPanel {
	//public boolean key=false;
	Random rand = new Random();
	ArrayList<Bubble>bubbleList;
	int size = 25;
	public BubblePanel(){
		bubbleList = new ArrayList<Bubble>();
		setBackground(Color.WHITE);	
		
		//testBubbles();
		addMouseListener(new BubbleListener());
		addMouseMotionListener(new BubbleListener());
		addMouseWheelListener(new BubbleListener());
	}
	
	public void paintComponent(Graphics canvas){
		super.paintComponent(canvas);
		for(Bubble b : bubbleList){
		b.draw(canvas);	
	}
	
}
	
	public void testBubbles(){
		for( int n = 0; n < 1000; n++ ){
		  int x = rand.nextInt(900);
		  int y = rand.nextInt(700);
		  int size = rand.nextInt(50);
		  bubbleList.add(new Bubble(x,y,size));
		}
		repaint();
	}
	private class BubbleListener extends MouseAdapter{
		
		public void mousePressed(MouseEvent e){
			 bubbleList.add(new Bubble(e.getX(),e.getY(),size));
			 repaint();
			}
		public void mouseDragged(MouseEvent e){
			bubbleList.add(new Bubble (e.getX(),e.getY(),size));
			repaint();
		}
		public void mouseWheelMoved(MouseWheelEvent e){
			if(System.getProperty("os.name").startsWith("Mac"))
			{
				size+=e.getUnitsToScroll();
				if(size<20)
				{
					size=20;
				}
			}
			else
				size-=e.getUnitsToScroll();
				if(size<20)
				{
					size=20;
				}
		}
	}
	
	private class Bubble{
		private int x;
		private int y;
		private int size;
		private Color color;
		public Bubble (int newX,int newY,int newSize){
		x=newX;
		y=newY;
		size=newSize;
		color = new Color(rand.nextInt(256),
				rand.nextInt(256),
				rand.nextInt(256));
		
		}
		public void draw(Graphics canvas){
			canvas.setColor(color);
			canvas.fillOval(x-size/2,y-size/2,size,size);
		
		}
		
	}
}



