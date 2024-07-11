package com.aiyuns.tinkerplay.Other.Demo;

// 位运算
public class BitwiseOperationsDemo {

    public static void main(String[] args) {
        int a = 5;  // 0101
        int b = 3;  // 0011

        // 按位与
        int andResult = a & b; // 0001
        System.out.println("a & b = " + andResult);

        // 按位或
        int orResult = a | b; // 0111
        System.out.println("a | b = " + orResult);

        // 按位异或
        int xorResult = a ^ b; // 0110
        System.out.println("a ^ b = " + xorResult);

        // 按位取反
        int notResult = ~a; // 1010（补码表示为 -6）
        System.out.println("~a = " + notResult);

        // 左移
        int leftShiftResult = a << 2; // 010100
        System.out.println("a << 2 = " + leftShiftResult);

        // 右移
        int rightShiftResult = a >> 1; // 0010
        System.out.println("a >> 1 = " + rightShiftResult);

        // 无符号右移
        int unsignedRightShiftResult = -5 >>> 1;
        System.out.println("-5 >>> 1 = " + unsignedRightShiftResult);
    }
}
