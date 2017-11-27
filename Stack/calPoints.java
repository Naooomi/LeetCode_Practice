/**

You're now a baseball game point recorder.

Given a list of strings, each string can be one of the 4 following types:

Integer (one round's score): Directly represents the number of points you get in this round.
"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
"C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
Each round's operation is permanent and could have an impact on the round before and the round after.

You need to return the sum of the points you could get in all the rounds.

*/
class Solution {
    public int calPoints(String[] ops) {
        int sum = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+")) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                int temp_sum = temp1 + temp2;
                sum += temp_sum;
                stack.push(temp2);
                stack.push(temp1);
                stack.push(temp_sum);
            } else if (ops[i].equals("D")) {
                int temp1 = stack.pop();
                int temp_d = temp1 * 2;
                sum += temp_d;
                stack.push(temp1);
                stack.push(temp_d);
            } else if (ops[i].equals("C")) {
                int cancel = stack.pop();
                sum -= cancel;
            } else {
                int temp = Integer.parseInt(ops[i]);
                sum += temp;
                stack.push(temp);
            }
        }
        return sum;
    }
}
