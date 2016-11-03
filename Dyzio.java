package ques;

import java.util.Scanner;

public class Dyzio {
	static int min=0;
	static int mincuts=0;
	static int noofcuts=0;
	static int cnt=0;
	public static void pre(String s,int j){
			if(j>min){
				mincuts=noofcuts;
				min=j;
			}
			if(cnt<s.length() && s.charAt(cnt)=='1'){
				cnt++;
				noofcuts+=1;
				pre(s,j+1);
				pre(s,j+1);
			}
			else {
				cnt++;
				return;}
	
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		for(int i=0;i<10;i++){
			int t=scanner.nextInt();
			String s=scanner.next();
			min=0;
			mincuts=0;
			noofcuts=0;
			cnt=0;
			pre(s,0);
			System.out.println(mincuts);
		}
	}
}
