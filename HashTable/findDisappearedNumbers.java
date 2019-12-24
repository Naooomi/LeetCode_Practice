import java.util.ArrayList;
import java.util.List;

/**
	448. Find All Numbers Disappeared in an Array
	
	Description:
	Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
	Find all the elements of [1, n] inclusive that do not appear in this array.
	Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
	
	Example:
	
	Input:
	[4,3,2,7,8,2,3,1]
	
	Output:
	[5,6]
	
*/
public class findDisappearedNumbers {
    public List<Integer> find_DisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        boolean[] bArray = new boolean[nums.length];
        
        for (int i = 0; i < nums.length; i++)
            bArray[nums[i] - 1] = true;
        
        for (int i = 0; i < nums.length; i++)
        {
            if (bArray[i] == false)
                result.add(i+1);
        }
        
        return result;
    }
}
