package bitManipulation;

public class NumberComplement_476 {
	public int findComplement(int num) {
		int bit1 = 0x80000000;

		while (((bit1 >> 1) & num) == 0) {
			bit1 >>= 1;
		}
		return (~bit1) ^ num;

	}

	// top
	public int findComplement2(int num) {
		return ~num & (Integer.highestOneBit(num) - 1);
	}
}
