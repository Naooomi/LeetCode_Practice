import java.util.ArrayList;
import java.util.List;

/**

	Description:
	
	A self-dividing number is a number that is divisible by every digit it contains.
	
	For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
	
	Also, a self-dividing number is not allowed to contain the digit zero.
	
	Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

*/

public class selfDividingNumbers {
    public List<Integer> solution(int left, int right) {

        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (selfDividing(i)) {
                res.add(i);
            }
        }
        return res;

    }

    private boolean selfDividing (int num) {
        int cur = num;
        while (cur != 0) {
            int digit = cur % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            cur /= 10;
        }
        return true;

    }
}
