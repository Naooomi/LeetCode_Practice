/**
    350. Intersection of Two Arrays II

    Description:
    Given two arrays, write a function to compute their intersection.

    Example 1:
    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2,2]
    
    Example 2:
    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [4,9]
    
    Note:
    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Hash nums1 into the hashtable and increase values.
        // Put nums2 into the array list and decrease values in hashtable.
        // Convert ArrayList to array of integers.
        
        HashMap<Integer, Integer> map1 = new HashMap<>();
        List<Integer> list1 = new ArrayList<Integer>();
        
        for (int i : nums1)
        {
            // if key is not in map1, put that key in the map and value will be 1 which is there is 1 value in nums1
            // if the key is in map1, increase the value of that key(will be the count of key in nums1)
            if (!map1.containsKey(i)) map1.put(i, 1);
            else map1.put(i, map1.get(i) + 1);
        }
        
        for (int i : nums2)
        {
            if (map1.containsKey(i) && map1.get(i) > 0)
            {
                // this value is in map1
                list1.add(i);
                map1.put(i, map1.get(i) - 1);
            }
        }
        
        // convert ArrayList to array of intergers
        int[] result = new int[list1.size()];
        
        for (int i = 0; i < list1.size(); i++)
        {
            result[i] = list1.get(i);
        }
        return result;
    }
}