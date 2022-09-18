package edu.papers.utils;

import java.io.*;

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

    public static boolean writeFile(String origpath, String testpath, double score, String resultpath) {
        BufferedWriter bwrite = null;
        try {
            bwrite = new BufferedWriter(new FileWriter(new File(resultpath)));
            bwrite.write("论文原文路径：" + origpath + "\n");
            bwrite.write("抄袭论文路径：" + testpath + "\n");
            bwrite.write("文本相似度：" + String.format("%.2f", score));
            bwrite.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != bwrite)
                    bwrite.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }
}
