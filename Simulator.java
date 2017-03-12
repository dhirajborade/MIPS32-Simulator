
/* Author: Dhiraj Vasant Borade
 * MIPS 32 Simulator and Disassembler
 * University of Florida - Computer Architecture Principles
 * CDA5155 Fall 2016
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Simulator {
	public enum instrType {
		FP, LD, SD, NA
	}

	static String outputFile = "";
	String file;
	int typeHold = 5; // 0 = FP, 1 = IM, 2 = BR, 3 = LS, 4 = N/A, 5 = ??
	long f1, f2, f3;
	String b0, b1, b2, b3;
	long rs, rt, rd = 0;

	public Simulator() {
		file = "";
	}

	@SuppressWarnings("null")
	public String disassemble(String inputfilename) throws IOException {

		FileInputStream fis = null;

		fis = new FileInputStream(inputfilename);
		byte[] bs = new byte[4];
		// read bytes to the buffer
		int n = 4;
		boolean broken = false;
		String[] instructionParts;
		int memcounter = 600;
		while (!broken) {
			n = fis.read(bs);

			if (n < 4) {
				// System.out.println("incomplete word");
				fis.close();
				return "error";
			}
			instructionParts = null;

			for (int i = 0; i < 6; i++)
				file += instructionParts[i] + " ";
			file += memcounter + " ";
			memcounter += 4;

			broken = disassembleInstruction(instructionParts, true);
			file += "\n";

		}
		while (true) {
			n = fis.read(bs);
			if (n != 4)
				break;
			String word = null;
			file += word + " " + memcounter + " " + Integer.parseUnsignedInt(word, 2);
			memcounter += 4;
			file += "\n";

		}
		fis.close();
		return (file);
	}

	private String formatWord(byte[] bs) {
		// TODO Auto-generated method stub
		return null;
	}

	// very similar to "str disassemble(str)" - instead of formatting in
	// strings, it passes instructions
	public ArrayList<Instruction> getInstrMem(String inputfilename) throws IOException {

		FileInputStream fis = null;
		ArrayList<Instruction> instrArr = new ArrayList<Instruction>(); // collect
																		// instructions
																		// for
																		// use
																		// by
																		// the
																		// simulator

		fis = new FileInputStream(inputfilename);
		byte[] bs = new byte[4];
		// read bytes to the buffer
		int n = 4;
		boolean broken = false;
		int memcounter = 600;

		while (!broken) {
			Instruction subject = new Instruction(memcounter); // create new
																// Instruction
																// at address
																// 'memcounter'
			n = fis.read(bs);

			if (n < 4) {
				// System.out.println("incomplete word");
				fis.close();
				return null;
			}

			// for(int i=0;i<6;i++) System.out.print(instructionParts[i] + " ");
			// file+=instructionParts[i]+" ";
			// file+=memcounter+" ";
			// System.out.println(memcounter + " ");

			// broken=disassembleInstruction(instructionParts, false);

			// transfer data to instruction object
			subject.setType(typeHold);
			subject.setOp(file.split(" ")[0]);
			subject.setFriendRep(file);
			subject.setFields(rs, rt, rd);

			// clear all holding variables
			file = "";
			// f1 = 0; f2 = 0; f3 = 0;
			// b0 = ""; b1 = ""; b2 = ""; b3 = "";
			// file+="\n";
			memcounter += 4;

			// System.out.print(instrArr.size() + "(" + subject.getOp() + ") ");
			// subject.printInstr();
			instrArr.add(subject);
		}

		while (true) { // handle NOPs after the BREAK command
			n = fis.read(bs);
			if (n != 4)
				break;
			// String word=getWord(bs);

			// file+=word+" "+ memcounter+" "+Integer.parseInt(word, 2);
			// System.out.println( word+" "+memcounter+"
			// "+Integer.parseInt(word, 2) );

			memcounter += 4;
			// file+="\n";
		}

		fis.close();
		// return (file);
		return instrArr;
	}

	public String getMem(String inputfilename) throws IOException {

		FileInputStream fis = null;
		ArrayList<Instruction> instrArr = new ArrayList<Instruction>(); // collect
																		// instructions
																		// for
																		// use
																		// by
																		// the
																		// simulator

		fis = new FileInputStream(inputfilename);
		byte[] bs = new byte[4];
		// read bytes to the buffer
		int n = 4;
		boolean broken = false;
		String[] instructionParts = null;
		int memcounter = 600;

		while (!broken) {
			Instruction subject = new Instruction(memcounter); // create new
																// Instruction
																// at address
																// 'memcounter'
			n = fis.read(bs);

			if (n < 4) {
				// System.out.println("incomplete word");
				fis.close();
				return null;
			}
			// instructionParts=formatWord(bs);

			// for(int i=0;i<6;i++) System.out.print(instructionParts[i] + " ");
			// file+=instructionParts[i]+" ";
			// file+=memcounter+" ";
			// System.out.println(memcounter + " ");

			broken = disassembleInstruction(instructionParts, false);

			// transfer data to instruction object
			subject.setType(typeHold);
			subject.setOp(file.split(" ")[0]);
			subject.setFriendRep(file);
			subject.setFields(rs, rt, rd);

			// clear all holding variables
			file = "";
			// f1 = 0; f2 = 0; f3 = 0;
			// b0 = ""; b1 = ""; b2 = ""; b3 = "";
			// file+="\n";
			memcounter += 4;

			// System.out.print(instrArr.size() + "(" + subject.getOp() + ") ");
			// subject.printInstr();
			instrArr.add(subject);
		}

		while (true) { // handle NOPs after the BREAK command
			n = fis.read(bs);
			if (n != 4)
				break;
			Instruction subject = new Instruction();
			subject.friendRep = formatWord(bs);
			subject.type = 5;
			instrArr.add(subject);
			// file+=word+" "+ memcounter+" "+Integer.parseInt(word, 2);
			// System.out.println( word+" "+memcounter+"
			// "+Integer.parseInt(word, 2) );

			memcounter += 4;
			file += "\n";
		}

		fis.close();
		return (file);
		// return instrArr;
	}

	public boolean disassembleInstruction(String[] instructionParts, boolean print) {
		boolean broken = false;
		int rs, rt, rd = 0;
		String foo;
		int opcode = Integer.parseInt(instructionParts[0], 2);
		if (opcode == 0) {

			// too many instructions have the 0 opcode, so im using typhold to
			// save me some work in execution
			if (instructionParts[5].equals("001101")) {
				broken = true;
				file += "BREAK";
				typeHold = 4; // N/A
				b0 = "001101";
			}
			if (instructionParts[5].equals("000000") && instructionParts[2].equals("00000")) {
				rd = Integer.parseInt(instructionParts[3], 2);
				if (rd == 0)
					file += "NOP";
				typeHold = 4; // N/A
				// b0 = "000000";
			}
			if (instructionParts[5].equals("100001")) {
				file += "ADDU ";
				rs = Integer.parseInt(instructionParts[1], 2);
				rt = Integer.parseInt(instructionParts[2], 2);
				rd = Integer.parseInt(instructionParts[3], 2);
				file += "R" + rd + ", R" + rs + ", R" + rt;
				typeHold = 6; // addu
				// f1 = rs; f2 = rt; f3 = rd;
				// b0 = ;
			}
			if (instructionParts[5].equals("100000")) {
				file += "ADD ";
				rs = Integer.parseInt(instructionParts[1], 2);
				rt = Integer.parseInt(instructionParts[2], 2);
				rd = Integer.parseInt(instructionParts[3], 2);
				file += "R" + rd + ", R" + rs + ", R" + rt;
				typeHold = 7; // FP
				// b0 = ;
			}
			if (instructionParts[5].equals("100100")) {
				file += "AND ";
				rs = Integer.parseInt(instructionParts[1], 2);
				rt = Integer.parseInt(instructionParts[2], 2);
				rd = Integer.parseInt(instructionParts[3], 2);
				file += "R" + rd + ", R" + rs + ", R" + rt;
				typeHold = 8; // FP
				// b0 = ;
			}
			if (instructionParts[5].equals("100101")) {
				file += "OR ";
				rs = Integer.parseInt(instructionParts[1], 2);
				rt = Integer.parseInt(instructionParts[2], 2);
				rd = Integer.parseInt(instructionParts[3], 2);
				file += "R" + rd + ", R" + rs + ", R" + rt;
				typeHold = 9; // FP
				// b0 = ;
			}
			if (instructionParts[5].equals("100110")) {
				file += "XOR ";
				rs = Integer.parseInt(instructionParts[1], 2);
				rt = Integer.parseInt(instructionParts[2], 2);
				rd = Integer.parseInt(instructionParts[3], 2);
				file += "R" + rd + ", R" + rs + ", R" + rt;
				typeHold = 10; // FP
				// b0 = ;
			}
			if (instructionParts[5].equals("100111")) {
				file += "NOR ";
				rs = Integer.parseInt(instructionParts[1], 2);
				rt = Integer.parseInt(instructionParts[2], 2);
				rd = Integer.parseInt(instructionParts[3], 2);
				file += "R" + rd + ", R" + rs + ", R" + rt;
				typeHold = 11; // FP
				// b0 = ;
			}
			if (instructionParts[5].equals("100010")) {
				file += "SUB ";
				rs = Integer.parseInt(instructionParts[1], 2);
				rt = Integer.parseInt(instructionParts[2], 2);
				rd = Integer.parseInt(instructionParts[3], 2);
				file += "R" + rd + ", R" + rs + ", R" + rt;
				typeHold = 12; // FP
				// b0 = ;
			}
			if (instructionParts[5].equals("100011")) {
				file += "SUBU ";
				rs = Integer.parseInt(instructionParts[1], 2);
				rt = Integer.parseInt(instructionParts[2], 2);
				rd = Integer.parseInt(instructionParts[3], 2);
				file += "R" + rd + ", R" + rs + ", R" + rt;
				typeHold = 13; // FP
				// b0 = ;
			}

			if (instructionParts[5].equals("000000")) {

				rs = Integer.parseInt(instructionParts[4], 2);
				rt = Integer.parseInt(instructionParts[2], 2);
				rd = Integer.parseInt(instructionParts[3], 2);
				if (rt != 0) {
					file += "SLL ";
					file += "R" + rd + ", R" + rt + ", #" + rs;
					typeHold = 14; // IM
				}
			}
			if (instructionParts[5].equals("000010")) {
				file += "SRL ";
				rs = Integer.parseInt(instructionParts[4], 2);
				rt = Integer.parseInt(instructionParts[2], 2);
				rd = Integer.parseInt(instructionParts[3], 2);
				file += "R" + rd + ", R" + rt + ", #" + rs;
				typeHold = 15; // IM
			}
			if (instructionParts[5].equals("000011")) {
				file += "SRA ";
				rs = Integer.parseInt(instructionParts[4], 2);
				rt = Integer.parseInt(instructionParts[2], 2);
				rd = Integer.parseInt(instructionParts[3], 2);
				file += "R" + rd + ", R" + rt + ", #" + rs;
				typeHold = 16; // IM
			}
			if (instructionParts[5].equals("101010")) {
				file += "SLT ";
				rs = Integer.parseInt(instructionParts[1], 2);
				rt = Integer.parseInt(instructionParts[2], 2);
				rd = Integer.parseInt(instructionParts[3], 2);
				file += "R" + rd + ", R" + rs + ", R" + rt;
				typeHold = 17; // FP
			}
			if (instructionParts[5].equals("101011")) {
				file += "SLTU ";
				rs = Integer.parseInt(instructionParts[1], 2);
				rt = Integer.parseInt(instructionParts[2], 2);
				rd = Integer.parseInt(instructionParts[3], 2);
				file += "R" + rd + ", R" + rs + ", R" + rt;
				typeHold = 18; // FP
			}

		} else if (opcode == 8) {

			file += "ADDI ";
			rs = Integer.parseInt(instructionParts[1], 2);
			rt = Integer.parseInt(instructionParts[2], 2);
			foo = instructionParts[3] + instructionParts[4] + instructionParts[5];
			rd = Integer.parseInt(foo, 2);
			if (foo.startsWith("1"))
				rd = rd - 65536;
			file += "R" + rt + ", R" + rs + ", #" + rd;
			typeHold = 1; // IM
		} else if (opcode == 10) {

			file += "SLTI ";
			rs = Integer.parseInt(instructionParts[1], 2);
			rt = Integer.parseInt(instructionParts[2], 2);
			foo = instructionParts[3] + instructionParts[4] + instructionParts[5];
			rd = Integer.parseInt(foo, 2);
			if (foo.startsWith("1"))
				rd = rd - 65536;
			file += "R" + rt + ", R" + rs + ", #" + rd;
			typeHold = 1; // IM
		} else if (opcode == 9) {

			file += "ADDIU ";
			rs = Integer.parseInt(instructionParts[1], 2);
			rt = Integer.parseInt(instructionParts[2], 2);
			foo = instructionParts[3] + instructionParts[4] + instructionParts[5];
			rd = Integer.parseInt(foo, 2);
			if (foo.startsWith("1"))
				rd = rd - 65536;
			file += "R" + rt + ", R" + rs + ", #" + rd;
			typeHold = 1; // IM
		} else if (opcode == 4) {

			file += "BEQ ";
			rs = Integer.parseInt(instructionParts[1], 2);
			rt = Integer.parseInt(instructionParts[2], 2);
			foo = instructionParts[3] + instructionParts[4] + instructionParts[5];
			foo += "00";
			rd = Integer.parseInt(foo);
			file += "R" + rs + ", R" + rt + ", #" + Integer.parseInt(foo, 2);
			typeHold = 2; // BR
		} else if (opcode == 5) {

			file += "BNE ";
			rs = Integer.parseInt(instructionParts[1], 2);
			rt = Integer.parseInt(instructionParts[2], 2);
			foo = instructionParts[3] + instructionParts[4] + instructionParts[5];
			foo += "00";
			rd = Integer.parseInt(foo);
			file += "R" + rs + ", R" + rt + ", #" + Integer.parseInt(foo, 2);
			typeHold = 2; // BR
		} else if (opcode == 1) {

			rs = Integer.parseInt(instructionParts[1], 2);
			rt = Integer.parseInt(instructionParts[2], 2);
			foo = instructionParts[3] + instructionParts[4] + instructionParts[5];
			if (rt == 1) {
				foo += "00";
				file += "BGEZ ";
				file += "R" + rs + ", #" + Integer.parseInt(foo, 2);
			}
			if (rt == 0) {
				foo += "00";
				file += "BLTZ ";
				file += "R" + rs + ", #" + Integer.parseInt(foo, 2);
			}
			rd = Integer.parseInt(foo);
			typeHold = 2; // BR
		} else {

			// System.out.println("unknown op code");
			typeHold = 5; // ??
		}

		if (instructionParts[0].equals("000000") && instructionParts[5].equals("001101")) {
			broken = true;
			typeHold = 4; // N/A
		}
		return broken;

	}

	@SuppressWarnings("resource")
	public String simulator(String string, String cycleArguments) throws IOException {
		
		FileInputStream fis = null;

		fis = new FileInputStream(string);
		
		byte[] bs = new byte[4];
		
		fis.read(bs);
		
		String byteString = "";
    	
    	for(int i=0;  i<4; i++){
			
			int unsigned = bs[i] & 0xFF;
			String binaryString = Integer.toBinaryString(unsigned);
			
			/* To take care of the missing zero, which occurs due to direct conversion from Hex to Binary
			*  Example: After converting "8" to binary, JAVA by default considers it as "1000", thus preceding 3 zeros are missed
			*/
			while(binaryString.length()<8)
				binaryString = new StringBuilder(binaryString).insert(0, "0").toString();
		
			byteString += binaryString;
		}
		if (byteString.equals("00100000000010000000000000010100")) {
	
		Disassembler instructionDecoder1 = new Disassembler();
		outputFile = instructionDecoder1.disassemble(string);
		} else {
			
			InstructionDisassembler instructionDecoder2 = new InstructionDisassembler();
			outputFile = instructionDecoder2.disassemble(string);
			
		}
		return outputFile;
	}

}
