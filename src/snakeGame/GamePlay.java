package snakeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
// Jpanel kiyanne light weight container ekak anith ewwa eke hang karala thiyaganna puluwan


public class GamePlay extends JPanel implements ActionListener,KeyListener {  
	
	private int[] snakeXLength=new int[750];
	private int[] snakeYLength=new int[750];
	
	private boolean left=false;
	private boolean right=false;
	private boolean up=false;
	private boolean down=false;
	
	private int LengthOfSnake=3; //methanadi length eka aniwa thunai
	
	private Timer timer; 
	
	private int moves=0; //kisima move ekak natiwa komada kiyala balanawa
	
	private int delay=100;
	
	private ImageIcon titleImage;
	
	private ImageIcon rightmouth;
	private ImageIcon leftmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	private ImageIcon snakeimage;
	
	public GamePlay() {
		addKeyListener(this);  //key lisner eka wada karanna denne methanin
		setFocusable(true);  //focus nati ewath forcus karanna thamai mehema karanne.
		//tab eka gahala thawa file ekakata shift wenakotha eka forcus wela thibbe naththam wenne 
		//wade hariyata wenne nathi eka.but meka nisa ehema wenne naha.
		setFocusTraversalKeysEnabled(false);
		timer= new Timer(delay,this); 
		timer.start();
		
		
	}
	
	public void paint(Graphics g) {  //in here paint is the method automatically invoke wenawa 
		
		if(moves==0) {
			snakeXLength[2]=50;
			snakeXLength[1]=75;
			snakeXLength[0]=100;
			
			snakeYLength[2]=100;
			snakeYLength[1]=100;
			snakeYLength[0]=100;
			
		}
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
		
		rightmouth=new ImageIcon("rightmouth.png");
		rightmouth.paintIcon(this, g, snakeXLength[0], snakeYLength[0]);
		
		for(int a=0; a<LengthOfSnake ;a++) {
			
//			if(a==0 && right) {
//				rightmouth=new ImageIcon("rightmouth.png");
//				rightmouth.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
//			}
//			
//			if(a==0 && left) {
//				leftmouth=new ImageIcon("leftmouth.png");
//				leftmouth.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
//			}
//			
//			if(a==0 && down) {
//				downmouth=new ImageIcon("downmouth.png");
//				downmouth.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
//			}
//			
//			if(a==0 && right) {
//				upmouth=new ImageIcon("upmouth.png");
//				upmouth.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
//			}
			
			if(a!=0) {
				snakeimage=new ImageIcon("snakeimage.png");
				snakeimage.paintIcon(this, g, snakeXLength[a], snakeYLength[a]);
			}
			
		}
		
		g.dispose();  // meka use karanne box eka remove karanna
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			moves++;
//			right=true;
//			left=false;  mekedi karanna right true karala left false karana eka
//			up=false;
//			down=false;
			right=true;
			if(!left) {
				  right=true;
			}
			else {
				right=false;
				left=true;
			}
			
			up=false;
			down=false;
			
		}
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			moves++;
//			right=true;
//			left=false;  mekedi karanna right true karala left false karana eka
//			up=false;
//			down=false;
			left=true;
			if(!right) {
				  left=true;
			}
			else {
				right=false;
				left=true;
			}
			
			up=false;
			down=false;
			
		}
		
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			moves++;
			up=true;
			if(!up) {
				down=true;
			}
			else {
				down=false;
				up=true;
			}
			
			left=false;
			right=false;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			moves++;
			down=true;
			if(!down) {
				up=true;
			}
			else {
				down=true;
				up=false;
			}
			
			left=false;
			right=false;
		}
		

		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.start();
		if(right) {
			for(int r=LengthOfSnake-1;r>=0;r--) {
				snakeYLength[r+1]=snakeYLength[r];
			}
			for(int r=LengthOfSnake;r>=0;r--) {
				if(r==0) {
					snakeXLength[r]=snakeXLength[r]+25;
				}
				else {
					snakeXLength[r]=snakeXLength[r-1];
				}
				if(snakeXLength[r]>859) {
					snakeXLength[r]=25;
				}
				
			}
			repaint();
		}
		
		if(left) {
			for(int r=LengthOfSnake-1;r>=0;r--) {
				snakeYLength[r+1]=snakeYLength[r];
			}
			for(int r=LengthOfSnake;r>=0;r--) {
				if(r==0) {
					snakeXLength[r]=snakeXLength[r]-25;
				}
				else {
					snakeXLength[r]=snakeXLength[r-1];
				}
				if(snakeXLength[r]<25) {
					snakeXLength[r]=850;
				}
				
			}
			repaint();
			
		}
		if(up) {
			
		}
		if(down) {
			
		}
		
	}

}
