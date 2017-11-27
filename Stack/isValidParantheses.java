/**
 * Description:
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty()) return false;
                if (c == ')') {
                    char last = stack.pop();
                    if (last != '(') return false;
                } else if (c == ']') {
                    char last = stack.pop();
                    if (last != '[') return false;
                } else if (c == '}') {
                    char last = stack.pop();
                    if (last != '{') return false;
                }
            }
        }
        if (stack.empty()) return true;
        else return false;

    }
}
