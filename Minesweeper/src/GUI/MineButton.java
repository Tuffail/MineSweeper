package GUI;

import javax.swing.JButton;

import Board.Square;

public class MineButton extends JButton {
	
	Square minesAdjacent;
	
	public MineButton(){
		super();
	}
	
	public void setMinesAdjacent(Square minesAdjacent){
		this.minesAdjacent = minesAdjacent;
	}
	
	public Square getMinesAdjacent(){
		return minesAdjacent;
	}
}
