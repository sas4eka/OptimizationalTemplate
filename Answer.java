import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Answer {
	// TODO: fields
	Input input;
	String testname;
	private long score;

	public Answer(Input input) {
		// TODO: init fields of empty answer
		this.input = input;
		this.testname = input.testname;
		score = -1;
	}

	// TODO: implement method to pass some values to the answer
	private void updateScore() {
		score = 0;
		// TODO: update score
	}

	long getScore() {
		if (score == -1) {
			updateScore();
		}
		return score;
	}

	void invalidateScore() {
		score = -1;
	}

	private void print(String filename) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(filename);
		// TODO: print solution
		writer.close();
	}

	void print() throws FileNotFoundException {
		String filename = Settings.outputDir + testname + Settings.outputFormat;
		print(filename);
	}

	void printWithScore() throws FileNotFoundException {
		String filename = String.format("%s%s_%018d%s", Settings.outputDir, testname, score, Settings.outputFormat);
		print(filename);
	}

	void readFromFile() throws IOException {
		invalidateScore();
		String filename = Settings.outputDir + testname + Settings.outputFormat;
		try {
			Reader reader = new Reader(filename);
			// TODO: read answer from file
			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("File " + filename + " not found");
		}
	}
}
