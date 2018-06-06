package testC.run;

import testC.logic.BoolMatrix;
import testC.logic.MatrixException;

/**
 * Demo class BoolMatrix
 */

public class RunMatrix {

	public static void main(String[] args) throws MatrixException {

		BoolMatrix bm1 = new BoolMatrix(3, 2);
		BoolMatrix bm2 = new BoolMatrix(3, 2);
		BoolMatrix bm3 = new BoolMatrix(2, 3);

		bm1.fillRandomMatrix();
		bm1.print();
		System.out.println();
		bm2.fillRandomMatrix();
		bm2.print();
		System.out.println();
		bm3.fillRandomMatrix();
		bm3.print();
		System.out.println();

		// Showing logical addition (disjunction) of matrices
		System.out.println("Summa of matrix1 and matrix3: ");
		BoolMatrix bms1 = BoolMatrix.sum(bm1, bm2);
		bms1.print();
		System.out.println();

		// Showing multiplication of matrices
		System.out.println("Multiplication of matrix2 and matrix3: ");
		BoolMatrix bmm2 = BoolMatrix.mult(bm2, bm3);
		bmm2.print();
		System.out.println();

		// Showing inversion of matrices
		System.out.println("Invers of matrix1: ");
		BoolMatrix bm1Inv = bm1.invers();
		bm1Inv.print();
		System.out.println();

		System.out.println("nvers of matrix2: ");
		BoolMatrix bm2Inv = bm2.invers();
		bm2Inv.print();
		System.out.println();

		System.out.println("nvers of matrix3: ");
		BoolMatrix bm3Inv = bm3.invers();
		bm3Inv.print();
		System.out.println();

		// Showing counting the number of true values in the matrix
		System.out.println("true number matrix1: " + bm1.trueNumber());
		System.out.println("true number matrix2: " + bm2.trueNumber());
		System.out.println("true number matrix13 " + bm3.trueNumber());

	}

}
