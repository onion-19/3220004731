package edu.papers.utils;

import org.junit.Test;

public class ComparatorTest {

    @Test
    public void compare() {
        System.out.println(Comparator.compare(Segmenter.seg(FileUtil.readFile("O:\\orig.txt")),
                Segmenter.seg(FileUtil.readFile("O:\\orig_0.8_add.txt"))));
        System.out.println(Comparator.compare(Segmenter.seg(FileUtil.readFile("O:\\orig_null.txt")),
                Segmenter.seg(FileUtil.readFile("O:\\orig_null.txt"))));
    }
}