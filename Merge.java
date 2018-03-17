import java.io.IOException;
import java.io.PrintWriter;

public class Merge {
	public static void main(String[] args) throws NumberFormatException, IOException {
		String task = Settings.taskName;
		String inputFormat = Settings.inputFormat;
		String outputFormat = Settings.outputFormat;
		String inDir = Settings.inputDir;
		String outDir = Settings.outputDir;
		String partsDir = Settings.partsDir;
		for (int k = 1; k <= 10; k++) {
			String testfile = String.format("%s%s%02d%s", inDir, task, k, inputFormat);
			Reader reader = new Reader(testfile);
			PrintWriter writer = new PrintWriter(String.format("%s%s%02d%s", outDir, task, k, outputFormat));
			int tests = reader.nextInt();
			for (int t = 0; t < tests; t++) {

				// TODO: read sizes from initial input, skip most data
				// int n = reader.nextInt();
				// for (int i = 0; i < n; i++) {
				// reader.nextInt();
				// }

				String partFile = String.format("%s%s%02d_%04d%s", partsDir, task, k, t, outputFormat);
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
