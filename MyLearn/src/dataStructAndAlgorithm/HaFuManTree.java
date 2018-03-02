package dataStructAndAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给定一组具有确定权值的叶子节点，可以构造出不同的二叉树，将其中带权路径长度最小的二叉树称为哈夫曼树。
class Node1<T>{
    T data; //数据
    double quanShu; //权数
    Node1 lChild;    //左子树
    Node1 rChild;    //右子树

    public Node1(T data, double quanShu) {
        super();
        this.data = data;
        this.quanShu = quanShu;
    }

    @Override
    public String toString() {
        return "Node1["+data+" "+quanShu+"]";
    }

}
public class HaFuManTree {
    /**
     * 　哈夫曼树的实现的基本思想（书上的定义太多，这里我自己简化以下）：
     1. 我们自己创建一个节点集合，把每个节点初始化，并且权数要赋值。
     2. 选择节点集合中权值最小的两个节点，将这两个节点分别作为左子树和右子树，生成一颗新的二叉树，这个二叉树根节点权值就是选出的两个节点的权值的和。
     3. 在集合删除（2）中选择出来的两个节点，再把新生成的节点加入集合中。
     4. 重复（2）、（3），直到集合中只有一棵二叉树时，这个二叉树就是哈夫曼树。
     */

    //创建哈夫曼树
    public Node1 createHaFuManTree(List<Node1> Node1s){
        //节点元素大于或者等于2时继续循环
        while(Node1s.size()>1)
        {
            //升序排序
            sort(Node1s);
            //获得最小的两位节点
            Node1 lChild=Node1s.get(0);
            Node1 rChild=Node1s.get(1);
            //将最小的两个节点"结合"
            Node1 parent=new Node1(null, lChild.quanShu+rChild.quanShu);
            parent.lChild=lChild;
            parent.rChild=rChild;
            //删除已经结合的两个节点
            Node1s.remove(0);
            Node1s.remove(0);
            //添加生成的节点
            Node1s.add(parent);
        }
        return Node1s.get(0);    //返回根节点
    }

    //冒泡排序，将Node1s按照权数升序排序
    public List<Node1> sort(List<Node1> Node1s){
        for(int i=0;i<Node1s.size();i++)
        {
            for(int j=i;j<Node1s.size();j++)
            {
                if(Node1s.get(i).quanShu>Node1s.get(j).quanShu)
                {
                    Node1 Node1 = Node1s.get(i);
                    Node1s.set(i,Node1s.get(j));
                    Node1s.set(j, Node1);
                }
            }
        }
        return Node1s;
    }

    //层序遍历，利用队实现
    public void levelTraversal(Node1 root){
        //创建队
        Queue q=new LinkedList<>();
        //添加根节点
        q.add(root);
        while(!q.isEmpty()){
            //第一个元素出队
            Node1 Node1=(Node1) q.poll();
            System.out.print(Node1+" ");
            if(Node1.lChild!=null)
                q.add(Node1.lChild);
            if(Node1.rChild!=null)
                q.add(Node1.rChild);
        }
    }

    //获得哈夫曼树带权数路径长度
    public double getPathNum(Node1 root,int height){
        if(root==null){
            return 0;
        }else{
            if(root.lChild==null&&root.rChild==null){
                return root.quanShu*height;
            }else{
                return getPathNum(root.lChild, height+1)+getPathNum(root.rChild, height+1);
            }
        }
    }

    public static void main(String[] args) {
        List<Node1> Node1s=new ArrayList<>();
        Node1s.add(new Node1("A", 6));
        Node1s.add(new Node1("B", 20));
        Node1s.add(new Node1("C", 31));
        Node1s.add(new Node1("D", 2));
        Node1s.add(new Node1("E", 12));
        Node1s.add(new Node1("F", 25));
        Node1s.add(new Node1("G", 10));
        HaFuManTree fuManTree=new HaFuManTree();
        Node1 root = fuManTree.createHaFuManTree(Node1s);
        fuManTree.levelTraversal(root);
        System.out.println();
        System.out.println("哈夫曼路径长度为："+fuManTree.getPathNum(root, 0));
    }

}
