package dataStructAndAlgorithm;

public class Queen {
    /**
     * 累计方案
     */
    public static int num = 0;
    public static final int MAXQUEEN = 4;
    /**
     * 8列棋子每一列皇后位置 cols[0] = 0 ,cols[1] = 2;
     */
    public static int [] cols = new int[MAXQUEEN];

    /**
     * 填第n列的皇后
     * @param n
     */
    public void getCount(int n){
        //记录每次递归时当前列的每个方格是否可以放皇后
        boolean [] rows = new boolean[MAXQUEEN];
        //记录所有不能放的位置
        for (int i = 0; i < n; i++) {
            //当前列N的的棋子不能放在前面列i的棋子的所在行上
            rows[cols[i]]=true;
            //当前列N的棋子到前面列i的棋子的距离
            int d = n - i;
            //当前列不能放在前面列i的棋子的正斜线上
            if(cols[i] - d >= 0){
                rows[cols[i] - d] = true;
            }
            //当前列不能放在前面列i的棋子的反斜线上
            if(cols[i] + d < MAXQUEEN){
                rows[cols[i] + d] = true;
            }
        }
        for (int i = 0; i < MAXQUEEN; i++) {
            //已经放了皇后的列跳过
            if(rows[i]){
                continue;
            }
            //没有放便将位置存放在数组中
            cols[n] = i;
            if(n < MAXQUEEN - 1){
                getCount(n+1);
            }else{
                //方案加1
                num++;
                printQueen();
            }
            //继续循环，重n列的不同位置再开始
        }
    }

    public void printQueen(){
        System.out.println("第"+num+"种方法：");
        for (int i = 0; i < MAXQUEEN; i++) {
            for (int j = 0; j < MAXQUEEN; j++) {
                if(cols[j]==i){
                    System.out.print("o ");
                }else{
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.getCount(0);
    }
}
