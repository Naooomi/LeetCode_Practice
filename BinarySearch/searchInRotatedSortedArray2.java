/**
    81. Search in Rotated Sorted Array II

    Description:

    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
    (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
    You are given a target value to search. If found in the array return true, otherwise return false.

    Example 1:
    Input: nums = [2,5,6,0,0,1,2], target = 0
    Output: true
    
    Example 2:
    Input: nums = [2,5,6,0,0,1,2], target = 3
    Output: false
    
    Follow up:
    This is a follow up problem to Search in Rotated Sorted Array(33), where nums may contain duplicates.
    Would this affect the run-time complexity? How and why?
    
 */
// Time: O(logN)
// Space: O(1)

public class searchInRotatedSortedArray2 {
	public boolean search(int[] nums, int target) {
        int left = 0, pivot = 0;
        int right = nums.length - 1;
        
        if (nums == null || nums.length == 0) return false;

        while (left <= right)
        {
            pivot = left + (right - left) / 2;
            
            if (target == nums[pivot]) return true;
            
            if (nums[pivot] > nums[left] || nums[pivot] > nums[right])
            {
                // left -> mid is sorted
                if (target >= nums[left] && target < nums[pivot])
                {
                    // target in left part
                    right = pivot - 1;
                }
                else 
                {
                    left = pivot + 1;
                }
            }
            else if (nums[pivot] < nums[right] || nums[pivot] < nums[left])
            {
                // mid -> right is sorted
                if (target > nums[pivot] && target <= nums[right])
                {
                    //target in right part
                    left = pivot + 1;
                }
                else 
                {
                    right = pivot - 1;
                }
            }
            else
            {
                // get here means nums[left] == nums[pivot] == nums[right]
                // shifting out any of the two side wouldn't change the result but can help remove the duplicate
                // left++ works too
                right--;
            }
        }
        return false;
    }
}
