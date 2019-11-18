/**
    34. Find First and Last Position of Element in Sorted Array

    Description:
    Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
    Your algorithm's runtime complexity must be in the order of O(log n).
    If the target is not found in the array, return [-1, -1].

    Example 1:
    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]
    
    Example 2:
    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]

*/


class Solution {
    public int[] searchRange(int[] nums, int target) 
    {
        int first = firstIndex(nums, 0, nums.length - 1, target);
        int last = lastIndex(nums, 0, nums.length - 1, target);
        
        return new int[] {first, last};
    }
    
    public int firstIndex (int[] nums, int left, int right, int target)
    {
        while (left <= right)
        {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] == target)
            {
                
                if (pivot == left || nums[pivot - 1] < nums[pivot]) 
                    // it means the search on left side is done or mid is the first occurance in the array
                    return pivot;
                
                else 
                    // still go left
                    right = pivot - 1;
            }
            else if (nums[pivot] > target)
                right = pivot - 1;
            else
                 left = pivot + 1;
        }
        return -1;
    }
    
    public int lastIndex (int[] nums, int left, int right, int target)
    {
        while (left <= right)
        {
            int pivot = left + (right - left) / 2;
            if (nums[pivot] == target)
            {
                
                if (pivot == right || nums[pivot] < nums[pivot + 1])
                    // it means the search on the right side is done or mid is the last occurance in the array
                    return pivot;
                else 
                    // still go right
                    left = pivot + 1;
            }
            else if (nums[pivot] > target)
                right = pivot - 1;
            else 
                left = pivot + 1;
        }
        return -1;
    }
}