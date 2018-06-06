package testB.run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import testB.logic.QuadraticEquation;
import testB.logic.QuadraticEquationArray;
import testB.logic.QuadraticEquationException;

/**
 * Demo class QuadraticEquation
 */

public class RunQuadraticEquation {

	public static void main(String[] args) throws QuadraticEquationException {
		List<QuadraticEquation> squareEquations = new ArrayList<QuadraticEquation>();
		squareEquations.add(new QuadraticEquation(2, 15, 5));
		squareEquations.add(new QuadraticEquation(3, -9, 6));
		squareEquations.add(new QuadraticEquation(2.5, 20, 3));
		squareEquations.add(new QuadraticEquation(1, 8, -3.5));
		squareEquations.add(new QuadraticEquation(2, 12, -6));
		squareEquations.add(new QuadraticEquation(-6, 14, 2));

		for (QuadraticEquation se : squareEquations) {
			System.out.println(se.toString());
			// Showing roots of quadratic equations:
			System.out.println("Root(s) = " + Arrays.toString(se.getX()));
			// Showing extremums, and also the intervals of decrease / increase
			se.showIntDec();
			System.out.println();
		}

		// Showing determine the largest and least significant roots.
		System.out.println("Max x = " + QuadraticEquationArray.getMaxX(squareEquations));
		System.out.println("Min x = " + QuadraticEquationArray.getMinX(squareEquations));

	}

}
