import java.util.Arrays;

public class GameStrategy {
	private boolean placedQueens[][] = new boolean[8][8];
	private int numQueens = 0;

	private int getColumn(int cellId) {
		return cellId%8;
	}
	
	private int getRow(int cellId) {
		return cellId/8;
	}

	public boolean isValidPosition(int cellId) {
		boolean isValid = true;

		if(numQueens == 8) throw new GameOverException();	// just return out of the method

		// the game is still on, so let us continue...
		
		int col = getColumn(cellId);
		int row = getRow(cellId);
		
		// Check if the tile is valid
		if(placedQueens[row][col])	return !isValid;
		
		// If valid place the increment numQueens
		numQueens++;
		
		// Update new invalid fields
		for(int i=0;i<8;i++) {
			placedQueens[row][i] = true;
			placedQueens[i][col] = true;
			if(row+1+i<8 && col+1+i<8)	
				placedQueens[row+1+i][col+1+i] = true;
			if(row-1-i>=0 && col-1-i>=0)	
				placedQueens[row-1-i][col-1-i] = true;
			if(row+1+i<8 && col-1-i>=0)	
				placedQueens[row+1+i][col-1-i] = true;
			if(row-1-i>=0 && col+1+i<8)	
				placedQueens[row-1-i][col+1+i] = true;
		}

		return isValid;
	}
}














