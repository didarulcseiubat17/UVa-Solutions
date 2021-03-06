package v004;
	
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
	
public class SynchingSignals_UVa467{
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();int k = 1;
	    while(br.ready())
	    {
	    	sb.append("Set "+k++);
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	int n = st.countTokens();
	    	int[] periods = new int[n];
	    	int minPeriod = 180;
	    	for(int i = 0; i < n; i++)
	    	{
	    		periods[i] = Integer.parseInt(st.nextToken())*2;
	    		if(periods[i]<minPeriod)
	    			minPeriod = periods[i];
	    	}
	    	int time = minPeriod/2-4;boolean gotGreen = false;
	    	while(!gotGreen&&time<=3600)
	    	{
	    		gotGreen = true;
	    		for(int i = 0; i < n; i++)
	    		{ 
	    			if(time%periods[i]>=periods[i]/2-5)
	    				gotGreen = false;
	    		}
	    		time ++;
	    	}
	    	if(!gotGreen)
	    		sb.append(" is unable to synch after one hour.\n");
	    	else
	    	{
	    		time--;
	    		int minutes = time/60;
	    		int seconds = time%60;
	    		sb.append(" synchs again at "+minutes+" minute(s) and "+seconds+" second(s) after all turning green.\n");
	    	}
	    }
		
		
		
		
		
		System.out.print(sb);
		
	}
	
	
	
}	