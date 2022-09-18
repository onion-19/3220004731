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

//    public static boolean readFile(String filepath, String content) {
//        File f = new File(filepath);
//        BufferedReader bread = null;
//        StringBuffer buffer = new StringBuffer();
//        String str = content;
//        try {
//            bread = new BufferedReader(new FileReader(f));
//            while(null != (str = bread.readLine())) {
//                buffer.append(str);
//            }
//            str = buffer.toString();
//
//            Field valueFieldOfString = String.class.getDeclaredField("value");
//            valueFieldOfString.setAccessible(true);
//            valueFieldOfString.set(str,content.toCharArray());
//
//            bread.close();
//        } catch (IOException e) {
//            System.out.println("文件 " + filepath + " 不存在");
//            return false;
//        } catch (IllegalAccessException | NoSuchFieldException ignored) {
//
//        } finally {
//            if(null != bread) {
//                try {
//                    bread.close();
//                } catch (IOException e) {
//                    System.out.println("读文件缓冲流关闭异常");
//                }
//            }
//        }
//        return true;
//    }

    public static boolean writeFile(String origpath, String testpath, double score, String resultpath) {
        BufferedWriter bwrite = null;
        try {
            bwrite = new BufferedWriter(new FileWriter(new File(resultpath)));
            bwrite.write("论文原文路径：" + origpath + "\n");
            bwrite.write("抄袭论文路径：" + testpath + "\n");
            bwrite.write("文本相似度：" + String.format("%.2f", score));
            bwrite.flush();
        } catch (IOException e) {
            System.out.println("结果文件路径 " + resultpath + " 格式有误");
            return false;
        } finally {
            try {
                if(null != bwrite)
                    bwrite.close();
            } catch (IOException e) {
                System.out.println("写文件缓冲流关闭异常");
            }
        }
        return true;
    }
}
