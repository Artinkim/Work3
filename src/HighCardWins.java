import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class HighCardWins {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
		int N = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[2 * N];
		ArrayList<Integer> bessie = new ArrayList<Integer>();
		ArrayList<Integer> ellise = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine()) - 1] = true;
		}
		for (int i = 0; i < N * 2; i++) {
			if (arr[i]) {
				ellise.add(i);
			} else {
				bessie.add(i);
			}
		}
		int count = 0;
		int i = 0;
		int j = 0;
		while (i < N && j < N) {
			if (ellise.get(i) < bessie.get(j)) {
				count++;
				j++;
				i++;
			} else {
				j++;
			}
		}
		pw.println(count);
		pw.close();
	}
}
