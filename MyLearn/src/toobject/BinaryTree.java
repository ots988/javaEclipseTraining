package toobject;
public class BinaryTree {
   public int value;
   public BinaryTree left;
   public BinaryTree right;
   public void store(int value)
   {
         if(value<this.value)
         {
               if(left == null)
               {
                     left = new BinaryTree();
                     left.value=value;
               }
               else
               {
                     left.store(value);
               }
         }
         else if(value>this.value)
          {
                if(right == null)
                {
                      right = new BinaryTree();
                      right.value=value;
                }
                else
                {
                      right.store(value);
                }                
          }
   }
   
   public boolean find(int value)
   {    
         System.out.println("happen " + this.value);
          if(value == this.value)
         {
                return true;
          }
         else if(value>this.value)
         {
                if(right == null) return false;
                return right.find(value);
         }else
         {
                if(left == null) return false;
                return left.find(value);
          }
   }
   
   public  void preList()
   {
          System.out.print(this.value + ",");
          if(left!=null) left.preList();
          if(right!=null) right.preList();
    }
   
   public void middleList(){
          if(left!=null) left.preList();
          System.out.print(this.value + ",");
          if(right!=null) right.preList();         
    }
   
   public void afterList()
    {
          if(left!=null) left.preList();
          if(right!=null) right.preList();
          System.out.print(this.value + ",");      
    }    
    public static void main(String [] args)
    {
          int [] data = new int[20];
          for(int i=0;i<data.length;i++)
          {
                data[i] = (int)(Math.random()*100) + 1;
                System.out.print(data[i] + ",");
          }
          System.out.println();
          BinaryTree root = new BinaryTree();
          root.value = data[0];
          for(int i=1;i<data.length;i++)
          {
                root.store(data[i]);
          }
          root.find(data[19]);
          root.preList();
         System.out.println();
         root.middleList();
         System.out.println();        
         root.afterList();
   }

}

//-----------------又一次临场写的代码---------------------------
//
//import java.util.Arrays;
//
//import java.util.Iterator;
//
//
//
//public class Node {
//
//    private Node left;
//
//    private Node right;
//
//    private int value;
//
//    //private int num;
//
//   
//
//    public Node(int value){
//
//          this.value = value;
//
//    }
//
//    public void add(int value){
//
//         
//
//          if(value > this.value)
//
//          {
//
//                if(right != null)
//
//                      right.add(value);
//
//                else
//
//                {
//
//                      Node node = new Node(value);                   
//
//                      right = node;
//
//                }
//
//          }
//
//          else{
//
//                if(left != null)
//
//                      left.add(value);
//
//                else
//
//                {
//
//                      Node node = new Node(value);                   
//
//                      left = node;
//
//                }                
//
//          }
//
//    }
//
//   
//
//    public boolean find(int value){
//
//          if(value == this.value) return true;
//
//          else if(value > this.value){
//
//                if(right == null) return false;
//
//                else return right.find(value);
//
//          }else{
//
//                if(left == null) return false;
//
//                else return left.find(value);            
//
//          }
//
//
//
//    }
//
//   
//
//    public void display(){
//
//          System.out.println(value);
//
//          if(left != null) left.display();
//
//          if(right != null) right.display();
//
//         
//
//    }
//
//   
//
//    /*public Iterator iterator(){
//
//         
//
//    }*/
//
//   
//
//    public static void main(String[] args){
//
//          int[] values = new int[8];
//
//          for(int i=0;i<8;i++){
//
//                int num = (int)(Math.random() * 15);
//
//                //System.out.println(num);
//
//                //if(Arrays.binarySearch(values, num)<0)
//
//                if(!contains(values,num))
//
//                      values[i] = num;
//
//                else
//
//                      i--;
//
//          }
//
//         
//
//          System.out.println(Arrays.toString(values));
//
//         
//
//          Node root  = new Node(values[0]);
//
//          for(int i=1;i<values.length;i++){
//
//                root.add(values[i]);
//
//          }
//
//         
//
//          System.out.println(root.find(13));
//
//         
//
//          root.display();
//
//         
//
//    }
//
//   
//
//    public static boolean contains(int [] arr, int value){
//
//          int i = 0;
//
//          for(;i<arr.length;i++){
//
//                if(arr[i] == value) return true;
//
//               
//
//          }
//
//          return false;
//
//    }
//}