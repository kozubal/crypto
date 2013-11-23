package test;

import static org.junit.Assert.assertEquals;
import main.GeffeGenerator;
import main.LinearFeedbackShiftRegister;
import main.NumberGenerator;
import main.PseudorandomNumberGenerator;
import model.Binseq;

import org.junit.Test;

public class GeffeGeneratorTest {

	@Test
	public void check() {
		Binseq init = new Binseq(90);
		init.bitSet.set(1);
		init.bitSet.set(51);

		PseudorandomNumberGenerator first = new NumberGenerator();
		PseudorandomNumberGenerator second = new LinearFeedbackShiftRegister(
				new Binseq("00101000100000000001"));
		PseudorandomNumberGenerator third = new LinearFeedbackShiftRegister(
				init);
		GeffeGenerator geffe = new GeffeGenerator(first, second, third);
		Binseq result = geffe.generate(1000);
		System.out.println(result);
		assertEquals(result.toString().length(), 1000);
	}
}
