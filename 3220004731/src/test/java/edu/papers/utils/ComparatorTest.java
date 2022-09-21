package edu.papers.utils;

import org.junit.Test;

public class ComparatorTest {

    @Test
    public void compare() {
        //两个不同的非空文件的相似度
        System.out.println(Comparator.compare(Segmenter.seg(FileUtil.readFile("O:\\orig.txt")),
                Segmenter.seg(FileUtil.readFile("O:\\orig_0.8_add.txt"))));
        //两个相同非空文件的相似度
        System.out.println(Comparator.compare(Segmenter.seg(FileUtil.readFile("O:\\orig.txt")),
                Segmenter.seg(FileUtil.readFile("O:\\orig.txt"))));
        //两个相同的空文件的相似度
        System.out.println(Comparator.compare(Segmenter.seg(FileUtil.readFile("O:\\orig_null.txt")),
                Segmenter.seg(FileUtil.readFile("O:\\orig_null.txt"))));
    }
}