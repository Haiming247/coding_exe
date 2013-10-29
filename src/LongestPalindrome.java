
public class LongestPalindrome {
	public static int flp(String s, int[][] map, int i, int j) {
		if(i==j) return map[i][j]=1;
		if(s.charAt(i)==s.charAt(j)) {
			if(map[i+1][j-1]!=0) {
				map[i][j] = map[i+1][j-1] +2;
			} else {
				map[i][j] = flp(s, map, i+1, j-1) +2;
			}
		} else {
			map[i][j] = Math.max(flp(s, map, i, j-1), flp(s, map, i-1,j));
		}
		return map[i][j];
	}

	public static String retrieve(String s, int[][] map) {
		return s;
	}

	public static void main(String[] args) {
		String myString = "asdffdsaede";
		int[][] map = new int[myString.length()][myString.length()];
		
		int longestLength = flp(myString, map, 0, myString.length());
		
		

	}
}
