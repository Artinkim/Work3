import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class pair {
	int x;
	int y;

	pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class MilkVisits {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] farmMilk = new boolean[N];
		boolean[] visited = new boolean[N];
		ArrayList<Integer>[] connections = new ArrayList[N];
		Stack<pair> stack = new Stack<pair>();
		int[][] dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			connections[i] = new ArrayList<Integer>();
		}
		st = new StringTokenizer(br.readLine().replace("", " "));
		for (int i = 0; i < N; i++) {
			if (st.nextToken().equals("H"))
				farmMilk[i] = true;
		}
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			connections[a].add(b);
			connections[b].add(a);

		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			if (dp[temp][end] == 0) {
				if (farmMilk[temp]) {
					stack.add(new pair(temp, 1));
				} else {
					stack.add(new pair(temp, 2));
				}

				int answer = 0;
				while (!stack.isEmpty()) {
					pair current = stack.pop();
					if ((current.y == 2 && farmMilk[current.x]) || (current.y == 1 && !farmMilk[current.x])) {
						current.y = 3;
					}
					if (current.x == end) {
						answer = current.y;
						break;
					}
					for (int j = 0; j < connections[current.x].size(); j++) {
						if (visited[connections[current.x].get(j)]) {
							continue;
						}
						stack.add(new pair(connections[current.x].get(j), current.y));
						visited[connections[current.x].get(j)] = true;
					}
				}
				Arrays.fill(visited, false);
				 String temp1 = st.nextToken();
				if (answer == 3 || (temp1.equals("H") && answer == 1) || (temp1.equals("G") && answer == 2)) {
					pw.print(1);
				} else {
					pw.print(0);
				}
			} else {
				String temp1 = st.nextToken();
				if (dp[temp][end] == 3 || (temp1.equals("H") && dp[temp][end] == 1)
						|| (temp1.equals("G") && dp[temp][end] == 2)) {
					pw.print(1);
				} else {
					pw.print(0);
				}
			}
		}
		pw.close();
	}
}
