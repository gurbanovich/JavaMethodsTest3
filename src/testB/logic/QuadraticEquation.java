package testB.logic;

/**
 * The task: Implement the methods of addition, subtraction, multiplication and
 * division of objects (for those classes whose objects can support arithmetic
 * operations).   Define the class The quadratic equation. Implement methods for
 * searching roots, extremums, and also the intervals of decrease / increase.
 * Create array / list / set of objects and determine the largest and least
 * significant roots.
 */

public class QuadraticEquation {

	private double a;
	private double b;
	private double c;

	public QuadraticEquation() {
		this.a = 1;
		this.b = 0;
		this.c = 0;
	}

	public QuadraticEquation(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public Double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public Double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "(" + getA() + ")*x^2 + (" + getB() + ")*x + (" + getC() + ") = 0;";
	}

	private double getDiscrimenant(double a, double b, double c) {
		double res = (b * b) - (4 * a * c);
		if (res < 0) {
			return -1;
		} else
			return res;
	}

	private double getXOne(double a, double b, double d) {
		return ((-1) * b - Math.sqrt(d)) / (2 * a);
	}

	private double getXTwo(double a, double b, double d) {
		return ((-1) * b + Math.sqrt(d)) / (2 * a);
	}

	private double getXNull(double a, double b) {
		return (-1) * b / (2 * a);
	}

	public double[] getX() throws QuadraticEquationException {
		double d = getDiscrimenant(getA(), getB(), getC());
		if (d == -1) {
			throw new QuadraticEquationException("the equation don't have any solutions");
		} else if (d == 0) {
			double[] sol = new double[1];
			sol[0] = getXNull(getA(), getB());
			return sol;
		} else {
			double[] sol = new double[2];
			sol[0] = getXOne(getA(), getB(), d);
			sol[1] = getXTwo(getA(), getB(), d);
			return sol;
		}
	}

	public double getExtremum() {
		return (-1) * getB() / (2 * getA());
	}

	public void showIntDec() {
		if (getA() > 0)
			System.out.println("Function " + toString() + " decreases on (-inf; " + getExtremum()
					+ ") and increases on (" + getExtremum() + "; +inf)");
		else if (getA() < 0)
			System.out.println("Function " + toString() + " increases on (-inf; " + getExtremum()
					+ ") and decreases on (" + getExtremum() + "; +inf)");
	}

}
