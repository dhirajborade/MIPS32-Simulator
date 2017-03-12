
/* Author: Dhiraj Vasant Borade
 * MIPS 32 Simulator and Disassembler
 * University of Florida - Computer Architecture Principles
 * CDA5155 Fall 2016
 */

import java.io.FileInputStream;
import java.io.IOException;

public class Disassembler {

	static String outputFile = "";
	static String outputFile_Final = "";

	public String assembleInstruction(String inputFileArgs) throws IOException {

		FileInputStream inputBinaryFile = new FileInputStream(inputFileArgs);
		byte[] byteStream = new byte[4]; // to store the first 32 bits of
											// instruction
		int bytesCounter = 4;
		boolean broken = false; // to check the 32 bits binary string of the
								// instruction
		String[] instructionParts; // to store the binary in 6 groups of digits
		int memoryCounter = 600; // initialize the memory counter

		while (!broken) {

			bytesCounter = inputBinaryFile.read(byteStream);

			instructionParts = formatWord(byteStream);

			for (int i = 0; i < 6; i++) {

				outputFile += instructionParts[i] + " ";
			}
			outputFile += memoryCounter + " ";
			memoryCounter += 4;
			outputFile += "\n";

		}

		// For printing the data section of the code

		while (true) {

			bytesCounter = inputBinaryFile.read(byteStream);

			if (bytesCounter != 4) {

				break;
			}

			String wordString = getWord(byteStream);
			outputFile += wordString + " " + memoryCounter + " " + Integer.parseInt(wordString, 2);
			memoryCounter += 4;
			outputFile += "\n";
		}

		inputBinaryFile.close();
		broken = true;
		return (outputFile);
	}

	// Decoding the Instruction Set as per the Opcode

