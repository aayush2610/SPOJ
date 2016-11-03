package ques;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QTREE2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t>0){
			t--;
			br.readLine();
			int n=Integer.parseInt(br.readLine());
			ArrayList<Integer>[] arr=new ArrayList[n];
			ArrayList<Integer>[] arr2=new ArrayList[n];
			for(int i=0;i<n;i++){
				arr[i]=new ArrayList<Integer>();
				arr2[i]=new ArrayList<Integer>();
			}
			for(int i=0;i<n-1;i++){
				String[] s=br.readLine().split(" ");
				int sr=Integer.parseInt(s[0]);
				int dest=Integer.parseInt(s[1]);
				int cost=Integer.parseInt(s[2]);
				arr[sr-1].add(dest-1);
				arr2[sr-1].add(cost);
				arr[dest-1].add(sr-1);
				arr2[dest-1].add(cost);
			}
			while(true){
				String[] s=br.readLine().split(" ");
				if(s[0].equals("DONE"))
					break;
				else if(s[0].equals("DIST")){
					int x=Integer.parseInt(s[1])-1;
					int y=Integer.parseInt(s[2])-1;
					Queue<pare> q=new LinkedList<pare>();
					Queue<Integer> q1=new LinkedList<Integer>();
					q.add(new pare(x,-1));
					q1.add(0);
					while(true){
						pare val=q.poll();
						int co=q1.poll();
						if(val.x==y){
							System.out.println(co);
							break;
						}
						int flag=0;
						for(int i=0;i<arr[val.x].size();i++){
							if( val.parent!=arr[val.x].get(i)){
								q.add(new pare(arr[val.x].get(i),val.x));
								q1.add(co+arr2[val.x].get(i));
								if(arr[val.x].get(i)==y){
									flag=co+arr2[val.x].get(i);
									break;
								}
							}
						}
						if(flag!=0){
							System.out.println(flag);
							break;
						}
					}
				}
				else{
					HashMap<Integer,Integer> hs=new HashMap<Integer,Integer>();
					int y=Integer.parseInt(s[1])-1;
					int x=Integer.parseInt(s[2])-1;
					int k=Integer.parseInt(s[3]);
					if(x==y || k==1){
						System.out.println(y);
						continue;
					}
					Queue<pare> q=new LinkedList<pare>();
					q.add(new pare(x,-1));
					hs.put(x,-1);
					while(true){
						pare val=q.poll();
						int flag=0;
						for(int i=0;i<arr[val.x].size();i++){
							if(val.parent!=arr[val.x].get(i)){
								pare pa=new pare(arr[val.x].get(i),val.x);
								q.add(pa);
								hs.put(arr[val.x].get(i),val.x);
								if(arr[val.x].get(i)==y){
									flag=1;
									break;
								}
							}
						}
						if(flag!=0){
							int count=1;
							int parent=-1;
							int hh=y;
							while(count<k){
								count++;
								parent=hs.get(hh);
								if(parent==-1 && count<=k){
									parent=-2;
									break;
								}
								hh=parent;
							}
							System.out.println(parent+1);
							break;
						}
					}
				}
			}
		}
	}
}
class pare{
	int x;
	int parent;
	public pare(int x, int parent){
		this.x=x;
		this.parent=parent;
	}
	@Override
	public boolean equals(Object obj) {
		pare pe=(pare)obj;
		if(this.x==pe.x)
			return true;
		return false;
	}
	@Override
	public int hashCode() {
		return this.x;
	}
}
