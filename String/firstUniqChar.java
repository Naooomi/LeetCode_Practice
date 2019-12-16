import java.util.HashMap;

/**
    387. First Unique Character in a String
    Description:
    Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

    Examples:
    s = "leetcode"
    return 0.

    s = "loveleetcode",
    return 2.

    Note: You may assume the string contain only lowercase letters.
*/
/**
    Complexity Analysis :
    1. Time Complexity : O(N) since we go throught the string of length N two times
    2. Space Complexity : O(N) since we have to keep a hash map with N elements
*/

public class firstUniqChar {
    public int solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        
        if (map.containsValue(1))
        {
            for (int j = 0; j < chars.length; j++)
            {
                if (map.get(chars[j]) == 1)
                    return j;
            }
        }
        
        return -1;
    }
}
