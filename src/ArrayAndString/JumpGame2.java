package ArrayAndString;

public class JumpGame2 {
    public static int jump(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(A==null||A.length<=1) return 0;
        int[] eachMinJump = new int[A.length];
        for(int i=0;i<eachMinJump.length;++i) eachMinJump[i] = Integer.MAX_VALUE;
        return jumpHelper(0, A, eachMinJump);
    }
    
    public static int jumpHelper(int cur, int[] A, int[] eachMinJump) {
        if(cur==A.length-1) return 0;
        else
            if(A[cur]<=0) return Integer.MAX_VALUE;
            else
                if(A[cur]>=(A.length-1-cur)) return eachMinJump[cur]=1;
                else {
                    for(int i=1;i<A.length-1-cur;i++) {
                        if(eachMinJump[cur+i]==Integer.MAX_VALUE) eachMinJump[cur+i] = jumpHelper(cur+i, A, eachMinJump);
                        eachMinJump[cur] = Math.min(eachMinJump[cur], eachMinJump[cur+i]+1);
                    }
                    return eachMinJump[cur];
                }
    }
    
    public static int jump_greedy(int[] A) {
        // try greedy
        if(A==null || A.length<=1) return 0;
        int cnt = 0;
        int start = 0;
        int end = 0;
        while(true) {
            int curMaxEnd=end;
            cnt++;
            for(int i=start;i<=end;++i) {
                if((A[i]+i)>curMaxEnd) curMaxEnd=A[i]+i;
                if(curMaxEnd>= A.length-1) return cnt;
            }
            start = end+1;
            end = curMaxEnd;
            if(end<start) return -1;
        }
    }
    
    public static void main(String[] args) {
    	int[] myArray = {2,3,1,1,4};
    	System.out.println(jump(myArray));
    }
}
