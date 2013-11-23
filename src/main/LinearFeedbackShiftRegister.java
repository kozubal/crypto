package main;

import java.util.Random;

import model.Binseq;

public class LinearFeedbackShiftRegister implements PseudorandomNumberGenerator {
	private final Binseq SEED;
	private static Random randomGenerator = new Random();

	public LinearFeedbackShiftRegister(Binseq bSet) {
		SEED = bSet;
	}

	@Override
	public Binseq generate(int n) {
		final int SEED_SIZE = SEED.len;
		Binseq bSet = new Binseq(n);
		generateInitialState(Math.min(bSet.len, SEED_SIZE), bSet);
		for (int i = SEED_SIZE; i < bSet.len; ++i) {
			int sum = 0;
			for (int j = 0, k = i - SEED_SIZE; j < SEED_SIZE; ++j, ++k) {
				sum += (bSet.bitSet.get(k) && SEED.bitSet.get(j)) ? 1 : 0;
			}
			bSet.bitSet.set(i, (sum % 2 == 0) ? false : true);
		}
		return bSet;
	}

	private Binseq generateInitialState(int n, Binseq bSet) {
		for (int i = 0; i < n; ++i) {
			bSet.bitSet.set(i, randomGenerator.nextBoolean());
		}
		return bSet;
	}
}
