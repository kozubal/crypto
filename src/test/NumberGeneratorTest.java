package test;

import static org.junit.Assert.assertEquals;
import main.NumberGenerator;
import model.Binseq;

import org.junit.Test;

public class NumberGeneratorTest {

	@Test
	public void checkSequenceLengthTest() {
		NumberGenerator gNumberGenerator = new NumberGenerator();
		Binseq result = gNumberGenerator.generate(100);
		assertEquals(result.toString().length(), 100);
	}
}
