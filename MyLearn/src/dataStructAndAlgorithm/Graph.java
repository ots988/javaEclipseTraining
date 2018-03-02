package dataStructAndAlgorithm;

import java.util.Arrays;
import java.util.LinkedList;
/*
图一般有两种实现方式，一种是邻接矩阵，一种是邻接表。这里为大家带来的是邻接矩阵实现图
深度遍历 和 广度优先遍历
 */
public class Graph {
    /**
     * 图的顶点数
     */
    private int vertexSize = 0;
    /**
     * 图的邻接矩阵
     */
    private int[][] matrix = null;
    /**
     * 顶点数组
     */
    private int[] vertex = null;
    /**
     * 代表两点之间无边
     */
    private static final int MAX_SIZE = 1000;
    /**
     * 每个点被访问的状态 0为没有访问，1为被访问
     */
    private int[] state = null;
    /**
     * 队，用于广度优先遍历
     */
    private LinkedList<Integer> queue = new LinkedList<Integer>();

    /**
     * 求顶点
     *
     * @return
     */
    public int getVertex() {
        return vertexSize;
    }

    public Graph(int size, int[]... number) {
        this.vertexSize = size;
        matrix = new int[size][size];
        vertex = new int[size];
        //初始化数组
        for (int i = 0; i < vertex.length; i++) {
            vertex[i] = i;
        }
        for (int i = 0; i < number.length; i++) {
            matrix[i] = number[i];
        }
        state = new int[size];
        Arrays.fill(state, 0);
    }

    /**
     * 获得顶点的出度,第i个顶点即第i行不等于0，小于最大值的数的和
     *
     * @param v
     */
    public void getOutDegree(int v) {
        // 出度数
        int j = 0;
        // 权重
        int weight = 0;
        // 遍历第i行
        for (int i = 0; i < matrix[v].length; i++) {
            weight = matrix[v][i];
            if (weight != 0 && weight < MAX_SIZE) {
                j++;
            }
        }
        System.out.println("v" + v + "出度为：" + j);
    }

    /**
     * 获得顶点的入度
     *
     * @param v
     */
    public void getIntoDegree(int v) {
        // 入度数
        int j = 0;
        // 权重
        int weight = 0;
        // 遍历第i行
        for (int i = 0; i < matrix.length; i++) {
            weight = matrix[i][v];
            if (weight != 0 && weight < MAX_SIZE) {
                j++;
            }
        }
        System.out.println("v" + v + "入度为：" + j);
    }

    /**
     * 获得两点之间的权重
     *
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1, int v2) {
        int weight = matrix[v1][v2] == MAX_SIZE ? -1 : matrix[v1][v2];
        return weight == 0 ? 0 : weight;
    }

    /**
     * 添加点
     *
     * @param thisToOther
     *            添加的点到其他点的距离
     * @param otherToThis
     *            其他点到这个点的距离
     */
    public void addVertex(int[] thisToOther, int[] otherToThis) {
        // 顶点数
        vertexSize++;
        vertex = new int[vertexSize];
        state = new int[vertexSize];
        Arrays.fill(state, 0);
        // 把原来的数据传到新的数组
        int[][] temp = matrix;
        matrix = new int[vertexSize][vertexSize];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
        matrix[vertexSize - 1][vertexSize - 1] = 0;
        // 把边添加进去
        for (int i = 0; i < thisToOther.length; i++) {
            matrix[vertexSize - 1][i] = thisToOther[i];
        }
        for (int i = 0; i < otherToThis.length; i++) {
            matrix[i][vertexSize - 1] = otherToThis[i];
        }

    }

    /**
     * 获得指定点的第一个邻接点
     *
     * @param v
     * @return
     */
    public int getFirst(int v) {
        for (int i = 0; i < vertexSize; i++) {
            if (matrix[v][i] > 0 && matrix[v][i] < MAX_SIZE) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获得指定节点的下一个邻接点
     *
     * @param v
     *            指定节点
     * @param index
     * @return
     */
    public int getNext(int v, int index) {
        for (int i = index + 1; i < vertexSize; i++) {
            if (matrix[v][i] > 0 && matrix[v][i] < MAX_SIZE) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 深度优先遍历
     *
     * @param v 开始点
     *
     */
    private void depthFirst(int v) {
        System.out.println("开始访问:" + v);
        state[v] = 1;
        int w = getFirst(v);
        while (w != -1) {
            // 如果没有被访问，从这个顶点开始
            if (state[w] == 0) {
                depthFirst(w);
            }
            w = getNext(v, w);
        }
    }

    /**
     * 对外开放的深度优先遍历
     *
     * @param v
     */
    public void depthFirstTraverse(int v) {
        depthFirst(v);
        //状态数组清理
        Arrays.fill(state, 0);
    }

    /**
     * 广度优先遍历
     *
     * @param v
     */
    private void boardFirst(int v) {
        // 顶点入队
        queue.offer(v);
        // 顶点被访问
        state[v] = 1;
        int w = 0;
        while (!queue.isEmpty()) {
            // 出队
            v = queue.poll();
            w = getFirst(v);
            System.out.println("开始访问点v"+v);
            while (w != -1) {
                //如果没有被访问则访问并且入队
                if(state[w] == 0){
                    queue.offer(w);
                    state[w] = 1;
                }
                w = getNext(v, w);
            }
        }
    }

    /**
     * 对外广度遍历算法
     * @param v
     */
    public void boardFirstTraverse(int v){
        boardFirst(v);
        Arrays.fill(state, 0);
    }

    /**
     * 打印矩阵
     */
    public void printGraph() {
        for (int[] is : matrix) {
            for (int i : is) {
                System.out.print(i + "  ");

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] a0 = new int[] { 0, 9, 6, MAX_SIZE, MAX_SIZE };
        int[] a1 = new int[] { MAX_SIZE, 0, 4, 5, MAX_SIZE };
        int[] a2 = new int[] { MAX_SIZE, MAX_SIZE, 0, MAX_SIZE, 7 };
        int[] a3 = new int[] { 3, MAX_SIZE, MAX_SIZE, 0, MAX_SIZE };
        int[] a4 = new int[] { MAX_SIZE, MAX_SIZE, MAX_SIZE, 8, 0 };
        Graph graph = new Graph(5, a0, a1, a2, a3, a4);
        graph.printGraph();

        /*
         * graph.getOutDegree(0); graph.getIntoDegree(4);
         * System.out.println("两点之间权重为：" + graph.getWeight(1, 3));
         * System.out.println("顶点为:" + graph.getVertex());
         *
         * graph.addVertex(new int[] { MAX_SIZE, MAX_SIZE, 6, MAX_SIZE, 5 }, new
         * int[] { MAX_SIZE, MAX_SIZE, 6, MAX_SIZE, 5 }); graph.printGraph();
         * graph.getOutDegree(0); graph.getIntoDegree(4);
         * System.out.println("两点之间权重为：" + graph.getWeight(1, 3));
         * System.out.println("顶点为:" + graph.getVertex());
         */
        System.out.println("开始深度遍历：");
        graph.depthFirstTraverse(0);
        System.out.println("开始广度遍历：");
        graph.boardFirstTraverse(0);
    }

}