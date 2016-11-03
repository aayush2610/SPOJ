package ques;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class StableMarriage {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t>0){
			t--;
			int n=Integer.parseInt(br.readLine());
			HashMap<Integer, ArrayList<Integer>> girlpref=new HashMap<Integer, ArrayList<Integer>>();
			HashMap<Integer, ArrayList<Integer>> boypref=new HashMap<Integer, ArrayList<Integer>>();
			for(int i=0;i<n;i++){
				String[] s=br.readLine().split(" ");
				int x=Integer.parseInt(s[0]);
				ArrayList<Integer> arr=new ArrayList<Integer>();
				for(int j=1;j<s.length;j++){
					arr.add(Integer.parseInt(s[j]));
				}
				girlpref.put(x,arr);
			}
			for(int i=0;i<n;i++){
				String[] s=br.readLine().split(" ");
				int x=Integer.parseInt(s[0]);
				ArrayList<Integer> arr=new ArrayList<Integer>();
				for(int j=1;j<s.length;j++){
					arr.add(Integer.parseInt(s[j]));
				}
				boypref.put(x,arr);
			}
			boolean[] g=new boolean[n];
			ArrayList<Integer> ar=new ArrayList<Integer>();
			for(int i=0;i<=n;i++){
				ar.add(i);
			}
			HashMap<Integer,Integer> hm=new HashMap<Integer, Integer>();
			ArrayList<Integer> arc=new ArrayList<Integer>();
			for(int i=1;i<=n;i++){
				arc.add(i);
			}
			HashMap<Integer, Integer> hmm=new HashMap<Integer, Integer>();
			while(arc.size()>0){
				int i=arc.get(0);
				ArrayList<Integer> temp=boypref.get(arc.get(0));
				for(int j=0;j<temp.size();j++){
					int x=temp.get(j);
					if(!g[x-1]){
						g[x-1]=true;
						hm.put(x, i);
						hmm.put(i, x);
						arc.remove(0);
						break;
					}
					else{
						ArrayList<Integer> temp2=new ArrayList<Integer>();
						temp2=girlpref.get(x);
						int p=hm.get(x);
						if(temp2.indexOf(i)<temp2.indexOf(p)){
							hm.put(x, i);
							hmm.remove(p);
							hmm.put(i, x);
							arc.remove(0);
							arc.add(p);
							break;
						}
					}
				}
			}
			for(int i=1;i<=n;i++){
				System.out.println(i+" "+hmm.get(i));
			}
		}
	}
}
