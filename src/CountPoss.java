
public class CountPoss {
//	public static int count(String s, int[] poss, int current){
//		if(s==null || s.length()==0) return -1;
//		if(current==s.length()-1) return 1;
//		if(current>s.length()-1) return 1; // this is calculated by reduction from when current is third to last.
//		if(s.charAt(current)=='1' || (s.charAt(current)=='2' && s.charAt(current+1)<='6')) 
//			if(poss[current+1]!=0 && poss[current+2]!=0)
//				return poss[current] = poss[current+1] + poss[current+2];
//			else
//				return poss[current]=count(s, poss, current+1)+count(s, poss, current+2);
//		else {
//			if(poss[current+1]!=0)
//				return poss[current]=poss[current+1];
//			else
//				return poss[current] = count(s, poss, current+1);
//		}
//	}
	
	public static int count(String s) {
		
		int cn= 1, cnn = 1, crr = 0;
		for (int i = s.length()-2; i >= 0; --i) {
			if (s.charAt(i) == '1' || (s.charAt(i)=='2' && s.charAt(i+1)<='6')) {
				crr = cn + cnn;
			} else {
				crr = cn;
			}
			cnn = cn;
			cn = crr;
		}
		
		return crr;
		
	}

	public static void main(String[] args) {
		String s = "12326";
		int[] poss = new int[s.length()];
		//System.out.print(CountPoss.count(s, poss, 0));
		System.out.println(count(s));
	}
}
