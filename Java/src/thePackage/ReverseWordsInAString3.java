package thePackage;

public class ReverseWordsInAString3 {
	
	public String reverseWords(String s) {
		String result = "";
		int L = 0;
		int R = 1;
		while (R < s.length()) {
			// if the char at pointer R is whitespace, time to do the thing
			if (s.charAt(R) == '\s') {
				result = result + reverseString(s.substring(L, R)) + " ";
				L = R+1;
			}
			R++;
		}
		
		// do it one more time at the end to account for the last word
		return result + reverseString(s.substring(L, R));
	}
	
	public String reverseString(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			result = s.charAt(i) + result;
		}
		return result;
	}
}
