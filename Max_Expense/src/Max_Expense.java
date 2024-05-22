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
		
		int[] midSumArr = new int[3];
		
		int m = 0;
		m = array.length / 2;
		int midIdx = m;
		
//		for(int i = m-1; i>=0; i--) {
//			int[] arrayL = new int[m];
//			if(arrayL[i] > arrayL[midIdx]) {
//				midIdx = i;
//			}
//		}
//		
//		for(int i = array.length; i>=m; i--) {
//			int[] arrayR = new int[array.length - m];
//			if(arrayR[i] > arrayR[array.length - m + 1]) {
//				midIdx = i;
//			}
//		}
		
		int[] maxArrL = new int[m];
		maxArrL = Arrays.copyOfRange(array, m-2, m);
		for(int i=m-2; i>=0; i--){
		    int[] newarr = Arrays.copyOfRange(array, i, m);
		    if (Arrays.stream(newarr).sum() > Arrays.stream(maxArrL).sum()){
		        maxArrL = newarr;
		    }
		}

		//write code to find maxArrR
		
	
		
		
		
		return midSumArr;
	}
}
