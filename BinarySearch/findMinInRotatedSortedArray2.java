/**
    154. Find Minimum in Rotated Sorted Array II

    Description:
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
    (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
    Find the minimum element.
    The array may contain duplicates.

    Example 1:
    Input: [1,3,5]
    Output: 1
    
    Example 2:
    Input: [2,2,2,0,1]
    Output: 0
    
    Note:
    This is a follow up problem to Find Minimum in Rotated Sorted Array.
    Would allow duplicates affect the run-time complexity? How and why?
    
 */

public class findMinInRotatedSortedArray2 {
	 public int findMin(int[] nums) {
        int left = 0, pivot = 0;
        int right = nums.length - 1;
        
        while (left <= right)
        {
            pivot = left + (right - left) / 2;
            
            if (nums[pivot] < nums[right])
            {
                // means left -> pivot is sorted in ascending, so search in left -> pivot
                right = pivot;
            }
            else if (nums[pivot] > nums[right])
            {
                // means pivot -> right is sorted in ascending, so minimum is in the right part
                left = pivot + 1;
            }
            else 
            {
                // nums[pivot] == nums[right]
                right--;
            }
        }
        
        return nums[left];
    }
}
