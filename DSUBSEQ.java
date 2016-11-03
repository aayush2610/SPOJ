package ques;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class DSUBSEQ {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t>0){
			t--;
			String s=br.readLine();
			HashMap<Character, Integer> hm=new HashMap<Character, Integer>();
			long[] dp=new long[s.length()+1];
			dp[0]=1;
			for(int i=1;i<=s.length();i++){
				if(!hm.containsKey(s.charAt(i-1))){
					hm.put(s.charAt(i-1),i-1);
					dp[i]=2*dp[i-1]%1000000007;
				}
				else{
					dp[i]=2*dp[i-1]-dp[hm.get(s.charAt(i-1))];
					if(dp[i]<=0){
						dp[i]=dp[i]+1000000007;
					}
					dp[i]=dp[i]%1000000007;
					hm.put(s.charAt(i-1), i-1);
				}
			}
			System.out.println(dp[s.length()]);
		}
	}
}
