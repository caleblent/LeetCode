package thePackage;

import java.util.HashMap;

public class FirstUniqueCharacterInAString {

	public static void main(String[] args) {

	}
	
	public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	/* If the character does not exist as a key in the mapping yet, 
        	 * put it in with a value of 1. Otherwise, increment the value
        	 * that is already in there. */
        	if (!map.containsKey(c)) {
        		map.put(c, 1);
        	} else {
        		map.put(c, map.get(c)+1);
        	}
        }
        /* Search through the mapping for the first character that appears
         * only once (i.e. the first key with a value of 1) */
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (map.get(c) == 1)
        		return i;
        }
        
        return -1;
        
    }

}
