package ques;

import java.util.Scanner;

public class SumtheDigits {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		while(true){
			long a=scanner.nextLong();
			long b=scanner.nextLong();
			if(a==-1 && b==-1)
				break;
			long f1=func(a-1);
			long f2=func(b);
			System.out.println(f2-f1);
		}
	}
	public static long func(long a){
		if(a<10)
			return a*(a+1)/2;
		int d=(int) Math.log10(a);
		long[] arr=new long[d+1];
		arr[0]=0;
		arr[1]=45;
		for(int i=2;i<=d;i++){
			arr[i]=(long) (arr[i-1]*10+45*Math.ceil(Math.pow(10, i-1)));
		}
		long p=(long)Math.ceil(Math.pow(10, d));
		long msd= (a/p);
		return msd*arr[d]+(msd*(msd-1)/2)*p+msd*(a%p+1)+func(a%p);
	}
}
