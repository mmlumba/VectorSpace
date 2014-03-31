package Jama.Matrix;

public class calculateMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double[][] array = {{2., 1., 8., 1., 0., 2., 1., 1., 0., 0., 2., 16.},{0., 0., 1., 0., 0., 0., 0., 0., 0., 0., 0., 0.},{1., 0., 6., 0., 2., 0., 2., 0., 1., 0., 0., 1.},{0., 0., 2., 0., 0., 0., 0., 0., 0., 0., 0., 0.}};
		Matrix A = new Matrix(array);
		//System.out.println(A);
	}

}
