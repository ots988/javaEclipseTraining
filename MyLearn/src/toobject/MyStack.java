package toobject;

import java.util.ArrayList;
import java.util.List;

/*
 * 请用JAVA实现两个类，分别实现堆栈（Stack)和队列（Queue）操作。
 */
public class MyStack {
	private List list;

	public MyStack(){
		list = new ArrayList();
	}

	public boolean isEmpty(){
		return list.size() == 0;
	}

	public void push(Object obj){
		list.add(obj);
	}

	public Object pop(){
		if(list.size()>0){
		Object obj = list.get(list.size()-1);
		list.remove(list.size()-1);
		return obj;
		}else{
		return null;
		}
	}

	public int getNumber(){
		return list.size();
	}
}

class IntegerQueue {

	public int[] integerQueue;// 用来当队列

	public int tail;// 队尾

	public int size;// 队的长度，也可以设置一个默认值，溢出时从新申请

	public IntegerQueue(int size) {

		integerQueue = new int[size];
	
		this.size = size;
	
		tail = 0;

	}

	public void inQueue(int i) {
		if (tail < size) {
		this.integerQueue[tail] = i;
		tail++;
		} else {
			System.err.println("溢出啦！");
		}
	}
	
	public int outQueue() {
		if(tail>=0){
			int tmp= this.integerQueue[tail];
			tail--;
			return tmp;
		}else{
			System.err.println("队列为空！");
			throw new RuntimeException();
		}
	}

	}