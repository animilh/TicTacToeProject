package TicTacToeProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CellsPanel extends JPanel {

	final static int rows=3;
	final static int cols=3;
	Font font = new Font("Aharoni",Font.BOLD, 52);
	private JButton[][] cells;
	
	CellsPanel(){
		
		this.setLayout(new GridLayout(rows,cols));
		this.setBackground(Color.WHITE);
		cells=new JButton[rows][cols];
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				cells[i][j]=new JButton();
				cells[i][j].setText("");
				cells[i][j].setFont(font);
				cells[i][j].setBackground(Color.WHITE);
				this.add(cells[i][j]);
			}
		}
		
	}

	public JButton[][] getCells() {
		return cells;
	}

	public void setCells(JButton[][] cells) {
		this.cells = cells;
	}
}

