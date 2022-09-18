package edu.papers.test;

import com.huaban.analysis.jieba.SegToken;
import edu.papers.utils.Comparator;
import edu.papers.utils.FileUtil;
import edu.papers.utils.Segmenter;
import org.junit.Test;

import java.util.List;

public class TestUnit {

//    @Test
//    public void testFile() {
//        String str = FileUtil.readFile("O:\\orig.txt");
//        System.out.println(str.substring(0, 50));
//    }

//    @Test
//    public void testSeg() {
//        List<Word> words = Segmenter.seg(FileUtil.readFile("O:\\orig.txt"));
//        System.out.println(words.toString());
//    }

//    @Test
//    public void testCmpSim() {
//        List<Word> orig = Segmenter.seg(FileUtil.readFile("O:\\orig.txt"));
//        List<Word> test = Segmenter.seg(FileUtil.readFile("O:\\orig_0.8_add.txt"));
//        System.out.println("余弦相似度：" + Comparator.cmpCosine(orig, test));
//        System.out.println("编辑距离：" + Comparator.cmpEdit(orig, test));
//        System.out.println("Eu：" + Comparator.cmpEu(orig, test));
//        System.out.println("Jaccard：" + Comparator.cmpJaccard(orig, test));
//        System.out.println("JaroDis：" + Comparator.cmpJaroDis(orig, test));
//        System.out.println("JaroWink：" + Comparator.cmpJaroWink(orig, test));
//        System.out.println("Manhattan：" + Comparator.cmpManhattan(orig, test));
//        System.out.println("SimHash：" + Comparator.cmpSimHash(orig, test));
//        System.out.println("SimText：" + Comparator.cmpSimText(orig, test));
//        System.out.println("SPhi：" + Comparator.cmpSPhi(orig, test));
//    }

//    @Test
//    public void testWordLowVersion() {
//        List<Word> orig = Segmenter.seg(FileUtil.readFile("O:\\orig.txt"));
//        List<Word> test = Segmenter.seg(FileUtil.readFile("O:\\orig_0.8_add.txt"));
//
//        System.out.println("SimText：" + Comparator.similarityCalculate(orig, test));
//        System.out.println("SPhi：" + Comparator.scoreImpl(orig, test));
//    }

//    @Test
//    public void testJieba() {
//        List<SegToken> orig = Segmenter.seg(FileUtil.readFile("O:\\orig.txt"));
//        List<SegToken> test = Segmenter.seg(FileUtil.readFile("O:\\orig_0.8_add.txt"));
//        System.out.println("文本相似度：" + Comparator.compare(orig, test));
//    }

    @Test
    public void testWriteFile() {
        FileUtil.writeFile("1", "2", 83.999999999, "O:\\result.txt");
    }

//    @Test
//    public void testSPhi() {
//        List<SegToken> orig = Segmenter.seg(FileUtil.readFile("O:\\orig.txt"));
//        List<SegToken> test = Segmenter.seg(FileUtil.readFile("O:\\orig_0.8_add.txt"));
//        System.out.println("文本相似度：" + Comparator.compare(orig, test));
//    }
//
//    @Test
//    public void testFileException() {
//        List<SegToken> orig = Segmenter.seg(FileUtil.readFile("O:\\orig.txt"));
////        List<SegToken> test = Segmenter.seg(FileUtil.readFile("O:\\orig_null.txt"));
//        List<SegToken> test = Segmenter.seg(FileUtil.readFile("orig_null.txt"));
//        System.out.println("文本相似度：" + Comparator.compare(orig, test));
//    }

//    @Test
//    public void testEntry() {
//        String origpath = "O:\\orig.txt";
//        String testpath = "O:\\orig_0.8_add.txt";
//        String resultpath = "O:\\result_.txt";
//
//        String origContent = "";
//        String testContent = "";
//        if(!FileUtil.readFile(origpath, origContent) || !FileUtil.readFile(testpath, testContent)) {
//            System.exit(0);
//        }
//
//        System.out.println(origContent.substring(0, 50));
//        System.out.println(testContent.substring(0, 50));
//
//        List<SegToken> orig = Segmenter.seg(origContent);
//        List<SegToken> test = Segmenter.seg(testContent);
//
//        FileUtil.writeFile(origpath, testpath, Comparator.compare(orig, test), resultpath);
//    }

    @Test
    public void testEntry_2() {
        String origpath = "O:\\orig.txt";
        String testpath = "O:\\orig_null.txt";
        String resultpath = "O:\\result_.txt";

        String origContent = "";
        String testContent = "";
        if(null == (origContent = FileUtil.readFile(origpath)) || null == (testContent = FileUtil.readFile(testpath))) {
            FileUtil.writeFile(origpath, testpath, 0.0, resultpath);
            System.exit(0);
        }

        List<SegToken> orig = Segmenter.seg(origContent);
        List<SegToken> test = Segmenter.seg(testContent);

        FileUtil.writeFile(origpath, testpath, Comparator.compare(orig, test), resultpath);
    }

}
