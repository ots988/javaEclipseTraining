package toobject;

/*
 * runnable和thread的区别
 *MyThread: start() 解释：如果在继承 Thread 时重写 star 方法是不会再调用 run 方法了。
 *MyRunnable:  run()  解释：Thread 类中 star（）方法调用 run()启动并执行线程，线程的
 *执行体在 run（）方法中
 */
class MyThread extends  Thread{ 
	public void  run(){ System.out.println("MyThread:  run()");
	}
	public void  start(){ System.out.println("MyThread:  start()");
	}
}

class MyRunnable implements  Runnable{ 
	public void  run(){ System.out.println("MyRunnable: run()");
	}
	public void  start(){ System.out.println("MyRunnable: start()");
	}
}

public class ThreadTest  {
public static  void  main(String args[]){ MyThread myThread	  =	new MyThread();
MyRunnable  myRunnable  = new MyRunnable(); Thread  thread	=	new Thread(myRunnable); 
myThread.start();
thread.start();
}
}

