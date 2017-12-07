package toobject;
/*
 * 类的成员变量 请定义一个交通工具(Vehicle)的类其中有: 
 * 属性速度(speed)体积(size)等等 方法移动(move())设置速度(setSpeed(int speed))加速speedUp(),减速speedDown()等等. 
 * 最后在测试类Vehicle中的main()中实例化一个交通工具对象并通过方法给它初始化speed,size的值并且通过打印出来。
 * 另外调用加速减速的方法对速度进行改变。
 */
public class Speed {
	
	public static void main(String[] args){
		Vehicle vehicle = new Vehicle(20,100);
		System.out.println("Vehicle的速度和大小是"+vehicle.speed+"  "+vehicle.size);
		vehicle.speedUp(5);
		System.out.println("Vehicle的速度和大小是"+vehicle.speed+"  "+vehicle.size);
	}
}
class Vehicle{
	Vehicle(){
		
	}
	Vehicle(int speed,int size){
		this.speed = speed;
		this.size = size;
	}	
	int speed;
	int size;
	void move(){
		
	}
	void setSpeed(int speed){
		
	}
	void speedUp(int speed){
		this.speed+=speed;
	}
	void speedDown(int speed){
		
	}
	
}