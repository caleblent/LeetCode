package thePackage;

public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		System.out.println(comparePrefix("ab","abcdefghijkl"));
	}

	public String longestCommonPrefix(String[] strs) {
		String ret = "";
		// if strs is null or empty
		if (strs.length == 0 || strs == null) 
			return ret;
		
		// if strs only has 1 entry
		if (strs.length == 1)
			return strs[0];
		
		// get common prefix among the first 2 entries
		ret = comparePrefix(strs[0], strs[1]);
		
		// compare each subsequent entry against this
		for (int i = 2; i < strs.length; i++) {
			ret = comparePrefix(strs[i], ret);
		}
		
		return ret;
	}
	
	public static String comparePrefix(String s1, String s2) {
		// account for null and blank strings
        if (s1 == null || s2 == null || s1.equals("") || s2.equals(""))
            return "";

		String pref = "";
		
		// set length variable to the shorter of the 2 lengths
		int length = s1.length() < s2.length() ? s1.length() : s2.length();
		
		// add chars to prefix until different chars
		int i = 0;
		while (s1.charAt(i) == s2.charAt(i) && i < length - 1) {
			pref += s1.charAt(i);
            i++;
		}
		
		// to get the last char
		if (s1.charAt(i) == s2.charAt(i))
			pref += s1.charAt(i);
		
		return pref;
	}
}
