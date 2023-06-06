package thePackage;

public class RunningSumOf1DArray {
	
	public int[] runningSum_bruteForce(int[] nums) {
        int[] sums = new int[nums.length];
        
        for (int i = 0; i < sums.length; i++) {
        	int sum = 0;
        	for (int j = 0; j <= i; j++) {
        		sum += nums[j];
        	}
        	sums[i] = sum;
        }
        
        return sums;
    }
	
	public int[] runningSum_optimized(int[] nums) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
        	sums[i] = nums[i] + sums[i-1];
        }
        
        return sums;
    }
}
