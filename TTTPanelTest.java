package TicTacToeProject;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class TTTPanelTest {
	
	public static void main(String[] args) {
		
		JFrame f =new JFrame("Sea Chess");
		f.setSize(700, 700);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		
		JPanel p=new TTTPanel();			
				
		f.add(p);
		f.setVisible(true);	
		
	}

}
