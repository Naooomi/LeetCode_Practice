/**

  Description:

  Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

*/
public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuffer reversedString = new StringBuffer();
        for(String word : words){
            reversedString.append(new StringBuffer(word).reverse().toString());
            reversedString.append(" ");
        }
    return reversedString.toString().trim();
    }
}
