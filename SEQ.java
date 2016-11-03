package ques;

import java.util.Scanner;

public class SEQ {
	public static long power(long[][] a, int n, long[] b, long[][] tr){
		if(n==1){
			long ans=0;
			for(int i=0;i<b.length;i++){
				ans+=a[0][i]*b[b.length-1-i];
				ans%=1000000000;
			}
			return ans;
		}
		power(a,n/2,b,tr);
		multiply(a,a);
		if(n%2!=0){
			multiply(a,tr);
		}
		long ans=0;
		for(int i=0;i<b.length;i++){
			ans+=a[0][i]*b[b.length-1-i];
			ans%=1000000000;
		}
		return ans;
	}
	public static void multiply(long[][] a,long[][] b){
		long[][] mul=new long[a.length][a.length];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length;j++){
				for(int k=0;k<a.length;k++){
					mul[i][j]+=a[i][k]*b[k][j];
					mul[i][j]%=1000000000;
				}
			}
		}
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length;j++){
				a[i][j]=mul[i][j];
			}
		}
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		while(t>0){
			t--;
			int k=scanner.nextInt();
			long[] b=new long[k];
			long[] c=new long[k];
			for(int i=0;i<k;i++){
				b[i]=scanner.nextLong();
			}
			for(int i=0;i<k;i++){
				c[i]=scanner.nextLong();
			}
			long[][] mid=new long[k][k];
			long[][] mid2=new long[k][k];
			for(int i=0;i<k;i++){
				mid[0][i]=c[i];
				mid2[0][i]=c[i];
			}
			for(int i=1;i<k;i++){
				mid[i][i-1]=1;
				mid2[i][i-1]=1;
			}
			int n=scanner.nextInt();
			if(n<=k){
				System.out.println(b[n-1]);
				continue;
			}
			else{
				System.out.println(power(mid,n-k,b,mid2));
			}
		}
	}
}
