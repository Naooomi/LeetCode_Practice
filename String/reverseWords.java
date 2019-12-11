/**
    557. Reverse Words in a String 3
    
    Description:

    Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

*/

public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sentence = new StringBuilder();

        for (int i = 0; i < words.length; i++)
        {
            StringBuilder word = new StringBuilder();
            word.append(words[i]);
            words[i] = word.reverse().toString();
            sentence.append(words[i]);
            sentence.append(" ");
        }
        return sentence.toString().trim();
    }
}
