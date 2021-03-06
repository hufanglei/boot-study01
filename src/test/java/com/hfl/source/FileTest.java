package com.hfl.source;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.FileCopyUtils;
import java.io.File;

/**
 * Created by hfl on 2017-5-2.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class FileTest {

    @Value("${web.upload-path}")
    private String path;

    /** 文件上传测试 */
    @Test
    public void uploadTest() throws Exception {
        File f = new File("D:/1111.jpg");
        FileCopyUtils.copy(f, new File(path+"/1.jpg"));
    }

    @Test
    public void listFilesTest() {
        File file = new File(path);
        for(File f : file.listFiles()) {
            System.out.println("fileName : "+f.getName());
        }
    }


}
