package snakeGame;

import java.awt.Color;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame obj=new JFrame();
		obj.setBounds(100, 100, 915, 500); //mul deka x andy y e kiyanne frame eka thiyena thana 
		obj.setBackground(Color.DARK_GRAY);
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePlay gameplay=new GamePlay();
		
		obj.add(gameplay);
		
		
		
	}

}
