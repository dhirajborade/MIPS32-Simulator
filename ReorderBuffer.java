import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
import java.util.Scanner;

/* Author: Dhiraj Vasant Borade
 * MIPS 32 Simulator and Disassembler
 * University of Florida - Computer Architecture Principles
 * CDA5155 Fall 2016
 */

public class ReorderBuffer {
	ArrayList<ReorderBufferEntry> fifo; // needed to be array list so i can
										// access elements out of order
	int max;
	boolean finished = false;

	public ReorderBuffer(int m) {
		max = m;
		fifo = new ArrayList<ReorderBufferEntry>(); // initialize table list
	}

	public int push(ReorderBufferEntry e) {
		fifo.add(e);
		return fifo.size();
	}

	public ReorderBufferEntry getIndex(int index) {
		ReorderBufferEntry thisEntry = null;
		for (int i = 0; i < fifo.size(); i++) {
			if (fifo.get(i).robIndex == index)
				thisEntry = fifo.get(i);
		}
		return thisEntry;

	}

	public boolean isDependent(long A, int robIndex) {
		boolean dependent = false;

		for (int i = 0; i < fifo.size(); i++) {
			if (fifo.get(i).robIndex < robIndex && fifo.get(i).destination == A)// if
																				// entry
																				// preceeds
																				// current
																				// address
				if (fifo.get(i).stage != 4)
					dependent = true;
		}

		return dependent;
	}

	public boolean isCommit() {
		if (fifo.size() > 0) {
			ReorderBufferEntry head = fifo.get(0);
			if (head != null && head.stage == 4) {
				return true;
			}
			return false;
		} else
			return false;
	}

	public ReorderBufferEntry pop() {
		return fifo.get(0);
	}

	public boolean kick() {
		if (fifo.get(fifo.size() - 1) != null) {
			if (fifo.size() == 0)
				finished = true; // if you commit the final instruction, we're
									// done
			return true;
		} else
			return false;
	}

	public boolean isFull() {
		if (fifo.size() == max)
			return true;
		else
			return false;
	}

	public boolean isDone() {
		return finished;
	}

	public void printData() {
		System.out.println("\nROB:");
		// ArrayList<robEntry> temp = new ArrayList<robEntry>();

		for (int i = 0; i < fifo.size(); i++) {
			System.out.print("[inst" + i + "]");
			System.out.println(" " + fifo.get(i).display());

		}

	}

	public ReorderBufferEntry moveFifo() {
		ReorderBufferEntry r = fifo.get(0);

		fifo.remove(0);
		for (int i = 0; i < fifo.size() - 2; i++) {
			fifo.add(i, fifo.get(i + 1));
		}
		fifo.remove(fifo.size() - 1);

		return r;
	}

	public class TestCases {

		public void main(String[] args) throws InterruptedException {

			Commands<String> list = new Commands<String>();

			Scanner s = new Scanner(System.in);
			String[] array = new String[5];

			System.out.println("Enter Data");

			for (int i = 0; i < array.length; i++) {
				array[i] = s.nextLine();
				list.insert(array[i]);
			}

			s.close();

			boolean searchResult = list.search("D");
			if (!searchResult) {
				System.out.println("Item Not Found in the List");
			}
			boolean removeStatus = list.remove("K");
			if (!removeStatus) {
				System.out.println("Item Not Found in the List");
			}
		}
	}
}
