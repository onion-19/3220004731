package edu.papers.utils;

import org.apdplat.word.segmentation.Word;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Comparator {

//    public static double cmpCosine(List<Word> words1, List<Word> words2) {
//        TextSimilarity sim = new CosineTextSimilarity();
//        return sim.similarScore(words1, words2);
//    }
//    public static double cmpEdit(List<Word> words1, List<Word> words2) {
//        TextSimilarity sim = new EditDistanceTextSimilarity();
//        return sim.similarScore(words1, words2);
//    }
//    public static double cmpEu(List<Word> words1, List<Word> words2) {
//        TextSimilarity sim = new EuclideanDistanceTextSimilarity();
//        return sim.similarScore(words1, words2);
//    }
//    public static double cmpSimHash(List<Word> words1, List<Word> words2) {
//        TextSimilarity sim = new SimHashPlusHammingDistanceTextSimilarity();
//        return sim.similarScore(words1, words2);
//    }
//    public static double cmpSimText(List<Word> words1, List<Word> words2) {
//        TextSimilarity sim = new SimpleTextSimilarity();
//        return sim.similarScore(words1, words2);
//    }
//    public static double cmpSPhi(List<Word> words1, List<Word> words2) {
//        TextSimilarity sim = new SørensenDiceCoefficientTextSimilarity();
//        return sim.similarScore(words1, words2);
//    }
//    public static double cmpJaccard(List<Word> words1, List<Word> words2) {
//        TextSimilarity sim = new JaccardTextSimilarity();
//        return sim.similarScore(words1, words2);
//    }
//    public static double cmpJaroDis(List<Word> words1, List<Word> words2) {
//        TextSimilarity sim = new JaroDistanceTextSimilarity();
//        return sim.similarScore(words1, words2);
//    }
//    public static double cmpJaroWink(List<Word> words1, List<Word> words2) {
//        TextSimilarity sim = new JaroWinklerDistanceTextSimilarity();
//        return sim.similarScore(words1, words2);
//    }
//    public static double cmpManhattan(List<Word> words1, List<Word> words2) {
//        TextSimilarity sim = new ManhattanDistanceTextSimilarity();
//        return sim.similarScore(words1, words2);
//    }

    /**
     * SimpleTextSimilarity
     * @author 杨尚川
     */
    public static double similarityCalculate(List<Word> words1, List<Word> words2) {
        AtomicInteger words1Length = new AtomicInteger();
        words1.parallelStream().forEach(word -> words1Length.addAndGet(word.getText().length()));
        AtomicInteger words2Length = new AtomicInteger();
        words2.parallelStream().forEach(word -> words2Length.addAndGet(word.getText().length()));

        words1.retainAll(words2);
        AtomicInteger intersectionLength = new AtomicInteger();
        words1.parallelStream().forEach(word -> {
            intersectionLength.addAndGet(word.getText().length());
        });
        double result = intersectionLength.get()/(double)Math.max(words1Length.get(), words2Length.get());
        return result;
    }

    /**
     * SørensenDiceCoefficientTextSimilarity
     * @author 杨尚川
     */
    public static double scoreImpl(List<Word> var1, List<Word> var2) {
        if (var1.isEmpty() && var2.isEmpty()) {
            return 1.0D;
        } else {
            HashSet var3 = new HashSet(var1);
            HashSet var4 = new HashSet(var2);
            int var5 = var3.size();
            int var6 = var4.size();
            var3.retainAll(var4);
            int var7 = var3.size();
            double var8 = (double)(2 * var7) / (double)(var5 + var6);
            return var8;
        }
    }

}
