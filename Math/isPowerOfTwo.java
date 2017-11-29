/**
  Given an integer, write a function to determine if it is a power of two.
*/
class Solution {

    /**
      Solution 1: Iterative
    */
    public boolean isPowerOfTwo(int n) {

      if (n == 0) return false;
      while (n % 2 == 0) {
          n /= 2;
      }
      return (n == 1);
    }

}
