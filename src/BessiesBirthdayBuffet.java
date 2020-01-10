import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

class Pair3 implements Comparable<Pair3> {
	int x;
	int y;

	Pair3(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Pair3 o) {
		// TODO Auto-generated method stub
		return this.y - o.y;
	}
}

public class BessiesBirthdayBuffet {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("buffet.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("buffet.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Pair3> queue = new LinkedList<Pair3>();
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
		int[] arr = new int[N];
		int[] original = new int[N];
		int[] arr2 = new int[N];
		boolean[] visited = new boolean[N];
		ArrayList<Integer>[] connections = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			connections[i] = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			tm.put(temp, i);
			arr2[i] = temp;
			original[i] = temp;
			int t = Integer.parseInt(st.nextToken());
			for (int j = 0; j < t; j++) {
				connections[i].add(Integer.parseInt(st.nextToken()) - 1);
			}
		}
		Arrays.sort(arr2);
 		for (int i = 0; i < N; i++) {
			arr[i] = arr2[i];
		}
		Pair3 current;
		for (int i = 0; i < N; i++) {
			queue.add(new Pair3(i, 1));
			visited[i] = true;
			System.out.println(original[tm.get(arr[i])]);
			while (!queue.isEmpty()) {
				current = queue.poll();
				for (int j = 0; j < connections[current.x].size(); j++) {
					if (visited[connections[current.x].get(j)])
						continue;
					if (tm.get(arr2[connections[current.x].get(j)]) > arr2[i]) {
						arr[connections[current.x].get(j)] = Math.max(
								arr[i] + arr2[connections[current.x].get(j)] - (E * current.y),
								arr[connections[current.x].get(j)]);
					}
					queue.add(new Pair3(connections[current.x].get(j), current.y + 1));
					visited[connections[current.x].get(j)] = true;

				}
			}
			Arrays.fill(visited, false);
		}
		int count = -1;
		for (int i = 0; i < N; i++) {
			count = Math.max(arr[i], count);
		}
		pw.println(count);
		pw.close();
	}
}
