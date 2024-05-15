
public class Inversion {
	
	public String[][] inversionCnt(int[] arr) {
		int[] Aarr = {5,4,3,2,1};
		
		int aLength = Aarr.length;
		
		int[] frontArr = new int[aLength/2];
		int[] backArr = new int[aLength - frontArr.length];
		String[][] mergeArr = new String[aLength][1];
		
		//base case
		if(aLength<2) {
			return arr,0;
		}
		
		for(int i = 0; i<aLength/2; i++) {
			frontArr[i] = Aarr[i];
		}
		
		for(int i = 0; i<aLength - frontArr.length; i++) {
			backArr[i] = Aarr[i + (aLength/2)];
		}
		
		int cntA = inversionCnt(frontArr);
		int cntB = inversionCnt(backArr);
		
		int cntC = merge(frontArr, backArr);
		return ;
	}
}
