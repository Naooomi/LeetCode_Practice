/**
  
	344. Reverse String
	
	Description
	Write a function that takes a string as input and returns the string reversed.

*/

public class reverseString {
	public String solution(String s) {
		StringBuffer sb = new StringBuffer(s);
		
		return sb.reverse().toString();
	}
}
