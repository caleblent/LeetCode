package thePackage;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	
	public static void main(String[] args) {
//		String str1 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABC...\r\n"
//				+ "t =\r\n"
//				+ "\"\\\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\\\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\\\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\\\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\\\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\\\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\\\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\\\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\\\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\\\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\\\"bcdefg&ijklmnopqrstuvwxyzAB";
//		String str2 = "\\\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\\\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\\\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\\\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\\\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\\\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\\\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\\\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\\\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\\\"bcdefg&ijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!a#$%h'()*+,-./:;<=> @[\\\\]^_`{|}~?\\\"bcdefg&ijklmnopqrstuvwxyzAB";
//		System.out.println("Are they isomorphic? " + isIsomorphic("title", "paper"));
		
//		for (int i = 50; i < 300; i++) {
//			char c1 = str1.charAt(i);
//			char c2 = str2.charAt(i);
//			System.out.println(c1 + " " + c2 + " ");
//		}
	}
	
	public static boolean isIsomorphic(String s, String t) {
		return isIsomorphic_worksButCopiedIt(s, t);
	}
	
	public static boolean isIsomorphic_worksButCopiedIt(String s, String t) {
		if(s == null || s.length() <= 1) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0 ; i< s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                 if(map.get(a).equals(b))
                continue;
                else
                return false;
            }else{
                if(!map.containsValue(b))
                map.put(a,b);
                else return false;
                
            }
        }
        return true;
	}
	
	public static boolean isIsomorphic_worksButDoesnt(String s, String t) {
		Map<Character, Integer> sMap = new HashMap<Character, Integer>();
		Map<Character, Integer> tMap = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			if (sMap.put(s.charAt(i), i) != tMap.put(t.charAt(i), i))
				return false;
		}

		return true;
	}

	public static boolean isIsomorphic_tooSlow2(String s, String t) {
		for (int i = 0; i < s.length(); i++) {
			char cs = s.charAt(i);
			char ct = t.charAt(i);
			for (int j = 0; j < s.length(); j++) {
				if (cs == s.charAt(j)) {
					if (ct != t.charAt(j)) {
						return false;
					}
				} else if (ct == t.charAt(j)) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isIsomorphic_tooSlow1(String s, String t) {

		while (s.length() > 0) {
			char cs = s.charAt(0);
			char ct = t.charAt(0);
			String _s = s;
			String _t = t;

			for (int i = 0; i < s.length(); i++) {
				if (cs == s.charAt(i)) {
					if (ct == t.charAt(i)) {
						_s = removeChar(_s, i);
						_t = removeChar(_t, i);
					} else {
						return false;
					}
				} else if (ct == t.charAt(i)) {
					return false;
				}
			}

			s = _s;
			t = _t;

			if (s.length() != t.length())
				return false;
		}

		return true;
	}

	public static String removeChar(String s, int index) {
		String ret = "";

		for (int i = 0; i < s.length(); i++) {
			if (i != index)
				ret += s.charAt(i);
		}

		return ret;
	}
}
