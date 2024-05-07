import java.util.Arrays;

public class MergeSort {

	public int[] mergeSort(int[] input) {
		//base case
		if(input.length<2) {
			return input;
		}
		
		// 받아온 int 배열을 둘로 나눈다.
		int[] half = new int[input.length / 2];
		int[] frontArr = new int[half.length];
		int[] backArr = new int[input.length-half.length];
		
		
		
		for(int i = 0; i<half.length; i++) {
			frontArr[i] = input[i];
		}
		
		for(int i = 0; i<input.length-half.length; i++) {
			backArr[i] = input[i+half.length];
		}
		
			
		int[] arrA = mergeSort(frontArr);
		int[] arrB = mergeSort(backArr);
		//////divide///////
		
		return merge(arrA, arrB);
	}
	
	
	private int[] merge(int[] frontArr, int[] backArr) {
		
		int[] mergeArr = new int[frontArr.length + backArr.length];
		
		int front = 0;
		int back = 0;
		int newSum = 0;
		
		while(front<frontArr.length && back<backArr.length) {
			if(frontArr[front] <= backArr[back]) {
				mergeArr[newSum++] = frontArr[front++];
			}else {
				mergeArr[newSum++] = backArr[back++];
			}
		}
		
		while(front < frontArr.length) {
			mergeArr[newSum++] = frontArr[front++];
		}
		
		while(back < backArr.length) {
			mergeArr[newSum++] = backArr[back++];
		}
		
		
		return mergeArr;

		
//		public static void merge(
//				  int[] a, int[] l, int[] r, int left, int right) {
//				 
//				    int i = 0, j = 0, k = 0;
//				    while (i < left && j < right) {
//				        if (l[i] <= r[j]) {
//				            a[k++] = l[i++];
//				        }
//				        else {
//				            a[k++] = r[j++];
//				        }
//				    }
//				    while (i < left) {
//				        a[k++] = l[i++];
//				    }
//				    while (j < right) {
//				        a[k++] = r[j++];
//				    }
//				}
		
		//a,b가 empty할때까지
		//min(a[0],b[0])
		
	}
}
