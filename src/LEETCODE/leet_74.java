package LEETCODE;

public class leet_74 {
	
	public static void main(String[] args) {
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 3;
		
		System.out.println(searchMatrix(matrix, target));
	}
	
    public static boolean searchMatrix(int[][] matrix, int target) {
    	int rowLen = matrix.length; // 행 길이
    	int colLen = matrix[0].length; // 열 길이
    	
    	if(matrix[0][0] > target || matrix[rowLen-1][colLen-1] < target) { return false; }
    	
    	for(int i=0; i<rowLen; i++) {
    		if(matrix[i][0] <= target && matrix[i][colLen-1] >= target) {
    			for(int j=0; j<colLen; j++) {
    				if(matrix[i][j] == target) {
    					return true;
    				}
    			}
    			return false;
    		}
    	}
    	
    	return false;
    	
    }
}
