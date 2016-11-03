package ques;


import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution
{
	static long gcd(long a, long b){
		while(b>0){
			long temp=b;
			b=a%b;
			a=temp;
		}
		return a;
	}
	static long lcm(long a, long b){
		return a*(b/gcd(a,b));
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		String s="sdsd";
			s+='d';
			System.out.println(s);
	}
}