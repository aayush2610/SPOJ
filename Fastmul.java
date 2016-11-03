package ques;

import java.math.BigInteger;
import java.util.Scanner;

public class Fastmul {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	int t=scanner.nextInt();
	for(int i=0;i<t;i++){
		BigInteger b1=scanner.nextBigInteger();
		BigInteger b2=scanner.nextBigInteger();
		BigInteger b3=b1.multiply(b2);
		System.out.println(b3);
	}
}
}
