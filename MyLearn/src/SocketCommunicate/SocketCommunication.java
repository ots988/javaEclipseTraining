package SocketCommunicate;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketCommunication {
	
	//单线程
	public void service(){
	    while(true){
	        Socket socket=null;
	        try{
	        	ServerSocket serverSocket = new ServerSocket();
	            socket=serverSocket.accept();//从连接队列中取出一个连接，如果没有则等待
	            System.out.println("新增连接："+socket.getInetAddress()+":"+socket.getPort());
	            //接收和发送数据
	        }catch(IOException e){e.printStackTrace();}finally{
	            try{
	                if(socket!=null) socket.close();//与一个客户端通信结束后，要关闭Socket
	            }catch(IOException e){e.printStackTrace();}
	        }
	    }
	}
	//多线程
	public void service2(){
	    while(true){
	        Socket socket=null;
	        try{ 
	        	ServerSocket serverSocket = new ServerSocket();
	            socket=serverSocket.accept();                        //主线程获取客户端连接
	            Thread workThread=new Thread(new Handler(socket));    //创建线程
	            workThread.start();                                    //启动线程
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	}
	class Handler implements Runnable{
	    private Socket socket;
	    public Handler(Socket socket){
	        this.socket=socket;
	    }
	    
	    public void run(){
	        try{
	            System.out.println("新连接:"+socket.getInetAddress()+":"+socket.getPort());
	            Thread.sleep(10000);
	        }catch(Exception e){e.printStackTrace();}finally{
	            try{
	                System.out.println("关闭连接:"+socket.getInetAddress()+":"+socket.getPort());
	                if(socket!=null)socket.close();
	            }catch(IOException e){
	                e.printStackTrace();
	            }
	        }
	    }
	}
}
