package ques;
import java.util.Scanner;

public class IMP {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		//do 10
		for(int i=0;i<10;i++){
			int a=scanner.nextInt();
			int b=scanner.nextInt();
			int x=scanner.nextInt();
			int y=scanner.nextInt();
//			if(x*y*a*b<0){
//				int c=x+a;
//				int d=y+b;
//				int min=(Math.abs(c)+Math.abs(d));
//				int k=c;
//				int j=d;
//				int min1=Integer.MAX_VALUE;
//				int s=1;
//				//System.out.println(min);
//				while(Math.abs(k)+Math.abs(j)<=min1){
//					k=Math.abs(s*c+a);
//					j=Math.abs(s*d+b);
//					min1=Math.min(min1, k+j);
//					s++;
//				}
//				//System.out.println(min1);
//				min=Math.min(min, min1);
//				//System.out.println(min);
//				k=c;
//				j=d;
//				min1=Integer.MAX_VALUE;
//				s=1;
//				while(Math.abs(k)+Math.abs(j)<=min1){
//					k=Math.abs(s*c+x);
//					j=Math.abs(s*d+y);
//					min1=Math.min(min1, k+j);
//					s++;
//				}
//				min=Math.min(min, min1);
//				//System.out.println(min);
//				c=x-a;
//				d=y-b;
//				min=Math.min(min, Math.abs(c)+Math.abs(d));
//				k=c;
//				j=d;
//				min1=Integer.MAX_VALUE;
//				s=1;
//				while(Math.abs(k)+Math.abs(j)<=min1){
//					k=Math.abs(s*c-a);
//					j=Math.abs(s*d-b);
//					min1=Math.min(min1, k+j);
//					s++;
//				}
//				min=Math.min(min, min1);
//				//System.out.println(min);
//				k=c;
//				j=d;
//				min1=Integer.MAX_VALUE;
//				s=1;
//				while(Math.abs(k)+Math.abs(j)<=min1){
//					k=Math.abs(s*c+x);
//					j=Math.abs(s*d+y);
//					min1=Math.min(min1, k+j);
//					s++;
//				}
//				//System.out.println(min);
//				min=Math.min(min, min1);
//				min=Math.min(min, Math.abs(a)+Math.abs(b));
//				min=Math.min(min, Math.abs(x)+Math.abs(y));
//				System.out.println(min);
//			}
			//else{
				if(a==x && b==y)
					System.out.println(0);
				else{
				a=Math.abs(a);
				b=Math.abs(b);
				x=Math.abs(x);
				y=Math.abs(y);
				int c=Math.abs(a-x);
				int d=Math.abs(b-y);
				int k=c;
				int j=d;
				int min=Integer.MAX_VALUE;
				int s=1;
				while(k+j<=min){
				//	System.out.println("ea");
					k=Math.abs(s*c-a);
					j=Math.abs(s*d-b);
					min=Math.min(min, k+j);
					s++;
				}
				int t=Integer.MAX_VALUE;
				s=1;
				k=c;
				j=d;
				while(k+j<=t){
					k=Math.abs(s*c-x);
					j=Math.abs(s*d-y);
					t=Math.min(t, k+j);
					s++;
				}
				int p=Math.min(a+b, x+y);
				min=Math.min(p,min);
				min=Math.min(c+d,min);
				System.out.println(Math.min(t, min));
			}
			}
		}
	//}
}
