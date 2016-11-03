package ques;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Interval{
	int start;
	int end;
	int cost;
	public Interval(int s, int e, int c){
		this.start=s;
		this.end=e;
		this.cost=c;
	}
}
public class weee {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int x=0;x<t;x++){
			int s=Integer.parseInt(br.readLine());
			ArrayList<Interval> arr=new ArrayList<Interval>();
			for(int i=0;i<s;i++){
				String[] ss=br.readLine().split(" ");
				Interval d=new Interval(Integer.parseInt(ss[0]),Integer.parseInt(ss[0])+Integer.parseInt(ss[1]) ,Integer.parseInt(ss[2]));
				arr.add(d);
			}
			Collections.sort(arr, new Comparator<Interval>(){
				public int compare(Interval i1, Interval i2){
					if(i1.end>i2.end)
						return 1;
					else if(i1.end<i2.end)
						return -1;
					else
						return 0;
				}
			});
			int n=arr.get(arr.size()-1).end;
			int []dp=new int[n+1];
			dp[0]=0;
			int j=0;
			for(int i=1;i<=n;i++){
				dp[i]=dp[i-1];
				while(j<arr.size() && arr.get(j).end==i){
					int yy=0;
					if(arr.get(j).start>0)
						yy=arr.get(j).start-1;
					dp[i]=Math.max(dp[i], arr.get(j).cost+dp[yy]);
					j++;
				}
			}
			System.out.println(dp[n]);
		}
	}
}
