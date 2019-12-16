/**
	Given an integer, write a function to determine if it is a power of two.
*/

public class isPowerOfTwo {
    /**
    Solution 1: Iterative
  */
  public boolean solution1(int n) {

    if (n == 0) return false;
    while (n % 2 == 0) {
        n /= 2;
    }
    return (n == 1);
  }

  /**
    Solution 2: Recursive
  */
  public boolean solution2(int n) {
    return n>0 && (n==1 || (n%2==0 && solution2(n/2)));
  }
}
