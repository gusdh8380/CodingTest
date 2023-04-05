import java.util.Scanner;

public class hw1_mergesort {
	
	public static void mergesort(int array[],int p,int r) {
		if(p<r) {
			int q = (p+r)/2;
			mergesort(array,p,q);
			mergesort(array,q+1,r);
			merge(array,p,q,r);
		}
		
	}
	
	public static void merge(int array[],int p,int q,int r) {
		int temp[] = new int[r+1];
		for(int i = p; i <=q; i++) {
			if(array[i]>array[i+1]) {
				swap(array,i,i+1);}
			temp[i] = array[i]; 
		}
		for(int i = q+1; i <=r; i++) {
			if(array[i]>array[i+1]) {
				swap(array,i,i+1);}
			temp[i] = array[i]; 
		}
		for(int i=p;i<=r;i++)
		  array[i] = temp[i];
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
		
		mergesort(a,0,n-1);
		
		for(int i =0; i<n;i++) {
			
			System.out.print(a[i]+ " ");
	}
		sc.close();
	}
}