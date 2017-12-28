package myTest;

import java.util.Scanner;

public  class Test011 {
	public Test011(){
		String aaa="aaaa";
	}
	static {
		String b ="aa";
	}
	static int a =3;
	final private String  name  ="ss";
//	Test011 test = new Test011();
	public static void main(String[] args){
		Test011 aa = new Test011();
		System.out.println(aa.toString());
		System.out.println((int)(Math.random()*100));
		Scanner input = new Scanner(System.in);
		System.out.println(input.nextInt());
	}
}

