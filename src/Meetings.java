import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Cow implements Comparable<Cow> {
	int x;
	int w;
	boolean l;

	Cow(int x, int w, boolean l) {
		this.x = x;
		this.w = w;
		this.l = l;
	}

	@Override
	public int compareTo(Cow o) {
		// TODO Auto-generated method stub
		return this.x - o.x;
	}
}

public class Meetings {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("meetings.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<Integer>();
		Cow[] arr1 = new Cow[N];
		Cow[] arr2 = new Cow[N];
		Cow[] arr3 = new Cow[N];
		ArrayList<Cow> left = new ArrayList<Cow>();
		ArrayList<Cow> right = new ArrayList<Cow>();
		int totalWeight = 0;
		int k = 0;
		int count;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			totalWeight += a;
			if (Integer.parseInt(st.nextToken()) == 1) {
				arr1[i] = new Cow(L - b, a, false);
				arr2[i] = new Cow(b, a, false);
				right.add(new Cow(b, a, false));
				k++;
			} else {
				arr1[i] = new Cow(b, a, true);
				arr2[i] = new Cow(b, a, true);
				left.add(new Cow(b, a, false));
				
			}
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		Collections.sort(left);
		Collections.sort(right);
		for (int i = 0; i < left.size(); i++) {
			arr3[i] = new Cow(left.get(i).x, arr2[i].w, true);
		}
		for (int i = 0; i < right.size(); i++) {
			arr3[left.size() + i] = new Cow(L - right.get(i).x, arr2[left.size() + i].w, true);
		}
//		int j = 0;
//		for (int i = 0; i < N; i++) {
//			if (arr2[i].l) {
//				arr3[i] = new Cow(arr1[j].x, arr2[j].w, true);
//				j++;
//
//			} else {
//				arr3[i] = new Cow(arr1[k].x, arr2[k].w, false);
//				k++;
//			}
//		}
		Arrays.sort(arr3);
		int weight = 0;
		int w = 0;
		for (; weight < totalWeight / 2; w++) {
			weight += arr3[w].w;
		}
		int T = arr3[w - 1].x;
		int collisions = 0;
		for (int i = 0; i < N; i++) {
			if (arr2[i].l) {
				if (!queue.isEmpty()) {
					while (queue.peek() + T * 2 < arr2[i].x) {
						queue.poll();
					}
					collisions += queue.size();
				}
			} else {
				queue.add(arr2[i].x);
			}
		}
		pw.println(collisions);
		pw.close();
	}
}
