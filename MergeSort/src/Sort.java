import java.util.Arrays;
import java.util.Scanner;

public class Sort {

	public static void main(String[] args) {
	
		System.out.println("==input numbers.==");
		System.out.println("1. Quick Sort\n"
							+ "2. Merge Sort");
//		
		Scanner sc = new Scanner(System.in);
//		String trimInput = input.trim();
		int num = 0;
//		
//		//¹Þ¾Æ¼­ String[]·Î ÂÉ°µ ¼ýÀÚ
//		String[] splitInt = trimInput.split(",");
		
		
		num = sc.nextInt();
		
		//quick sort
		if(num == 1) {
			System.out.println("==input numbers with comma==");
			
			Scanner scan = new Scanner(System.in);
			String input = scan.next();
			
			QuickSort quickSort = new QuickSort();
			
			long beforeTime = System.currentTimeMillis();
			
			 
			String[] inputArr = input.split(",");
			//String[] -> int[]
			int[] test = Arrays.stream(inputArr).mapToInt(Integer::parseInt).toArray();
			
			quickSort.quickSort(test);
			
			
			
			
		//merge sort
		}else if(num == 2) {
			System.out.println("==input numbers with comma==");
			
			Scanner scan = new Scanner(System.in);
			String input = scan.next();
			
			MergeSort mergeSort = new MergeSort();
			
			long beforeTime = System.currentTimeMillis();
			
			 
			String[] inputArr = input.split(",");
			//String[] -> int[]
			int[] test = Arrays.stream(inputArr).mapToInt(Integer::parseInt).toArray();
			
			System.out.println(Arrays.toString(mergeSort.mergeSort(test)));
			long afterTime = System.currentTimeMillis();
			
			long diffTime = (afterTime - beforeTime)/1000;
			System.out.println("elapsed time : " + diffTime +"s");
		}else {
			System.out.println("Wrong number.");
		}
		
		
		
		
	}

}
