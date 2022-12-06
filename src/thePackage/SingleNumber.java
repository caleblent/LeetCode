package thePackage;

import java.util.HashMap;

public class SingleNumber {
	
	public int singleNumber(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		// iterate through array, adding entries to the hashmap
		for (int i = 0; i < nums.length; i++) {
			if (map.put(nums[i], 1) != null)
				map.put(nums[i], 2);
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (map.get(nums[i]) == 1)
				return nums[i];
		}
		
		return -1;
	}
}
