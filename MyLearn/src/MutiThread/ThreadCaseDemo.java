package MutiThread;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class Info1{	// 定义信息类
    private String name = "name";//定义name属性，为了与下面set的name属性区别开
    private String content = "content" ;// 定义content属性，为了与下面set的content属性区别开
    private boolean flag = true ;	// 设置标志位,初始时先生产
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition(); //产生一个Condition对象
    public  void set(String name,String content){
        lock.lock();
        try{
            while(!flag){
                condition.await() ;
            }
            this.setName(name) ;	// 设置名称
            Thread.sleep(300) ;
            this.setContent(content) ;	// 设置内容
            flag  = false ;	// 改变标志位，表示可以取走
            condition.signal();
        }catch(InterruptedException e){
            e.printStackTrace() ;
        }finally{
            lock.unlock();
        }
    }

    public void get(){
        lock.lock();
        try{
            while(flag){
                condition.await() ;
            }
            Thread.sleep(300) ;
            System.out.println(this.getName() +
                    " --> " + this.getContent()) ;
            flag  = true ;	// 改变标志位，表示可以生产
            condition.signal();
        }catch(InterruptedException e){
            e.printStackTrace() ;
        }finally{
            lock.unlock();
        }
    }

    public void setName(String name){
        this.name = name ;
    }
    public void setContent(String content){
        this.content = content ;
    }
    public String getName(){
        return this.name ;
    }
    public String getContent(){
        return this.content ;
    }
}
class Producer1 implements Runnable{	// 通过Runnable实现多线程
    private Info1 Info1 = null ;		// 保存Info1引用
    public Producer1(Info1 Info1){
        this.Info1 = Info1 ;
    }
    public void run(){
        boolean flag = true ;	// 定义标记位
        for(int i=0;i<10;i++){
            if(flag){
                this.Info1.set("姓名--1","内容--1") ;	// 设置名称
                flag = false ;
            }else{
                this.Info1.set("姓名--2","内容--2") ;	// 设置名称
                flag = true ;
            }
        }
    }
}
class Consumer1 implements Runnable{
    private Info1 Info1 = null ;
    public Consumer1(Info1 Info1){
        this.Info1 = Info1 ;
    }
    public void run(){
        for(int i=0;i<10;i++){
            this.Info1.get() ;
        }
    }
}
public class ThreadCaseDemo{
    public static void main(String args[]){
        Info1 Info1 = new Info1();	// 实例化Info1对象
        Producer1 pro = new Producer1(Info1) ;	// 生产者
        Consumer1 con = new Consumer1(Info1) ;	// 消费者
        new Thread(pro).start() ;
        //启动了生产者线程后，再启动消费者线程
        try{
            Thread.sleep(500) ;
        }catch(InterruptedException e){
            e.printStackTrace() ;
        }

        new Thread(con).start() ;
    }
}
