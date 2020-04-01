package programmersProject;

import java.util.Arrays;

public class Array01_KthNumber {
	public static void main(String[] args) {
		int[] array = {1,5,2,6,3,7,4};
		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
		
		int[] rtn = solution(array, commands);
	}
	
	public static int[] solution(int[] array, int[][] commands) {
		int commandsCnt = commands.length;
		int[] answer = new int[commandsCnt];
		for(int i=0; i<commandsCnt; i++){
			int strCnt = commands[i][0];
			int endCnt = commands[i][1];
			int rtnValue = commands[i][2]-1;
			
			
			int[] rtnArrays = Arrays.copyOfRange(array, strCnt-1, endCnt);
			Arrays.sort(rtnArrays);
			answer[i] = rtnArrays[rtnValue];
			
			
//			int arrayCnt = endCnt-strCnt+1;
//			System.out.println("arrayCnt : "+arrayCnt); 
//			int[] editArrray = new int[arrayCnt];
//			int p = 0;
//			for(int j=strCnt-1; j<endCnt; j++){
//				System.out.println("array["+j+"] --> "+array[j]);
//				editArrray[p]=array[j];
//				
//				System.out.println(i+" 번째 "+p+"번" + editArrray[p]);
//				p++;
//				
//			}
//			Arrays.sort(editArrray);
//			System.out.println("return될 값 :: "+editArrray[rtnValue]);
//			
//			answer[i] = editArrray[rtnValue];
//			System.out.println("-----------------------------");
		}
        
        return answer;
    }
	
}
