package Array;

/**
	
	1122. Relative Sort Array
	
	Description:
	Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
	
	Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  
	Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
	
	Example 1:
	
	Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
	Output: [2,2,2,1,4,3,3,9,6,7,19]
	
	Constraints:
	
	1. arr1.length, arr2.length <= 1000
	2. 0 <= arr1[i], arr2[i] <= 1000
	3. Each arr2[i] is distinct.
	4. Each arr2[i] is in arr1.
	
	Explaination:
	
	Step 1.
	Create two arrays: 
	bucket[] -> Store all possible values in the array, based on the Constrains, the max value we can have is 100, so length of temp will be 1000 + 1
	result[] -> Store the final result, length of result is the same as length of arr1
	
	Step 2.
	count the occurance of each value in arr1 and store the number of occurance in bucket in the index of the number itself
	
	For Example : arr1 = [2,3,1,3,2,4,6,7,9,2,19]
	there are three 2s, two 3s and one occurance of the rest
	bucket[2] = 3;
	bucket[3] = 2;
	bucket[1] = 1;
	bucket[4] = 1;
	...
	
	Step 3.
	All all values from arr2 to result. Before adding the values, check the occurance in bucket and loop accordingly
	For Example : 2 occurances three times, then we need to loop three times and add 2 to result
	
	while(bucket[2] > 0)
	{
	    result[index] = 2;
	    bucket[2]--;
	    index++;
	}
	
	here, we looped three timre, so 2 has been added three times
	
	Step 4.
	Add all the rest from arr1(those in arr1 but not in arr2)
	
	Simply, just loop throught bucket and check if the value is 1, if so we add to result

*/

public class relativeSortArray {
    public int[] solution(int[] arr1, int[] arr2) {
        int[] bucket = new int[1001];
        int[] result = new int[arr1.length];
        int index = 0;
        
        for (int i : arr1)
        {
            bucket[i]++;
        }
        
        for (int j : arr2)
        {
            while (bucket[j]-- > 0)
                result[index++] = j;
        }
        
        for (int k = 0; k < bucket.length; k++)
        {
            if (bucket[k] > 0)
                while (bucket[k]-- > 0)
                    result[index++] = k;
        }
        
        return result;
    }
}
