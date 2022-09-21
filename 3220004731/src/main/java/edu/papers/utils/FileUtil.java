package edu.papers.utils;

import java.io.*;

public class FileUtil {
    public static String readFile(String filepath) {
        File f = new File(filepath);
        //判断文件是否存在
        if(!f.exists()) {
            System.out.println("文件 " + filepath + " 不存在");
            return null;
        }
        BufferedReader bread = null;
        String str = null;
        StringBuffer buffer = new StringBuffer();
        try {
            bread = new BufferedReader(new FileReader(f));
            //逐行读取文件
            while(null != (str = bread.readLine())) {
                buffer.append(str);
            }
            str = buffer.toString();
        } catch (IOException e) {
            System.out.println("读取文件 " + filepath + " 时出现异常");
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
            try {
                //创建文件
                f.createNewFile();
            } catch (IOException e) {
                //创建上级目录
                if(!f.getParentFile().mkdirs()) {
                    System.out.println("结果文件路径 " + resultpath + " 格式有误，结果文件目录创建失败");
                    return;
                }
                try {
                    //创建文件
                    f.createNewFile();
                } catch (IOException e1) {
                    System.out.println("结果文件 " + resultpath + " 创建失败");
                    return;
                }
            }
        }
        BufferedWriter bwrite = null;
        try {
            bwrite = new BufferedWriter(new FileWriter(f));
            //写入文件
            bwrite.write("论文原文路径：" + origpath + "\n");
            bwrite.write("抄袭论文路径：" + testpath + "\n");
            bwrite.write("文本相似度：" + String.format("%.2f", score) + "\n");
            bwrite.flush();
            //打印结果文件的保存路径
            System.out.println("结果文件保存路径：" + resultpath);
        } catch (IOException e) {
            System.out.println("写入文件 " + resultpath + " 时出现异常");
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
