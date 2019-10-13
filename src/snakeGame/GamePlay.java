package snakeGame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
// Jpanel kiyanne light weight container ekak anith ewwa eke hang karala thiyaganna puluwan


public class GamePlay extends JPanel {  
	private ImageIcon titleImage;
	
	public void paint(Graphics g) {  //in here paint is the method automatically invoke wenawa 
		
		//draw the image border
		g.setColor(Color.green);
		g.drawRect(24, 10, 851, 55); //snaketitle eke border eka x,y,with,and height rect ekak
		
		//draw the title image
		titleImage=new ImageIcon("snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
		
		//draw border for gameplay
		g.setColor(Color.blue);
		g.drawRect(25,75,851,370);
		
		//background filling for game play
		g.setColor(Color.black);
		g.fillRect(26, 76, 850, 369);
		
		
		
		
		
		
		
		
		
		
		
	}

}
