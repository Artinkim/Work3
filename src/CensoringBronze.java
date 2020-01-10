import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CensoringBronze {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("censor.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));
		String str = br.readLine();
		String censor = br.readLine();
		StringBuilder sb = new StringBuilder(str.substring(0, censor.length()));
		for (int i = censor.length(); i < str.length(); i++) {
			sb.append(str.charAt(i));
			if (sb.length() >= censor.length()) {
				if (sb.substring(sb.length() - censor.length(), sb.length()).equals(censor)) {
					sb.delete(sb.length() - censor.length(), sb.length());
				}
			}
		}
		System.out.println(sb.toString());
		pw.println(sb.toString());
		pw.close();
	}
}
