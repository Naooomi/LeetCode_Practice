import java.util.Arrays;
import java.util.HashSet;

/**
    349. Intersection of Two Arrays

    Description:
    Given two arrays, write a function to compute their intersection.

    Example 1:
    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2]
    
    Example 2:
    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [9,4]
    
    Note:
    Each element in the result must be unique.
    The result can be in any order.
    
 */

 // Time: O(nlogn)
public class intersectionOfTwoArray {
	public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        Arrays.sort(nums1);
        
        // loop num2 find if element in nums2 also in num1
        // if yes add to set
        for (Integer num : nums2)
        {
           if (binarySearch(nums1, num))
           {
               set.add(num);
           }
        }
        
        // convert HashSet to array
        int[] result = new int[set.size()];
        int i = 0;
        for (int n : set)
        {
            result[i++] = n;
        }
        
        return result;
    }
    
    public boolean binarySearch (int[] nums, int target)
    {
        int left = 0, pivot = 0;
        int right = nums.length - 1;
        
        while (left <= right)
        {
            pivot = left + (right - left) / 2;
            
            if (target > nums[pivot])
            {
                left = pivot + 1;
            } 
            else if (target < nums[pivot])
            {
                right = pivot - 1;
            }
            else 
            {
                return true;
            }
        }
        return false;
    }
}
