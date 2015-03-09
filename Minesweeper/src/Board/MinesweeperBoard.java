package Board;

import java.util.Random;

public class MinesweeperBoard {

	private int width;
	private int height;
	private int numberOfMines;
	private Square[][] board;
	
	public MinesweeperBoard(int width, int height, int numberOfMines){
		this.width = width;
		this.height = height;
		this.numberOfMines = numberOfMines;
		board = new Square[width][height];
		if (numberOfMines > width*height) numberOfMines = width*height;
		for (int i = 0; i < numberOfMines; ++i){
			boolean added = false;
			while (!added){
				int w = new Random().nextInt(width);
				int h = new Random().nextInt(height);
				if (board[w][h] != Square.NINE){
					board[w][h] = Square.NINE;
					added = true;
				}
			}
		}
		for (int i = 0; i < width; ++i){
			for (int j = 0; j < height; ++j){
				if (board[i][j] != Square.NINE){
					int count = 0;
					
					//check left
					if (i-1 >= 0){
						if (board[i-1][j] == Square.NINE) ++count;
					}
					
					//check right
					if (i+1 < width){
						if (board[i+1][j] == Square.NINE) ++count;
					}
					
					//check top
					if (j-1 >= 0){
						if (board[i][j-1] == Square.NINE) ++count;
					}
					
					//check bottom
					if (j+1 < height){
						if (board[i][j+1] == Square.NINE) ++count;
					}
					
					//check top left
					if (i-1 >= 0 && j-1 >= 0){
						if (board[i-1][j-1] == Square.NINE) ++count;
					}
					
					//check bottom left
					if (i-1 >= 0 && j+1 < height){
						if (board[i-1][j+1] == Square.NINE) ++count;
					}
					
					//check top right
					if (i+1 < width && j-1 >= 0){
						if (board[i+1][j-1] == Square.NINE) ++count;
					}
					
					//check bottom right
					if (i+1 < width && j+1 < height){
						if (board[i+1][j+1] == Square.NINE) ++count;
					}
					
					switch (count){
						case 0:
							board[i][j] = Square.ZERO;
							break;
						case 1:
							board[i][j] = Square.ONE;
							break;
						case 2:
							board[i][j] = Square.TWO;
							break;
						case 3:
							board[i][j] = Square.THREE;
							break;
						case 4:
							board[i][j] = Square.FOUR;
							break;
						case 5:
							board[i][j] = Square.FIVE;
							break;
						case 6:
							board[i][j] = Square.SIX;
							break;
						case 7:
							board[i][j] = Square.SEVEN;
							break;
						case 8:
							board[i][j] = Square.EIGHT;
							break;
					}
				}
			}
		}
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getMines(){
		return numberOfMines;
	}
	
	public Square getSquare(int i, int j){
		return board[i][j];
	}
	
}
