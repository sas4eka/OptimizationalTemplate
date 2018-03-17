import java.io.IOException;
import java.io.PrintWriter;

public class Split {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String task = Settings.taskName;
		String inputFormat = Settings.inputFormat;
		for (int k = 0; k <= 10; k++) {
			String testfile = String.format("%s%02d%s", task, k, inputFormat);
			Reader reader = new Reader(testfile);
			int tests = reader.nextInt();
			for (int t = 0; t < tests; t++) {
				String partFile = String.format("%s%02d_%04d%s", task, k, t, inputFormat);
				System.out.print(String.format("\"%s%02d_%04d\"", task, k, t) + ", ");
				PrintWriter partWriter = new PrintWriter(partFile);

				// TODO: read from reader and write to separate writers
				// int m = reader.nextInt();
				// int n = reader.nextInt();
				// partWriter.println(m + " " + n);

				partWriter.close();
			}
			reader.close();
		}
	}

}
