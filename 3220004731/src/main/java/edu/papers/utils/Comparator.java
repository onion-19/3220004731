package edu.papers.utils;

import com.huaban.analysis.jieba.SegToken;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Comparator {

    /**
     * 简单共有词算法
     * @author 杨尚川
     */
//    public static double compare(List<SegToken> words1, List<SegToken> words2) {
//        List<String> list1 = new ArrayList<>();
//        List<String> list2 = new ArrayList<>();
//        words1.forEach(w1 -> {
//            list1.add(w1.word);
//        });
//        words2.forEach(w2 -> {
//            list2.add(w2.word);
//        });
//        AtomicInteger words1Length = new AtomicInteger();
//        list1.parallelStream().forEach(item -> words1Length.addAndGet(item.length()));
//        AtomicInteger words2Length = new AtomicInteger();
//        list2.parallelStream().forEach(item -> words2Length.addAndGet(item.length()));
//
//        list1.retainAll(list2);
//        AtomicInteger intersectionLength = new AtomicInteger();
//        list1.parallelStream().forEach(item -> intersectionLength.addAndGet(item.length()));
//
//        return intersectionLength.get() / (double)Math.max(words1Length.get(), words2Length.get());
//    }

    /**
     * SørensenDiceCoefficientTextSimilarity
     * @author 杨尚川
     */
    public static double compare(List<SegToken> words1, List<SegToken> words2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        words1.forEach(w1 -> {
            list1.add(w1.word);
        });
        words2.forEach(w2 -> {
            list2.add(w2.word);
        });
        if(list1.isEmpty() && list2.isEmpty())
            return 1.0;
        //转变为不重复的集合
        Set<String> words1Set = new HashSet<>(list1);
        Set<String> words2Set = new HashSet<>(list2);
        // 两个集合的大小
        int set1Size = words1Set.size();
        int set2Size = words2Set.size();
        // 求交集（去重），计算交集的不重复词的个数
        words1Set.retainAll(words2Set);
        int intersectionSize = words1Set.size();
        //相似度分值
        return 2*intersectionSize / (double)(set1Size+set2Size);
    }

}
