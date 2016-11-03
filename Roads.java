package ques;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Roads {
	public static ArrayList<edg>[] grid;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t>0){
			t--;
			int k=Integer.parseInt(br.readLine());
			int n=Integer.parseInt(br.readLine());
			int r=Integer.parseInt(br.readLine());;
			String[] s;
			grid=new ArrayList[n];
			for(int i=0;i<n;i++){
				grid[i]=new ArrayList<edg>();
			}
			for(int i=0;i<r;i++){
				s=br.readLine().split(" ");
				int sou=Integer.parseInt(s[0])-1;
				int des=Integer.parseInt(s[1])-1;
				int w=Integer.parseInt(s[2]);
				int tax=Integer.parseInt(s[3]);
				grid[sou].add(new edg(des,w,tax));
			}
			int x=dijkstra(k);
			if(x==Integer.MAX_VALUE)
				System.out.println(-1);
			else
				System.out.println(x);
		}
	}
	public static int dijkstra(int k){
		PriorityQueue<edg> pq=new PriorityQueue<edg>();
		pq.add(new edg(0,0,0));
		int[] dist=new int[grid.length];
		for(int i=0;i<dist.length;i++)
			dist[i]=Integer.MAX_VALUE;
		while(!pq.isEmpty()){
			edg e=pq.poll();
			int dest=e.dest;
			int len=e.len;
			int tax=e.tax;
			if(dist[dest]<len)
				continue;
			dist[dest]=len;
			for(int i=0;i<grid[dest].size();i++){
				edg f=grid[dest].get(i);
				if(f.tax+tax<=k){
					pq.add(new edg(f.dest,len+f.len,f.tax+tax));
				}
			}
		}
		return dist[dist.length-1];
	}
}
class edg implements Comparable<edg>{
	int dest,len,tax;
	public edg(int dest, int len, int tax){
		this.dest=dest;
		this.len=len;
		this.tax=tax;
	}
	
	public int compareTo(edg o) {
		if(tax==o.tax)
			return len-o.len;
		return tax-o.tax;
	}
	
}
