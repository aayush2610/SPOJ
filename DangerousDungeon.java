package ques;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Node{
	
	 public ArrayList<edge> e;
	 public Node(ArrayList<edge> ee){
		 e=new ArrayList<edge>(ee);
	 }
}
class edge{
	public long src;
	public long dest;
	public long value;
	public edge(long srcx, long destx,long valuex){
		src=srcx;
		dest=destx;
		value=valuex;
	}
}
public class DangerousDungeon {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=new String[3];
		s=br.readLine().split(" ");
		long n=Long.parseLong(s[0]);
		long m=Long.parseLong(s[1]);
		long p=Long.parseLong(s[2]);
		String[] s1=new String[(int)n];
		s1=br.readLine().split(" ");
		long[] arr=new long[(int)n];
		for(long i=0;i<n;i++){
			arr[(int)i]=Long.parseLong(s1[(int)i]);
		}
		Node[] node=new Node[(int)n];
		ArrayList<edge> ee=new ArrayList<edge>();
		for(int i=0;i<n;i++){
			node[i]=new Node(ee);
		}
		for(int i=0;i<m;i++){
			String[] ss=new String[3];
			ss=br.readLine().split(" ");
			long a=Long.parseLong(ss[0]);
			long b=Long.parseLong(ss[1]);
			long c=Long.parseLong(ss[2]);
			edge e1=new edge(a,b,c);
			node[(int)a].e.add(e1);
		}
		if(arr[0]==0)
			System.out.println(-1);
		else{
			long x=dijkstras(node, arr, p,m);
			if(x==Long.MAX_VALUE)
				System.out.println(-1);
			else
			System.out.println(x);
		}
	}
	static int minDistance(long dist[], boolean sptSet[])
	{
	   long min = Long.MAX_VALUE;int min_index=0;
	   for (int v = 0; v < dist.length; v++)
	     if (sptSet[v] == false && dist[v] <= min){
	         min = dist[v]; min_index = v;}
	   return min_index;
	}
	public static long dijkstras(Node[]  node,long[] arr,long p,long m){
		int n=node.length;
		     long dist[]=new long[n];     
		     boolean sptSet[]=new boolean[n]; 
		     for (int i = 0; i < n; i++){
		        dist[i] = Long.MAX_VALUE; sptSet[i] = false;}
		 
		     dist[0] = 0;
		     for (int count = 0; count < m; count++)
		     {
		       int u = minDistance(dist, sptSet);
		       sptSet[u] = true;
		       if(u==n-1)
		    	   return dist[u];
		       for (int v = 0; v < node[u].e.size(); v++)
		       {
		         if (!sptSet[(int)node[u].e.get(v).dest] && dist[u] != Long.MAX_VALUE 
		             && dist[u]+node[u].e.get(v).value < dist[(int)node[u].e.get(v).dest]){
		        	 
		        	 if(arr[(int)node[u].e.get(v).dest]!=(dist[u]+node[u].e.get(v).value)%p)
		        		 dist[(int)node[u].e.get(v).dest] = dist[u] +node[u].e.get(v).value; 
		         }}
		     }
		     return dist[n-1];
	}
}
