import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BessieGoesMoo {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("bgm.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bgm.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr2 = new int[7][500];
		int[][] arr = new int[3][500];
		String str;
		int a2 = 0, b2 = 0, c2 = 0, d2 = 0, e2 = 0, f2 = 0, g2 = 0, temp;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); 
			str = st.nextToken();
			temp = Integer.parseInt(st.nextToken());
			if (str.equals("B")) {
				arr[0][a2] += temp;
				a2++;
			} else if (str.equals("E")) {
				arr[0][b2] += temp * 2;
				arr[1][b2] += temp;
				b2++;
			} else if (str.equals("S")) {
				arr[0][c2] += temp * 2;
				arr[1][c2] += temp;
				c2++;
			} else if (str.equals("I")) {
				arr[2][d2] += temp;
				d2++;
			} else if (str.equals("G")) {
				arr[1][e2] += temp;
				e2++;
			} else if (str.equals("O")) {
				arr[1][f2] += temp;
				arr[2][f2] += temp * 2;
				f2++;
			} else {
				arr[2][g2] += temp;
				g2++;
			}
		}
		int count = 0;
		for (int a = 0; a < arr[0].length; a++) {
			for (int b = 0; b < arr[1].length; b++) {
				for (int c = 0; c < arr[2].length; c++) {
					if ((arr[0][a] * arr[1][b] * arr[2][c]) % 7 == 0)
						count++;
				}
			}
		}

//		for (int a = 0; a < a2; a++) {
//			for (int b = 0; b < b2; b++) {
//				for (int c = 0; c < c2; c++) {
//					for (int d = 0; d < d2; d++) {
//						for (int e = 0; e < e2; e++) {
//							for (int f = 0; f < f2; f++) {
//								for (int g = 0; g < g2; g++) {
//									bessie = arr[0][a] + arr[1][b] * 2 + arr[2][c] * 2 + arr[3][d];
//									goes = arr[4][e] + arr[5][f] + arr[1][b] + arr[2][c];
//									moo = arr[6][g] + arr[5][f] * 2;
//									if ((bessie * goes * moo) % 7 == 0) {
//										count++;
//									}
//								}
//							}
//						}
//					}
//				}
//			}
//		}
		pw.println(count);
		pw.close();
	}
}
