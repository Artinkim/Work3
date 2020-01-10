import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Pair4 {
	int x;
	int y;
	Pair4(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class CowHopscotchBronze {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("hopscotch.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hopscotch.out")));
		Queue<Pair4> queue = new LinkedList<Pair4>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		boolean[][] grid = new boolean[R][C];
		for(int i = 0;i<R;i++) {
			st = new StringTokenizer(br.readLine().replace(""," "));
			for(int j = 0;j<C;j++) {
				if(st.nextToken().equals("R")) {
					grid[i][j] = true;
				}
			}
		}
		queue.add(new Pair4(0,0));
		int count = 0;
		while(!queue.isEmpty()) {
			Pair4 current = queue.poll();
			if(current.x == R-1 &&current.y ==C-1)
				count++;
			for(int i = current.x+1;i<R;i++) {
				for(int j = current.y+1;j<C;j++) {
					if(grid[i][j] == grid[current.x][current.y]) 
						continue;
					queue.add(new Pair4(i,j));
				}
			}
		}
		pw.println(count);
		pw.close();
	}
}
