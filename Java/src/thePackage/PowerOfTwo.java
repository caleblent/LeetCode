package thePackage;

public class PowerOfTwo {

	public boolean isPowerOfTwo(int n) {
		// base case
		if (n <= 0)
			return false;
		if (n == 1)
			return true;

		// if odd, return false
		// otherwise, recursively call the function on n / 2
		if (n % 2 == 1) {
			return false;
		} else {
			return isPowerOfTwo(n / 2);
		}
	}
}
