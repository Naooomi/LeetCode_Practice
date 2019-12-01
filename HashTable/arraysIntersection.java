/**
    1213. Intersection of Three Sorted Arrays

    Description:
    Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays.

    Example 1:
    Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
    Output: [1,5]
    
    Explanation: Only 1 and 5 appeared in the three arrays.

    Constraints:
    1. 1 <= arr1.length, arr2.length, arr3.length <= 1000
    2. 1 <= arr1[i], arr2[i], arr3[i] <= 2000

*/
class Solution {
    public int[] arraysIntersection(int[] A, int[] B, int[] C) {
        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < A.length; i++)
            map.put(A[i], 1);

        for (int j = 0; j < B.lengh; j++)
            map.put(B[j], map.getOrDefault(B[J], 0) + 1)

        List<Integer> result = new LinkedList<>();
        for (int k = 0; k < C.length; k++)
        {
            if (map.get(C[k]) == 2)
                result.add(C[k]);
        }

        return result;
    }
}
