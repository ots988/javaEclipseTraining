package dataStructAndAlgorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//节点类
class Node<T>{
    Node parent; // 父节点
    Node lChild; // 左子树
    Node rChild; // 右子树
    double data; // 数据

    public Node(Node parent, Node lChild, Node rChild, double data) {
        this.parent = parent;
        this.lChild = lChild;
        this.rChild = rChild;
        this.data = data;
    }

    @Override
    public String toString() {
        return "[Node:" + data + "]";
    }
}
//排序二叉树类
public class SortedBinaryTree<T> {
    private Node root; // 根节点

    public SortedBinaryTree(double data) {
        root = new Node(null, null, null, data);
    }

    // 广度遍历，也是层序遍历
    public void broadTraversal() {
        Queue queue = new LinkedList<>();
        // 进队
        queue.offer(root);
        while (!queue.isEmpty()) {
            //出队
            Node node = (Node) queue.poll();
            System.out.print(node + " ");
            if (node.lChild != null) {
                queue.offer(root.lChild);
            }
            if (node.rChild != null) {
                queue.offer(root.rChild);
            }
        }
    }

    // 获得指定节点
    public Node getNode(double data) {
        Node node = root;
        while (node != null) {
            if (node.data == data) {
                // 等于根节点时直接返回该节点
                return node;
            } else if (node.data > data) {
                // 左子树开始查询
                node = node.lChild;
            } else {
                // 右子树开始查询
                node = node.rChild;
            }
        }
        return null;
    }

    public boolean isEmpty(){
        return root==null;
    }

    //递归获得深度
    public int deep(){
        return deep(root);
    }

    private  int deep(Node root){
        if(root==null){
            return 0;
        }else if(root.lChild==null&&root.rChild==null){
            //根节点孩子为null时，树深度为1
            return 1;
        }else{
            int lDeep=deep(root.lChild);
            int rDeep=deep(root.rChild);
            //比较左右子树深度
            int max=lDeep>rDeep? lDeep:rDeep;
            return max+1;
        }
    }

    //添加节点
    public void add(double data){
        //添加根节点
        if(root==null){
            root=new Node(null, null, null, data);
        }else {
            Node current=root;
            Node parent = null;
            while(current!=null)
            {
                parent=current;
                if(current.data>data){
                    current=current.lChild;
                }
                else {
                    current=current.rChild;
                }
            }
            current =new Node(parent, null, null, data);
            if(parent.data>current.data){
                //插在左子树
                parent.lChild=current;
            }else {
                //插在右子树
                parent.rChild=current;
            }
        }
    }

    //删除指定节点
    public void delete(double data) {
        Node target = getNode(data);
        if (target == null) {
            return;
        }
        // 删除的节点左，右子树为空
        if (target.lChild == null && target.rChild == null) {
            if (target == root) {
                //删除根节点
                root = null;
            } else {
                if (target.parent.lChild == target) {
                    //如果target是其父节点的左孩子
                    target.parent.lChild = null;
                } else {
                    //如果target是其父节点的右孩子
                    target.parent.rChild = null;
                }
            }
        }
        // 删除的节点左子树为空，右子树不为空
        else if (target.lChild == null && target.rChild != null) {
            if (target == root) {
                //将根节点指向其右节点即完成删除
                root = target.rChild;
            } else {
                if (target.parent.lChild == target) {
                    // 让target的父节点左子树指向target的右节点
                    target.parent.lChild = target.rChild;
                } else {
                    // 让target的父节点右子树指向target的右节点
                    target.parent.rChild = target.rChild;
                }
                // 让target的父节点指向target的右孩子
                target.rChild.parent = target.parent;
            }
        }
        // 删除的节点左子树不为空，右子树为空
        else if (target.lChild != null && target.rChild == null) {
            if (target == root) {
                root = target.lChild;
            } else {
                //如果target是父节点的左节点
                if (target.parent.lChild == target) {
                    // 让target的父节点左子树指向target的左节点
                    target.parent.lChild = target.lChild;
                } else {
                    // 让target的父节点右子树指向target的左节点
                    target.parent.rChild = target.lChild;
                }
                // 让target的父节点指向target的左孩子
                target.lChild.parent = target.parent;
            }
        }
        // 删除的节点左、右子树不为空
        else {
            Node lMaxNode = target.lChild; // 左子树上最大的节点
            while (lMaxNode.rChild != null) {
                lMaxNode = lMaxNode.rChild;
            }
            //如果target左子树最大节点不是target的左孩子
            if(target.lChild!=lMaxNode)
                lMaxNode.parent.rChild = null;
            lMaxNode.parent = target.parent;
            // 被删除的节点是父节点的左节点
            if (target.parent.lChild == target) {
                // 让target的父节点的左节点指向lMaxNode
                target.parent.lChild = lMaxNode;
            } else {
                // 让target的父节点的右节点指向lMaxNode
                target.parent.rChild = lMaxNode;
            }
            //如果target左子树最大节点不是target的左孩子
            if(lMaxNode!=target.lChild)
                lMaxNode.lChild = target.lChild;
            lMaxNode.rChild = target.rChild;
            target.parent = null;
            target.lChild = null;
            target.rChild = null;
        }
    }
    //前序遍历,递归实现前序遍历
    private String preTraversal(Node node){
        if(node.lChild==null&&node.rChild==null){
            return node.data+"";
        }else{
            StringBuilder sb=new StringBuilder();
            sb.append(node.data+" ");
            String data="";
            String data1="";
            if(node.lChild!=null){
                data=preTraversal(node.lChild);
            }
            if(node.rChild!=null){
                data1=preTraversal(node.rChild);
            }
            return sb.append(data+" "+data1)+"";
        }

    }

    public String preTraversal(){
        return preTraversal(root);
    }

    //前序遍历，利用栈进行
    public void preTraversal2(Node root){
        if(root==null)return;
        Stack<Node> s=new Stack<Node>();
        while(root!=null||!s.isEmpty()){
            while(root!=null){
                System.out.print(root.data+" ");
                s.push(root);//先访问再入栈
                root=root.lChild;
            }
            root=s.pop();  //出栈
            root=root.rChild;//如果是null，出栈并处理右子树
        }
    }

    //前序遍历3
    public void preTraversal3(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            preTraversal3(root.lChild);
            preTraversal3(root.rChild);
        }
    }

    //中序遍历
    public void inOrderTraversal(Node root){
        if(root!=null){
            inOrderTraversal(root.lChild);
            System.out.print(root.data+" ");
            inOrderTraversal(root.rChild);
        }
    }

    //后序遍历
    public void postOrderTraversal(Node root){
        if(root!=null){
            postOrderTraversal(root.lChild);
            postOrderTraversal(root.rChild);
            System.out.print(root.data+" ");
        }
    }

    //层序遍历，利用队实现
    public void levelTraversal(){
        //创建队
        Queue q=new LinkedList<>();
        //添加根节点
        q.add(root);
        while(!q.isEmpty()){
            //第一个元素出队
            Node node=(Node) q.poll();
            System.out.print(node.data+" ");
            if(node.lChild!=null)
                //入队
                q.add(node.lChild);
            if(node.rChild!=null)
                //入队
                q.add(node.rChild);
        }
    }

}
