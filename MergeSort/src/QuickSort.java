
public class QuickSort {

	public int[] quickSort(int[] input) {
		
		//base case
		if(input.length<2) {
			return input;
		}
		
		//임의의 기준 pivot
		int pivot = 0;
		int pivotValue = 0;
		
		pivot = input.length / 2;
		pivotValue = input[pivot];
		
		
		
		//int 배열을 pivot 기준으로 둘로 나눈다.
		int[] half = new int[pivot];
		int[] frontArr = new int[half.length];
		int[] backArr = new int[input.length - half.length];
		
		
		for(int i = 0; i<half.length; i++) {
			frontArr[i] = input[i];
		}
		
		for(int i = 0; i<input.length - half.length; i++) {
			backArr[i] = input[i+half.length];
		}
		
		int[] arrA = quickSort(frontArr);
		int[] arrB = quickSort(backArr);
		
		
		return quick(arrA, arrB, pivotValue);
		
	}
	
	
	
	private int[] quick(int[] frontArr, int[] backArr, int pivotValue) {
		
		int[] quickArr = new int[frontArr.length + backArr.length];
		
		int front = 0;
		int back = 0;
		int newSum = 0;
		
		for(int i = 0; i <quickArr.length; i++) {
			
			while(frontArr[i]<pivotValue) {
				quickArr[newSum++] = frontArr[i];
			}
			
//			while()
		}
		
		
		while(quickArr[back] > pivotValue) {
			quickArr[newSum++] = backArr[back--];
		}
		
		
		
		return quickArr;
	}
}
