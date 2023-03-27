//6 정렬 위에서 아래로_qiuckSort 알고리즘으로 구현
import java.util.Scanner;
public class hw1 {

	public static void quicksort(int[]array,int p,int r) {
		if(p<r) {
			int q = patition(array,p,r);
			quicksort(array,p,q-1);
			quicksort(array,q+1,r);
		}
	}

	public static int patition(int[]array,int p,int r) {

		int pivot = array[r];
		int i = p-1;

		for(int j = p; j<r; j++) {
			if(array[j]<pivot) {
				swap(array,++i,j);
			}

		}
		swap(array,i+1,r);
		return i+1;


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
		quicksort(a,0,n-1);

		for(int i =n-1; i >=0;i--)
		{
			System.out.print(a[i]+" ");
		}
	}
}
