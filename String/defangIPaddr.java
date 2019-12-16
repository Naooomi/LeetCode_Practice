/**
    1108. Defanging an IP Address
    
    Description:
    Given a valid (IPv4) IP address, return a defanged version of that IP address.
    A defanged IP address replaces every period "." with "[.]".

    Example 1:
    Input: address = "1.1.1.1"
    Output: "1[.]1[.]1[.]1"
    
    Example 2:
    Input: address = "255.100.50.0"
    Output: "255[.]100[.]50[.]0"

    Constraints:
    The given address is a valid IPv4 address.
*/

public class defangIPaddr {
	/**
	 * Solution One
	*/
    public String solution1(String address) {
        String result = "";
        
        for (int i = 0; i < address.length(); i++)
        {
            if (address.charAt(i) == '.')
            {
                result += "[.]";
                continue;
            }
            else
                result += address.charAt(i);
        }
        
        return result;
    }

	/**
	 * Solution Two
	*/
    public String solution2(String address) {
        String result = address.replace(".", "[.]");
            
        return result;
    }
}
