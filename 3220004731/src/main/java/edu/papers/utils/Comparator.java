package edu.papers.utils;

import org.apdplat.word.analysis.*;
import org.apdplat.word.segmentation.Word;

import java.util.List;

public class Comparator {

    public static double cmpCosine(List<Word> words1, List<Word> words2) {
        TextSimilarity sim = new CosineTextSimilarity();
        return sim.similarScore(words1, words2);
    }
    public static double cmpEdit(List<Word> words1, List<Word> words2) {
        TextSimilarity sim = new EditDistanceTextSimilarity();
        return sim.similarScore(words1, words2);
    }
    public static double cmpEu(List<Word> words1, List<Word> words2) {
        TextSimilarity sim = new EuclideanDistanceTextSimilarity();
        return sim.similarScore(words1, words2);
    }
    public static double cmpSimHash(List<Word> words1, List<Word> words2) {
        TextSimilarity sim = new SimHashPlusHammingDistanceTextSimilarity();
        return sim.similarScore(words1, words2);
    }
    public static double cmpSimText(List<Word> words1, List<Word> words2) {
        TextSimilarity sim = new SimpleTextSimilarity();
        return sim.similarScore(words1, words2);
    }
    public static double cmpSPhi(List<Word> words1, List<Word> words2) {
        TextSimilarity sim = new SørensenDiceCoefficientTextSimilarity();
        return sim.similarScore(words1, words2);
    }
    public static double cmpJaccard(List<Word> words1, List<Word> words2) {
        TextSimilarity sim = new JaccardTextSimilarity();
        return sim.similarScore(words1, words2);
    }
    public static double cmpJaroDis(List<Word> words1, List<Word> words2) {
        TextSimilarity sim = new JaroDistanceTextSimilarity();
        return sim.similarScore(words1, words2);
    }
    public static double cmpJaroWink(List<Word> words1, List<Word> words2) {
        TextSimilarity sim = new JaroWinklerDistanceTextSimilarity();
        return sim.similarScore(words1, words2);
    }
    public static double cmpManhattan(List<Word> words1, List<Word> words2) {
        TextSimilarity sim = new ManhattanDistanceTextSimilarity();
        return sim.similarScore(words1, words2);
    }

}
