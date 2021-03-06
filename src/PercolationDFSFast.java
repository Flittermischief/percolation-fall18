//import java.util.*;

public class PercolationDFSFast extends PercolationDFS {
	
	// Create constructor
	public PercolationDFSFast(int size) {
		super(size);
	}
	
	
	// override udateonopen
	@Override
	protected void updateOnOpen(int row, int col) {
		if (row == 0 || 
		    (inBounds(row - 1, col) && isFull(row - 1, col)) ||
		    (inBounds(row + 1, col) && isFull(row + 1, col)) ||
		    (inBounds(row, col - 1) && isFull(row, col - 1)) ||
		    (inBounds(row, col + 1) && isFull(row, col + 1))) {
				dfs(row, col);
		}
	}
	
}
