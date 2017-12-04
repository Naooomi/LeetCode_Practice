/**

  Description

  Write a function that takes a string as input and returns the string reversed.

*/
public class Solution {
    public String reverseString(String s) {
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();

    }
}
