import java.io.IOException;

public class Input {
	// TODO: is it max or min task?
	boolean minimizeScore = false;

	String testname;
	// TODO: input fields

	public Input(String testname) throws IOException {
		this.testname = testname;
		// TODO: init default input fields
	}

	void readFromFile() throws IOException {
		String filename = Settings.inputDir + testname + Settings.inputFormat;
		Reader reader = new Reader(filename);
		// TODO: read input
		reader.close();
	}
}
