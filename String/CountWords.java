
public class CountWords{
	
	public static int count(String str) {
		boolean insideWord = false;
		int count = 0;
		for(char c: str.toCharArray()) {
			if(c >=65 && c<= 90 || c>=97 && c<=122) {
				if(insideWord == false) {
					count++;
					insideWord = true;
				}
			}
			else {
				if(insideWord) {
					insideWord = false;
				}
			}
		}
		return count;
	}
	
	public static void main(String []args) {
		String input = " hi i am sidharth. ";
		int result = count(input);
		System.out.println("input is: "+input);
		System.out.println("number of words in the sentence is: "+result);
			
	}
}