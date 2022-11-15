package thePackage;

import java.util.HashMap;

public class LongestSubstringWIthoutRepeatingCharacters {
	
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		// iterate through each character in the string
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), 1);
			int currMax = 1;
			for (int j = i+1; j < s.length(); j++) {
				if (map.put(s.charAt(j), 1) != null)
					break;
				currMax++;
			}
			if (currMax > max)
				max = currMax;
			map.clear();
		}
		
		return max;
	}
}
