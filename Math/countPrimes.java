/**

	Description:
	
	Count the number of prime numbers less than a non-negative number, n.

*/

public class countPrimes {
	public int solution(int n) {
        boolean[] m = new boolean[n];
       int count = 0;
       for (int i=2; i<n; i++) {
           if (m[i])
               continue;

           count++;
           for (int j=i; j<n; j=j+i)
               m[j] = true;
       }

       return count;
   }
}
