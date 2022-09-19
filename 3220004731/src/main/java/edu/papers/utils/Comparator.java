package edu.papers.utils;

import com.huaban.analysis.jieba.SegToken;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Comparator {

    /**
     * 简单共有词算法
     * @author 杨尚川
     */
    public static double compare(List<SegToken> words1, List<SegToken> words2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        //取出SegToken类列表words1的每一个元素的word成员变量，加入新列表list1
        words1.forEach(w1 -> {
            list1.add(w1.word);
        });
        //取出SegToken类列表words2的每一个元素的word成员变量，加入新列表list2
        words2.forEach(w2 -> {
            list2.add(w2.word);
        });
        //若词列表1和词列表2的内容均为空，则文本相似度为1.0
        if(list1.isEmpty() && list2.isEmpty())
            return 1.0;
        //计算词列表1总的字符数
        AtomicInteger words1Length = new AtomicInteger();
        list1.parallelStream().forEach(item -> words1Length.addAndGet(item.length()));
        //计算词列表2总的字符数
        AtomicInteger words2Length = new AtomicInteger();
        list2.parallelStream().forEach(item -> words2Length.addAndGet(item.length()));
        //计算词列表1和词列表2共有的词的总的字符数
        list1.retainAll(list2);
        AtomicInteger intersectionLength = new AtomicInteger();
        list1.parallelStream().forEach(item -> intersectionLength.addAndGet(item.length()));
        //返回文本相似度的计算结果
        return intersectionLength.get() / (double)Math.max(words1Length.get(), words2Length.get());
    }

}
