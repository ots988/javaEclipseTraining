package dataStructAndAlgorithm;

import java.util.Stack;

/*
    中缀表达式转后缀表达式的三个要点：
    1、数字直接输出
    2、括号匹配出栈，即括号凑成一对时，就将括号中包括的运算符从栈中弹出并输出，如栈中依次放入了（+-），则弹出( - +)，并输出- +。
    3、入栈运算符与栈顶元素发生比较，
    如果遇到的栈顶运算符一直小于入栈运算符优先级则不断弹出并输出，直到遇到更大优先级的运算符或栈为空。（* / 优先级大于 + - 优先级）
 */
public class TestZhongzhuiAndHouZhui {
    Stack<Character> stack = new Stack<>();
    String output = "";

    /**
     * *\/ 优先级大于 + - 优先级
     * 与栈顶运算符比较 一直弹出 直到遇到更大优先级运算符或者栈为空
     * @param element 传入元素
     * @param adv 优先级
     * @return
     */
    String meetOtherElement(char element, int adv) {
        while (!stack.isEmpty()) {
            char element2 = stack.pop();
            //遇到（则退出循环 再将其放入即可
            if (element2 == '(') {
                stack.push(element2);
                break;
            }
            int adv2 = 0;// 遇到的另一个元素优先级
            if (element2 == '+' || element2 == '-') {
                adv2 = 1;
            } else {
                adv2 = 2; // 定义优先级
            }
            //如果运算符优先级低，则把原来弹出元素放回   如：*遇- 则放回 -遇* 弹出
            if (adv2 < adv) {
                stack.push(element2);
                break;
            } else {
                output = output + element2;
            }
        }
        stack.push(element);//将运算符放入
        return output;
    }

    /**
     * 括号配对输出括号中的内容
     *
     * @return
     */
    String popIf() {
        char element;
        while (!stack.isEmpty()) {
            element = stack.pop();
            // 弹出的值不是（就一直加下去
            if (element != '(') {
                output = output + element;
            } else {
                break;
            }
        }
        return output;
    }

    /**
     * 中缀表达式换后缀表达式
     * @param reg
     */
    void changeZhongZhuiToHouZhui(String reg) {
        char[] eg = reg.toCharArray();
        for (int i = 0; i < eg.length; i++) {
            char element = eg[i];
            switch (element) {

                case '+':
                case '-':
                    meetOtherElement(element, 1);
                    break;

                case '*':
                case '/':
                    meetOtherElement(element, 2);
                    break;

                case '(':
                    stack.push(element);
                    break;

                case ')':
                    popIf();
                    break;
                //默认数字输出
                default:
                    output = output + element;
                    break;
            }
            //最后还在栈中的元素输出
            if(i==eg.length-1){
                while(!stack.isEmpty()){
                    output = output+stack.pop();
                }
            }
        }
        System.out.println(output);
    }

    public static void main(String[] args) {
        TestZhongzhuiAndHouZhui t = new TestZhongzhuiAndHouZhui();
        t.changeZhongZhuiToHouZhui("9+(2+3)*5-8/2");
    }

}
