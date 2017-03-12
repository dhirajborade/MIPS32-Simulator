
/* Author: Dhiraj Vasant Borade
 * MIPS 32 Simulator and Disassembler
 * University of Florida - Computer Architecture Principles
 * CDA5155 Fall 2016
 */

import java.util.LinkedList;
import java.util.Queue;

public class InstructionQueue {
	Queue<Instruction> fifo;

	public InstructionQueue() {
		fifo = new LinkedList<Instruction>();
	}

	public void push(Instruction e) {
		fifo.add(e);
	}

	public Instruction pop() {
		return fifo.remove();
	}

	public Instruction peek() {
		return fifo.peek();
	}

	public boolean kick() {
		if (fifo.remove() != null)
			return true;
		else
			return false;
	}
}
