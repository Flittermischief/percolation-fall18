import java.util.*;

public class PercolationUF implements IPercolate {
	
	boolean[][] myGrid;
	int myOpenCount;
	IUnionFind myFinder;
	private final int VTOP;
	private final int VBOTTOM;
	int theSize;
//	public HashMap<Integer, Integer> IUFmap;


	
	PercolationUF(int size, IUnionFind finder) {
		myFinder = finder;
		myFinder.initialize(size*size+2);
		VTOP = size*size;
		VBOTTOM = size*size+1;
		theSize = size;
		myOpenCount = 0;
		myGrid = new boolean[size][size];
		for (int a=0; a<theSize; a++) {
			for (int b=0; b<theSize; b++) {
				myGrid[a][b] = false;
			}
		}
	}
	
	@Override
	public boolean isOpen(int row, int col) {
		if (row < 0 || row >= theSize || col < 0 || col >= theSize) {
			throw new IllegalArgumentException("That's out of bounds!");
		}
		if (myGrid[row][col]==true) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean isFull(int row, int col) {
		if (row < 0 || row >= theSize || col < 0 || col >= theSize) {
			throw new IllegalArgumentException("That's out of bounds!");
		}
		if (myFinder.connected((row*theSize)+col,VTOP)) {
			return true;
		} else {
			return false;
		}
	}
		
	
	@Override 
	public void open(int row, int col) {
		if (row < 0 || row >= theSize || col < 0 || col >= theSize) {
			throw new IllegalArgumentException("That's out of bounds!");
		}
		myGrid[row][col] = true;
		if (checkBounds(row+1,col) && isOpen(row+1,col)) {
			myFinder.union(row*theSize+col, (row+1)*theSize+col);
		}
		if (checkBounds(row-1,col) && isOpen(row-1,col)) {
			myFinder.union(row*theSize+col, (row-1)*theSize+col);
		}
		if (checkBounds(row,col+1) && isOpen(row,col+1)) {
			myFinder.union(row*theSize+col, (row)*theSize+(col+1));
		}
		if (checkBounds(row,col-1) && isOpen(row,col-1)) {
			myFinder.union(row*theSize+col, (row)*theSize+(col-1));
		}
		if (row==0) {
			myFinder.union(row*theSize+col, VTOP);
		}
		if (row==theSize-1) {
			myFinder.union(row*theSize+col, VBOTTOM);
		}
		myOpenCount++;
	}
	
	@Override
	public int numberOfOpenSites() {
		return myOpenCount;
	}
	
	@Override
	public boolean percolates() {
		if (myFinder.connected(VTOP, VBOTTOM)) {
			return true;
		} else {
			return false;
		}
	}
	public boolean checkBounds(int row, int col) {
		if (row < 0 || row >= theSize || col < 0 || col >= theSize) {
			return false;
		} else {return true;}
	}

}


