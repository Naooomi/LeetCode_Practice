import java.util.Arrays;

/**

	Description:
	  
	Given an integer array, find three numbers whose product is maximum and output the maximum product.

*/

public class maximumProduct {
    public int solution(int[] nums) {

        Arrays.sort(nums);

        int a = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        int b = nums[0] * nums[1] * nums[nums.length - 1];

        return a > b ? a : b;
    }
}
