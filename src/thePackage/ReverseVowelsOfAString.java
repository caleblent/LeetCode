package thePackage;

public class ReverseVowelsOfAString {
	
	public String reverseVowels(String s) {
		int p1 = 0, p2 = s.length() - 1;
		
		/* copy String over into a char[] so it's mutable */
		char[] chars = copyStringToCharArray(s);
		
		while (p1 < p2) {
			/* check with each increment/decrement that p1 and p2 don't collide */
			while (!isVowel(chars[p1]) && p1 < p2)
				p1++;
			while (!isVowel(chars[p2]) && p1 < p2)
				p2--;
			
			
			/* make the swap */
			char temp = chars[p1];
			chars[p1] = chars[p2];
			chars[p2] = temp;
			p1++;
			p2--;
			
		}
		
		/* return the char[] in String form */
		return copyCharArrayToString(chars);
    }
	
	public char[] copyStringToCharArray(String s) {
		char[] c = new char[s.length()];
		
		for (int i = 0; i < c.length; i++) {
			c[i] = s.charAt(i);
		}
		
		return c;
	}
	
	public String copyCharArrayToString(char[] c) {
		String s = "";
		
		for (int i = 0; i < c.length; i++) {
			s += c[i];
		}
		
		return s;
	}

	public boolean isVowel(char c) {
		if (c == 'a' ||
			c == 'A' ||
			c == 'e' ||
			c == 'E' ||
			c == 'i' ||
			c == 'I' ||
			c == 'o' ||
			c == 'O' ||
			c == 'u' ||
			c == 'U')
			return true;

		return false;
	}
}
