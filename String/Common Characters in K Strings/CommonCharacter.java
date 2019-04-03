import java.util.*;


public class CommonCharacter{
	
	public static List<Character> common(List<String> list){
		List<Character> result = new ArrayList<Character>();
		int[] arr = new int[256];
		for(int i=0; i<256; i++)
			arr[i] = 0;
		for(char c: list.get(0).toCharArray()) {
			if(arr[c] == 0) {
				arr[c] = 1;
			}
		}
		for(String s: list) {
			for(char c: s.toCharArray()) {
				if(arr[(int)c] == 1) {
					arr[(int)c] = 2;
				}
			}
			for(int i=0; i<256; i++) {
				if(arr[i] == 2) {
					arr[i] = 1;
				}
				else {
					arr[i] = 0;
				}
			}
		}
		for(int i=0; i<256; i++) {
			if(arr[i] == 1) {
				result.add((char)(i));
			}
		}
		return result;
	}
	
	public static void main(String []args) {
		List<String> list = new ArrayList<String>();
		List<Character> result = new ArrayList<Character>();
		list.add("sidharth.");
		list.add("avinash.");
		list.add("Mr.Chandan");
		result = common(list);
		System.out.println("the input strings are: ");
		System.out.println(list);
		System.out.println("and the common characters are: "+result);
	}
}