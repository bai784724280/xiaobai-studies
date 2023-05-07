package com.baiyx.wfwbitest.Algorithm.AlgorithmTest;

import java.util.Scanner;

/**
 * @Author: 白宇鑫
 * @Date: 2023年5月7日, 0007 下午 5:47:16
 * @Description: 商店规定：三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
 * 小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
 * 假设小张手上有n个空汽水瓶，她可以先用自己手上的瓶子换取汽水，然后将得到的空瓶再向老板借用，直到无法再借为止。具体的做法如下：
 *
 * 将n个空瓶换成汽水，可以得到k瓶汽水，同时手上剩下n1个空瓶（其中k=n/3）。
 * 将n1个空瓶再次换成汽水，可以得到k1瓶汽水，同时手上剩下n2个空瓶（其中k1=n1/3）。
 * 依次类推，直到无法再借为止。
 * 最终，小张喝到的汽水瓶数为：
 *
 * k + k1 + k2 + ... + km，
 *
 * 其中m为小张最多可以向老板借用的次数，即手上空瓶数无法再换成汽水时，向老板借用的次数（每次借用都会得到3个空瓶）。
 *
 * 为了简化问题，我们可以将上述过程转化为一个递归函数。假设函数f(n)表示手上有n个空瓶时最多可以喝到多少瓶汽水，则有：
 *
 * f(n) = k + f(n1)，
 *
 * 其中k=n/3，n1=n%3+k。
 *
 * 初始条件为f(0)=0，即手上没有空瓶时无法喝到汽水。
 */

public class Main1 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n;
        while(sc.hasNext())
        {
            n=sc.nextInt();
            System.out.println(Drink(n));
        }

    }

    public static int Drink(int n) {
        if(n<=0) {
            return 0;
        } else if(n==3) {
            return 1;
        } else if(n==2) {
            return 1;
        } else//此时表明对应为3的倍数，递归
        {
            int h=0;
            h=n/3;
            return h+Drink(n-3*h+h);
        }


    }
}