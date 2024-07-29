import java.awt.Dimension;
import java.awt.Font;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import org.w3c.dom.events.Event;
import java.awt.Graphics;

public class BubbleDraw extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame ("Maksat Bubble Daraw app");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new BubblePanel());
		int p=900;
		int p1=700;
		frame.setSize(new Dimension(p,p1));
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("Clear");
		Font font = new Font("Verdana", Font.BOLD, 14);
		JMenuItem clearItem = new JMenuItem("Clear",KeyEvent.VK_C);
		clearItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		
        clearItem.setFont(font);
        fileMenu.add(clearItem);
        fileMenu.setFont(font);
		menuBar.add(fileMenu);
		 clearItem.addActionListener(new ActionListener() {           
	            public void actionPerformed(ActionEvent e) {
	            	//BubblePanel bp = new BubblePanel();
	            	int i=frame.getSize().height;
	            	int i1=frame.getSize().width;
	            	frame.getContentPane().removeAll();
	            	frame.getContentPane().add(new BubblePanel());
	            	frame.setSize(new Dimension(i1,i));
	            	if(i==i) {
	            		frame.setSize(new Dimension(i1+1,i+1));
	            	}
	            	 
	            	
	            	
	            }           
	        }); 
		frame.setJMenuBar(menuBar);
		frame.setVisible(true);
		
		
	}

}

