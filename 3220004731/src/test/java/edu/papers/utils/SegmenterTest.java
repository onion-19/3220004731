package edu.papers.utils;

import com.huaban.analysis.jieba.SegToken;
import org.junit.Test;

import java.util.List;

public class SegmenterTest {

    @Test
    public void seg() {
        //测试jieba分词器的分词功能
        List<SegToken> words = Segmenter.seg("一位真正的作家永远只为内心写作，" +
                "只有内心才会真实地告诉他，他的自私、他的高尚是多么突出。");
        System.out.println(words.toString());
    }
}