package ques;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AssignBitMask {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t>0){
			t--;
			int n=Integer.parseInt(br.readLine());
			int[][] arr=new int[n][n];
			for(int i=0;i<n;i++){
				String[] s=br.readLine().split(" ");
				for(int j=0;j<n;j++){
					arr[i][j]=Integer.parseInt(s[j]);
				}
			}
			long[] dp=new long[1<<n];
			dp[0]=1;
			for(int i=1;i<(1<<n);i++){
				dp[i]=0;
				int j=0;
				for(int k=0;k<n;k++)
					j+=(i>>k)&1;
				for(int p=0;p<n;p++){
					if(arr[j-1][p]==1 && ((i>>p)&1)==1){
						dp[i]+=dp[i & ~(1<<p)];
					}
				}
			}
			System.out.println(dp[(1<<n)-1]);
		}
	}
}
