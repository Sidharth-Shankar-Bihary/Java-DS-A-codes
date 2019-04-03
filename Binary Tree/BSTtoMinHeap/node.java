

public class node{
	
		int value;
		node left;
		node right;
		
		public node(int k){
			this.value = k;
			left = right = null;
		}
		
		public node(int k, node left, node right) {
			this.value = k;
			this.left = left;
			this.right = right;
		}
	
}