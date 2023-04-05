package CodingText_Algorithm;

import java.util.Scanner;

public class hw1_insertionsort {
	public static void insertionSort(int array[], int n) {
		for(int i = 1;i<=n; i++) {
			int loc = i-1;
			int newitem = array[i];
			while(loc>=0&&newitem<array[loc]) {
			    swap(array,loc+1,loc);
			    loc--;
			}
			array[loc+1]= newitem;
		}
		
	}
	private static void swap(int[] array, int i, int j) {	
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n] ;
		
		
		for(int i =0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		insertionSort(a,n-1);
		
		for(int i =0; i<n;i++) {
			
			System.out.print(a[i]+ " ");
	}
	sc.close();

}
}
