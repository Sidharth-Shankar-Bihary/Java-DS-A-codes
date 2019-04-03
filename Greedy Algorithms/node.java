
public class node{
	char value;
	int freq;
	node left;
	node right;
	
	public node(char value, int freq) {
		this.value = value;
		this.freq = freq;
		left = right = null;
	}
	
	public node(int freq, node left, node right) {
		this.freq = freq;
		this.left = left;
		this.right = right;
	}
	
}