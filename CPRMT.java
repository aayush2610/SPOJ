package ques;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CPRMT {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String a=br.readLine();
			if(a==null || a.length()==0)
				break;
			String b=br.readLine();
			int[] aa=new int[26];
			int[] bb=new int[26];
			for(int i=0;i<a.length();i++){
				aa[a.charAt(i)-'a']++;
			}
			for(int i=0;i<b.length();i++){
				bb[b.charAt(i)-'a']++;
			}
			String s="";
			for(int i=0;i<26;i++){
				char c=(char) (i+'a');
				for(int j=0;j<Math.min(aa[i], bb[i]);j++){
					s+=c;
				}
			}
			System.out.println(s);
		}
	}
}
