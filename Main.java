import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	static boolean SHOW_VISUALIZATION = false;
	static boolean SHOW_ONLY_INPUT = true;
	static boolean SHOW_ALL_SOLUTIONS = true;

	static boolean OPTIMIZE_SOLUTIONS = false;

	static Visualizer v;

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO: put all test names
		String[] testnames = { "example" };
		if (SHOW_VISUALIZATION) {
			v = new Visualizer();
		}
		for (String testname : testnames) {
			long timePerTest = 1000; // ms
			runTest(testname, timePerTest, new RandomSolver(), new RandomOptimizer());
		}
		System.out.println("done!");
	}

	static void runTest(String testname, long timePerTest, Solver solver, Optimizer optimizer)
			throws IOException, InterruptedException {
		Input input = new Input(testname);
		input.readFromFile();

		Answer bestAnswer = readBestAnswer(input);

		if (SHOW_VISUALIZATION) {
			v.setFrame(getInputFrame(input));
		}

		if (SHOW_VISUALIZATION && SHOW_ONLY_INPUT) {
			v.setTitle(testname);
			v.setFrame(getInputFrame(input));
			Thread.sleep(2000);
		} else {
			long start = System.currentTimeMillis();
			while (System.currentTimeMillis() - start > timePerTest) {
				Answer answer = solver.solve(input);
				if (OPTIMIZE_SOLUTIONS) {
					while (true) {
						long oldScore = answer.getScore();
						if (optimizer.optimize(answer)) {
							answer.invalidateScore();
							System.out.println(
									answer.testname + " WAS OPTIMIZED: " + oldScore + "->" + answer.getScore());
						} else {
							break;
						}
					}
				}
				int sign = Settings.minimizeScore ? -1 : 1;
				if (sign * answer.getScore() > sign * bestAnswer.getScore()) {
					onBestAnswerUpdate(bestAnswer, answer);
					bestAnswer = answer;
					if (SHOW_VISUALIZATION) {
						v.setFrame(getSolutionFrame(input, answer));
					}
				}
				if (SHOW_VISUALIZATION && SHOW_ALL_SOLUTIONS) {
					v.setFrame(getSolutionFrame(input, answer));
				}
			}
		}
	}

	static void onBestAnswerUpdate(Answer oldAnswer, Answer newAnswer) throws FileNotFoundException {
		System.out.println(
				newAnswer.testname + " HAS NEW BEST SCORE: " + oldAnswer.getScore() + "->" + newAnswer.getScore());
		newAnswer.print();
		newAnswer.printWithScore();
	}

	static Answer readBestAnswer(Input input) throws IOException {
		Answer bestAnswer = new Answer(input);
		bestAnswer.readFromFile();
		return bestAnswer;
	}

	static private BufferedImage getInputFrame(Input input) {
		return new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		// int n = input.n;
		// int m = input.m;
		// BufferedImage frame = new BufferedImage(m, n, BufferedImage.TYPE_INT_RGB);
		// for (int x = 0; x < n; x++) {
		// for (int y = 0; y < m; y++) {
		// int r = 255;
		// int g = 255;
		// int b = 255;
		// if (input.field[x][y] == 1) {
		// b = g = 0;
		// } else if (input.field[x][y] == 0) {
		// b = r = 0;
		// } else {
		// System.err.println("Unknown field " + input.field[x][y]);
		// }
		// frame.setRGB(y, x, (r << 16) + (g << 8) + b);
		// }
		// }
		// return frame;
	}

	static private BufferedImage getSolutionFrame(Input input, Answer answer) {
		return new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		// int n = input.n;
		// int m = input.m;
		// BufferedImage frame = new BufferedImage(m, n, BufferedImage.TYPE_INT_RGB);
		// for (int x = 0; x < n; x++) {
		// for (int y = 0; y < m; y++) {
		// int r = 255;
		// int g = 255;
		// int b = 255;
		// if (input.field[x][y] == 1) {
		// b = g = 0;
		// } else if (input.field[x][y] == 0) {
		// b = r = 0;
		// } else {
		// System.err.println("Unknown field " + input.field[x][y]);
		// }
		// frame.setRGB(y, x, (r << 16) + (g << 8) + b);
		// }
		// }
		// for (int i = 0; i < s.M; i++) {
		// int ar = s.ar[i];
		// int as = s.as[i];
		// int ap = s.ap[i];
		// if (ap != -1) {
		// int r = (i + ar * as + ap + (int) s.score) % 200;
		// int g = (i + ar + as * ap + (int) s.score) % 200;
		// int b = 255;
		// for (int y = as; y < as + input.z[i]; y++) {
		// frame.setRGB(y, ar, (r << 16) + (g << 8) + b);
		// }
		// }
		// }
		// return frame;
	}
}
