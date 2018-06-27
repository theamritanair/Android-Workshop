import java.util.*;

public class BinarySearchExample{


	public boolean binarySearch( int sortedArray[],
							  int left,
							  int right,
							  int key){
		while(left<=right){

			int mid = left + (right-left)/2;
			if(sortedArray[mid]==key){
					return true;
			} 
			else if( sortedArray[mid]>key){
				right = mid-1;
			}
			else if(sortedArray[mid]<key){

				left = mid +1;
			}

	}
	return false;

	}

	public static void main(String[] args) {


			int[] unsortedArray = new int[10];
		for(int i=0;i<unsortedArray.length;i++){
			unsortedArray[i]= 1+(int)(Math.random()*10);
		}

		System.out.println();
		System.out.println("Unsorted Array");
		for(int i=0;i<unsortedArray.length;i++){

			System.out.print(unsortedArray[i]+ " ");
		}
		System.out.println();
		System.out.println("Sorted Array ");
		Arrays.sort(unsortedArray);

		for(int i=0;i<unsortedArray.length;i++){

			System.out.print(unsortedArray[i]+ " ");
		}
		System.out.println();

		BinarySearchExample bin = new BinarySearchExample();
		System.out.println(bin.binarySearch(unsortedArray,0,9,0));

		System.out.println(Arrays.binarySearch(unsortedArray,8));

	}
}