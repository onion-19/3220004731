package edu.papers.test;

import edu.papers.utils.FileUtil;
import org.junit.Test;

public class TestUnit {

    @Test
    public void testFile() {
        String str = FileUtil.readFile("O:\\orig.txt");
        System.out.println(str.substring(0, 50));
    }

}
