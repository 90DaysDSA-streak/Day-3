
public class NQueens {

	public static void main(String[] args) {

		
		// array,row,col,totat queen, queen placed so far,answer
		Nqueen(new boolean[4][4],0,0,4,0,"");
	}

	private static void Nqueen(boolean[][] board, int row, int column, int tq, int qpsf, String ans) {
		
		
		if(tq==qpsf) {
			System.out.println(ans);
			return;
		}
		if(column==board[0].length) {
			row++;
			column=0;
			
		}
		if(row==board.length) {
			return;
		}
		
		//placed
		if(isItSafeToPlace(board,row,column)) {
			//do
			board[row][column]=true;
			//recur
			Nqueen(board, row, column+1, tq, qpsf+1, ans+"["+row+"-"+column+"]");
			//undo
			board[row][column]=false;
			
		}
		
		//unplaced
		Nqueen(board, row, column+1, tq, qpsf, ans);
		
		
	}

	private static boolean isItSafeToPlace(boolean[][] board, int row, int column) {
		
		//vertically up
		int r=row-1;
		int c=column;
		while (r>=0) {
			if(board[r][c]) {
				return false;
			}
			r--;
		}
		
		//horizontally left
		 r=row;
		 c=column-1;
		while (c>=0) {
			if(board[r][c]) {
				return false;
			}
			c--;
		}
		
		//diagonally left
		 r=row-1;
		 c=column-1;
		while (r>=0 && c>=0) {
			if(board[r][c]) {
				return false;
			}
			r--;
			c--;
		}
		
		//diagonally right
		 r=row-1;
		 c=column+1;
		while (r>=0 && c<board[0].length) {
			if(board[r][c]) {
				return false;
			}
			r--;
			c++;
		}
		
		return true;
	}

}
