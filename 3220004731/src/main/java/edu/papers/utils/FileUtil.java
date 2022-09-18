package edu.papers.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
    public static String readFile(String filepath) {
        File f = new File(filepath);
        BufferedReader bread = null;
        String str = null;
        StringBuffer buffer = new StringBuffer();
        try {
            bread = new BufferedReader(new FileReader(f));
            while(null != (str = bread.readLine())) {
                buffer.append(str);
            }
            str = buffer.toString();
            bread.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != bread) {
                try {
                    bread.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return str;
    }
}
