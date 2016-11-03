package ques;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SimpleArith {
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	int t=Integer.parseInt(br.readLine());
	while(t>0){
		String sa;
		sa = br.readLine();
		
		String []s=sa.split("\\+");
		if(s.length>1){
		BigInteger b1=new BigInteger(s[0]);
		BigInteger b2=new BigInteger(s[1]);
		String s1=b1.toString();
		String s2=b2.toString();
		if(s1.length()>=(s2.length()+1)){
			int x=s1.length()-s2.length()-1;
			System.out.println(b1);
			while(x>0){
				System.out.print(" ");
				x--;
			}
			System.out.println("+"+b2);
		}
		else{
			int x;
			x=s2.length()-s1.length()+1;
			while(x>0){
				System.out.print(" ");
				x--;
			}
			System.out.println(b1);
			System.out.println("+"+b2);
		}
		int l1=(s1.length()>(s2.length()+1)?s1.length():(s2.length()+1));
		for(int i=0;i<l1;i++)
			System.out.print("-");
		System.out.println();
		System.out.println(b1.add(b2));
		}
		else{
			s=sa.split("\\-");
			if(s.length>1){
				BigInteger b1=new BigInteger(s[0]);
				BigInteger b2=new BigInteger(s[1]);
				String s1=b1.toString();
				String s2=b2.toString();
				if(s1.length()>=(s2.length()+1)){
					int x=s1.length()-s2.length()-1;
					System.out.println(b1);
					while(x>0){
						System.out.print(" ");
						x--;
					}
					System.out.println("-"+b2);
				}
				else{
					int x;
					x=s2.length()-s1.length()+1;
					while(x>0){
						System.out.print(" ");
						x--;
					}
					System.out.println(b1);
					System.out.println("-"+b2);
				}
				int l1=(s1.length()>(s2.length()+1)?s1.length():(s2.length()+1));
				for(int i=0;i<l1;i++)
					System.out.print("-");
				System.out.println();
				System.out.println(b1.subtract(b2));
			}
			else{
				s=sa.split("\\*");
				BigInteger b1=new BigInteger(s[0]);
				BigInteger b2=new BigInteger(s[1]);
				String s1=b1.toString();
				String s2=b2.toString();
				if(s1.length()>=(s2.length()+1)){
					int x=s1.length()-s2.length()-1;
					System.out.println(b1);
					while(x>0){
						System.out.print(" ");
						x--;
					}
					System.out.println("*"+b2);
				}
				else{
					int x;
					x=s2.length()-s1.length()+1;
					while(x>0){
						System.out.print(" ");
						x--;
					}
					System.out.println(b1);
					System.out.println("*"+b2);
				}
				int l1=(s1.length()>(s2.length()+1)?s1.length():(s2.length()+1));
				for(int i=0;i<l1;i++)
					System.out.print("-");
				System.out.println();
				System.out.println(b1.multiply(b2));
			}
		}
		t--;
	}
}
}
