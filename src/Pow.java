import java.util.Hashtable;


public class Pow {
    public double pow(double x, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Hashtable<Integer, Double> ht = new Hashtable<Integer, Double>();
        return powHelper(x, n, ht);
    }
    
    public double powHelper(double x, int n, Hashtable<Integer, Double> ht) {
        if(x==0)
            if(n<0) return Double.MAX_VALUE;
            else if(n==0) return 1.0;
            else return 0.0;
        if(n==0) return 1.0;
        if(n==1) return x;
        if(n==-1) return 1.0/x;
        if(ht.containsKey(n)) return ht.get(n);
        else {
        	if(n%2==0) {
                ht.put(n, powHelper(x, n/2, ht)*powHelper(x, n/2, ht));
                return ht.get(n);
        	} else {
                ht.put(n, powHelper(x, n/2, ht)*powHelper(x, n/2+((n>0)?1:(-1)), ht));
                return ht.get(n);
        	}
        }
    }
}