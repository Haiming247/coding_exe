public class BinaryInsert {
    public static int searchInsert(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int ss=0, ee=A.length-1;
        int middle;
        while(ss<=ee) {
            middle=(ss+ee)/2;
            if(A[middle]==target) return middle;
            else if(A[middle]>target) ee=middle-1;
            else ss=middle+1;
        }
        return ee+1;
    }
    public static void main(String[] args) {
    	int[] array={1,3,5,6,9};
    	int tar = 0;
    	System.out.println(BinaryInsert.searchInsert(array, tar));
    }
}