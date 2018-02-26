import java.io.IOException;
import java.io.PrintWriter;

public class Split {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String task = "example";
		for (int k = 0; k <= 10; k++) {
			String testfile = String.format("%s%02d.in", task, k);
			Reader reader = new Reader(testfile);
			int tests = reader.nextInt();
			for (int t = 0; t < tests; t++) {
				String partfile = String.format("%s%02d_%04d.in", task, k, t);
				System.out.print(String.format("\"%s%02d_%04d\"", task, k, t) + ", ");
				PrintWriter writer = new PrintWriter(partfile);

				// TODO: read from reader and write to separate writers
				// int m = reader.nextInt();
				// int n = reader.nextInt();
				// writer.println(m + " " + n);

				writer.close();
			}
			reader.close();
		}
	}

}
