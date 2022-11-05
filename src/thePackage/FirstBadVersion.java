package thePackage;

public class FirstBadVersion {

	public int firstBadVersion(int n) {
		int left = 0;
		int right = n;

		while (left < right) {
			int midpoint = left + (right - left) / 2;
			if (isBadVersion(midpoint)) {
				if (!isBadVersion(midpoint-1))
					return midpoint;
				right = midpoint;
			} else {
				if (isBadVersion(midpoint+1))
					return midpoint+1;
				left = midpoint;
			}
		}
		
		if (left == right && isBadVersion(left)) {
			return left;
		}
		
		return -1;
	}

	public int firstBadVersion_linear2(int n) {
		if (isBadVersion(n))
			return firstBadVersion(n - 1);
		else
			return n + 1;
	}

	public int firstBadVersion_linear1(int n) {
		while (!(isBadVersion(n) && !isBadVersion(n - 1))) {
			n--;
		}
		return n;
	}

	public static boolean isBadVersion(int version) {
		return true;
	}

}
