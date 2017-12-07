package toobject;


/*
 * 编写代码实现同一平面内两圆是否碰撞，其中：
 * 第一个圆圆心坐标为(x1,y1)，半径是r1，第二个圆圆心坐标为(x2,y2)，半径是r2。
 */
public class CircleCollide {

//	Circle cle =new Circle();
//	Circle[] cles =  Circle.values();
	public static void main(String[] args){
		System.out.println(collisWith(Circle.a.x,Circle.a.y,Circle.a.z,Circle.b.x,Circle.b.y,Circle.b.z));
	}
	private enum Circle{
		a(2,2,3),b(1,6,4);
		private int x;
		private int y;
		private int z;
		Circle(){
		}
	    Circle(int x,int y,int z){
			this.x=x;this.y=y;this.z=z;
		}
	}
	static boolean collisWith(int x1, int y1, int r1, int x2, int y2, int r2) {

		boolean flag=false;

		int num1=(x1-x2)*(x1-x2);

		int num2=(y1-y2)*(y1-y2);

		int num3=num1+num2;

		double distance=Math.sqrt(num3);

		if(distance<=(r1+r2)){

		flag=true;

		}

		return flag;

		}
    
}
