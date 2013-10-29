import java.util.Arrays;


public class Sorting {
	public static int[] randArrayGen(int n){
		int[] array = new int[n];
		for(int i=0;i<n;i++) {
			array[i] = (int) (Math.random()*99+1);
		}
		return array;
	}
	
	public static int[] bubble(int[] array) {
		if(array==null || array.length==0) return array;
		int tmp;
		int cnt=0;
		for(int i=0;i<array.length;++i) {
			for(int j=0;j<array.length-i-1;++j) {
				if(array[j]>array[j+1]) {
					cnt++;
					tmp = array[j];
					array[j] = array[j+1];
					array[j+1] = tmp;
				}
			}
		}
		System.out.print("Bubble sort, N="+array.length+", Excution times="+cnt+", Extra Space=0");
		return array;
	}

	public static int[] selection(int[] array) {
		if(array==null || array.length==0) return array;
		int minIndex;
		int tmp;
		int cnt=0;
		for(int i=0;i<array.length;++i) {
			minIndex = i;
			for(int j=i;j<array.length;++j) {
				cnt++;
				if(array[minIndex]>array[j]) minIndex=j;
			}
			tmp = array[i];
			array[i]=array[minIndex];
			array[minIndex]=tmp;
		}
		System.out.print("Selection sort, N="+array.length+", Excution times="+cnt+", Extra Space=0");
		return array;
	}
	
	public static void main(String[] args) {
		int[] array = Sorting.randArrayGen(15);
		System.out.println("Initial array: "+Arrays.toString(array));
		System.out.println(Arrays.toString(Sorting.bubble(array)));
		System.out.println(Arrays.toString(Sorting.selection(array)));
	}

}
