import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BreedCounting {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int[][] arr = new int[3][N + 1];
		int a = 0, b = 0, c = 0;
		for (int i = 1; i < N + 1; i++) {
			for (int j = 0; j < 3; j++)
				arr[j][i] = arr[j][i - 1];
			arr[Integer.parseInt(br.readLine()) - 1][i]++;
		}
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken());
			pw.write(arr[0][e] - arr[0][s] + " ");
			pw.write(arr[1][e] - arr[1][s] + " ");
			pw.write(arr[2][e] - arr[2][s] + "\n");
		}
		pw.close();
	}
}
