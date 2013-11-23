package model;

import java.util.BitSet;

public class Binseq {
	public final BitSet bitSet;
	public final int len;

	public Binseq(int n) {
		bitSet = new BitSet(n);
		len = n;
	}

	public Binseq(String binary) {
		len = binary.length();
		bitSet = new BitSet(len);
		for (int i = 0; i < len; ++i) {
			if (binary.charAt(i) == '1') {
				bitSet.set(i);
			}
		}
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < len; ++i) {
			result += bitSet.get(i) ? "1" : "0";
		}
		return result;
	}

}
