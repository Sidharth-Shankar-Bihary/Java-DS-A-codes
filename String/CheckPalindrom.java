import java.lang.Character;
public class CheckPalindrom {
	
	public static boolean CheckPalindromString(String s) {
		int low = 0;
		int high = s.length() - 1;
		while(low <= high) {
			while((int)Character.toLowerCase(s.charAt(low)) < 97 && (int)Character.toLowerCase(s.charAt(low)) > 57 || (int)Character.toLowerCase(s.charAt(low)) < 48 || (int)Character.toLowerCase(s.charAt(low)) > 122)
				low++;
			while((int)Character.toLowerCase(s.charAt(high)) < 97 && (int)Character.toLowerCase(s.charAt(high)) > 57 || (int)Character.toLowerCase(s.charAt(high)) < 48 || (int)Character.toLowerCase(s.charAt(high)) > 122)
				high--;
			if(Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high))) return false;
			else {
				low++;
				high--;
			}
		}
		return true;
	}

	public static boolean CheckPalindromNumbers(int a, int b) {
		String s1 = Integer.toString(a);
		String s2 = Integer.toString(b);
		
		if(s1.length() != s2.length()) return false;
		int counter1 = 0;
		int counter2 = s2.length() - 1;
		while(counter2 >= 0) {
			if(s1.charAt(counter1) == s2.charAt(counter2)) {
				counter1++;
				counter2--;
			}
			else return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s1 = "Stella won no wallets";
		String s2 = "No, it is open on one position.";
		String s3 = "Rise to vote, Sir.";
		String s4 = "123Won't lovers revolt now?321";
		String s5 = "123454321";
		int number1 = 123;
		int number2 = 321;
		
		boolean bool = CheckPalindromString(s5);
		System.out.println(s5);
		if(bool == true) System.out.println("the string is palindrom");
		else System.out.println("the string is not palindrom");
		
		boolean bool1 = CheckPalindromNumbers(number1, number2);
		if(bool1 == true) System.out.println("the two numbers "+number1+" and "+number2+" are palindrom");
		else System.out.println("the two numbers "+number1+" and "+number2+" are not palindrom");
	}

}
