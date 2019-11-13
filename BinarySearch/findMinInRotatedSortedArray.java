/**
    153. Find Minimum in Rotated Sorted Array

    Description：

    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
    (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
    Find the minimum element.

    You may assume no duplicate exists in the array.

    Example 1:
    Input: [3,4,5,1,2] 
    Output: 1

    Example 2:
    Input: [4,5,6,7,0,1,2]
    Output: 0
    
 */

class Solution {
    public int findMin(int[] nums) {
        int left = 0, pivot = 0;
        int right = nums.length - 1;
        
        while (left < right)
        {
            pivot = left + (right - left) / 2;
            
            if (nums[right] < nums[pivot])
            {
                // left -> pivot is ascending sorted means minimum is on right
                left = pivot + 1;
            }
            else
            {
                // pivot -> right is ascending sorted means minimum is on left
                right = pivot;
            }
        }
        return nums[right];
    }
}