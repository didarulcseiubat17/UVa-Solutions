package v109;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HowManyDependencies_UVa10926 {

	static int[][] adjList;
	static boolean[] vis;

	static int deps(int u)
	{
		vis[u] = true;
		int ret = 1;
		for(int v: adjList[u])
			if(!vis[v])
				ret += deps(v);
		return ret;
	}

	public static void main(String[] args) throws IOException 
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		while(true)
		{
			int N = sc.nextInt();
			if(N == 0)
				break;
			adjList = new int[N][];
			for(int i = 0; i < N; ++i)
			{
				int T = sc.nextInt();
				adjList[i] = new int[T];
				for(int j = 0; j < T; ++j)
					adjList[i][j] = sc.nextInt() - 1;
			}
			int ans = -1, idx = -1;
			for(int i = 0; i < N; ++i)
			{
				vis = new boolean[N];
				int cur = deps(i);
				if(cur > ans)
				{
					ans = cur;
					idx = i;
				}
			}
			out.println(idx + 1);
		}
		out.flush();
		out.close();
	}

	static class Scanner 
	{
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

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