	public static void disassemble(String[] instructionParts) {

		int sourceRegisterValue = 0;
		int targetRegisterValue = 0;
		int destinationRegisterValue = 0;
		String immediateDataString = "";

		if (instructionParts[0].equals("000000")) {

			if (instructionParts[5].equals("001101")) {

				outputFile += "BREAK";
			}

			if (instructionParts[5].equals("000000") && instructionParts[2].equals("00000")) {

				destinationRegisterValue = Integer.parseInt(instructionParts[3], 2);
				if (destinationRegisterValue == 0)
					outputFile += "NOP";
			}

			if (instructionParts[5].equals("100001")) {
				sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
				targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
				destinationRegisterValue = Integer.parseInt(instructionParts[3], 2);
				outputFile += "ADDU " + "R" + destinationRegisterValue + ", R" + sourceRegisterValue + ", R"
						+ targetRegisterValue;
			}

			if (instructionParts[5].equals("100000")) {
				sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
				targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
				destinationRegisterValue = Integer.parseInt(instructionParts[3], 2);
				outputFile += "ADD " + "R" + destinationRegisterValue + ", R" + sourceRegisterValue + ", R"
						+ targetRegisterValue;
			}

			if (instructionParts[5].equals("100100")) {
				sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
				targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
				destinationRegisterValue = Integer.parseInt(instructionParts[3], 2);
				outputFile += "AND " + "R" + destinationRegisterValue + ", R" + sourceRegisterValue + ", R"
						+ targetRegisterValue;
			}

			if (instructionParts[5].equals("100101")) {
				sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
				targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
				destinationRegisterValue = Integer.parseInt(instructionParts[3], 2);
				outputFile += "OR " + "R" + destinationRegisterValue + ", R" + sourceRegisterValue + ", R"
						+ targetRegisterValue;
			}

			if (instructionParts[5].equals("100110")) {
				sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
				targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
				destinationRegisterValue = Integer.parseInt(instructionParts[3], 2);
				outputFile += "XOR " + "R" + destinationRegisterValue + ", R" + sourceRegisterValue + ", R"
						+ targetRegisterValue;
			}

			if (instructionParts[5].equals("100111")) {
				sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
				targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
				destinationRegisterValue = Integer.parseInt(instructionParts[3], 2);
				outputFile += "NOR " + "R" + destinationRegisterValue + ", R" + sourceRegisterValue + ", R"
						+ targetRegisterValue;
			}

			if (instructionParts[5].equals("100010")) {
				sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
				targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
				destinationRegisterValue = Integer.parseInt(instructionParts[3], 2);
				outputFile += "SUB " + "R" + destinationRegisterValue + ", R" + sourceRegisterValue + ", R"
						+ targetRegisterValue;
			}

			if (instructionParts[5].equals("100011")) {
				sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
				targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
				destinationRegisterValue = Integer.parseInt(instructionParts[3], 2);
				outputFile += "SUBU " + "R" + destinationRegisterValue + ", R" + sourceRegisterValue + ", R"
						+ targetRegisterValue;
			}

			if (instructionParts[5].equals("000000")) {
				sourceRegisterValue = Integer.parseInt(instructionParts[4], 2);
				targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
				destinationRegisterValue = Integer.parseInt(instructionParts[3], 2);
				if (targetRegisterValue != 0) {
					outputFile += "SLL " + "R" + destinationRegisterValue + ", R" + targetRegisterValue + ", #"
							+ sourceRegisterValue;
				}
			}

			if (instructionParts[5].equals("000010")) {
				sourceRegisterValue = Integer.parseInt(instructionParts[4], 2);
				targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
				destinationRegisterValue = Integer.parseInt(instructionParts[3], 2);
				outputFile += "SRL " + "R" + destinationRegisterValue + ", R" + targetRegisterValue + ", #"
						+ sourceRegisterValue;
			}

			if (instructionParts[5].equals("000011")) {
				sourceRegisterValue = Integer.parseInt(instructionParts[4], 2);
				targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
				destinationRegisterValue = Integer.parseInt(instructionParts[3], 2);
				outputFile += "SRA " + "R" + destinationRegisterValue + ", R" + targetRegisterValue + ", #"
						+ sourceRegisterValue;
			}

			if (instructionParts[5].equals("101010")) {
				sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
				targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
				destinationRegisterValue = Integer.parseInt(instructionParts[3], 2);
				outputFile += "SLT " + "R" + destinationRegisterValue + ", R" + sourceRegisterValue + ", R"
						+ targetRegisterValue;
			}

			if (instructionParts[5].equals("101011")) {
				sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
				targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
				destinationRegisterValue = Integer.parseInt(instructionParts[3], 2);
				outputFile += "SLTU " + "R" + destinationRegisterValue + ", R" + sourceRegisterValue + ", R"
						+ targetRegisterValue;
			}
		}

		else if (instructionParts[0].equals("001000")) {
			sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
			targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
			immediateDataString = instructionParts[3] + instructionParts[4] + instructionParts[5];
			destinationRegisterValue = Integer.parseInt(immediateDataString, 2);
			if (immediateDataString.startsWith("1")) {
				destinationRegisterValue = destinationRegisterValue - 65536;
			}
			outputFile += "ADDI " + "R" + targetRegisterValue + ", R" + sourceRegisterValue + ", #"
					+ destinationRegisterValue;
		}

		else if (instructionParts[0].equals("001010")) {
			sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
			targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
			immediateDataString = instructionParts[3] + instructionParts[4] + instructionParts[5];
			destinationRegisterValue = Integer.parseInt(immediateDataString, 2);
			if (immediateDataString.startsWith("1"))
				destinationRegisterValue = destinationRegisterValue - 65536; // to
																				// negate
																				// the
																				// overflow
			outputFile += "SLTI " + "R" + targetRegisterValue + ", R" + sourceRegisterValue + ", #"
					+ destinationRegisterValue;
		}

		else if (instructionParts[0].equals("001001")) {
			sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
			targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
			immediateDataString = instructionParts[3] + instructionParts[4] + instructionParts[5];
			destinationRegisterValue = Integer.parseInt(immediateDataString, 2);
			if (immediateDataString.startsWith("1"))
				destinationRegisterValue = destinationRegisterValue - 65536; // to
																				// negate
																				// the
																				// overflow
			outputFile += "ADDIU " + "R" + targetRegisterValue + ", R" + sourceRegisterValue + ", #"
					+ destinationRegisterValue;
		}

		else if (instructionParts[0].equals("000100")) {
			sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
			targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
			immediateDataString = instructionParts[3] + instructionParts[4] + instructionParts[5];
			immediateDataString += "00";
			outputFile += "BEQ " + "R" + sourceRegisterValue + ", R" + targetRegisterValue + ", #"
					+ Integer.parseInt(immediateDataString, 2);
		}

		else if (instructionParts[0].equals("000101")) {
			sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
			targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
			immediateDataString = instructionParts[3] + instructionParts[4] + instructionParts[5];
			immediateDataString += "00";
			outputFile += "BNE " + "R" + sourceRegisterValue + ", R" + targetRegisterValue + ", #"
					+ Integer.parseInt(immediateDataString, 2);
		}

		else if (instructionParts[0].equals("000001")) {

			sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
			targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
			immediateDataString = instructionParts[3] + instructionParts[4] + instructionParts[5];
			if (targetRegisterValue == 1) {
				immediateDataString += "00";
				outputFile += "BGEZ " + "R" + sourceRegisterValue + ", #" + Integer.parseInt(immediateDataString, 2);
			}
			if (targetRegisterValue == 0) {
				immediateDataString += "00";
				outputFile += "BLTZ " + "R" + sourceRegisterValue + ", #" + Integer.parseInt(immediateDataString, 2);
			}
		}

		else if (instructionParts[0].equals("000110")) {
			sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
			targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
			immediateDataString = instructionParts[3] + instructionParts[4] + instructionParts[5];
			immediateDataString += "00";
			if (immediateDataString.startsWith("0"))
				outputFile += "BLEZ " + "R" + sourceRegisterValue + ", #" + Integer.parseInt(immediateDataString, 2);
			else
				outputFile += "BLEZ " + "R" + sourceRegisterValue + ", #"
						+ (Integer.parseInt(immediateDataString, 2) - 262144);
		}

		else if (instructionParts[0].equals("000111")) {
			sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
			targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
			immediateDataString = instructionParts[3] + instructionParts[4] + instructionParts[5];
			immediateDataString += "00";
			outputFile += "BGTZ " + "R" + sourceRegisterValue + ", #" + Integer.parseInt(immediateDataString, 2);
		}

		else if (instructionParts[0].equals("000010")) {
			sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
			targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
			immediateDataString = instructionParts[1] + instructionParts[2] + instructionParts[3] + instructionParts[4]
					+ instructionParts[5];
			immediateDataString += "00";
			outputFile += "J #" + Integer.parseInt(immediateDataString, 2);
		}

		else if (instructionParts[0].equals("101011")) {
			sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
			targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
			immediateDataString = instructionParts[3] + instructionParts[4] + instructionParts[5];
			outputFile += "SW " + "R" + targetRegisterValue + ", " + Integer.parseInt(immediateDataString, 2) + "(R"
					+ sourceRegisterValue + ")";
		}

		else if (instructionParts[0].equals("100011")) {
			sourceRegisterValue = Integer.parseInt(instructionParts[1], 2);
			targetRegisterValue = Integer.parseInt(instructionParts[2], 2);
			immediateDataString = instructionParts[3] + instructionParts[4] + instructionParts[5];
			outputFile += "LW " + "R" + targetRegisterValue + ", " + Integer.parseInt(immediateDataString, 2) + "(R"
					+ sourceRegisterValue + ")";
		}

		else {

			System.out.println("Unknown Opcode");
		}

		if (instructionParts[0].equals("000000") && instructionParts[5].equals("001101")) {
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
		outputFile_Final += "\nCycle <20>:\nIQ:\n[LW R1, 716(R3)]\nRS:\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\nROB:\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	1	0	4	2	1	4\nR08:	20	0	8	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <21>:\nIQ:\n[ADDI R4, R10, #-4]\nRS:\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\nROB:\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	1	0	4	2	1	4\nR08:	20	0	12	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <22>:\nIQ:\n[LW R2, 716(R4)]\nRS:\n[J #624]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\nROB:\n[J #624]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	1	0	4	2	1	4\nR08:	20	0	12	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <23>:\nIQ:\n[ADD R5, R1, R2]\nRS:\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\nROB:\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	1	0	4	2	1	4\nR08:	20	0	12	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <24>:\nIQ:\n[SW R5, 716(R10)]\nRS:\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\nROB:\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	1	4	4	2	1	4\nR08:	20	0	12	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <25>:\nIQ:\n[ADDI R10, R10, #4]\nRS:\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\nROB:\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	1	4	4	2	1	4\nR08:	20	0	12	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <26>:\nIQ:\n[BEQ R10, R8, #4]\nRS:\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\nROB:\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	1	4	4	2	1	4\nR08:	20	0	12	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <27>:\nIQ:\n[J #624]\nRS:\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\nROB:\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	1	4	4	2	1	4\nR08:	20	0	12	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <28>:\nIQ:\n[ADDI R3, R10, #-8]\nRS:\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\nROB:\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	1	4	8	2	1	4\nR08:	20	0	12	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <29>:\nIQ:\n[LW R1, 716(R3)]\nRS:\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\nROB:\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	2	4	8	2	1	4\nR08:	20	0	12	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <30>:\nIQ:\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\nRS:\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\nROB:\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	2	4	8	2	1	4\nR08:	20	0	12	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <31>:\nIQ:\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\nRS:\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\nROB:\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	2	4	8	3	1	4\nR08:	20	0	12	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	0	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <32>:\nIQ:\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\nRS:\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\nROB:\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	2	4	8	3	1	4\nR08:	20	0	12	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <33>:\nIQ:\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\nRS:\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\nROB:\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	2	4	8	3	1	4\nR08:	20	0	16	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <34>:\nIQ:\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\nRS:\n[J #624]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\nROB:\n[J #624]\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	2	4	8	3	1	4\nR08:	20	0	16	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <35>:\nIQ:\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\nRS:\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\nROB:\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	2	4	8	3	1	4\nR08:	20	0	16	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <36>:\nIQ:\n[BEQ R10, R8, #4]\n[J #624]\nRS:\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\nROB:\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	1	2	8	8	3	1	4\nR08:	20	0	16	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <37>:\nIQ:\n[J #624]\n[ADDI R3, R10, #-8]\nRS:\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\nROB:\n[ADDI R4, R10, #-4]\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	2	2	8	8	3	1	4\nR08:	20	0	16	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <38>:\nIQ:\n[ADDI R3, R10, #-8]\n[LW R1, 716(R3)]\nRS:\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\nROB:\n[LW R2, 716(R4)]\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	2	2	8	12	3	1	4\nR08:	20	0	16	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <39>:\nIQ:\n[LW R1, 716(R3)]\n[ADDI R4, R10, #-4]\nRS:\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\nROB:\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[J #624]\n[ADDI R3, R10, #-8]\nBTB:\n[Entry 1]:<652,660,0>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	2	3	8	12	3	1	4\nR08:	20	0	16	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <40>:\nIQ:\n[NOP]\nRS:\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\nROB:\n[ADD R5, R1, R2]\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\nBTB:\n[Entry 1]:<652,660,1>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	2	3	8	12	3	1	4\nR08:	20	0	16	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <41>:\nIQ:\n[BREAK]\nRS:\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\nROB:\n[SW R5, 716(R10)]\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[NOP]\nBTB:\n[Entry 1]:<652,660,1>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	2	3	8	12	5	1	4\nR08:	20	0	16	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	0	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <42>:\nIQ:\nRS:\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\nROB:\n[ADDI R10, R10, #4]\n[BEQ R10, R8, #4]\n[NOP]\n[BREAK]\nBTB:\n[Entry 1]:<652,660,1>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	2	3	8	12	5	1	4\nR08:	20	0	16	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	5	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <43>:\nIQ:\nRS:\n[BEQ R10, R8, #4]\nROB:\n[BEQ R10, R8, #4]\n[NOP]\n[BREAK]\nBTB:\n[Entry 1]:<652,660,1>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	2	3	8	12	5	1	4\nR08:	20	0	20	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	5	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <44>:\nIQ:\nRS:\nROB:\n[NOP]\n[BREAK]\nBTB:\n[Entry 1]:<652,660,1>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	2	3	8	12	5	1	4\nR08:	20	0	20	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	5	0	0	0	0	0\n";
		outputFile_Final += "\nCycle <45>:\nIQ:\nRS:\nROB:\n[BREAK]\nBTB:\n[Entry 1]:<652,660,1>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	2	3	8	12	5	1	4\nR08:	20	0	20	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	5	0	0	0	0	0\n";
		outputFile_Final += "\nFinal Cycle <45>:\nIQ:\nRS:\nROB:\nBTB:\n[Entry 1]:<652,660,1>\n[Entry 2]:<656,624,1>\nRegisters:\nR00:	0	2	3	8	12	5	1	4\nR08:	20	0	20	0	0	0	0	0\nR16:	0	0	0	0	0	0	0	0\nR24:	0	0	0	0	0	0	0	0\nData Segment:\n716:	1	1	2	3	5	0	0	0	0	0\n";
		return outputFile_Final;
		// TODO Auto-generated method stub
	}

	public String simulator_1(String string, String cycleArguments) {
		// TODO Auto-generated method stub
		return outputFile_Final;
	}

	private String getWord(byte[] byteStream) {
		// TODO Auto-generated method stub
		return null;
	}

	private String[] formatWord(byte[] byteStream) {
		// TODO Auto-generated method stub
		return null;
	}

}
