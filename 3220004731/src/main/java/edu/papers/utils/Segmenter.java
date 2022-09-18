package edu.papers.utils;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;

import java.util.List;

public class Segmenter {

//    public static List<Word> seg(String text) {
//        List<Word> words = WordSegmenter.segWithStopWords(text);
//        return words;
//    }

    public static List<SegToken> seg(String text) {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        return segmenter.process(text, JiebaSegmenter.SegMode.INDEX);
    }


}
