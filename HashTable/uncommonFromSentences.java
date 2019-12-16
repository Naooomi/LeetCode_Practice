import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
    884. Uncommon Words from Two Sentences
    
    Description:
    We are given two sentences A and B.  (A sentence is a string of space separated words.  
    Each word consists only of lowercase letters.)
    A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
    Return a list of all uncommon words. 
    You may return the list in any order.

    Example 1:
    Input: A = "this apple is sweet", B = "this apple is sour"
    Output: ["sweet","sour"]
    
    Example 2:
    Input: A = "apple apple", B = "banana"
    Output: ["banana"]

    Note:
    1. 0 <= A.length <= 200
    2. 0 <= B.length <= 200
    3. A and B both contain only spaces and lowercase letters.

*/

public class uncommonFromSentences {
	public String[] uncommon_FromSentences(String A, String B) {
        HashMap<String, Integer> count = new HashMap<>();
        List<String> result = new ArrayList<>();
        
        String[] fromA = A.split(" ");
        String[] fromB = B.split(" ");
        
        for (String s : fromA)
            count.put(s, count.getOrDefault(s, 0) + 1);
        
        for (String s : fromB)
            count.put(s, count.getOrDefault(s, 0) + 1);
        
        for (String word : count.keySet())
        {
            if (count.get(word) == 1)
                result.add(word);
        }
        
        return result.toArray(new String[result.size()]);              
    }
}
