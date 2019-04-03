
public class BitonicArray {

	public static int BA(int[] arr) {
		return(BA1(arr, 0, arr.length));
	}
	
	public static int BA1(int[] arr, int low, int high) {
		int mid = low + (high-low)/2;
		
		if(low > high) return -1;
		if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
		
		else if(arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]) {
			low = mid + 1;
			return(BA1(arr, low, high));
		}
		
		else {
			high = mid - 1;
			return(BA1(arr, low, high));
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {3,25,35,34,22,17,8,6,4,2,1};
		for(int i:arr) System.out.print(i+" ");
		System.out.println();
		int value = BA(arr);
		if(value == -1) System.out.println("check the array, the array may not be bitonic");
		else System.out.println("the bitonic point is at "+arr[value]);
	}
}
