
/* Author: Dhiraj Vasant Borade
 * MIPS 32 Simulator and Disassembler
 * University of Florida - Computer Architecture Principles
 * CDA5155 Fall 2016
 */

public class Instruction {

	int addr;
	String op;
	int type;
	boolean r1, r2;
	long f1, f2, f3, mem;
	String b0, b1, b2, b3;
	String friendRep;

	public Instruction() {
	}

	public Instruction(int a) {
		addr = a;
	}

	public boolean isEmpty() {
		return op.isEmpty();
	}

	public String getOp() {
		return op;
	}

	public int getType() {
		return type;
	}

	public long getField(int c) {
		long r = 0;
		switch (c) {
		case 1:
			r = f1;
			break;
		case 2:
			r = f2;
			break;
		case 3:
			r = f3;
		}
		return r;
	}

	public String getFriendRep() {
		return friendRep;
	}

	public void setOp(String o) {
		op = o;
	}

	public void setType(int t) {
		type = t;
	}

	public void setFriendRep(String f) {
		friendRep = f;
	}

	public void setFields(long p1, long p2, long p3) {
		f1 = p1;
		f2 = p2;
		f3 = p3;
	}
}
