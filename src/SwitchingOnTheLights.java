import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	int x;
	int y;

	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class SwitchingOnTheLights {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lightson.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Pair>[][] switches = new ArrayList[N][N];
		boolean[][] lights = new boolean[N][N];
		boolean[][] visited = new boolean[N][N];
		Queue<Pair> queue = new LinkedList<Pair>();
		ArrayList<Pair> arr = new ArrayList<Pair>();
		queue.add(new Pair(0, 0));
		lights[0][0] = true;
		visited[0][0] = true;
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				switches[i][j] = new ArrayList<Pair>();
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			switches[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1]
					.add(new Pair(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1));
		}
		Pair current;
		while (!queue.isEmpty()) {
			current = queue.poll();
			arr.add(current);
			// System.out.println(curr3ent.x+" "+current.y);
			for (int i = 0; i < switches[current.x][current.y].size(); i++) {
				Pair p = switches[current.x][current.y].get(i);
				lights[p.x][p.y] = true;
			}
			for (int j = 0; j < arr.size(); j++) {	
				current = arr.get(j);
				// System.out.println(" "+current.x+" "+current.y);
				for (int i = 0; i < 4; i++) {
					if (current.x + dx[i] > N - 1 || current.x + dx[i] < 0
						|| current.y + dy[i] > N - 1 || current.y + dy[i] < 0)
						continue;
					 //System.out.println(current.x + dx[i]+" "+(current.y + dy[i]));
					if (visited[current.x + dx[i]][current.y + dy[i]])
						continue;
					if (!lights[current.x + dx[i]][current.y + dy[i]])
						continue;
					visited[current.x + dx[i]][current.y + dy[i]] = true;
					queue.add(new Pair(current.x + dx[i], current.y + dy[i]));
				}
			}
		}
		int count = 0;
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(lights[i][j])
					count++;
			}
		}
		pw.println(count);
		pw.close();
	}
}
