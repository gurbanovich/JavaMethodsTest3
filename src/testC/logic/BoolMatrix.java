package testC.logic;

import java.util.Random;

/**
 * The task: Define the Boolean matrix class (BoolMatrix). Implement methods for
 * logical addition (disjunction), multiplication and inversion of matrices.
 * Implement methods for counting the number of units in the matrix.
 */

public class BoolMatrix {

	private final int row;
	private final int col;
	private boolean[][] bm;

	public BoolMatrix() {
		this.row = 2;
		this.col = 2;
		this.bm = new boolean[row][col];
	}

	public BoolMatrix(int size) {
		this.row = size;
		this.col = size;
		this.bm = new boolean[row][col];
	}

	public BoolMatrix(boolean[][] bm) {
		this.row = bm.length;
		this.col = bm[0].length;
		this.bm = new boolean[row][col];
	}

	public BoolMatrix(int row, int col) {
		this.row = row;
		this.col = col;
		this.bm = new boolean[row][col];
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public boolean[][] getBm() {
		return bm;
	}

	public void setBm(boolean[][] bm) {
		this.bm = bm;
	}

	public static BoolMatrix sum(BoolMatrix bm1, BoolMatrix bm2) throws MatrixException {
		if (!checkMatrix(bm1, bm2, false))
			throw new MatrixException("Size of matrix don't match ");
		else {
			int size;
			if (!bm1.checkSquare()) {
				size = bm1.row > bm1.col ? bm1.col : bm1.row;
			}
			size = bm1.row;
			BoolMatrix sbm = new BoolMatrix(size);
			for (int i = 0; i < bm1.row; i++) {
				for (int j = 0; j < bm1.col; j++) {
					sbm.bm[i][j] = bm1.bm[i][j] || bm2.bm[i][j];
				}
			}
			return sbm;
		}
	}

	public static BoolMatrix mult(BoolMatrix bm1, BoolMatrix bm2) throws MatrixException {
		if (!checkMatrix(bm1, bm2, true))
			throw new MatrixException("Size of matrix don't match ");
		else {
			int size = bm1.getRow();
			int n = bm2.getCol();
			int m = bm2.getRow();
			BoolMatrix mbm = new BoolMatrix(size);
			mbm.fill(false);
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < m; k++) {
						mbm.getBm()[i][j] = mbm.getBm()[i][j] || (bm1.getBm()[i][k] && bm2.getBm()[k][j]);
					}
				}
			}
			return mbm;
		}
	}

	public BoolMatrix invers() {
		BoolMatrix ibm = new BoolMatrix(getRow(), getCol());
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getCol(); j++) {
				ibm.bm[i][j] = !bm[i][j];
			}
		}
		return ibm;
	}

	public int trueNumber() {
		int n = 0;
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getCol(); j++) {
				if (bm[i][j] == true)
					n++;
			}
		}
		return n;
	}

	public void print() {
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getCol(); j++) {
				System.out.print(getBm()[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void fill(boolean b) {
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getCol(); j++) {
				bm[i][j] = b;
			}
		}
	}

	public void fillRandomMatrix() {
		Random rand = new Random();
		for (int i = 0; i < getRow(); i++) {
			for (int j = 0; j < getCol(); j++) {
				bm[i][j] = rand.nextBoolean();
			}
		}
	}

	private static boolean checkMatrix(BoolMatrix bm1, BoolMatrix bm2, boolean forMult) {
		if (forMult) {
			return ((bm1.row == bm2.row) && (bm1.col == bm2.col)) || (bm1.row == bm2.col);
		} else {
			return (bm1.row == bm2.row) && (bm1.col == bm2.col);
		}
	}

	private boolean checkSquare() {
		return getRow() == getCol();
	}

}
