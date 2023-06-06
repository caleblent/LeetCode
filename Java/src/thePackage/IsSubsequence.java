package thePackage;

public class IsSubsequence {
	
	public boolean isSubsequence(String s, String t) {
		if (s.isBlank())
			return true;
		
        int indexS = 0;
        int indexT = 0;
        
		while (indexT < t.length()) {
			if (s.charAt(indexS) == t.charAt(indexT))
				indexS++;
			
			if (indexS >= s.length())
				return true;
			
			indexT++;
		}
		
		return false;
    }

}
