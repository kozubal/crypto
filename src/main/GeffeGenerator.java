package main;

import model.Binseq;

public class GeffeGenerator implements PseudorandomNumberGenerator {

	private final PseudorandomNumberGenerator L1; // x register
	private final PseudorandomNumberGenerator L2; // y register
	private final PseudorandomNumberGenerator L3; // s register

	public GeffeGenerator(PseudorandomNumberGenerator aL1,
			PseudorandomNumberGenerator aL2, PseudorandomNumberGenerator aL3) {
		L1 = aL1;
		L2 = aL2;
		L3 = aL3;
	}

	@Override
	public Binseq generate(int n) {
		Binseq bSet = new Binseq(n);
		Binseq x = L1.generate(n);
		Binseq y = L2.generate(n);
		Binseq s = L3.generate(n);
		for (int i = 0; i < n; ++i) {
			boolean result = s.bitSet.get(i) & x.bitSet.get(i)
					^ (true ^ s.bitSet.get(i)) & y.bitSet.get(i);
			bSet.bitSet.set(i, result);
		}
		return bSet;
	}
}
