package edu.papers.utils;

import org.junit.Test;

public class FileUtilTest {

    @Test
    public void readFile() {
        FileUtil.readFile("O:\\orig.txt");
        FileUtil.readFile("O:\\orig");
    }

    @Test
    public void writeFile() {
        FileUtil.writeFile("o1", "o2", 0.0, "O:\\null");
        FileUtil.writeFile("o1", "o2", 0.0, "\\null");
        FileUtil.writeFile("o1", "o2", 0.0, "O:\\\\");
        FileUtil.writeFile("o1", "o2", 0.0, "O:\\ans.txt");
        FileUtil.writeFile("o1", "o2", 0.0, "O:\\z2.txt");
        FileUtil.writeFile("o1", "o2", 0.0, "O:\\z\\z2.txt");

    }
}