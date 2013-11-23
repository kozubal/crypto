package main;

import java.util.Random;

import model.Binseq;

public class NumberGenerator implements PseudorandomNumberGenerator {
	private static Random randomGenerator = new Random();

	public Binseq generate(int n) {
		Binseq sequence = new Binseq(n);
		for (int i = 0; i < sequence.len; ++i) {
			sequence.bitSet.set(i, randomGenerator.nextBoolean());
		}
		return sequence;
	}
}
