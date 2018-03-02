package dataStructAndAlgorithm;

import java.util.Arrays;

public class SortUtil {
    /*
     *直接插入排序
     *每次将一个待排序的记录按其关键码的大小插入到一个已经排好序的有序序列中，直到全部记录排好序。
     * 复杂度为O（n^2）
     */
    public void insertSort(int[] a) {
        for (int i = 1; i < a.length; i++)
        {
            int cos = a[i]; //用于交换元素
            int j = i - 1;
            //不要用a[i]代替cos，a[i]会偷偷摸摸改变
            for (; j >= 0 && cos < a[j]; j--)
            {
                //数据后移
                a[j + 1] = a[j];
            }
            //将值插入
            a[j + 1] = cos;
        }
    }

    /*
     *希尔排序 gap分，先排子序列，再排全部
     * 性能约为O(n^1.3)
     */
    // 以d=n/2为间距（n为数组长），将数组分为几个序列，对每个序列进行插入排序，直到d=1
    public void shellSort(int[] a){
        // 以数组长度的一半为d，每次缩小一半，直到d=1
        for(int d=a.length/2;d>=1;d=d/2)
        {
            for (int m = 0; m <= a.length/2; m++) {
                //将每个序列进行插入排序，从数组第一个开始，每次i加间隔d
                for(int i=m;i<a.length;i=i+d)
                {
                    int cos=a[i];
                    int j=i-d;
                    for(;j>=0&&cos<a[j];j=j-d)
                    {
                        a[j+d]=a[j];
                    }
                    //因为上面最后执行了j=j-d，所以此处j+d
                    a[j+d]=cos;
                }
            }
        }
    }

