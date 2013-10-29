package ArrayAndString;

public class StringToInteger {

	public static int atoi2(String str) {
		// Note: The Solution object is instantiated only once and is reused by each test case.
		int result=0;
		for(int i=str.length()-1, w=0;i>=0;--i) {
			if(str.charAt(i)=='-') return -result;
			if(str.charAt(i)=='+') return result;
			if(str.charAt(i)!=' ') {
				result += ((int)(str.charAt(i))-48)*Math.pow(10,w);
				w++;
			}
		}
		return result;
	}

	public static int atoi(String str) {
		// Note: The Solution object is instantiated only once and is reused by each test case.
		int result=0;
		int sign=1;
		boolean first_sign = true;
		boolean first_spaces = true;
		for(int i=0;i<str.length();++i) {
		    if(str.charAt(i)==' '&&first_spaces==true) continue;
		    else if(first_sign==true&&(str.charAt(i)=='+'||str.charAt(i)=='-')) {
		        first_spaces = false;
		        first_sign = false;
		        sign = str.charAt(i)=='+'?1:(-1);
		    }
		    else if((str.charAt(i)>='0')&&(str.charAt(i)<='9')) {
		        first_spaces = false;
//		        int tmp = result*10 + ((int)str.charAt(i)-48);
//		        if(tmp<result) return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
//		        else result = tmp;
		        if(sign==1&&(result>(Integer.MAX_VALUE-((int)str.charAt(i)-48))/10.0)) return Integer.MAX_VALUE;
		        else if(sign==(-1)&&(result>(Integer.MIN_VALUE+((int)str.charAt(i)-48))/(-10.0))) return Integer.MIN_VALUE;
		        else result = result*10 + ((int)str.charAt(i)-48);
		    } else break;
		}
        return sign*result;
	}
	
	
	public static void main(String[] args) {
		String str = " -10522545459";
		System.out.println(atoi2(str));
		System.out.println(atoi(str));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE+1);
	}
}
