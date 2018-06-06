package testB.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * The class create array / list / set of objects and determine the largest and
 * least significant roots.
 */

public class QuadraticEquationArray {

	public QuadraticEquationArray() {
	}

	private static void checkQuadratic(double a) throws QuadraticEquationException {
		if (a == 0)
			throw new QuadraticEquationException("This isn't quadratic eqyation");
	}

	public static double getMaxX(List<QuadraticEquation> sl) throws QuadraticEquationException {
		double max = -100000;
		List<Double> roots = getAllRoots(sl);
		for (double el : roots) {
			if (max < el)
				max = el;
		}
		return max;
	}

	public static double getMinX(List<QuadraticEquation> sl) throws QuadraticEquationException {
		double min = 100000;
		List<Double> roots = getAllRoots(sl);
		for (double el : roots) {
			if (min > el)
				min = el;
		}
		return min;
	}

	private static List<Double> getAllRoots(List<QuadraticEquation> sl) throws QuadraticEquationException {
		List<Double> roots = new ArrayList<Double>();
		for (QuadraticEquation se : sl) {
			checkQuadratic(se.getA());
			for (double x : se.getX()) {
				roots.add(x);
			}
		}
		return roots;
	}

}
