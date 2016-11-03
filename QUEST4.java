package ques;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class QUEST4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t>0){
			t--;
			int n=Integer.parseInt(br.readLine());
			int y=0;
			int x=0;
			HashSet<Integer> hy=new HashSet<Integer>();
			HashSet<Integer> hx=new HashSet<Integer>();
			for(int i=0;i<n;i++){
				String[] s=br.readLine().split(" ");
				int xx=Integer.parseInt(s[0]);
				int yy=Integer.parseInt(s[1]);
				if(!hy.contains(yy)){
					y++;
					hy.add(yy);
				}
				if(!hx.contains(xx)){
					x++;
					hx.add(xx);
				}
			}
			System.out.println(Math.min(x,y));
		}
	}
}
