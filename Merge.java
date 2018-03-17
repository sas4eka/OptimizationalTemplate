import java.io.IOException;
import java.io.PrintWriter;

public class Merge {
	static final String inputFormat = ".in";
	static final String outputFormat = ".out";

	public static void main(String[] args) throws NumberFormatException, IOException {
		String task = "example";
		for (int k = 1; k <= 10; k++) {
			String testfile = String.format("%s%02d" + inputFormat, task, k);
			Reader reader = new Reader(testfile);
			PrintWriter writer = new PrintWriter(String.format("%s%02d" + outputFormat, task, k));
			int tests = reader.nextInt();
			for (int t = 0; t < tests; t++) {

				// TODO: read sizes from initial input, skip most data
				// int n = reader.nextInt();
				// for (int i = 0; i < n; i++) {
				// reader.nextInt();
				// }

				String partFile = String.format("%s%02d_%04d" + outputFormat, task, k, t);
				Reader partReader = new Reader(partFile);

				// TODO: read answers from parts and merge them together
				// for (int i = 0; i < n; i++) {
				// int x = partReader.nextInt();
				// writer.println(x);
				// }

				partReader.close();
			}
			writer.close();
			reader.close();
		}
	}
}
