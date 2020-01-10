import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Moocryption {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("moocrypt.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocrypt.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] grid = new int[N][M];
		int[][] letters = new int[26][26];
		int[] dx = { 1, 2, 1, 2, 1, 2, 0, 0, -1, -2, -1, -2, -1, -2, 0, 0 };
		int[] dy = { 1, 2, 0, 0, -1, -2, -1, -2, -1, -2, 0, 0, 1, 2, 1, 2 };
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().replace("", " "));
			for (int j =  0; j < M; j++) {
				grid[i][j] = st.nextToken().hashCode() - 65;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (grid[i][j] == 12)
					continue;
				for (int k = 0; k < 16; k += 2) {
					if ((i + dx[k] < 0 || i + dx[k] > N - 1) || (j + dy[k] < 0 || j + dy[k] > M - 1)) {
						continue;
					}
					if ((i + dx[k + 1] < 0 || i + dx[k + 1] > N - 1) || (j + dy[k + 1] < 0 || j + dy[k + 1] > M - 1)) {
						continue;
					}
					if (grid[i + dx[k]][j + dy[k]] == 14 || grid[i + dx[k + 1]][j + dy[k + 1]] == 14)
						continue;
					if ((grid[i + dx[k]][j + dy[k]] == grid[i + dx[k + 1]][j + dy[k + 1]])) {
						if(grid[i + dx[k]][j + dy[k]] == grid[i][j])
							continue;
						letters[grid[i][j]][grid[i + dx[k]][j + dy[k]]]++;
					}
				}
			}
		}
		int count = -1;
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				count = Math.max(letters[i][j], count);
			}
		}
		pw.println(count);
		pw.close();
	}
}
