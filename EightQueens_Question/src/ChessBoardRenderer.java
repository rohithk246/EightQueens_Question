public class ChessBoardRenderer {
	public boolean isBlackSquare(int square) {

		int row = square/8, column = square%8;
		
		return (row + column)%2==1;
	}
}
