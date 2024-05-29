import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		String fileName = null;
		List<List<String>> csvData = null;
		
		System.out.println("File 이름를 입력해주세요");
		Scanner sc = new Scanner(System.in);
		
		fileName = sc.next();
		
		CSVReader csvReader = new CSVReader();
		csvData = csvReader.readCSV("C:\\Users\\gmltj\\Desktop\\Practice_Project\\expense_data\\" + fileName);
		
		
		int[] defaultArr = getAmount(csvData);
		
		Max_Expense maxExpense = new Max_Expense();
		int[] aaa = maxExpense.maxSubArr(defaultArr);
		
		System.out.println(Arrays.toString(aaa));
		
	}
	
	public static int[] getAmount(List<List<String>> data) {
		
		int csvDataSize = data.size();
		int[] amount = new int[csvDataSize];
		
		for(int i = 0; i<csvDataSize; i++) {
			amount[i] = Integer.parseInt(data.get(i).get(2));
		}
		
		
		return amount;
	}
}
