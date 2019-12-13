/**
    1078. Occurrences After Bigram
    
    Description:
    Given words first and second, consider occurrences in some text of the form "first second third", 
    where second comes immediately after first, and third comes immediately after second.
    For each such occurrence, add "third" to the answer, and return the answer.

    Example 1:
    Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
    Output: ["girl","student"]
    
    Example 2:
    Input: text = "we will we will rock you", first = "we", second = "will"
    Output: ["we","rock"]
    
    Note:

    1. 1 <= text.length <= 1000
    2. text consists of space separated words, where each word consists of lowercase English letters.
    3. 1 <= first.length, second.length <= 10
    4. first and second consist of lowercase English letters.
*/
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        
        ArrayList<String> result = new ArrayList<String>();
        
        
        for (int i = 0; i < words.length - 2; i++)
        {
            if (first.equals(words[i]) && second.equals(words[i+1]))
            {
                result.add(words[i+2]);
            }
        }
        
        // ArrayList.toArray(T[] a)	-> Type Parameters: T - the runtime type of the array to contain the collection
        // The array into which the elements of the list are to be stored, if it is big enough; 
        // otherwise, a new array of the same runtime type is allocated for this purpose.
        return result.toArray(new String[0]);
    }
}