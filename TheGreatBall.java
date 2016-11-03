package ques;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class tw{
	int a,b;
}
public class TheGreatBall {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t>0){
			t--;
			int n=Integer.parseInt(br.readLine());
			ArrayList<tw> arr=new ArrayList<tw>();
			for(int i=0;i<n;i++){
				String[] s=br.readLine().split(" ");
				tw x=new tw();
				x.a=Integer.parseInt(s[0]);
				x.b=1;
				arr.add(x);
				tw y=new tw();
				y.a=Integer.parseInt(s[1]);
				y.b=-1;
				arr.add(y);
			}
			Collections.sort(arr, new Comparator<tw>(){
				public int compare(tw t1,tw t2){
						return t1.a-t2.a;
				}
			});
			int count=0;
			int max=0;
			for(int i=0;i<arr.size();i++){
				count+=arr.get(i).b;
				if(count>max)
					max=count;
			}
			System.out.println(max);
		}
	}
}
