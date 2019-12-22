import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 	347. Top K Frequent Elements
	
	Description:
	Given a non-empty array of integers, return the k most frequent elements.
	
	Example 1:
	Input: nums = [1,1,1,2,2,3], k = 2
	Output: [1,2]
	
	Example 2:	
	Input: nums = [1], k = 1
	Output: [1]
	
	Note:
	You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
	Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
	
 */
public class topKFrequent {
    public List<Integer> topK_Frequent(int[] nums, int k) {
        //Using HashMap and LinkedList
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        List<Integer>[] bucket = new LinkedList[nums.length + 1];
        List<Integer> result = new ArrayList<>();
        
        for(int n : nums)
            count.put(n, count.getOrDefault(n, 0) + 1);
        
        System.out.println(count);
        System.out.println("Adding to the list : index will be the count of the index value");
        
        for (int key : count.keySet())
        {
            int freq = count.get(key);
            if(bucket[freq] == null)
                bucket[freq] = new LinkedList<Integer>();
            bucket[freq].add(key);
            System.out.println("Add key " + key + " to bucket list. " + key + " has " + freq + " in the list");
            System.out.println("Now the bucket list is : " + Arrays.toString(bucket));
        }
        
        System.out.println("");
        for (int i = nums.length, c = 0; c < k && i >= 0; i--)
        {
        	System.out.println("i = " + i + " bucket[" + i + "] = " + bucket[i]);
            if (bucket[i] != null)
            {
            	c += bucket[i].size();
            	System.out.print("count is : " + c);
                result.addAll(bucket[i]);
                System.out.print(". bucket[" + i + "] = " + bucket[i]);
                System.out.println(". Add " + bucket[i] + " to the result list. The result list is now : " + result);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) 
    {
    	int[] nums = {1, 1, 2, 2, 4, 4, 4, 4, 5, 6};
    	int k = 3;
    	topKFrequent topKF = new topKFrequent();
    	List<Integer> result = topKF.topK_Frequent(nums, k);
    	
    	System.out.println(result);
    }
    
}
