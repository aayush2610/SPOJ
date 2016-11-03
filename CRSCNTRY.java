package ques;

import java.util.Scanner;
import java.util.*;
public class CRSCNTRY {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		while(t>0){
			t--;
			ArrayList<Integer> arr=new ArrayList<Integer>();
			int x=scanner.nextInt();
			while(x!=0){
				arr.add(x);
				x=scanner.nextInt();
			}
			int y=scanner.nextInt();
			int max=0;
			while(y!=0){
				ArrayList<Integer> test=new ArrayList<Integer>();
				test.add(y);
				int p=scanner.nextInt();
				while(p!=0){
					test.add(p);
					p=scanner.nextInt();
				}
				int maxi=func(arr,test);
				max=Math.max(max, maxi);
				y=scanner.nextInt();
			}
			System.out.println(max);
		}
	}
	public static int func(ArrayList<Integer> arr, ArrayList<Integer> test){
		if(arr.size()==0 || test.size()==0)
			return 0;
		int[][] dp=new int[arr.size()+1][test.size()+1];
		for(int i=0;i<=arr.size();i++){
			dp[i][0]=0;
		}
		for(int i=0;i<=test.size();i++){
			dp[0][i]=0;
		}
		for(int i=1;i<=arr.size();i++){
			for(int j=1;j<=test.size();j++){
				if(arr.get(i-1)==test.get(j-1)){
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else{
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[arr.size()][test.size()];
	}
}