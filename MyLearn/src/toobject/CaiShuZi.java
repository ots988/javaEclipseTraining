package toobject;

import java.util.Scanner;

/*
 * 类的成员变量 猜数字游戏一个类A有一个成员变量v有一个初值100。
 * 定义一个类对A类的成员变量v进行猜。
 * 如果大了则提示大了小了则提示小了。等于则提示猜测成功。 
 */
public class CaiShuZi {
	
	static class A{
		int v =100;
		
	}
	public static void main(String[] args){
		A a =new A();
		System.out.println("请输入数字");
		while(true){
			Scanner input = new Scanner(System.in);
			int i=input.nextInt();
			if(i>a.v){
				System.out.println("大了");
//				continue;
			}else if(i<a.v){
				System.out.println("小了");
//				continue;
			}else{
				System.out.println("对了");
				break;
			}
		}
	}
}
