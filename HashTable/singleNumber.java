import java.util.HashMap;
import java.util.Set;

/**

    136. Single Number

    Description:
    Given a non-empty array of integers, every element appears twice except for one. Find that single one.

    Note:
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

    Example 1:
    Input: [2,2,1]
    Output: 1
    
    Example 2:
    Input: [4,1,2,1,2]
    Output: 4
    
*/

public class singleNumber {
    public int single_Number(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        
        for (int num : nums)
        {
            if (count.containsKey(num))
                count.remove(num);
            else
                count.put(num, count.getOrDefault(num, 0) + 1);
        }
            
        
        Set<Integer> result = count.keySet();
        return (int)result.toArray()[0];
    }
}
