
public class Diameter{
	
	public static int diameter(node root) {
		if(root == null) return 0;
		int leftDiameter = diameter(root.left);
		int rightDiamter = diameter(root.right);
		return Math.max(height(root.left)+height(root.right)+1, Math.max(leftDiameter, rightDiamter));
	}
	
	public static int height(node root) {
		if(root == null) return 0;
		return Math.max(height(root.left), height(root.right))+1;
	}
	
	public static void main(String []args) {
		node root;
		root = new node(3);
		node temp = root;
		temp.left = new node(6);
		temp.right = new node(8);
		temp.left.left = new node(2);
		temp.left.right = new node(11);
		temp.left.right.left = new node(9);
		temp.left.right.left.left = new node(15);
		temp.left.right.right = new node(5);
		temp.right.right = new node(13);
		temp.right.right.left = new node(7);

		int diameter = diameter(root);
		System.out.println("Diameter of the tree is: "+diameter);
	}
}