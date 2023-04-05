package CodingText_Algorithm;


import java.util.Scanner;

public class hw1_bublesort {
	public static void bublesort(int array[],int n) {
		for(int last = n; last>=1;last--) {
			boolean sorted = true;
			for(int i=0; i<=last-1;i++) {
				if(array[i]>array[i+1]) {
					swap(array,i,i+1);
					sorted = false;
				}
			}
			if(sorted == true)
				return;
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
		int []a = new int[n];

		for(int i=0; i<n; i++ ) {
			a[i] = sc.nextInt(); 
		}
		sc.close();
		bublesort(a,n-1);

		for(int i =n-1; i >=0;i--)
		{
			System.out.print(a[i]+" ");

	}
	}
}


