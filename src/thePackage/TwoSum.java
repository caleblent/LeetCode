package thePackage;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; i + j < nums.length; j++) {
                if (nums[i] + nums[i+j] == target) {
                    return new int[]{i, i+j};
                }
            }
        }
        return null;
    }
}