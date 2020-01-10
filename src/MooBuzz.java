import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MooBuzz {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
		int N = Integer.parseInt(br.readLine());
		long min = 0;
		long max = 2000000000;
		long key = 0;
		while (min != max) {
			key = (min + max) / 2;
			if (key -(key / 3) - (key / 5) + (key / 15) >= N) {
				max = key;
			} else {
				min = key + 1;
			}
		}
		pw.println(min);
		pw.close();
	}
}
