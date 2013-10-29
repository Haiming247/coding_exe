import static org.junit.Assert.*;

import org.junit.Test;


public class PowTest {

	@Test
	public void testPow() {
		System.out.println("Test general case and extrame cases in Pow() function");
		Pow p = new Pow();
		assertTrue(p.pow(3.0, 4)==81.0);
		assertTrue(p.pow(0.0, 1)==0.0);
		assertTrue(p.pow(0.0, -1)==Double.MAX_VALUE);
		assertTrue(p.pow(0.0, 0)==1.0);
		assertTrue(p.pow(1, 0)==1.0);
		assertTrue(p.pow(-1, 0)==1.0);
	}
}
