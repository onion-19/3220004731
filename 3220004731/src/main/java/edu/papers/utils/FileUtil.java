package edu.papers.utils;

import java.io.*;

public class FileUtil {
    public static String readFile(String filepath) {
        File f = new File(filepath);
        if(!f.exists()) {
            System.out.println("文件 " + filepath + " 不存在");
            return null;
        }
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
            System.out.println("文件 " + filepath + " 不存在");
        } finally {
            if(null != bread) {
                try {
                    bread.close();
                } catch (IOException e) {
                    System.out.println("读文件缓冲流关闭异常");
                }
            }
        }
        return str;
    }

    public static void writeFile(String origpath, String testpath, double score, String resultpath) {
        File f = new File(resultpath);
        if(!f.exists()) {
            if(!f.getParentFile().mkdirs()) {
                System.out.println("结果文件路径 " + resultpath + " 格式有误，结果文件目录创建失败");
                return;
            }
            try {
                if(!f.createNewFile()) {
                    System.out.println("结果文件路径 " + resultpath + " 格式有误，结果文件创建失败");
                    return;
                }
            } catch (IOException e) {
                System.out.println("结果文件路径 " + resultpath + " 格式有误，结果文件创建失败");
                return;
            }
        }
        BufferedWriter bwrite = null;
        try {
            bwrite = new BufferedWriter(new FileWriter(f));
            bwrite.write("论文原文路径：" + origpath + "\n");
            bwrite.write("抄袭论文路径：" + testpath + "\n");
            bwrite.write("文本相似度：" + String.format("%.2f", score));
            bwrite.flush();
        } catch (IOException e) {
            System.out.println("结果文件路径 " + resultpath + " 格式有误");
        } finally {
            try {
                if(null != bwrite)
                    bwrite.close();
            } catch (IOException e) {
                System.out.println("写文件缓冲流关闭异常");
            }
        }
    }
}
