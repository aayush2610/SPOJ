package ques;

import java.util.Scanner;

public class Party {
	static void func(int cost,int n, int[] a1,int[] a2){
		int[][] k=new int[n+1][cost+1];
		for(int i=0;i<=n;i++){
			for(int w=0;w<=cost;w++){
				if(i==0|| w==0)
					k[i][w]=0;
				else if(a1[i-1]<=w)
					k[i][w]=Math.max(a2[i-1]+k[i-1][w-a1[i-1]], k[i-1][w]);
				else
					k[i][w]=k[i-1][w];
			}
		}
		int c=cost-1;
		while(k[n][c]==k[n][cost]){
			c--;
		}
		System.out.print((c+1)+" ");
		System.out.println(k[n][cost]);
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int w=scanner.nextInt();
		int t=scanner.nextInt();
		int[] a1=new int[t];
		int[] a2=new int[t];
		while(true){
			for(int i=0;i<t;i++){
				a1[i]=scanner.nextInt();
				a2[i]=scanner.nextInt();
			}
			func(w,t,a1,a2);
			w=scanner.nextInt();
			t=scanner.nextInt();
			if(w==0 &&t==0)
				break;
		}
	}
}
