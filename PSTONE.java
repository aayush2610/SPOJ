package ques;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PSTONE {
	public static void main(String[] args) throws Exception {
		BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(b.readLine());
		for(int k=0;k<t;k++){
			int m,n;
			String[] str = new String[2];
			str = b.readLine().split(" ");
			m=Integer.parseInt(str[0]);
			n=Integer.parseInt(str[1]);
			String[][] in = new String[m][n];
			for(int i=0;i<m;i++){
				in[i]= b.readLine().split(" ");
			}
			int[][] dp=new int[m][n];
			int[][] d=new int[m][n];
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					d[i][j]=Integer.parseInt(in[i][j]);
					if(i==0)
						dp[i][j]=d[i][j];
				}
			}
			for(int i=1;i<m;i++){
				for(int j=0;j<n;j++){
				    if(n==1)
				    	dp[i][j]=d[i][j]+dp[i-1][j];
					else if(j==0)
						dp[i][j]=d[i][j]+Math.max(dp[i-1][j], dp[i-1][j+1]);
					else if(j==n-1)
						dp[i][j]=d[i][j]+Math.max(dp[i-1][j-1], dp[i-1][j]);
					else
						dp[i][j]=d[i][j]+Math.max(Math.max(dp[i-1][j], dp[i-1][j+1]), dp[i-1][j-1]);
				}
			}
			int max=0;
			for(int j=0;j<n;j++){
				if(dp[m-1][j]>max)
					max=dp[m-1][j];
			}
			System.out.println(max);
		}
	}
}
