import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Pair2 implements Comparable<Pair2> {
	int x;
	int y;

	Pair2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Pair2 o) {
		// TODO Auto-generated method stub
		return this.x - o.x;
	}
}

public class TrappedInTheHaybales {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("trapped.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("trapped.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		TreeSet<Pair2> left = new TreeSet<Pair2>();
		TreeSet<Pair2> right = new TreeSet<Pair2>();
		int temp1, temp2;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			temp1 = Integer.parseInt(st.nextToken());
			temp2 = Integer.parseInt(st.nextToken());
			if (temp2 > B) {
				right.add(new Pair2(temp2, temp1));
			} else {
				left.add(new Pair2(temp2, temp1));
			}
		}
		if (left.size() == 0 || right.size() == 0) {
			pw.println(-1);
		} else {
			Pair2 l = new Pair2(-1, -1), r = new Pair2(-1, -1);
			int count = Integer.MAX_VALUE;
			boolean impossible = true;
			while (left.size() > 0 && right.size() > 0) {
				if (left.size() > 0)
					l = left.last();
				if (right.size() > 0)
					r = right.first();
				int difference = r.x - l.x;
				boolean a = difference > r.y;
				boolean b = difference > l.y;
				System.out.println(a + " " + b);
				System.out.println(l.x + " " + r.y);
				if (a && b) {
					if (a) {
						right.pollFirst();
						continue;
					}
					if (b) {
						left.pollLast();
						continue;
					}
				} else if (a || b) {
					impossible = false;
					if (a) {
						count = Math.min(difference - l.y, count);
						right.pollFirst();
						continue;
					}
					if (b) {
						count = Math.min(difference - r.y, count);
						left.pollLast();
						continue;
					}
				} else {
					impossible = false;
					count = 0;
					break;
				}

			}
			System.out.println(count);
			System.out.println(impossible);
			if (impossible) {
				pw.println(-1);
			} else {
				pw.println(count);
			}
		}
		pw.close();
	}
}
