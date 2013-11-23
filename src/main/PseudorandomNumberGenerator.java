package main;

import model.Binseq;

public interface PseudorandomNumberGenerator {
	Binseq generate(int n);
}
