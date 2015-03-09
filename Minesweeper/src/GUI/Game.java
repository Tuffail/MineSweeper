package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Board.MinesweeperBoard;
import Board.Square;

public class Game extends JPanel {

	private MinesweeperBoard mineboard;
	private JPanel[][] panelHolder;
	private MineButton[][] button;
	private boolean gameOver = false;
	public Game(MinesweeperBoard m){
		mineboard = m;
		this.setLayout(new GridLayout(mineboard.getWidth(), mineboard.getHeight()));
		panelHolder = new JPanel[mineboard.getWidth()][mineboard.getHeight()];
		button = new MineButton[mineboard.getWidth()][mineboard.getHeight()];
		
		for (int i = 0; i < mineboard.getWidth();++i){
			for (int j = 0; j < mineboard.getHeight(); ++j){
				button[i][j] = new MineButton();
				button[i][j].setPreferredSize(new Dimension(30,30));
				button[i][j].setMinesAdjacent(mineboard.getSquare(i, j));
				final int fi = i;
				final int fj = j;
				button[i][j].addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						if (!gameOver){
							if(SwingUtilities.isRightMouseButton(e)){
						        if (!button[fi][fj].getText().equals("F"))
						        	button[fi][fj].setText("F");
						        else button[fi][fj].setText("");
						    }else{
						    	if (!button[fi][fj].getText().equals("F")){
						    		Game.this.panelHolder[fi][fj].removeAll();
						    		JLabel text = new JLabel();
						    		Game.this.panelHolder[fi][fj].add(text);
						    		
						    		switch (button[fi][fj].getMinesAdjacent()){
									case ZERO:
										text.setText("");
										break;
									case ONE:
										text.setText("1");								
										break;
									case TWO:
										text.setText("2");									
										break;
									case THREE:
										text.setText("3");									
										break;
									case FOUR:
										text.setText("4");									
										break;
									case FIVE:
										text.setText("5");									
										break;
									case SIX:
										text.setText("6");										
										break;
									case SEVEN:
										text.setText("7");										
										break;
									case EIGHT:
										text.setText("8");								
										break;
									case NINE:
										text.setText("9");
										gameOver = true;
										break;
									default:
										System.out.println("Error with button");
										break;
									}
						    		Game.this.panelHolder[fi][fj].updateUI();
						    	}					
						    }
						}
					}
				});
				panelHolder[i][j] = new JPanel(new FlowLayout(FlowLayout.CENTER));
				panelHolder[i][j].add(button[i][j]);
				this.add(panelHolder[i][j]);
				//button[i][j].doClick();
			}
			
		}
	}
	
}
