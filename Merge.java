import java.io.IOException;
import java.io.PrintWriter;

public class Merge {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String task = "example";
		for (int k = 1; k <= 10; k++) {
			String testfile = String.format("%s%02d.in", task, k);
			Reader reader = new Reader(testfile);
			PrintWriter writer = new PrintWriter(String.format("%s%02d.ans", task, k));
			int tests = reader.nextInt();
			for (int t = 0; t < tests; t++) {

				// TODO: read sizes from initial input, skip most data
				// int n = reader.nextInt();
				// for (int i = 0; i < n; i++) {
				// reader.nextInt();
				// }

				String partfile = String.format("%s%02d_%04d.ans", task, k, t);
				Reader partreader = new Reader(partfile);

				// TODO: read answers from parts and merge them together
				// for (int i = 0; i < n; i++) {
				// int x = partreader.nextInt();
				// writer.println(x);
				// }

				partreader.close();
			}
			writer.close();
			reader.close();
		}
	}
}
