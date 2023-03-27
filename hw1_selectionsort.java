
import java.util.Scanner;
public class hw1_selectionsort {
	
	public static void selectionSort(int []array,int n){
		for(int last = n; last>=1; last--){
			int k = Largest(array,last);   //t는 가장 큰 수의 인덱스
			swap(array, k, last);          // 가장 큰 수의 인덱스와 가장 뒤의 인덱스값 교환
			
			
			for(int i =0; i<=n; i++)
			System.out.print(array[i]+ " ");
			System.out.println(" ");
		}
		//2) a[1~마지막 중 가장 큰수
		//3) 교환
		
	}
	
	public static int Largest(int[]array,int n) {
		int Large =0; 
		for(int i = 1; i<=n; i++) {
			if(array[i] > array[Large]) {
				Large = i;
			}
		}
		return Large;
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
		
		selectionSort(a,n-1);
		System.out.print("= ");
		for(int i =0; i<n;i++) {
			
			System.out.print(a[i]+ " ");
		}
		
	}

}
