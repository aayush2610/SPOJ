package ques;

import java.util.Arrays;
import java.util.Scanner;

public class Diehard {
	static int[][] dp=new int[1010][1010];
	
public static int func(int x, int y, int count,boolean b){
	if(x<=0 ||y<=0)
		return count;
	if(dp[x][y]!=-1)
		return dp[x][y];
	if(b){
		dp[x][y]=func(x+3,y+2,count+1,!b);
		return dp[x][y];
	}
	else{
		dp[x][y]=Math.max(func(x-5,y-10,count+1,!b), func(x-20,y+5,count+1,!b));
		return dp[x][y];
	}
}
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	int t=scanner.nextInt();
	for(int i=0;i<1010;i++)
		Arrays.fill(dp[i], -1);
	for(int i=0;i<t;i++){
		int h,a;
		h=scanner.nextInt();
		a=scanner.nextInt();
		System.out.println(func(h,a,-1,true));
	}
}
}
