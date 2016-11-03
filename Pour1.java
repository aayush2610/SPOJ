package ques;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Key {
    public int x;
    public int y;
    public Key(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;
        Key key = (Key) o;
        return x == key.x && y == key.y;
    }
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

public class Pour1 {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	int t=scanner.nextInt();
	while(t>0){
		Key ob=new Key(0,0);
		Key o1=new Key(0,0);
		ob.x=scanner.nextInt();
		ob.y=scanner.nextInt();
		int c=scanner.nextInt();
		HashMap<Key, Integer> hm=new HashMap<Key, Integer>();
		hm.put(o1, 0);
		int a=ob.x;
		int b=ob.y;
		hm.put(new Key(a,0), 1);
		hm.put(new Key(0,b), 1);
		Queue<Key> q=new LinkedList<Key>();
		q.add(new Key(a,0));
		q.add(new Key(0,b));
		int flag=0;
		if(c>ob.x && c>ob.y)
			System.out.println(-1);
		else{
			while(!q.isEmpty()){
				Key ob1=q.poll();
				int i=ob1.x;
				int j=ob1.y;
				if(i==c || j==c){
					System.out.println(hm.get(ob1));
					flag=1;
					break;
				}
				if(i<a){
					if(!hm.containsKey(new Key(a,j))){
						q.add(new Key(a,j));
						hm.put(new Key(a,j), hm.get(ob1)+1);
					}
				}
				if(j<b){
					if(!hm.containsKey(new Key(i,b))){
						q.add(new Key(i,b));
						hm.put(new Key(i,b), hm.get(ob1)+1);
					}
				}
				if(i>0){
					if(!hm.containsKey(new Key(0,j))){
						q.add(new Key(0,j));
						hm.put(new Key(0,j), hm.get(ob1)+1);
					}
				}
				if(j>0){
					if(!hm.containsKey(new Key(i,0))){
						q.add(new Key(i,0));
						hm.put(new Key(i,0), hm.get(ob1)+1);
					}
				}
				if(i<a && i+j<=a){
					if(!hm.containsKey(new Key(i+j,0))){
						q.add(new Key(i+j,0));
						hm.put(new Key(i+j,0), hm.get(ob1)+1);
					}
				}
				if(i<a && i+j>a){
					if(!hm.containsKey(new Key(a,j-(a-i)))){
						q.add(new Key(a,j+i-a));
						hm.put(new Key(a,j+i-a), hm.get(ob1)+1);
					}
				}
				if(j<b && i+j<=b){
					if(!hm.containsKey(new Key(0,i+j))){
						q.add(new Key(0,i+j));
						hm.put(new Key(0,i+j), hm.get(ob1)+1);
					}
				}
				if(j<b && i+j>b){
					if(!hm.containsKey(new Key(i+j-b,b))){
						q.add(new Key(i+j-b,b));
						hm.put(new Key(i+j-b,b), hm.get(ob1)+1);
					}
				}
			}
			if(q.isEmpty() && flag==0)
				System.out.println(-1);
		}
		t--;
	}
}
}
