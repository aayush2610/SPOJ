package ques;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UPSUB {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t>0){
			t--;
			String s=br.readLine();
			int[] arr=new int[s.length()];
			for(int i=0;i<s.length();i++){
				arr[i]=1;
			}
			ArrayList<Integer>[] ar=new ArrayList[s.length()];
			for(int i=0;i<s.length();i++)
				ar[i]=new ArrayList<Integer>();
			int max=1;
			for(int i=1;i<s.length();i++){
				for(int j=i-1;j>=0;j--){
					if(s.charAt(i)>=s.charAt(j)){
						if(arr[i]<=arr[j]+1){
							arr[i]=arr[j]+1;
							if(max<arr[i])
								max=arr[i];
						}
					}
				}
			}
			for(int i=1;i<s.length();i++){
				for(int j=i-1;j>=0;j--){
					if(arr[i]==arr[j]+1 && s.charAt(i)>=s.charAt(j)){
						ar[i].add(j);
					}
				}
			}
			ArrayList<String> result=new ArrayList<String>();
			for(int i=0;i<s.length();i++){
				if(arr[i]==max)
					func(result,i,ar,"",s,max);
			}
			for(int i=0;i<result.size();i++){
				System.out.println(result.get(i));
			}
			System.out.println();
		}
	}
	public static void func(ArrayList<String> result,int i,ArrayList<Integer>[] ar,String s, String a,int max){
		s=s+a.charAt(i);
		if(s.length()==max){
			StringBuffer p=new StringBuffer(s);
			p=p.reverse();
			result.add(p.toString());
			return;
		}
		for(int x=0;x<ar[i].size();x++){
			func(result,ar[i].get(x),ar,s,a,max);
		}
		s=s.substring(0, s.length()-1);
		return;
	}
}
