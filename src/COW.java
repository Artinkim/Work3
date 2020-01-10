import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class COW {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cow.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cow.out")));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		int[] PrefixSumO = new int[N+1];
		int[] PrefixSumW = new int[N+1];
		long count = 0;
		for(int i = N-1;i>-1;i--) {
			PrefixSumO[i] = PrefixSumO[i+1];
			PrefixSumW[i] = PrefixSumW[i+1];
			if(str.charAt(i) == 'C') {
				count+=PrefixSumO[i];
			} else if(str.charAt(i) == 'O') {
				PrefixSumO[i] += PrefixSumW[i];
			} else {
				PrefixSumW[i]++;
			}
		}
		pw.println(count);
		pw.close();
		
	}
}
