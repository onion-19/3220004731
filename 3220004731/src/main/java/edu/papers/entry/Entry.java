package edu.papers.entry;

import com.huaban.analysis.jieba.SegToken;
import edu.papers.utils.Comparator;
import edu.papers.utils.FileUtil;
import edu.papers.utils.Segmenter;

import java.util.List;

public class Entry {
//    public static void main(String[] args) {
//        List<SegToken> orig = Segmenter.seg(FileUtil.readFile(args[0]));
//        List<SegToken> test = Segmenter.seg(FileUtil.readFile(args[1]));
//
//        FileUtil.writeFile(args[0], args[1], Comparator.compare(orig, test), args[2]);
//    }

//    public static void main(String[] args) {
//        String origContent = "";
//        String testContent = "";
//        if(!FileUtil.readFile(args[0], origContent) || !FileUtil.readFile(args[1], testContent)) {
//            System.exit(0);
//        }
//
//        List<SegToken> orig = Segmenter.seg(origContent);
//        List<SegToken> test = Segmenter.seg(testContent);
//
//        FileUtil.writeFile(args[0], args[1], Comparator.compare(orig, test), args[2]);
//    }

    public static void main(String[] args) {
        if(args.length < 3) {
            System.out.println("请输入正确的参数数量");
            System.out.println("格式：java -jar main.jar D:\\org.txt D:\\org_add.txt D:\\ans.txt\n");
            System.exit(0);
        }
        String origContent = "";
        String testContent = "";
        if(null == (origContent = FileUtil.readFile(args[0])) || null == (testContent = FileUtil.readFile(args[1]))) {
            FileUtil.writeFile(args[0], args[1], 0.0, args[2]);
            System.exit(0);
        }

        List<SegToken> orig = Segmenter.seg(origContent);
        List<SegToken> test = Segmenter.seg(testContent);

        FileUtil.writeFile(args[0], args[1], Comparator.compare(orig, test), args[2]);
    }
}
