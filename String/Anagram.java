import java.util.*;

/*
 * problem statement: Find the indices of all anagrams of a given word in a another word. 
For example: Find the indices of all the anagrams of AB in ABCDBACDAB (Answer: 0, 4, 8)
 */

public class Anagram{
	
	//returns the list of required indices
	public static List<Integer> findPositions(String pattern, String text){
		List<Integer> list = new ArrayList<Integer>();
		int phash = 0;
		int whash = 0;
		int patternLength = pattern.length();
		int[] freq = new int[26];
		//either pattern or the text is empty
		if(pattern == null || text == null) {
			System.out.println("empty input");
		}
		//pattern is longer than the text
		if(pattern.length() > text.length()) {
			System.out.println("the length of the pattern is greater than the length of the text");
			return list;	
		}
		//calculate the unique hash(phash) for the pattern
		for(int i=0; i<26; i++) {
			freq[i] = 0;
		}
		for(char c: pattern.toCharArray()) {
			freq[c-97]++;
		}
		for(int i=0; i<26; i++) {
			phash += (i+1)*freq[i]; 
		}
		System.out.println("uhash: "+phash);
		//the substring of text of same length with that of pattern and check if it is anagram of pattern
		char[] window = new char[patternLength];
		for(int i=0; i<patternLength; i++) {
			window[i] = text.toCharArray()[i];
		}
		for(int i=0; i<26; i++) {
			freq[i] = 0;
		}
		for(char c: window) {
			freq[c-97]++;
		}
		for(int i=0; i<26; i++) {
			whash += (i+1)*freq[i]; 
		}
		if(phash == whash) {
			list.add(0);
		}
		//check for anagram for the rest by sliding the window to right by one character
		char prev = window[0];
		for(int i=1; i<text.length()-patternLength+1; i++) {
			whash -= (int) prev;
			whash += (int) text.charAt(i+patternLength-1);
			if(whash == phash) {
				list.add(i);
			}
			prev = text.charAt(i);
		}
		//the list of the required indices where the anagrams of the pattern starts
		return list;
	}
	
	public static void main(String []args) {
		List<Integer> list;
		String pattern = "ggf";
		String text = "aasdggfaaasdfggdggaaasd";
		list = findPositions(pattern, text);
		System.out.println(list);
	}
}

/*
 * @test cases:
 * pattern is empty and text is non-empty
 * pattern is non-empty and text is empty
 * pattern text
 * aaaa,aaa
 * aaaa,aaaa
 * as,asasasbas
 * aa, aaaaaaaaa
 * aasd, aasdggfaaasdfgdgaaasd
 * asadsad,asdadasdfafagadf
 */
