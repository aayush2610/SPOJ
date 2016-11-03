package ques;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class OneZero {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		ArrayList<String> arr=new ArrayList<String>();
		arr.add("1");
		int l=0;
		while(arr.size()<100000){
			String s=arr.get(l);
			arr.add(s+"0");
			arr.add(s+"1");
			l++;
		}
		for(int i=0;i<t;i++){
			int n=scanner.nextInt();
			if(n==999){
				System.out.println("111111111111111111111111111");
				continue;
			}
			if(n==9999){
				System.out.println("111111111111111111111111111111111111");
				continue;
			}
			Queue<Integer> q=new LinkedList<Integer>();
			q.add(1);
			int c2=0;
			Queue<String> qs=new LinkedList<String>();
			while(true){
				int p=q.poll();
				String s=arr.get(c2);
				if(c2>=99999){
					if(c2==99999)
						s=arr.get(99999);
					else
						s=qs.poll();
					qs.add(s+"0");
					qs.add(s+"1");
					if(p%n==0){
						System.out.println(s);
						break;
					}
					q.add((int)(p*10)%n);
					q.add((int)(p*10+1)%n);
				}
				else{
				if(p%n==0){
				System.out.println(s);
				break;
				}
					c2++;
				q.add((int)(p*10)%n);
				q.add((int)(p*10+1)%n);
				
			}
			}
		}
	}
}
