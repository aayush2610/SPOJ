package ques;

import java.util.Scanner;
import java.util.*;
public class ALLIZZWELL {
	public static void main(String[] args)throws Exception {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		while(t>0){
			t--;
			int r=scanner.nextInt();
			int c=scanner.nextInt();
			char[][] arr=new char[r][c];
			for(int i=0;i<r;i++){
				arr[i]=scanner.next().toCharArray();
			}
			ArrayList<Integer> x=new ArrayList<Integer>();
			ArrayList<Integer> y=new ArrayList<Integer>();
			for(int i=0;i<r;i++){
				for(int j=0;j<c;j++){
					if(arr[i][j]=='A'){
						x.add(i);
						y.add(j);
					}
				}
			}
			if(x.size()==0){
				System.out.println("NO");
				continue;
			}
			int i=0;
			for(i=0;i<x.size();i++){
				if(dfs(arr,x.get(i),y.get(i),0,"ALLIZZWELL")){
					System.out.println("YES");
					break;
				}
			}
			if(i==x.size())
				System.out.println("NO");
			String newline=scanner.nextLine();
		}
	}
	public static boolean dfs(char[][] arr, int i, int j, int index, String s){
		if(index==s.length())
			return true;
		if((i<0 || i>=arr.length || j<0 || j>=arr[0].length)|| arr[i][j]=='#')
			return false;
		int[] a={1,1,1,-1,-1,-1,0,0};
		int[] b={1,-1,0,1,-1,0,1,-1};
		if(arr[i][j]!=s.charAt(index))
			return false;
		arr[i][j]='#';
		for(int t=0;t<8;t++){
			if(dfs(arr,i+a[t],j+b[t],index+1,s)){
				return true;
			}
		}
		arr[i][j]=s.charAt(index);
		return false;
	}
}
