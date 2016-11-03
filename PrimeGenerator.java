package ques;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PrimeGenerator {
	static ArrayList<Integer> a =new ArrayList<Integer>(){{
		add(2);
		add(3);
		add(5);
		add(7);
		add(11);
		add(13);
		add(17);
		add(19);
		add(23);
		add(29);
		add(31);
		add(37);
		add(41);
		add(43);
		add(47);
		add(53);
		add(59);
		add(61);
		add(67);
		add(71);
		add(73);
		add(79);
		add(83);
		add(89);
		add(97);
		add(101);
	}};
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t,m,n;
		t=scanner.nextInt();
		while(t>0){
			t--;
			m=scanner.nextInt();
			n=scanner.nextInt();
			int l=a.size();
			int i=0;
			
			if(n<=a.get(l-1)){
				while(m>a.get(i))
					i++;
				while(n>=a.get(i)){
					System.out.println(a.get(i));
					i++;
				}
			}
			else if(m>a.get(l-1)){
				int h=a.get(l-1);
				i=l-1;
					for(h=h+1;;h++){
						int p=0;
						int g=(int)Math.sqrt(h);
						while(g>=a.get(p)){
							if(h%a.get(p)==0)
								break;
							p++;
						}
						if(a.get(p)>g){
							a.add(h);
							i++;
							if(a.get(i)>=m && a.get(i)<=n)
								System.out.println(a.get(i));
						}
						if(n<a.get(i))
							break;
					}
				
			}
			else{
				while(m>a.get(i))
					i++;
				for(i=i;i<l;i++)
					System.out.println(a.get(i));
				int h=a.get(l-1);
				i=l-1;
					for(h=h+1;;h++){
						int p=0;
						int g=(int)Math.sqrt(h);
						while(g>=a.get(p)){
							if(h%a.get(p)==0)
								break;
							p++;
						}
						if(a.get(p)>g){
							a.add(h);
							i++;
							if(a.get(i)<=n)
								System.out.println(a.get(i));
						}
						if(n<a.get(i))
							break;
					}
				
			}
		}
		
	}
}