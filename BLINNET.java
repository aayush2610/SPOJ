package ques;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class ed{
	int src,dest,cost;
	public ed(int src, int dest, int cost){
		this.src=src;
		this.dest=dest;
		this.cost=cost;
	}
}
class subset{
	int parent;
	int rank;
}
public class BLINNET {
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t>0){
			t--;
			br.readLine();
			int n=Integer.parseInt(br.readLine());
			ArrayList<ed> arr=new ArrayList<ed>();
			for(int i=0;i<n;i++){
				String sst=br.readLine();
				int x=Integer.parseInt(br.readLine());
				for(int j=0;j<x;j++){
					String[] s=br.readLine().split(" ");
					int de=Integer.parseInt(s[0]);
					int co=Integer.parseInt(s[1]);
					ed z=new ed(i,de-1,co);
					arr.add(z);
				}
			}
			Collections.sort(arr,new Comparator<ed>(){
				public int compare(ed e1,ed e2){
					return e1.cost-e2.cost;
				}
			});
			subset[] sub=new subset[n];
			for(int i=0;i<n;i++){
				sub[i]=new subset();
				sub[i].parent=i;
				sub[i].rank=0;
			}
			int sum=0;
			int i=0,j=0;
			while(j<n-1){
				ed r=arr.get(i);
				int sr=r.src;
				int de=r.dest;
				int srp=find(sr,sub);
				int dep=find(de,sub);
				if(srp!=dep){
					j++;
					sum+=r.cost;
					union(sub,srp,dep);
				}
				i++;
			}
			System.out.println(sum);
		}
	}
	public static int find(int x,subset[] sub){
		if(sub[x].parent!=x)
			sub[x].parent=find(sub[x].parent,sub);
		return sub[x].parent;
	}
	public static void union(subset[] sub, int x, int y){
		int xp=find(x,sub);
		int yp=find(y,sub);
		if(sub[xp].rank>sub[yp].rank){
			sub[yp].parent=xp;
		}
		else if(sub[yp].rank>sub[xp].rank){
			sub[xp].parent=yp;
		}
		else{
			sub[yp].parent=xp;
			sub[xp].rank++;
		}
	}
}
