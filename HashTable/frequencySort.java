import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**

	451. Sort Characters By Frequency

	Description:
	Given a string, sort it in decreasing order based on the frequency of characters.
	
	Example 1:
	
	Input:
	"tree"
	
	Output:
	"eert"
	
	Explanation:
	'e' appears twice while 'r' and 't' both appear once.
	So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
	
	Example 2:
	
	Input:
	"cccaaa"
	
	Output:
	"cccaaa"
	
	Explanation:
	Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
	Note that "cacaca" is incorrect, as the same characters must be together.
	
	Example 3:
	
	Input:
	"Aabb"
	
	Output:
	"bbAa"
	
	Explanation:
	"bbaA" is also a valid answer, but "Aabb" is incorrect.
	Note that 'A' and 'a' are treated as two different characters.

*/
public class frequencySort {
    // Solution One : using HashMap
	public String frequencySort1(String s) {
        
        HashMap<Character, Integer> count = new HashMap<>();
        
        for (Character letter : s.toCharArray())
            count.put(letter, count.getOrDefault(letter, 0) + 1);
        
        List<Character>[] bucket = new LinkedList[s.length() + 1];
        
        for (char c : count.keySet())
        {
            int charCount = count.get(c);
            if (bucket[charCount] == null)
                bucket[charCount] = new LinkedList<>();
            bucket[charCount].add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = bucket.length - 1; i >= 0; i--)
        {
            if (bucket[i] != null)
            {
                for (char c : bucket[i])
                {
                    for (int j = 0; j < i; j++)
                        sb.append(c);
                }
            }
        }
        
        return sb.toString();
    }
	
	//Solution Two : using PriorityQueue
	
    public String frequencySort2(String s) {
        Map<Character, Integer> count = new HashMap<Character, Integer>(); 
        for (char c : s.toCharArray())
            count.put(c, count.getOrDefault(c, 0) + 1);
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> count.get(b) - count.get(a));
        for(char c : count.keySet())
            maxHeap.offer(c);
            
        char[] res = new char[s.length()];
        
        int index = 0;
        while(!maxHeap.isEmpty())
        {
            char c = maxHeap.poll();
            for(int i = 0; i < count.get(c); i++)
                res[index++] = c;
        }
    
        return new String(res);    
    }
	
}
