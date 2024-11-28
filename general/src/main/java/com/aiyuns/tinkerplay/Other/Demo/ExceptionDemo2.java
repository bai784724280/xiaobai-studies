package com.aiyuns.tinkerplay.Other.Demo;

public class ExceptionDemo2 {

    public static void main(String[] args) throws Exception{
        String value = "";
        try {
            throw new Exception("Primary Exception");
        } catch (Exception e) {
            try {
                //int i = 1/0;
                value = "xxx";
            } catch (Exception ex) {
                System.out.println("抛出内部异常");
                throw ex;
            }
            System.out.println("抛出外部异常");
            throw e;
        }
    }
}
