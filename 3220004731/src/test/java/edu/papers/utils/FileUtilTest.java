package edu.papers.utils;

import org.junit.Test;

public class FileUtilTest {

    @Test
    public void readFile() {
        //读取根目录下已存在的文件
        FileUtil.readFile("O:\\orig.txt");
        //读取根目录下不存在的文件
        FileUtil.readFile("O:\\orig");
        //读取不存在的目录下不存在的文件
        FileUtil.readFile("O:\\z\\orig");
        //读取已存在目录下不存在的文件
        FileUtil.readFile("O:\\test\\orig");
        //读取已存在目录下不存在的文件
        FileUtil.readFile("O:\\test\\orig.txt");
    }

    @Test
    public void writeFile() {
        //结果文件不存在
        FileUtil.writeFile("o1", "o2", 0.0, "O:\\null");
        //结果文件路径格式不合法，根目录为空
        FileUtil.writeFile("o1", "o2", 0.0, "\\null");
        //结果文件路径格式不合法，上级目录名和文件名均为空
        FileUtil.writeFile("o1", "o2", 0.0, "O:\\\\");
        //结果文件已存在
        FileUtil.writeFile("o1", "o2", 0.0, "O:\\ans.txt");
        //结果文件上级目录不存在
        FileUtil.writeFile("o1", "o2", 0.0, "O:\\z\\z1.txt");
        //结果文件上级目录已存在，文件不存在
        FileUtil.writeFile("o1", "o2", 0.0, "O:\\test\\z2.txt");
        //结果文件上级目录已存在，文件已存在
        FileUtil.writeFile("o1", "o2", 0.0, "O:\\test\\z3.txt");
    }
}