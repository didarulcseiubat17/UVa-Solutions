package v116;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class RomanNumerals_UVa11616 {
	
	static int[] val = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
	static String[] key = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
	
	static String getRoman(int n)
	{
		String ret = "";
		while(n > 0)
			for(int i = 12; i >= 0; --i)
				if(val[i] <= n)
				{
					ret += key[i];
					n -= val[i];
					break;
				}
		return ret;
	}
	
	static int[] valOf = new int[26];
	
	static int getArabic(String s)
	{
		int ans = 0;
		for(int i = 0; i < s.length(); ++i)
		{
			int x = valOf[s.charAt(i)-'A'], y = i < s.length() - 1 ? valOf[s.charAt(i+1)-'A'] : 0;
			if(x < y)
			{
				ans += y - x;
				++i;
			}
			else
				ans += x;
		}
		return ans;
	}
	
	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		valOf['I'-'A'] = 1;	valOf['V'-'A'] = 5;	valOf['X'-'A'] = 10;
		valOf['L'-'A'] = 50; valOf['C'-'A'] = 100; valOf['D'-'A'] = 500;
		valOf['M'-'A'] = 1000;
		
		while(sc.ready())
		{
			String s = sc.next();
			if(s.charAt(0) >= '0' && s.charAt(0) <= '9')
				out.println(getRoman(Integer.parseInt(s)));
			else
				out.println(getArabic(s));
		}
		out.flush();
		out.close();
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){    br = new BufferedReader(new InputStreamReader(s));}

		public Scanner(FileReader r){    br = new BufferedReader(r);}

		public String next() throws IOException 
		{
			while (st == null || !st.hasMoreTokens()) 
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public int nextInt() throws IOException {return Integer.parseInt(next());}

		public long nextLong() throws IOException {return Long.parseLong(next());}

		public String nextLine() throws IOException {return br.readLine();}

		public double nextDouble() throws IOException { return Double.parseDouble(next()); }

		public boolean ready() throws IOException {return br.ready();}


	}
}