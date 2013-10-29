// http://oj.leetcode.com/problems/combinations/
// ref: http://discuss.leetcode.com/questions/252/combinations
package ArrayAndString;

import java.util.ArrayList;

public class Combinations {
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(n<k||k<=0) return null;
		ArrayList<ArrayList<Integer>> all = new  ArrayList<ArrayList<Integer>>();       
		if(k==1){
			for(int i=1;i<=n;i++){
				ArrayList<Integer> al = new ArrayList<Integer>();
				al.add(i);
				all.add(al);
			}
			return all;
		}
		for(int i=n;i>=k;i--){                
			for(ArrayList<Integer> al : combine(i-1,k-1)){
				al.add(i);  // mind that we add i here, not n!!
				// for each i, it can either be selected(as added in here), or unselected(ignored in the next iteration)
				all.add(al);
			} 
		}
		return all;       
	}
	
	public static ArrayList<ArrayList<Integer>> combine2(int n, int k) {
	    if(n<k||k==0) return null;
	    ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
	    // boundary case
	    if(n==k) {
	        ArrayList<Integer> al = new ArrayList<Integer>();
	        for(int i=1;i<=n;++i) {
	            al.add(i);
	        }
	        all.add(al);
	        return all;
	    }
	    
	    // general case
	    // mind when k==1, k-1==0, you then can't handle this situation and will get StackOverFlow exception. 
	    for(int i=n;i>=k;--i)
	        for(ArrayList<Integer> al: combine(i-1, k-1)) {
	            al.add(i);
	            all.add(al);
	        }
	    return all;
	}
	
	public static void main(String[] args) {
		System.out.println(combine(4,1));
//		System.out.println(combine2(4,1));
	}
}
