package edu.papers.test;

import edu.papers.utils.FileUtil;
import edu.papers.utils.Segmenter;
import org.apdplat.word.segmentation.Word;
import org.junit.Test;

import java.util.List;

public class TestUnit {

    @Test
    public void testFile() {
        String str = FileUtil.readFile("O:\\orig.txt");
        System.out.println(str.substring(0, 50));
    }

    @Test
    public void testSeg() {
        List<Word> words = Segmenter.seg(FileUtil.readFile("O:\\orig.txt"));
        System.out.println(words.toString());
    }

}
