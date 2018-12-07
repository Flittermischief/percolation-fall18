import java.util.*;

public class PercolationBFS extends PercolationDFSFast {
	
	// Create constructor
	public PercolationBFS(int size) {
		super(size);
	}
	
	// Override dfs method inherited from PercolationDFS to use queue and BFS
	@Override
	protected void dfs(int row, int col) {
		Queue<Integer> myQ = new LinkedList<>(); 
		myGrid[row][col] = FULL;
		myQ.add(row*myGrid.length+col);
		int a=0;
		while (myQ.size() != 0 || a==0){
			a=0;
			int dQd = myQ.remove();

			int dQdCol = dQd%myGrid.length;
			int dQdRow = dQd/myGrid.length; //(dQd-dQdCol)/myGrid.length;

			if (inBounds(dQdRow - 1, dQdCol) && isOpen(dQdRow - 1, dQdCol) && (!isFull(dQdRow - 1, dQdCol))) {
				myGrid[dQdRow - 1][dQdCol] = FULL;
				myQ.add(myGrid[dQdRow - 1][dQdCol]);
				dfs(dQdRow - 1, dQdCol); 	// B001b
			}
			if (inBounds(dQdRow + 1, dQdCol) && isOpen(dQdRow + 1, dQdCol) && (!isFull(dQdRow + 1, dQdCol))) {
				myGrid[dQdRow + 1][dQdCol] = FULL;
				myQ.add(myGrid[dQdRow + 1][dQdCol]);
				dfs(dQdRow + 1, dQdCol); 	// B001b
			}
			if (inBounds(dQdRow, dQdCol - 1) && isOpen(dQdRow, dQdCol - 1) && (!isFull(dQdRow, dQdCol - 1))) {
				myGrid[dQdRow][dQdCol - 1] = FULL;
				myQ.add(myGrid[dQdRow][dQdCol - 1]);
				dfs(dQdRow, dQdCol - 1); 	// B001b
			}
			if (inBounds(dQdRow, dQdCol + 1) && isOpen(dQdRow, dQdCol + 1) && (!isFull(dQdRow, dQdCol + 1))) {
				myGrid[dQdRow][dQdCol + 1] = FULL;
				myQ.add(myGrid[dQdRow][dQdCol + 1]);
				dfs(dQdRow, dQdCol + 1); 	// B001b
			}
			a=1;
		}
	}
}
