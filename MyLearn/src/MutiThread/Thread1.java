package MutiThread;
/*
 * 线程A向队列Q中不停写入数据，线程B从队列Q中不停读取数据（只要Q中有数据）。
 * 接口中有两个一个是向队列中写push方法 一个是从队列中读。
 */
public class Thread1 {
	
	public static void main(String[] args) throws InterruptedException{
//		Writing w = new Writing(12);
//		Thread th = new Thread(w);
//		th.start();
		StackInterface st = new SafeStack();
		PushThread push = new PushThread(st);
		Thread th2 = new Thread(push);
		th2.start();
		PopThread pop =new PopThread(st);
		Thread th1 = new Thread(pop);
		th1.start();

	}
}
class Writing implements Runnable{
	Writing(){
		
	}
	Writing(int aa){
		this.aa =aa;
	}
	int aa;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		System.out.println(aa);
	}
	
}

interface StackInterface{

	public void push(int n);
	
	public int pop();

}

//上边接口的实现类。

class SafeStack implements StackInterface {
	
	private int top = 0;
	
	private int[] values = new int[21];
	
//	private boolean dataAvailable = false;
	
	public void push(int n) {
	
		synchronized (this) {
//			while (dataAvailable){
//				try {
//					wait();
//				} catch (InterruptedException e) {
//					// 忽略 //2
//				}
//			}
			values[top] = n;
			System.out.println("压入数字" + n + "步骤1完成");
			top++;
//			dataAvailable = true;
			notifyAll();
			System.out.println("压入数字完成");
		}
	}
	
	public int pop() {
		synchronized (this) {
			while (top==0){
				try {
					wait();
				} catch (InterruptedException e) {
				// 忽略 //4
				}
			
			}
			System.out.print("弹出");
			top--;
//			int[] test = { values[top], top };
//			dataAvailable = false;
			// 唤醒正在等待压入数据的线程
//			notifyAll();
			return values[top];
		}
	}
}

//读线程

class PopThread implements Runnable{
	
	private StackInterface s;

	public PopThread(StackInterface s){
		this.s = s;
	}
	public void run()
	{
		while(true)
		{
			System.out.println("->"+ s.pop() + "<-");
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException e){
				
			}
		}
	}
}

//写线程

class PushThread implements Runnable{

	private StackInterface s;

	public PushThread(StackInterface s){
		this.s = s;
	}
	
	public void run(){
		int i = 0;
		while(true)
		{
			java.util.Random r = new java.util.Random();
			i = r.nextInt(10);
			s.push(i);
			try {
				Thread.sleep(100);
			}
			catch(InterruptedException e){}
		}
	}
}