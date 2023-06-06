package thePackage;

public class NumberOf1Bits {

	public int hammingWeight(int n) {
		// cast the int n as the Integer wrapper object class
		Integer i = new Integer(n);
		
		// convert it to a binary string with an arbitrary length
		String b = i.toBinaryString(n);
		
		// pad the String b to 32 characters long
//		int paddingLength = 32 - b.length();
//		String padding = "";
//		for (int j = 0; j < paddingLength; j++) {
//			padding += "0";
//		}
//		b = padding + b
		// 	NOTE: I guess we don't actually need to do this above step
		
		// go through the binary string and count the number of 1's
		int hw = 0;
		for (int j = 0; j < b.length(); j++) {
			if (b.charAt(j) == '1') {
				hw += 1;
			}
		}
		
		// return the hamming weight
		return hw;
		
	}
}
