/**

	Description:
	
	Given a 32-bit signed integer, reverse digits of an integer.

*/

public class reverse {
    public int solution(int x) {

        int result = 0;

        int flag = x<0?-1:1;
        x=x*flag;


        while (x>0){
        // after the multiply is should not exceed
            if(Integer.MAX_VALUE/10<result){
                return 0;
            }
        // after the multiply and the increase, it should not exceed
            if(Integer.MAX_VALUE -result*10 < (x%10)){
                return 0;
            }
            result = (x%10)+result*10;
            x/=10;
        }

        return result*flag;
    }
}