    /*
     *冒泡排序
     *两两比较，再相互交换位置
     * 复杂度为O(n^2)
     */
    public void BubbleSort(int[] a) {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = i+1; j < a.length; j++)
            {
                if (a[i] > a[j])
                {
                    // 交换位置
                    int cos = a[i];
                    a[i] = a[j];
                    a[j] = cos;
                }
            }
        }
    }

    /*
     *快速排序
     * 设置两个变量i、j，排序开始的时候：i=0，j=N-1；
        以第一个数组元素作为关键数据，赋值给key，即key=A[0]；
        从j开始向前搜索，即由后开始向前搜索(j–)，找到第一个小于key的值A[j]，将A[j]和A[i]互换；
        从i开始向后搜索，即由前开始向后搜索(i++)，找到第一个大于key的A[i]，将A[i]和A[j]互换；
        重复第3、4步，直到i=j； 3,4步中，没找到符合条件的值，即3中A[j]不小于key,4中A[i]不大于key的时候改变j、i的值，
        使得j=j-1，i=i+1，直至找到为止。找到符合条件的值，进行交换的时候i， j指针位置不变。
     */
     /* 返回轴值的下标i
     * @param a 数组
     * @param i 轴值，也是每个分区的第一个元素
     * @param j 数组下标的最大值
     */
    private int quickSort1(int [] a, int i,int j){
        int key=a[i];   //轴值
        outer:while (i < j) {
            for (;; j--) {
                if (i >= j) {
                    //当i=j时结束while循环
                    break outer;
                }
                //从前向后查找，找到第一个小于轴值的数并且交换a[i]和a[j]
                if (a[j] < key) {
                    int cos = a[i];
                    a[i] = a[j];
                    a[j] = cos;
                    break;
                }
            }
            for (;; i++) {
                if (i >= j) {
                    //当i=j时结束while循环
                    break outer;
                }
                //从前向后查找，找到第一个小于轴值的数并且交换a[i]和a[j]
                if (a[i] > key) {
                    int cos = a[i];
                    a[i] = a[j];
                    a[j] = cos;
                    break;
                }
            }
        }
        //返回轴值下标i
        return i;
    }

    /**快速排序
     * @param a 数组
     * @param i 轴值，也是数组第一个元素
     * @param j 数组下标的最大值
     */
    public void quickSort(int[] a ,int i,int j) {
        //执行区间大于1时，执行划分数组，否则结束递归
        if(i<j){
            //接受上一次轴值下标
            int middle=quickSort1(a, i, j);
            quickSort(a, i, middle-1);
            quickSort(a, middle+1, j);
        }
    }

    /*
    直接选择排序
    复杂度为O(n^2)
    不稳定
     */
    public void selectSort(int[] a){
        //执行n-1躺即可，最后一个数自动排好
        for(int i=0;i<a.length-1;i++)
        {
            //j一定要等于i+1，才能确保每趟第i个数和从i+1开始的无序区中选中的最小数比较
            for(int j=i+1;j<a.length;j++)
            {
                //如果第i个数比第j个数大则交换
                if(a[i]>a[j]){
                    int cos=a[i];
                    a[i]=a[j];
                    a[j]=cos;
                }
            }
        }
    }

    /*
     *堆排序 的调整
     * @param a 待需排序的数组
     * @param k 当前筛选的节点
     * @param m 堆中最后一个节点下标
     */
    public void modifyHeap(int[] a,int k,int m){
        // i为筛选节点，j为i的左孩子
        int i = k, j = 2 * i + 1;
        // 筛选的不是叶子结点便循环下去
        while (j <= m) {
            // 如果筛选节点的左孩子小于右孩子，则j指向右孩子下标;
            if (j < m && a[j] < a[j + 1]) {
                j++;
            }
            // 筛选节点大于其左右孩子则结束
            if (a[i] > a[j]) {
                break;
            } else {
                // 交换筛选节点与叶子节点位置
                int cos = a[i];
                a[i] = a[j];
                a[j] = cos;
                //继续循环调整直到i为叶子节点
                i = j;
                j = 2 * i + 1;
            }
        }
    }

    // 堆排序  O（nlog2 n） 不稳定
    public void heapSort(int[] a ) {
        int n=a.length; //a的数组长度
        //建立大根堆，从i=(n-1)/2的位置开始处理
        for(int i=(n-1)/2;i>=0;i--){
            modifyHeap(a, i, n-1);
        }
        //运行了n-1趟
        for(int i=1;i<n;i++){
            //交换最后一个数与第一个数的位置
            int cos=a[0];
            a[0]=a[n-i];
            a[n-i]=cos;
            //再次调整堆
            modifyHeap(a, 0, n-i-1);
        }
    }

    /**
     * @param a 待排序数组
     * @param left 左数组的第一个数下标
     * @param center 左数组的最后一个数下标
     * @param right 右数组的最后一个数下标
     */
    private void merge(int [] a,int left,int center,int right){
        int[] temp=new int[a.length];   //临时数组
        int mid= center+1;
        //中间数组的索引
        int i=left;
        int j=left;
        //一直进行到其中一方所有数据全部复制到临时数组
        while(left<=center&&mid<=right){
            //比较两组数据，根据大小确定将谁复制
            if(a[left]<=a[mid]){
                temp[i]=a[left];
                i++;
                left++;
            }
            else{
                temp[i]=a[mid];
                i++;
                mid++;
            }
        }
        //将剩余部分加入到数组中
        while(left<=center){
            temp[i]=a[left];
            i++;
            left++;
        }
        while(mid<=right){
            temp[i]=a[mid];
            i++;
            mid++;
        }
        //将临时数组中数据复制回原来的数组
        while(j<=right){
            a[j]=temp[j];
            j++;
        }
    }
    public void mergeSort(int [] a){
        sort(a, 0, a.length-1);
    }

    /**
     * @param a 待排序数组
     * @param first 数组第一个数下标
     * @param end 数组最后一个数下标
     * 归并排序需要先分解，再合并。 归并排序算法复杂度为O(nlog2 n)。
     * 归并排序算法空间效率较差，因为它需要一个与原数组相同大小的数组，但归并排序是稳定的
     */
    private void sort(int [] a,int first,int end){
        if(first<end){
            //找出中间索引
            int middle=(first+end)/2;
            //对左边数组进行递归
            sort(a, first, middle);
            //对右边数组进行递归
            sort(a, middle+1, end);
            //合并
            merge(a, first, middle, end);
        }
    }

    /**
     * 桶式排序
     * @param a待排序数组
     * @param min数组中最小的数
     * @param max数组中最大的数
     */
    public void bucketSort(int [] a,int min,int max){
        //buckets数组相当于定义了max-min+1个桶，即数组的容量就是桶几个
        int [] buckets=new int[max-min+1];
        //记录每个数出现的次数
        for(int i=0;i<a.length;i++){
            //在指定的位置记录元素出现的个数
            buckets[a[i]-min]++;
        }
        //将buckets换成新的buckets
        for(int i=1;i<max-min+1;i++){
            buckets[i]=buckets[i]+buckets[i-1];
        }
        //定义一个临时数组将a数组缓存下来
        int[] tmp=new int[a.length];
        System.arraycopy(a, 0, tmp, 0, a.length);
        //根据新的buckets的信息将数据按放回相应位置，即排序
        for(int k=a.length-1;k>=0;k--){
                /*
                tmp[k]-min得到的是tmp[k]在buckets数组中的下标
                --buckets[tmp[k]-min]中的--是因为要将得到的
                buckets[tmp[k]-min]，即某数排在第几位转化为数组下标
                所以减一即可。
                */
            a[--buckets[tmp[k]-min]]=tmp[k];
        }
    }

    /**
     * @param a待排序数组
     * @param radix 指定关键字拆分进制
     * @param d 子关键字数目
     */
    public void radixSort(int [] a ,int radix,int d){
        System.out.println("开始排序:");
        int length=a.length;
        //创建临时数组
        int[] tmp=new int[length];
        //创建buckets数组即创建了其长度数量的桶
        int[] buckets=new int[radix];
        //rate为保存当前计算的位，1为个位，10为十位......
        for(int i=0,rate=1;i<d;i++){
            //重置buckets数组
            Arrays.fill(buckets, 0);
            //将data数组的元素复制到临时数组中
            System.arraycopy(a, 0, tmp, 0, length);
            for(int j=0;j<length;j++){
                //计算数据指定位上的子关键字，比如第一轮129的subKey为9
                int subKey=(tmp[j]/rate)%radix;
                //记录subKey出现的次数
                buckets[subKey]++;
            }
            //按桶式公式将buckets换成新的buckets
            for(int j=1;j<radix;j++){
                buckets[j]=buckets[j]+buckets[j-1];
            }
            //按子关键字对指定数据进行排序
            for(int m=length-1;m>=0;m--){
                int subKey=(tmp[m]/rate)%radix;
                a[--buckets[subKey]]=tmp[m];
            }
            System.out.println("按"+rate+"位上子关键字进行排序："+Arrays.toString(a) );
            rate *=radix;
        }
    }
}
