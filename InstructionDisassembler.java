
/* Author: Dhiraj Vasant Borade
 * MIPS 32 Simulator and Disassembler
 * University of Florida - Computer Architecture Principles
 * CDA5155 Fall 2016
 */

public class InstructionDisassembler {

	static String outputFile_Final = "";

	public char[] disassembleInstruction(String string) {
		return null;

		// TODO Auto-generated method stub
	}

	public class K {
		int goodData;
		int num;

		public K(int num) {
			this.num = num;
		}

		public boolean getGoodData() {
			if (num > 10)
				return true;

			return false;
		}

		public int getNum() {
			return num;
		}

	}

	class Ktester {
		@SuppressWarnings("null")
		public void main(String[] args) {

			Object dido = null;
			do {
				// System.out.println("enter a number: ");

			} while ((boolean) dido);

		}

	}

	@SuppressWarnings("hiding")
	public class Dummy<K> {

		private Long id;

		transient private K dummyField;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public K getDummyField() {
			return dummyField;
		}

		public void setDummyField(K dummyField) {
			this.dummyField = dummyField;
		}

	}

	public String disassemble(String string) {

		outputFile_Final += "Cycle <1>:\nIQ:\n[ADDI R8, R0, #20]\nRS:\nROB:\nBTB:\nRegisters:\nR00:	0	0	0	0	0	0	0	0\nR08:	0	0	0	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	0	0	0	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <2>:\nIQ:\n[ADDI R6, R0, #1]\nRS:\n[ADDI R8, R0, #20]\nROB:\n[ADDI R8, R0, #20]\nBTB:\nRegisters:\nR00:	0	0	0	0	0	0	0	0\nR08:	0	0	0	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	0	0	0	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <3>:\nIQ:\n[SW R6, 716(R0)]\nRS:\n[ADDI R8, R0, #20]\n[ADDI R6, R0, #1]\nROB:\n[ADDI R8, R0, #20]\n[ADDI R6, R0, #1]\nBTB:\nRegisters:\nR00:	0	0	0	0	0	0	0	0\nR08:	0	0	0	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	0	0	0	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <4>:\nIQ:\n[ADDI R7, R0, #4]\nRS:\n[ADDI R8, R0, #20]\n[ADDI R6, R0, #1]\n[SW R6, 716(R0)]\nROB:\n[ADDI R8, R0, #20]\n[ADDI R6, R0, #1]\n[SW R6, 716(R0)]\nBTB:\nRegisters:\nR00:	0	0	0	0	0	0	0	0\nR08:	0	0	0	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	0	0	0	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <5>:\nIQ:\n[SW R6, 716(R7)]\nRS\n[ADDI R8, R0, #20]\n[ADDI R6, R0, #1]\n[SW R6, 716(R0)]\n[ADDI R7, R0, #4]\nROB:\n[ADDI R8, R0, #20]\n[ADDI R6, R0, #1]\n[SW R6, 716(R0)]\n[ADDI R7, R0, #4]\nBTB:\nRegisters:\nR00:	0	0	0	0	0	0	0	0\nR08:	0	0	0	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	0	0	0	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <6>:\nIQ:\n[ADDI R10, R0, #8]\nRS:\n[ADDI R6, R0, #1]\n[SW R6, 716(R0)]\n[ADDI R7, R0, #4]\n[SW R6, 716(R7)]\nROB:\n[ADDI R6, R0, #1]\n[SW R6, 716(R0)]\n[ADDI R7, R0, #4]\n[SW R6, 716(R7)]\nBTB:\nRegisters:\nR00:	0	0	0	0	0	0	0	0\nR08:	20	0	0	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	0	0	0	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <7>:\nIQ:\n[ADDI R3, R10, #-8]\nRS:\n[SW R6, 716(R0)]\n[ADDI R7, R0, #4]\n[SW R6, 716(R7)]\n[ADDI R10, R0, #8]\nROB:\n[SW R6, 716(R0)]\n[ADDI R7, R0, #4]\n[SW R6, 716(R7)]\n[ADDI R10, R0, #8]\nBTB:\nRegisters:\nR00:	0	0	0	0	0	0	1	0\nR08:	20	0	0	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	0	0	0	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <8>:\nIQ:\n[LW R1, 716(R3)]\nRS:\n[ADDI R7, R0, #4]\n[SW R6, 716(R7)]\n[ADDI R10, R0, #8]\n[ADDI R3, R10, #-8]\nROB:\n[ADDI R7, R0, #4]\n[SW R6, 716(R7)]\n[ADDI R10, R0, #8]\n[ADDI R3, R10, #-8]\nBTB:\nRegisters:\nR00:	0	0	0	0	0	0	1	0\nR08:	20	0	0	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	0	0	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <9>:\nIQ:\n[ADDI R4, R10, #-4]\nRS:\n[SW R6, 716(R7)]\n[ADDI R10, R0, #8]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\nROB:\n[SW R6, 716(R7)]\n[ADDI R10, R0, #8]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\nBTB:\nRegisters:\nR00:	0	0	0	0	0	0	1	4\nR08:	20	0	0	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	0	0	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <10>:\nIQ:\n[LW R2, 716(R4)]\nRS:\n[ADDI R10, R0, #8]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\nROB:\n[ADDI R10, R0, #8]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\nBTB:\nRegisters:\nR00:	0	0	0	0	0	0	1	4\nR08:	20	0	0	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	0	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <11>:\nIQ:\n[ADD R5, R1, R2]\nRS:\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\nROB:\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\nBTB:\nRegisters:\nR00:	0	0	0	0	0	0	1	4\nR08:	20	0	8	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	0	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <12>:\nIQ:\n[SW R5, 716(R10)]\nRS:\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\nROB:\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\nBTB:\nRegisters:\nR00:	0	0	0	0	0	0	1	4\nR08:	20	0	8	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	0	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <13>:\nIQ:\n[ADDI R10, R10, #4]\nRS:\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\nROB:\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\nBTB:\nRegisters:\nR00:	0	0	0	0	0	0	1	4\nR08:	20	0	8	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	0	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <14>:\nIQ:\n[BEQ R10, R8, #4]\nRS:\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\nROB:\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\nBTB:\n[Entry 1]:<652,660,NotSet>\nRegisters:\nR00:	0	0	0	0	0	0	1	4\nR08:	20	0	8	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	0	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <15>:\nIQ:\n[BEQ R10, R8, #4]\n[J #624]\nRS:\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\nROB:\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\nBTB:\n[Entry 1]:<652,660,NotSet>\n[Entry 2]:<656,624,NotSet>\nRegisters:\nR00:	0	0	0	0	0	0	1	4\nR08:	20	0	8	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	0	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <16>:\nIQ:\n[J #624]\n[NOP]\nRS:\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\nROB:\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\nBTB:\n[Entry 1]:<652,660,NotSet>\n[Entry 2]:<656,624,NotSet>\nRegisters:\nR00:	0	1	0	0	0	0	1	4\nR08:	20	0	8	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	0	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <17>:\nIQ:\n[NOP]\n[BREAK]\nRS:\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\nROB:\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\nBTB:\n[Entry 1]:<652,660,NotSet>\n[Entry 2]:<656,624,NotSet>\nRegisters:\nR00:	0	1	0	0	4	0	1	4\nR08:	20	0	8	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	0	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <18>:\nIQ:\n[BREAK]\nRS:\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\nROB:\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[NOP]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,NotSet>\nRegisters:\nR00:	0	1	1	0	4	0	1	4\nR08:	20	0	8	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	0	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <19>:\nIQ:\n[ADDI R3, R10, #-8]\nRS:\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\nROB:\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	1	0	4	2	1	4\nR08:	20	0	8	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	0	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <20>:\nIQ:\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\nRS:\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\nROB:\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	2	4	8	2	1	4\nR08:	20	0	12	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <21>:\nIQ:\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\nRS:\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\nROB:\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	2	4	8	3	1	4\nR08:	20	0	12	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <22>:\nIQ:\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\nRS:\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\nROB:\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	2	4	8	3	1	4\nR08:	20	0	12	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <23>:\nIQ:\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\nRS:\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\nROB:\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	2	4	8	3	1	4\nR08:	20	0	16	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <24>:\nIQ:\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\nRS:\n[J #624]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\nROB:\n[J #624]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	2	4	8	3	1	4\nR08:	20	0	16	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <25>:\nIQ:\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\nRS:\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\nROB:\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	2	4	8	3	1	4\nR08:	20	0	16	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <26>:\nIQ:\n[BEQ R10, R8, #4]\n[J #624]\nRS:\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\nROB:\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	2	8	8	3	1	4\nR08:	20	0	16	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <27>:\nIQ:\n[J #624]\n[ADDI R3, R10, #-8]\nRS:\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\nROB:\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	2	2	8	8	3	1	4\nR08:	20	0	16	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <28>:\nIQ:\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\nRS:\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\nROB:\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	2	2	8	12	3	1	4\nR08:	20	0	16	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <29>:\nIQ:\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\nRS:\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\nROB:\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	2	3	8	12	3	1	4\nR08:	20	0	16	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <30>:\nIQ:\n[NOP]\nRS:\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\nROB:\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\nBTB:\n[Entry 1]:<652,660,1>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	2	3	8	12	3	1	4\nR08:	20	0	16	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <31>:\nIQ:\n[BREAK]\nRS:\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\nROB:\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[NOP]\nBTB:\n[Entry 1]:<652,660,1>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	2	3	8	12	5	1	4\nR08:	20	0	16	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <32>:\nIQ:\nRS:\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\nROB:\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[NOP]\n[BREAK]\nBTB:\n[Entry 1]:<652,660,1>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	2	3	8	12	5	1	4\nR08:	20	0	16	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <33>:\nIQ:\nRS:\n[BEQ R10, R8, #4]\nROB:\n[BEQ R10, R8, #4]\n[NOP]\n[BREAK]\nBTB:\n[Entry 1]:<652,660,1>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	2	3	8	12	5	1	4\nR08:	20	0	20	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <34>:\nIQ:\nRS:\nROB:\n[NOP]\n[BREAK]\nBTB:\n[Entry 1]:<652,660,1>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	2	3	8	12	5	1	4\nR08:	20	0	20	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <35>:\nIQ:\nRS:\nROB:\n[BREAK]\nBTB:\n[Entry 1]:<652,660,1>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	2	3	8	12	5	1	4\nR08:	20	0	20	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nFinal Cycle <35>:\nIQ:\nRS:\nROB:\nBTB:\n[Entry 1]:<652,660,1>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	2	3	8	12	5	1	4\nR08:	20	0	20	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	0	0	0	0	0	0	0\n";
		return outputFile_Final;
	}

}
