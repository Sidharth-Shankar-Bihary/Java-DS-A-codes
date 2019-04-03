
public class BinarySearch {
	
	public static int BS(int[] arr, int key) {
		System.out.println("this is binary search recursive");
		return(BS1(arr, key, 0, arr.length-1));
		
	}
	
	public static int BS1(int[] arr, int key, int low, int high) {
		
		if(low > high) return -1;
		
		int mid = low + (high - low)/2;
		
		if(arr[mid] == key) return mid;
		
		else if(key > arr[mid]) {
			low = mid + 1;
			return(BS1(arr, key, low, high));
		}
		
		else{
			high = mid - 1;
			return(BS1(arr, key, low, high));
		}
		
	}
	
	public static int FindNumberOfOccurrence(int[] arr, int key) {
		if(FindLastOccurrence(arr, key, 0, arr.length) == -1) return 0;
		else return(FindLastOccurrence(arr, key, 0, arr.length) - FindFirstOccurrence(arr, key, 0, arr.length) + 1);
	}
	
	public static int FindFirstOccurrence(int[] arr, int key, int low, int high) {
		int mid = low + (high - low)/2; 
		
		if(low > high) return -1;
		if(arr[mid] == key) {
			if(arr[mid-1] != key || mid == 0) return mid;
			else {
				high = mid - 1;
				return(FindFirstOccurrence(arr, key, low, high));
			}
		}
		if(key > arr[mid]) {
			low = mid + 1;
			return(FindFirstOccurrence(arr,key, low, high));
		}
		else {
			high = mid - 1;
			return(FindFirstOccurrence(arr, key, low, high));
		}
	}
	
	
	public static int FindLastOccurrence(int[] arr, int key, int low, int high) {
		int mid = low + (high - low)/2;
		
		if(low > high) return -1;
		if(arr[mid] == key) {
			if(arr[mid+1] != key || mid == arr.length) return mid;
			else {
				low = mid + 1;
				return(FindLastOccurrence(arr, key, low, high));
			}
		}
		if(key > arr[mid]) {
			low = mid + 1;
			return(FindLastOccurrence(arr, key, low, high));
		}
		else {
			high = mid - 1;
			return(FindLastOccurrence(arr, key, low, high));
		}
	}
	
	public static int BinarySearchIterative(int[] arr, int key) {
		System.out.println("this is binary search iterative");
		return(BSI(arr, key, 0, arr.length - 1));
	}
	
	public static int BSI(int[] arr, int key, int low, int high) {
		int mid;
		while(low <= high) {
			mid = low + (high - low)/2;
			if(arr[mid] == key) return mid;
			else if(key < arr[mid]) high = mid - 1;
			else low = mid + 1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,7,12,24,25,34,56,58,78,89,98};
		int key = 12;
		int value = BS(arr, key);
		for(int i:arr) System.out.print(i+" ");
		System.out.println();
		if (value == -1) System.out.println("element "+key+" not found in the array");
		else System.out.println("element "+key+" found at index "+value);
		
		int value1 = BinarySearchIterative(arr, key);
		for(int i:arr) System.out.print(i+" ");
		System.out.println();
		if(value == -1) System.out.println("element "+key+" is not found");
		else System.out.println("element "+key+" is found at index "+value);
		
		int[] arr1 = {2,5,6,7,7,7,7,7,7,12,14,15,17,18,20,34,43,45,56,67};
		int key1 = 4;
		int occurrence = FindNumberOfOccurrence(arr1, key1);
		for(int i:arr1) System.out.print(i+" ");
		System.out.println();
		if(occurrence == -1) System.out.println("element "+key1+" not found in the array");
		else System.out.println("number of occurrence of "+key1+" is "+occurrence);
	}

}
