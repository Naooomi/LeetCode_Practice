/**

	Description:
	
	Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

*/

public class judgeSquareSum {
    public boolean solution(int c) {

        int i = 0;
        int j = (int) Math.sqrt(c);
        while (i <= j) {
            if ((i*i + j*j < c)) {
                i++;
            } else if (i*i + j*j > c) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
