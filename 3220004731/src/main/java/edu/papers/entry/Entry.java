package edu.papers.entry;

import com.huaban.analysis.jieba.SegToken;
import edu.papers.utils.Comparator;
import edu.papers.utils.FileUtil;
import edu.papers.utils.Segmenter;

import java.util.List;

public class Entry {
    public static void main(String[] args) {
        List<SegToken> orig = Segmenter.seg(FileUtil.readFile(args[0]));
        List<SegToken> test = Segmenter.seg(FileUtil.readFile(args[1]));

        FileUtil.writeFile(args[0], args[1], Comparator.compare(orig, test), args[2]);

    }
}