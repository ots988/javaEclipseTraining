package toobject;
/*
 * 懒汉模式
 */
public class Singleton {
	private static Singleton singleton ;
	private Singleton(){}
	//线程不安全
	public static Singleton getSing(){
		if(null==singleton){
			singleton = new Singleton();
		}
		return singleton;
	}
	//线程安全
	public static Singleton getInstance() {  
        if (singleton == null) {    
            synchronized (Singleton.class) {    
               if (singleton == null) {    
                  singleton = new Singleton();   
               }    
            }    
        }    
        return singleton;   
    } 
}
/*
 * 懒汉模式，线程安全，静态内部类
 */
 class Singleton1 {  
    private static class LazyHolder {  
       private static final Singleton1 INSTANCE = new Singleton1();  
    }  
    private Singleton1 (){}  
    public static final Singleton1 getInstance() {  
       return LazyHolder.INSTANCE;  
    }  
} 
 
 
/*
 * 饿汉模式
 */
class Singleton2 {  
	    private Singleton2() {}  
	    private static final Singleton2 single = new Singleton2();  
	    //静态工厂方法   
	    public static Singleton2 getInstance() {  
	        return single;  
	    }  
	}
