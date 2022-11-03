package thePackage;

public class FirstBadVersion {

	public int firstBadVersion(int n) {
		if(isBadVersion(n/2))
			return firstBadVersion(n/2);
		else {
			if (isBadVersion(n/2 + 1))
				return n/2 + 1;
			else {
				return firstBadVersion(0); // THIS SHOULDNT WORK AT ALL
			}
		}
	}
	
	public int firstBadVersion_linear2(int n) {
		if(isBadVersion(n))
			return firstBadVersion(n-1);
		else
			return n+1;
	}
	
	public int firstBadVersion_linear1(int n) {
		while (! (isBadVersion(n) && !isBadVersion(n-1)) ) {
			n--;
		}
		return n;
	}

	public static boolean isBadVersion(int version) {
		return true;
	}

}
