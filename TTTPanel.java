package TicTacToeProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;




public class TTTPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Font myTextFont = new Font("Aharoni", Font.BOLD, 21);
	static Font myButtonFont = new Font("Aharoni",Font.BOLD, 100);
	public static final int PLAYING=0;
	public static final int EQUAL=1;
	public static final int XWON=2;
	public static final int OWON=3;
	
	private JLabel label;
	private JButton playButton;
	private CellsPanel board;
	private boolean xTurn=false;
	private boolean oTurn=false;
	private int gameState;
	
		
	TTTPanel(){		
	
	BorderLayout b = new BorderLayout();
	this.setLayout(b);
	        
	        JPanel p=new JPanel(new FlowLayout());            
			label=new JLabel();			
			label.setText("It's X's turn");	
			label.setAlignmentY(CENTER_ALIGNMENT);
			p.add(label);
			label.setFont(myTextFont);
			p.setBackground(Color.CYAN);			
			playButton=new JButton("Play");		
			p.add(playButton);
			playButton.setFont(myTextFont);
			playButton.setBackground(Color.orange);
			playButton.setVisible(false);
	    	this.add(BorderLayout.NORTH,p);
						
			JPanel pe=new JPanel();
			pe.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
			pe.setBackground(Color.CYAN);			
			this.add(BorderLayout.EAST,pe);
			
			JPanel pw=new JPanel();
			pw.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
			pw.setBackground(Color.CYAN);
			this.add(BorderLayout.WEST,pw);			
			board=new CellsPanel();
			this.add(BorderLayout.CENTER,board);	
			initGame();
			
			playButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e){
					initGame();
				}
				
			});
			
			for (int i=0;i<board.getCells().length;i++){
				 for(int j=0;j<board.getCells().length;j++){
					 board.getCells()[i][j].addActionListener((new ActionListener(){
							@Override
							public void actionPerformed(ActionEvent e){
								JButton clickedButton=(JButton) e.getSource();
								play(clickedButton);
							}
						}));					 
				 }				 
			 }			
		}



	protected void play(JButton clickedButton) {
		// TODO Auto-generated method stub
		if (gameState==PLAYING){
			if (xTurn && isEmpty(clickedButton)){
				clickedButton.setText("X");
				clickedButton.setForeground(Color.RED);
				clickedButton.setFont(myButtonFont);				
				clickedButton.setEnabled(false);
				updateGameState(clickedButton);
				
			}
			if (oTurn && isEmpty(clickedButton)){
				clickedButton.setText("O");
				clickedButton.setForeground(Color.GREEN);
				clickedButton.setFont(myButtonFont);				
				clickedButton.setEnabled(false);
				updateGameState(clickedButton);
			}
		  }
		}
		
	private void updateGameState(JButton clickedButton) {
		// TODO Auto-generated method stub
		if(hasWon("X")){
			gameState=XWON;
			label.setText("X win the game! Click Play to start it again.");
			playButton.setVisible(true);
			return;
		}
		else if (hasWon("O")){
			gameState=OWON;
			label.setText("O win the game! Click Play to start it again.");
			playButton.setVisible(true);
			return;
		}
		else if(isEqual()){
			gameState=EQUAL;
			label.setText("The game is equal! Click Play to start it again.");
			label.setAlignmentY(LEFT_ALIGNMENT);
			playButton.setVisible(true);
			playButton.setAlignmentY(RIGHT_ALIGNMENT);
			return;
		}
		
		gameState=PLAYING;
		changePlayerTurn();
		
	}

	private boolean hasWon(String symbol) {
		// TODO Auto-generated method stub
		boolean hasWon=false;
		//check the two diagonals for win	
		if ((symbol.equals(board.getCells()[0][0].getText()) && symbol.equals(board.getCells()[1][1].getText()) && symbol.equals(board.getCells()[2][2].getText())) || 
			
			(symbol.equals(board.getCells()[0][2].getText()) && symbol.equals(board.getCells()[1][1].getText()) && symbol.equals(board.getCells()[2][0].getText()))){ 
				hasWon=true;
		}		
		
		
		for (int i=0;i<CellsPanel.rows;i++){
            //check if we have 3 equal symbols in a row
				if ((symbol.equals(board.getCells()[i][0].getText()) && symbol.equals(board.getCells()[i][1].getText()) && symbol.equals(board.getCells()[i][2].getText())) ||
            //check if we have 3 equal symbols in a col	
				(symbol.equals(board.getCells()[0][i].getText()) && symbol.equals(board.getCells()[1][i].getText()) && symbol.equals(board.getCells()[2][i].getText()))){  
					hasWon=true;
					break;					
				}
			}
		return hasWon;
	}



	private boolean isEqual() {
		// TODO Auto-generated method stub
		for (int i=0;i<CellsPanel.rows;i++){
			for(int j=0;j<CellsPanel.cols;j++){
				if("".equals(board.getCells()[i][j].getText())){
				return false;
				}
			}
		}
		return true;
	}



	private void changePlayerTurn() {
		// TODO Auto-generated method stub
		if(xTurn){
			xTurn=false;
			oTurn=true;
			label.setText("It's O's turn");
		} else {
			xTurn=true;
			oTurn=false;
			label.setText("It's X's turn");
		}
		
	}



	private boolean isEmpty(JButton clickedButton) {
		// TODO Auto-generated method stub
		if("".equals(clickedButton.getText())){
			return true;
		}	
		return false;
	}

	protected void initGame(){
		// TODO Auto-generated method stub
		for (int i=0;i<CellsPanel.rows;i++){
			 for(int j=0;j<CellsPanel.cols;j++){
				 board.getCells()[i][j].setText("");
				 board.getCells()[i][j].setEnabled(true);
		     }
		}		
		xTurn=true;
		label.setText("It's X's turn");
		playButton.setVisible(false);
		gameState=PLAYING;
	}
}	
		
	
			
	
	
	



