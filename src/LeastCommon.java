//ref: http://stackoverflow.com/questions/15036821/find-common-elements-in-n-sorted-arrays-with-no-extra-space
// improved over original answer to handle different length issue
// can improve to avoid extra memory
public class LeastCommon {
	public static int findLeastCommon(int[][] matrix) {
		// exception cases
		if(matrix.length==0 || matrix==null) return -1;
		for(int i=0;i<matrix.length;i++)
			if(matrix[i].length==0) return -1;
		
		int[] indices = new int[matrix.length]; //indices for each of the arrays
		boolean found;
		for(int i=0;i<matrix[0].length;i++) { // current index in matrix[0]
			found = true;
			indices[0] = i;
			for(int j=1;j<matrix.length;j++) { // search from 1 to the last
				while(matrix[j][indices[j]]<matrix[0][indices[0]] && indices[j]<matrix[j].length-1) indices[j]++;
				if(matrix[j][indices[j]]!=matrix[0][indices[0]]) found = false;
			}
			if(found==true) return indices[0];
		}
		return -1;
	}
	
	public static void main(String[] args) {
	    int[][] a = {
	            { 10, 160, 200, 500, 500, },
	            { 4, 150, 160, 170 },
	            { 2, 160, 200, 202, 203, },
	            { 3, 150, 155, 300 },
	            { 3, 150, 155, 160 } };
	    
	    System.out.print(findLeastCommon(a));
	    
	}
}