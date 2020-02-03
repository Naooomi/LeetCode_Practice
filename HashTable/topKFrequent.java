import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

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
	// Solution One : Priority Queue + Max Heap
	// Time Complexity : O(N) + O(nlogk)
	// Space Complexity : O(N)
	public List<Integer> topKFrequentPriorityQueue(int[] nums, int k) 
	{
		List<Integer> result = new ArrayList<Integer>();
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		
		for (int n : nums)
			count.put(n, count.getOrDefault(n, 0) + 1);
		
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		
		// Unfinish
		return result;
	}
	
	// Solution Two : Bucket Sort
	// Time Complexity : O(N)
	// Space Complexity : O(N)
	public List<Integer> topK_FrequentBucketSort(int[] nums, int k) 
	{
		List[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		List<Integer> result = new ArrayList<Integer>();
		
		for (int n : nums)
			count.put(n, count.getOrDefault(n, 0) + 1);
		
		for (int num : count.keySet())
		{
			int c = count.get(num);
			if (bucket[c] == null)
				bucket[c] = new ArrayList<Integer>();
			bucket[c].add(num);
		}
		
		for (int i = nums.length; i >= 0 && result.size() < k; i--)
		{
			if (bucket[i] != null) result.addAll(bucket[i]);
		}
		
		return result;
	}
	
	public List<Integer> explain_TopKFrequent(int[] nums, int k) 
	{
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
    	List<Integer> result = topKF.explain_TopKFrequent(nums, k);
    	
    	System.out.println(result);
    }
    
}
