import java.util.Arrays;

public class Max_Expense {
	public int[] maxSubArr(int[] array) {
		
		int[] frontArr = new int[array.length / 2];
		int[] backArr = new int[array.length - frontArr.length];
		
		if(array.length < 2) {
			return array;
		}
		
		int sumA = 0;
		int sumB = 0;
		int sumM = 0;

		frontArr = Arrays.copyOfRange(array, 0, frontArr.length);
		backArr = Arrays.copyOfRange(array, frontArr.length, array.length);
		
		
		int[] arrayA = maxSubArr(frontArr);
		int[] arrayB = maxSubArr(backArr);
		int[] arrayM = midMaxSubArr(array);
		
		sumA = Arrays.stream(arrayA).sum();
		sumB = Arrays.stream(arrayB).sum();
		sumM = Arrays.stream(arrayM).sum();
		
		int[] maxSumArr = {sumA, sumB, sumM};
		int maxIndex = 0;
		
		for (int i = 0; i < maxSumArr.length; i++) {
		    if (maxSumArr[i] > maxSumArr[maxIndex]) {
		        maxIndex = i;
		    }
		}
		
		if(maxIndex == 0) {
			return arrayA;
		}
		
		if(maxIndex == 1) {
			return arrayB;
		}
		
		return arrayM; 
		
	}
	
	public int[] midMaxSubArr(int[] array) {
		
		
//		array = [1,3,-2,4]
		int m = 0;
		m = array.length / 2;
		int midIdx = m;

		int[] maxArrL = new int[m];
		int[] maxArrR = new int[m];
		int[] currentArr = new int[m];
		
		
		int sumArr = 0;
		
		maxArrL = Arrays.copyOfRange(array, m-1, m);
		
		for(int i = m-1; i>=0; i--) {
			currentArr = Arrays.copyOfRange(array, i, m);
			if(Arrays.stream(currentArr).sum() > Arrays.stream(maxArrL).sum()) {
				maxArrL = currentArr;
			}
		}
		
		maxArrR = Arrays.copyOfRange(array, m, m+1);
		
		for(int i = m; i<array.length; i++) {
			currentArr = Arrays.copyOfRange(array, m, i+1);
			if(Arrays.stream(currentArr).sum() > Arrays.stream(maxArrR).sum()) {
				maxArrR = currentArr;
			}
		}
		
		int[] midSumArr = new int[maxArrL.length + maxArrR.length];
		
		System.arraycopy(maxArrL, 0, midSumArr, 0, maxArrL.length);
		System.arraycopy(maxArrR, 0, midSumArr, maxArrL.length, maxArrR.length);
		
		
		return midSumArr;
	}
}
