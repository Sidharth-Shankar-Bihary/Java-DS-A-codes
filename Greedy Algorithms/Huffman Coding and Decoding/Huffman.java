import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Map;

public class Huffman{
	public static Map<Character, String> map = new HashMap<Character, String>();
	
	public static void generateHuffmanCode(String str) {
		if(str.length() == 0) {
			System.out.println("empty string");
			return;
		}
		int[] freq = new int[26];
		node root;
		PriorityQueue<node> pq = new PriorityQueue<node>((a,b)->a.freq-b.freq);
		for(char c: str.toCharArray()) {
			freq[c-97]++;
		}
		for(int i=0; i<26; i++) {
			if(freq[i] > 0) {
				pq.add(new node((char)(i+97), freq[i]));
			}
		}
		if(pq.size() == 1) {
			map.put(pq.peek().value, "0");
		}
		else {
			while(pq.size()>1) {
				node a = pq.peek();
				pq.remove();
				node b = pq.peek();
				pq.remove();
				pq.add(new node(a.freq+b.freq, a, b));
				root = pq.peek();
			}
			root = pq.peek();
			generateCode(root, map, "");
		}
		System.out.println("the input string is: \n"+str);
		System.out.println("the Huffman code table is: ");
		for(char c: map.keySet()) {
			System.out.println(c+": "+map.get(c));
		}
		System.out.println("and the encoded message is: ");
		for(char c: str.toCharArray()) {
			System.out.print(map.get(c));
		}
		
	}
	
	public static void generateCode(node root, Map<Character, String> map, String str) {
		if(root == null) return;
		if(root.left == null && root.right == null) {
			map.put(root.value, str);
			return;
		}
		generateCode(root.left, map, str+0);
		generateCode(root.right, map, str+1);
	}
	
	public static void main(String []args) {
		String input = "avinash";
		generateHuffmanCode(input);
	}
}