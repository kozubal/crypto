package test;

import static org.junit.Assert.assertEquals;
import main.LinearFeedbackShiftRegister;
import main.PseudorandomNumberGenerator;
import model.Binseq;

import org.junit.Test;

public class LinearFeedbackShiftRegisterTest {

	@Test
	public void checkSequenceLenght() {
		PseudorandomNumberGenerator shiftRegister = new LinearFeedbackShiftRegister(
				new Binseq("00101000100000000001"));
		Binseq result = shiftRegister.generate(100);
		assertEquals(result.toString().length(), 100);
	}
}
