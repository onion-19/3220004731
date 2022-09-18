package edu.papers.utils;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

import java.util.List;

public class Segmenter {

    public static List<Word> seg(String text) {
        List<Word> words = WordSegmenter.segWithStopWords(text);

        return words;
    }

}
