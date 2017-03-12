
/* Author: Dhiraj Vasant Borade
 * MIPS 32 Simulator and Disassembler
 * University of Florida - Computer Architecture Principles
 * CDA5155 Fall 2016
 */

import java.util.ArrayList;

public class ReservationStation {
	ArrayList<ReservationStationEntry> table;
	int max;

	public ReservationStation(int m) {
		max = m;
		table = new ArrayList<ReservationStationEntry>(); // initialize table
															// list
		int i = 0;
		while (i < m) {

			table.add(new ReservationStationEntry()); // initialize all RS table
														// entry slots
			i++;
		}
	}

	public boolean push(ReservationStationEntry e) {

		int i = 0;
		while (i < table.size()) {

			if (!table.get(i).busy) {
				table.remove(i);
				e.busy = true;
				table.add(e);
				return true;
			}
			i++;
		}
		return false;
	}

	public void updateOperands(int ROBindex, long value) {
		for (int i = 0; i < table.size(); i++) {
			ReservationStationEntry loopRS = table.get(i);
			if ((long) ROBindex == loopRS.Qj) {
				loopRS.Vj = value;
				loopRS.VjSrc = true;
			}
			if ((long) ROBindex == loopRS.Qk) {
				loopRS.Vk = value;
				loopRS.VkSrc = true;
			}

		}
	}

	public boolean isFull() {
		boolean full = true;
		for (int i = 0; i < max; i++)
			if (!table.get(i).isBusy())
				full = false;

		return full;
	}

	public ReservationStationEntry get(int i) {
		return table.get(i);
	}

	public int currSize() {
		return table.size();
	}

	public int getMax() {
		return max;
	}
}
