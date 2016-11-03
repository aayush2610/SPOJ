package ques;

import java.util.Scanner;

public class DoubleHelix {
	public static void main(String[] args) throws Exception{
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		while(t!=0){
			int[] a=new int[t];
			for(int i=0;i<t;i++)
				a[i]=scanner.nextInt();
			t=scanner.nextInt();
			int[] b=new int[t];
			for(int i=0;i<t;i++)
				b[i]=scanner.nextInt();
			int i=0,j=0;
			int sum=0,suma=0,sumb=0;
			while(i<a.length && j<b.length){
				if(a[i]<b[j]){
					suma+=a[i];
					i++;
				}
				else if(a[i]>b[j]){
					sumb+=b[j];
					j++;
				}
				else{
					sum+=a[i];
					sum+=Math.max(suma, sumb);
					suma=0;sumb=0;
					i++;j++;
				}
			}
			if(i==a.length){
				while(j<b.length){
					sumb+=b[j];
					j++;
				}
				sum+=Math.max(suma, sumb);
			}
			else if(j==b.length){
				while(i<a.length){
					suma+=a[i];
					i++;
				}
				sum+=Math.max(suma, sumb);
			}
			System.out.println(sum);
			t=scanner.nextInt();
		}
	}
}
