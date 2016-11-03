package ques;

import java.util.Scanner;

public class OptimalBST {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++){
			a[i]=scanner.nextInt();
		}
		System.out.println(func(n,a));
	}
	public static int func(int n, int[] a){
		int[][] dp=new int[n][n];
		for(int i=0;i<n;i++){
			dp[i][i]=a[i];
		}
		for(int l=2;l<=n;l++){
			for(int i=0;i<n-l+1;i++){
				int j=i+l-1;
				for(int k=i;k<=j;k++)
					dp[i][j]+=a[k];
				int min=Integer.MAX_VALUE;
				min=Math.min(dp[i+1][j],dp[i][j-1]);
				for(int k=i+1;k<j;k++){
					min=Math.min(min,dp[i][k-1]+dp[k+1][j]);
				}
				dp[i][j]+=min;
				//System.out.println(i+", "+j+" ="+dp[i][j]);
			}
		}
		return dp[0][n-1];
	}
}
