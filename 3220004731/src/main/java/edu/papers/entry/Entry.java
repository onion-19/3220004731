package edu.papers.entry;

import com.huaban.analysis.jieba.SegToken;
import edu.papers.utils.Comparator;
import edu.papers.utils.FileUtil;
import edu.papers.utils.Segmenter;

import java.util.List;

public class Entry {

    public static void main(String[] args) {
        //判断参数数量是否合法
        if(args.length < 3) {
            System.out.println("请输入正确的参数数量");
            System.out.println("格式：java -jar main.jar D:\\org.txt D:\\org_add.txt D:\\ans.txt\n");
            System.exit(0);
        }
        String origContent = "";
        String testContent = "";
        //读取文件内容
        if(null == (origContent = FileUtil.readFile(args[0])) || null == (testContent = FileUtil.readFile(args[1]))) {
            //若其中一个文件不存在或内容为空，则文本相似度为0.0
            FileUtil.writeFile(args[0], args[1], 0.0, args[2]);
            System.exit(0);
        }
        //对文本进行分词
        List<SegToken> orig = Segmenter.seg(origContent);
        List<SegToken> test = Segmenter.seg(testContent);
        //将文本相似度的比较结果写入文件
        FileUtil.writeFile(args[0], args[1], Comparator.compare(orig, test), args[2]);
    }
}
