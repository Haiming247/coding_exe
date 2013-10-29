// http://oj.leetcode.com/problems/triangle/
// what I leant:
// ArrayList: http://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html#size()
// this one uses dynamic programming.
// * can do it in-place if allowed to change the data
// * can use recursion either top-down or bottom.
package ArrayAndString;

import java.lang.reflect.Array;
import java.util.ArrayList;
//import java.util.Iterator;

public class Triangle {
    public static int minimumTotal_DP(ArrayList<ArrayList<Integer>> triangle) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(triangle==null||triangle.size()==0||triangle.get(0).size()==0) return -1;
        int length = triangle.size();
        ArrayList<Integer> pathArray = new ArrayList<Integer>(length); // the capacity doesn't equal to length, since all null
        ArrayList<Integer> tmp = new ArrayList<Integer>(length);
        // initialize the arraylists
        for(int i=0;i<length;++i) {
        	pathArray.add(i,0); // add real element to avoid null
        	tmp.add(i,0);
        }
        for(int level=0;level<length;++level) {
            for(int ind=0;ind<=level;++ind) { // update pathArray, and fetch from tmp the previous path length 
                if(ind==0) pathArray.set(ind, tmp.get(ind)+triangle.get(level).get(ind));
                else if(ind==level) pathArray.set(ind, tmp.get(ind-1)+triangle.get(level).get(ind));
                else pathArray.set(ind, triangle.get(level).get(ind) + Math.min(tmp.get(ind), tmp.get(ind-1)));
            }
            // cache the current path array into tmp for the next level to ref
            for(int i=0;i<=level;++i) tmp.set(i,pathArray.get(i));
        }
        int minPath=Integer.MAX_VALUE;
        for(int i=0;i<length;++i)
        	if(minPath>pathArray.get(i)) minPath=pathArray.get(i);
        
        return minPath;
    }    
    
    // let's just go with the iteration DP version
    public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
    	return getCurMin(triangle, 0, 0);
    }
    
    public static int getCurMin(ArrayList<ArrayList<Integer>> triangle, int level, int ind) {
    	if(level==triangle.size()-1) return triangle.get(level).get(ind);
    	return Math.min(getCurMin(triangle, level+1, ind), getCurMin(triangle, level+1, ind+1));
    }
    
    public static void main(String[] args) {
//    	ArrayList<Integer> mylist = new ArrayList<Integer>(10);
//    	mylist.add(10);
//    	Iterator<Integer> it = mylist.iterator();
//    	while(it.hasNext()) // iterator can't be used in foreach.
//    		System.out.println(it.next());
//    	
//    	int[] myArray = new int[10];
//    	for(int i: myArray)
//    		System.out.print(i);
//    	
//    	Integer[] myIntArray = new Integer[10];
//    	for(Integer i: myIntArray)
//    		System.out.print(i);
    	
    	ArrayList<Integer> aRow = new ArrayList<Integer>();
    	aRow.add(-10);
    	ArrayList<ArrayList<Integer>> test = new ArrayList<ArrayList<Integer>>();
    	test.add(aRow);
    	System.out.print(test);
    	System.out.println(minimumTotal(test));
    }
}
