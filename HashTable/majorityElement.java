import java.util.HashMap;
import java.util.Map;

/**
	169. Majority Element
	
	Description:
	Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
	You may assume that the array is non-empty and the majority element always exist in the array.
	
	Example 1:
	Input: [3,2,3]
	Output: 3
	
	Example 2:
	Input: [2,2,1,1,1,2,2]
	Output: 2

*/
public class majorityElement {
    public int majority_Element(int[] nums) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int result = 0;
        for (int num : nums)
            count.put(num, count.getOrDefault(num, 0) + 1);
        
        for (Map.Entry<Integer, Integer> entry : count.entrySet())
        {
            if (entry.getValue() > nums.length / 2)
                result = entry.getKey();
        }
        
        return result;
    }
}
