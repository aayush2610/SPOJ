package ques;

import java.util.Scanner;
import java.util.Stack;

public class CTGAME {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		while(t>0){
			t--;
			int r=scanner.nextInt();
			int c=scanner.nextInt();
			int[][] arr=new int[r][c];
			for(int i=0;i<r;i++){
				for(int j=0;j<c;j++){
					char x=scanner.next().charAt(0);
					if(x=='R')
						arr[i][j]=0;
					else
						arr[i][j]=1;
				}
			}
			int[] temp=new int[c];
			int max=0;
			for(int i=0;i<r;i++){
				for(int j=0;j<c;j++){
					if(arr[i][j]==0)
						temp[j]=0;
					else
						temp[j]+=1;
				}
				max=Math.max(max, area(temp));
			}
			System.out.println(max*3);
			String ss=scanner.nextLine();
		}
	}
	public static int area(int[] a){
		Stack<Integer> st=new Stack<Integer>();
		int maxarea=0;
		int top=0;
		int area=0;
		int i=0;
		for(i=0;i<a.length;){
			if(st.isEmpty() || a[st.peek()]<=a[i]){
				st.add(i);
				i++;
			}
			else{
				top=st.pop();
				if(st.isEmpty())
					area=a[top]*i;
				else
					area=a[top]*(i-st.peek()-1);
				if(area>maxarea){
					maxarea=area;
				}
			}
		}
		while(!st.isEmpty()){
			top=st.pop();
			if(st.isEmpty())
				area=a[top]*i;
			else
				area=a[top]*(i-st.peek()-1);
			if(area>maxarea){
				maxarea=area;
			}
		}
		return maxarea;
	}
}
