package edu.papers.utils;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;

import java.util.List;

public class Segmenter {

    public static List<SegToken> seg(String text) {
        JiebaSegmenter segmenter = new JiebaSegmenter();
        //返回分词结果
        return segmenter.process(text, JiebaSegmenter.SegMode.INDEX);
    }


}
