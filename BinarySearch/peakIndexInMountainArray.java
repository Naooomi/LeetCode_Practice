/**
    852. Peak Index in a Mountain Array

    Description:
    Let's call an array A a mountain if the following properties hold:
        A.length >= 3
        There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
    Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

    Note:
    You may assume that all elements in nums are unique.
    n will be in the range [1, 10000].
    The value of each element in nums will be in the range [-9999, 9999].

    Example 1:
    Input: [0,1,0]
    Output: 1
    
    Example 2:
    Input: [0,2,1,0]
    Output: 1

*/

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int start = 0;
        int length = A.length;
        int peak = 0;

        while (start < length - 2)
        {
            // go up
            while (A[start] < A[start + 1])
            {
                start++;
            }
            peak = start;
            
            //go down
            while(A[start] > A[start + 1])
            {
                start++;
            }
        }
        if (start == length-1)
        {
            return peak;
        }
        return -1;
    }
}