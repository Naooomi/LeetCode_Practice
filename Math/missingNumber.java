/**

Description:

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

*/
class Solution {
    public int missingNumber(int[] nums) {

        Arrays.sort(nums);

        // If the last index is missing
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }

        // If the first is missing
        else if (nums[0] != 0) {
            return 0;
        }

        // if the missing number is not 0 or n
        for (int i = 1; i < nums.length; i++) {
            int expectedNum = nums[i-1] + 1;
            if (nums[i] != expectedNum) {
                return expectedNum;
            }
        }
        // the array was not missing any numbers
        return -1;
    }
}
