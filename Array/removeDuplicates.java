/**

  Description:

  Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.

  Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

*/
public class Solution {
    public int removeDuplicates(int[] nums) {

        int i = 1; //iterator thru array
        int j = 0; //current index
        for (; i<nums.length; i++) {
            if (nums[i] != nums[j]) { //new number
                j++; //move current index
                nums[j] = nums[i]; //fill current index with new number
            }
        }
    return j+1;
   }
}
