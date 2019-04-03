import java.util.List;
import java.util.ArrayList;

public class BSTtoMinHeap{
	public static List<Integer> list = new ArrayList<Integer>();
	public static int index = 0;
	
	public static node constructMinHeap(node root) {
		List<Integer> inOrder = inOrderTraversal(root);
		buildMinHeap(root, inOrder);
		return root;
	}
	
	public static void buildMinHeap(node root, List<Integer> inOrder) {
		if(root == null) return;
		root.value = inOrder.get(index++);
		buildMinHeap(root.left, inOrder);
		buildMinHeap(root.right, inOrder);
	}
	
	public static List<Integer> inOrderTraversal(node root){
		list.clear();
		inOrder(root);
		return list;
	}
	
	public static void inOrder(node root) {
		if(root == null) return;
		inOrder(root.left);
		list.add(root.value);
		inOrder(root.right);
	}
	
	public static void inOrderDisplay(node root) {
		if(root == null) return;
		inOrderDisplay(root.left);
		System.out.print(root.value+" ");
		inOrderDisplay(root.right);
	}
	
	public static void preOrderDisplay(node root) {
		if(root == null) return;
		System.out.print(root.value+" ");
		preOrderDisplay(root.left);
		preOrderDisplay(root.right);
	}
	
	public static void main(String []args) {
		node root;
		root = new node(8);
		node temp = root;
		temp.left = new node(3);
		temp.right = new node(9);
		temp.left.left = new node(2);
		temp.left.right = new node(6);
		temp.left.right.left = new node(5);
		temp.left.right.right = new node(7);
		temp.right.right = new node(13);
		temp.right.right.left = new node(11);
		
		System.out.println("in-Order traversal of the BST");
		inOrderDisplay(root);
		System.out.println();
		root = constructMinHeap(root);
		System.out.println("pre-Order traversal of the min-Heap");
		preOrderDisplay(root);
		System.out.println();	
		System.out.println("Both are same");
	}
}