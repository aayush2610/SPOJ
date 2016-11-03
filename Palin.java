package ques;

import java.util.Scanner;

public class Palin {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		while(t>0){
			String s=scanner.next();
			int n=s.length();
			int [][]dp=new int[n][n];
			for(int i=n-1;i>=0;i--){
				for(int j=i;j<n;j++){
					if(i==j)
						dp[i][j]=0;
					else if(s.charAt(i)==s.charAt(j))
						dp[i][j]=dp[i+1][j-1];
					else
						dp[i][j]=1+Math.min(dp[i][j-1], dp[i+1][j]);
				}
			}
			System.out.println(dp[0][n-1]);
			t--;
		}
	}
}
