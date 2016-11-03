package ques;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MARTIAN {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String[] s=br.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int m=Integer.parseInt(s[1]);
			if(n==0 && m==0)
				break;
			int[][] left=new int[n][m];
			int[][] up=new int[n][m];
			for(int i=0;i<n;i++){
				s=br.readLine().split(" ");
				for(int j=0;j<m;j++){
					left[i][j]=Integer.parseInt(s[j]);
				}
			}
			for(int i=0;i<n;i++){
				s=br.readLine().split(" ");
				for(int j=0;j<m;j++){
					up[i][j]=Integer.parseInt(s[j]);
				}
			}
			for(int i=0;i<n;i++){
				for(int j=1;j<m;j++){
					left[i][j]+=left[i][j-1];
				}
			}
			for(int i=0;i<m;i++){
				for(int j=1;j<n;j++){
					up[j][i]+=up[j-1][i];
				}
			}
			int[][] dp=new int[n][m];
			for(int i=0;i<n;i++){
				for(int j=0;j<m;j++){
					int a1=left[i][j];
					int a2=up[i][j];
					if(j>0){
						a2=a2+dp[i][j-1];
					}
					if(i>0){
						a1=a1+dp[i-1][j];
					}
					dp[i][j]=Math.max(a1, a2);
				}
			}
			System.out.println(dp[n-1][m-1]);
		}
	}
}
