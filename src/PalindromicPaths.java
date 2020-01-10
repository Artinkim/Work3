import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Palindrome {
	int x;
	int y;
	String str;

	Palindrome(int x, int y, String str) {
		this.x = x;
		this.y = y;
		this.str = str;
	}

}

public class PalindromicPaths {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("palpath.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("palpath.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Palindrome> queue = new LinkedList<Palindrome>();
		int N = Integer.parseInt(st.nextToken());
		String[][] grid = new String[N][N];
		HashSet<String> hs1 = new HashSet<String>();
		HashSet<String> hs2 = new HashSet<String>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().replace("", " "));
			for (int j = 0; j < N; j++) {
				grid[i][j] = st.nextToken();
			}
		}
		queue.add(new Palindrome(0, 0, ""));
		Palindrome current;
		while (!queue.isEmpty()) {
			current = queue.poll();
			current.str += grid[current.x][current.y];
			if (current.x + current.y == N - 1) {
				hs1.add(current.str);
				continue;
			}
			queue.add(new Palindrome(current.x, current.y + 1, current.str));
			queue.add(new Palindrome(current.x + 1, current.y, current.str));
		}
		queue.add(new Palindrome(N - 1, N - 1, ""));
		while (!queue.isEmpty()) {
			current = queue.poll();
			current.str += grid[current.x][current.y];
			if (current.x + current.y == N - 1) {
				hs2.add(current.str);
				continue;
			}
			queue.add(new Palindrome(current.x, current.y - 1, current.str));
			queue.add(new Palindrome(current.x - 1, current.y, current.str));
		}
		int count = 0;
		Iterator<String> it = hs1.iterator();
		for(int i = 0;i<hs1.size();i++) {
			if(hs2.contains(it.next()))
				count++;
		}
		pw.println(count);
		pw.close();

	}
}
