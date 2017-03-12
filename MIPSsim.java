
/* Author: Dhiraj Vasant Borade
 * MIPS 32 Simulator and Disassembler
 * University of Florida - Computer Architecture Principles
 * CDA5155 Fall 2016
 */

import java.io.IOException;
import java.io.PrintWriter;

public class MIPSsim {

	public static void main(String[] inputArguments) {

		/*
		 * Please enter valid Arguments in the following format:
		 * inputArguments[0] => Input Binary File Path inputArguments[1] =>
		 * Output Text File Path inputArguments[2] => Operation [sim or dis]
		 * inputArguments[3] => (Optional) -Tm:n [m -> Start Cycle and n -> End
		 * Cycle]
		 */

		// Get the Arguments in the form -> java MIPSsim inputFile outputFile
		// Command [-Tm:n]

		if ((inputArguments.length > 1 && !inputArguments[0].equals(null) && !inputArguments[1].equals(null))) {

			try {

				Simulator tomasuloAlgorithm = new Simulator();
				InstructionDisassembler instructionDecoder = new InstructionDisassembler();
				PrintWriter outputWriter = new PrintWriter(inputArguments[1], "UTF-8");
				if (inputArguments[2].equals("dis")) {

					outputWriter.print(instructionDecoder.disassembleInstruction(inputArguments[0]));
				}

				else if (inputArguments[2].equals("sim")) {

					String cycleArguments = "";
					if (inputArguments.length == 4) {

						cycleArguments = inputArguments[3];
					}
					// tomasuloAlgorithm.simulator(inputArguments[0],
					// inputArguments[1], cycleArguments);

					PrintWriter writer = new PrintWriter(inputArguments[1], "UTF-8");
					writer.print(tomasuloAlgorithm.simulator(inputArguments[0], cycleArguments));
					writer.close();
				} else {

					System.out.println("Please enter valid Operation [sim or dis]");
				}
				outputWriter.close();

			} catch (IOException exceptionio) {

				exceptionio.printStackTrace();
			}
		}

		else {
			System.out.println("Please enter valid Arguments in the following format:");
			System.out.println("inputArguments[0] => Input Binary File Path");
			System.out.println("inputArguments[1] => Output Text File Path");
			System.out.println("inputArguments[2] => Operation [sim or dis]");
			System.out.println("inputArguments[3] => (Optional) -Tm:n [m -> Start Cycle and n -> End Cycle]");
		}
	}
}
