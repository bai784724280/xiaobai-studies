package com.baiyx.wfwbitest.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: baiyx
 * @Date: 2023年5月18日, 0018 上午 10:10:18
 * @Description: IO小例子
 */

public class IOdemo {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/db.properties"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
